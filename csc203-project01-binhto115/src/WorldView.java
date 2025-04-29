import processing.core.PApplet;
import processing.core.PImage;

import javax.swing.text.View;
import java.util.Optional;

public final class WorldView {
    private final PApplet screen;
    private final WorldModel world;
    private final int tileWidth;
    private final int tileHeight;
    private final Viewport viewport;

    public Viewport getViewport(){
        return this.viewport;
    }
    public WorldView(int numRows, int numCols, PApplet screen, WorldModel world, int tileWidth, int tileHeight) {
        this.screen = screen;
        this.world = world;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.viewport = new Viewport(numRows, numCols);
    }
    private void drawBackground() {
        for (int row = 0; row < this.viewport.getNumRow(); row++) {
            for (int col = 0; col < this.viewport.getNumCols(); col++) {
                Point worldPoint = viewport.viewportToWorld(col, row);
                Optional<PImage> image = world.getBackgroundImage(worldPoint);
                if (image.isPresent()) {
                    this.screen.image(image.get(), col * this.tileWidth, row * this.tileHeight);
                }
            }
        }
    }
    public void drawViewport() {
        drawBackground();
        this.drawEntities();
    }
    private void drawEntities() {
        for (Entity entity : this.world.getEntities()) {
            Point pos = entity.getPosition();

            if (viewport.contains(pos)) {
                Point viewPoint = viewport.worldToViewport(pos.x, pos.y);
                this.screen.image(Entity.getCurrentImage(entity), viewPoint.x * this.tileWidth, viewPoint.y * this.tileHeight);
            }
        }
    }
    public void shiftView(WorldView view, int colDelta, int rowDelta) {
        int newCol = clamp(view.viewport.getCol() + colDelta, 0, view.world.getNumCols() - view.viewport.getNumCols());
        int newRow = clamp(view.viewport.getRow() + rowDelta, 0, view.world.getNumRows() - view.viewport.getNumRow());

        viewport.shift(newCol, newRow);
    }
    public int clamp(int value, int low, int high) {
        return Math.min(high, Math.max(value, low));
    }
}