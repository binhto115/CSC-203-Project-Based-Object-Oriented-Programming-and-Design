import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class LabStrategy implements PathingStrategy {

    private final PathingMain.GridValues[][] grid;

    /**
     * Creates a new lab pathing strategy the uses the given grid. For this lab, this is a reference to
     * the PathingMain grid, not a new one.
     *
     * @param grid the grid associated with this strategy.
     */
    public LabStrategy(PathingMain.GridValues[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns a prefix of a path from the start point to a point within reach
     * of the end point. This path is only valid ("clear") when returned, but
     * may be invalidated by movement of other entities. The prefix includes
     * neither the start nor end points.
     * This implementation is recursive and returns null if no path is found!
     *
     * @param start              the point to begin the search from
     * @param end                the point to search for a point within reach of
     * @param canPassThrough     a function that returns true if the given point is traversable
     * @param withinReach        a function that returns true if both points are within reach of each other
     * @param potentialNeighbors a function that returns the neighbors of a given point, as a stream
     */
    public List<Point> computePath(
            Point start, // In this recursive version, it's the current point, too
            Point end,
            Predicate<Point> canPassThrough,
            BiPredicate<Point, Point> withinReach,
            Function<Point, Stream<Point>> potentialNeighbors
    ) {
        if (withinReach.test(start, end)) {
            return new ArrayList<>();
        } else {
            // Get neighboring points
            Stream<Point> neighborStream = potentialNeighbors.apply(start);

            // 1. Filter out impassable neighbors
            // 2. Filter out all but the "right adjacent" neighbor
            List<Point> neighborList = neighborStream
                    .filter(canPassThrough)
                    //.filter(p -> (Math.abs(p.x - start.x) <= 1) && (Math.abs(p.y - start.y) <= 1))
                    //.filter(p -> p.x == start.x + 1 && p.y == start.y)
                    .toList();

            // Check if we have remaining neighbors
            if (neighborList.size() == 0) {
                return null; // No path can be found!
            }

            // Get the right neighbor
            //Point rightNeighbor = neighborList.get(0);
            for (Point rightNeighbor : neighborList) {

                // Set the neighbor as searched
                grid[rightNeighbor.y][rightNeighbor.x] = PathingMain.GridValues.SEARCHED;

                // Check if the neighbor is within reach of the goal
                if (withinReach.test(rightNeighbor, end)) {
                    List<Point> path = new ArrayList<Point>();
                    path.add(rightNeighbor);
                    path.add(start);
                    return path;
                }
                // Otherwise, recursively check
                else {
                    List<Point> path = computePath(rightNeighbor, end, canPassThrough, withinReach, potentialNeighbors);

                    // Check if the goal was found
                    if (path != null) {
                        path.add(0, start); // Add this point to the path
                        return path; // Propagate the path to previous calls
                    }
                }
            }
            return null;
        }
    }
}

