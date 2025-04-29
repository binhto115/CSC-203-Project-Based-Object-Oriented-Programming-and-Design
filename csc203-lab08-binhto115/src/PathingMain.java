import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PathingMain extends PApplet {
    /**
     * Image Data
     */
    private static final int PENGUIN_ANIMATION_TIME_IN_MS = 333;

    private List<PImage> penguinImages;
    private int penguinCurrentImage;
    private long penguinNextImageTime;

    private PImage backgroundImage;
    private PImage obstacleImage;
    private PImage goalImage;

    /**
     * Grid Data
     */
    private static final int ROWS = 15;
    private static final int COLUMNS = 20;
    private static final int TILE_SIZE_IN_PIXELS = 32;

    public enum GridValues { BACKGROUND, OBSTACLE, SEARCHED };

    private GridValues[][] grid = new GridValues[ROWS][COLUMNS];

    /**
     * Pathing Data
     */
    private static final char KEY_SEARCH = ' ';
    private static final char KEY_CLEAR = 'c';
    private static final char KEY_PATH = 'p';

    private Point penguinPosition = new Point(2, 2);
    private Point goalPosition = new Point(COLUMNS - 2, ROWS - 2);

    private List<Point> path = new LinkedList<>();

    private boolean drawPath = false;

    /**
     * Initialization
     */
    public static void main(String args[]) {
        PApplet.main("PathingMain");
    }

    public void settings() {
        size(640,480);
    }

    public void setup() {
        loadImages();
        loadGrid();
        displayControls();
    }

    public void loadImages() {
        penguinImages = new ArrayList<>();
        penguinImages.add(loadImage("images/penguin1.png"));
        penguinImages.add(loadImage("images/penguin2.png"));

        penguinCurrentImage = 0;
        penguinNextImageTime = System.currentTimeMillis() + PENGUIN_ANIMATION_TIME_IN_MS;

        backgroundImage = loadImage("images/snow.png");
        obstacleImage = loadImage("images/boulder.png");

        goalImage = loadImage("images/fish.png");
    }

    private void loadGrid() {
        for (GridValues[] gridValues : grid) {
            Arrays.fill(gridValues, GridValues.BACKGROUND);
        }

        for (int y = 1; y < ROWS; ++y) {
            for (int x = 1; x < COLUMNS; ++x) {
                int distance = (int) Math.sqrt(x * x + y * y);
                if (distance == max(ROWS, COLUMNS) / 2) {
                    grid[y][x] = GridValues.OBSTACLE;
                }
            }
        }
    }

    public void displayControls() {
        System.out.printf("Press '%c' to search for the goal.%n", KEY_SEARCH);
        System.out.printf("Press '%c' to clear the searched grid data.%n", KEY_CLEAR);
        System.out.printf("Press '%c' to hide/show the successful path, if found.%n", KEY_PATH);
        System.out.println("Use the left mouse button to change the grid.");
    }

    /**
     * images and Drawing.
     */
    public void draw() {
        drawGrid();

        if (drawPath) drawPath();

        updatePenguinImage();
        drawImageAtGrid(penguinImages.get(penguinCurrentImage), penguinPosition.x, penguinPosition.y);

        drawImageAtGrid(goalImage, goalPosition.x, goalPosition.y );
    }

    public void updatePenguinImage() {
        long currentTime = System.currentTimeMillis();

        if (currentTime >= penguinNextImageTime) {
        updatePenguinCurrentImage();
        penguinNextImageTime = currentTime + PENGUIN_ANIMATION_TIME_IN_MS;
        }
    }

    private void updatePenguinCurrentImage() {
        penguinCurrentImage = (penguinCurrentImage + 1) % penguinImages.size();
    }

    private void drawGrid() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                drawTile(row, col);
            }
        }
    }

    private void drawTile(int row, int col) {
        drawImageAtGrid(backgroundImage, col, row);
        switch (grid[row][col]) {
            case OBSTACLE -> drawImageAtGrid(obstacleImage, col, row);
            case SEARCHED -> drawRectAtGrid(0, 0, 0, col, row, 24);
        }
    }

    private void drawPath() {
        for (Point p : path) {
            drawRectAtGrid(128, 0, 0, p.x, p.y, 16);
        }
    }

    private void drawImageAtGrid(PImage image, int col, int row) {
        image(image, col * TILE_SIZE_IN_PIXELS, row * TILE_SIZE_IN_PIXELS);
    }

    private void drawRectAtGrid(int red, int green, int blue, int col, int row, int size) {
        int left = col * TILE_SIZE_IN_PIXELS + TILE_SIZE_IN_PIXELS / 2 - size / 2;
        int top = row * TILE_SIZE_IN_PIXELS + TILE_SIZE_IN_PIXELS / 2 - size / 2;
        fill(red, green, blue);
        rect(left, top, size, size);
    }

    /**
     * Input
     */
    @Override
    public void keyPressed() {
        if (key == KEY_SEARCH) {
            path.clear();
            clearSearched();

            boolean found = searchForGoal(penguinPosition, goalPosition, path);

            if (found) {
                drawPath = true;
                System.out.println("Found a path to the goal!");
            } else {
                System.out.println("Could not find a path to the goal.");
            }
        } else if (key == KEY_PATH) {
            drawPath = !drawPath;
        } else if (key == KEY_CLEAR) {
            path.clear();
            clearSearched();
        }
    }

    @Override
    public void mousePressed() {
        int mouseColumn = mouseX / TILE_SIZE_IN_PIXELS;
        int mouseRow = mouseY / TILE_SIZE_IN_PIXELS;
        if (withinBounds(new Point(mouseColumn, mouseRow))) {
            switch (grid[mouseRow][mouseColumn]) {
                case BACKGROUND -> grid[mouseRow][mouseColumn] = GridValues.OBSTACLE;
                case OBSTACLE -> grid[mouseRow][mouseColumn] = GridValues.BACKGROUND;
            }
        }
    }

    /**
     * Attempts to find a goal, returning true inserting the path to the given list if successful. Returns false otherwise.
     *
     * @param start the position to search from
     * @param end the position to search for
     * @param path the point list to populate
     */
    private boolean searchForGoal(Point start, Point end, List<Point> path) {

        // Initialize the pathing strategy
        PathingStrategy pathingStrategy = new LabStrategy(grid);

        // A lambda function that determines if a grid point is traversable
        // TODO: Ensure that you can't pass through "searched" grid points
        Predicate<Point> canPassThrough = p ->
                withinBounds(p) && grid[p.y][p.x] != GridValues.OBSTACLE && grid[p.y][p.x] != GridValues.SEARCHED;

        // A lambda function that determines if two points are adjacent to each another
        BiPredicate<Point, Point> withinReach = (p1, p2) -> (Math.abs(p2.x - p1.x) + Math.abs(p2.y - p1.y)) == 1;

        // A lambda function that produces a stream of neighboring points for a given point
        // TODO: Ensure that you return all "cardinal" neighbors
        Function<Point, Stream<Point>> potentialNeighbors = PathingStrategy.CARDINAL_NEIGHBORS;
        //p -> Stream.of(new Point(p.x + 1, p.y))
        // Call the pathing strategy's computePath
        List<Point> searchedPath = pathingStrategy.computePath(start, end, canPassThrough, withinReach, potentialNeighbors);

        if (searchedPath == null) {
            return false;
        } else {
            path.addAll(searchedPath);
            return true;
        }
    }

    private static boolean withinBounds(Point p) {
        return (p.y >= 0 && p.y < ROWS) && (p.x >= 0 && p.x < COLUMNS);
    }

    private void clearSearched() {
        for (int y = 0; y < ROWS; ++y) {
            for (int x = 0; x < COLUMNS; ++x) {
                if (grid[y][x] == GridValues.SEARCHED) {
                    grid[y][x] = GridValues.BACKGROUND;
                }
            }
        }
    }
}
