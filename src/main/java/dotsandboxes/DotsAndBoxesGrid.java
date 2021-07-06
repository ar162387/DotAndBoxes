package dotsandboxes;


import java.util.Arrays;

/**
 * The state of a dots and boxes grid.
 *
 * A (4, 3) dots and boxes grid looks like this:
 *
 * *-*-*-*
 * | | | |
 * *-*-*-*
 * | | | |
 * *-*-*-*
 *
 * Notice that:
 *
 * - for each row, there is one less horizontal than the number of corner dots
 * - for each row, there are as many verticals as there are corner dots
 * - for each row, there is one less box than the number of corner dots
 * - for each column, there is one less vertical than the number of corner dots.
 * - for each column, there are as many horizontals as there are corner dots.
 * - for each column, there is one less box than the number of corner dots
 *
 * For example, in this (4, 3) grid, there are (3, 3) horizontal lines, and (4, 2) vertical lines, and (3, 2) boxes.
 *
 * We number all lines and boxes by their top-left coordinate.
 *
 * In Java 14+, we might use a Record class for this, but we're using 11+ as an LTS version, so we don't have that yet.
 */
public class DotsAndBoxesGrid {

    final int width;
    final int height;

    /** The horizontal lines in the grid. True if drawn. */
    private boolean[][] horizontals;

    /** The vertical lines in the grid. True if drawn. */
    private boolean[][] verticals;

    /** Which owner (if any) claimed any given box. */
    private int[][] boxOwners;

    public DotsAndBoxesGrid(int width, int height) {
        this.width = width;
        this.height = height;

        this.horizontals = new boolean[width - 1][height];
        this.verticals = new boolean[width][height - 1];
        this.boxOwners = new int[width - 1][height - 1];
    }

    /**
     * Checks whether a box has been fully drawn (all four sides)
     * @param x coordinate of the left side of the box
     * @param y coordinate of the top of the box
     * @return true if all four sides have been drawn.
     */
    public boolean boxComplete(int x, int y) {
        if (x >= width - 1 || x < 0) {
            throw new IndexOutOfBoundsException(String.format("x was %d, which is out of range. Range is 0 to %d", x, width - 1));
        }
        if (y >= height - 1|| y < 0) {
            throw new IndexOutOfBoundsException(String.format("y was %d, which is out of range. Range is 0 to %d", y, height - 1));
        }

        // A box is complete if the north and south horizontals and the east and west verticals have all been drawn.
        // FIXME: You'll need to fix this code (after writing a test first).
        return true;
    }

    /**
     * "Draws" a horizontal line, from grid point (x, y) to (x + 1, y). (i.e. sets that line to true)
     * @param x
     * @param y
     * @return true if it completes a box
     */
    public boolean drawHorizontal(int x, int y, int player) {
        if (x >= width - 1 || x < 0) {
            throw new IndexOutOfBoundsException(String.format("x was %d, which is out of range. Range is 0 to %d", x, width - 1));
        }
        if (y >= height || y < 0) {
            throw new IndexOutOfBoundsException(String.format("y was %d, which is out of range. Range is 0 to %d", y, height));
        }

        // FIXME: You need to throw an exception if the line was already drawn.

        this.horizontals[x][y] = true;
        if (boxComplete(x, y)) {
            boxOwners[x][y] = player;
            return true;
        } else {
            return false;
        }
    }

    /**
     * "Draws" a vertical line, from grid point (x, y) to (x, y + 1). (i.e. sets that line to true)
     * @param x
     * @param y
     * @return true if it completes a box
     */
    public boolean drawVertical(int x, int y, int player) {
        if (x >= width || x < 0) {
            throw new IndexOutOfBoundsException(String.format("x was %d, which is out of range. Range is 0 to %d", x, width));
        }
        if (y >= height - 1 || y < 0) {
            throw new IndexOutOfBoundsException(String.format("y was %d, which is out of range. Range is 0 to %d", y, height - 1));
        }

        // You need to throw an exception if the line was already drawn.

        this.verticals[x][y] = true;
        if (boxComplete(x, y)) {
            boxOwners[x][y] = player;
            return true;
        } else {
            return false;
        }
    }

    public boolean gameComplete() {
        // Students who took COSC250 might recognise this style of code. This is Java's version of higher order functions.
        // The grid is complete if "for all rows, all the boxes in that row have a non-zero owner"
        return Arrays.stream(boxOwners).allMatch((row) -> Arrays.stream(row).allMatch((owner) -> owner > 0));
    }


}
