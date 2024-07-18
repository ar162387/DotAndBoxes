package dotsandboxes;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DotsAndBoxesGridTest {
    /*
     * Because Test classes are classes, they can have fields, and can have static fields.
     * This field is a logger. Loggers are like a more advanced println, for writing messages out to the console or a log file.
     */
    private static final Logger logger = LogManager.getLogger(DotsAndBoxesGridTest.class);

    /*
     * Tests are functions that have an @Test annotation before them.
     * The typical format of a test is that it contains some code that does something, and then one
     * or more assertions to check that a condition holds.
     *
     * This is a dummy test just to show that the test suite itself runs
     */
    @Test
    public void testTestSuiteRuns() {
        logger.info("Dummy test to show the test suite runs");
        assertTrue(true);
    }

    // FIXME: You need to write tests for the two known bugs in the code.


    @Test
    public void testDrawHorizontalLineTwiceThrowsException() {
        DotsAndBoxesGrid grid = new DotsAndBoxesGrid(3, 3, 2);

        grid.drawHorizontal(0, 0, 1);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            grid.drawHorizontal(0, 0, 1);
        });

        String expectedMessage = "Line has already been drawn";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Expected an IllegalStateException for drawing a line that was already drawn");
    }

    @Test
    public void testDrawVerticalLineTwiceThrowsException() {
        DotsAndBoxesGrid grid = new DotsAndBoxesGrid(3, 3, 2);

        grid.drawVertical(0, 0, 1);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            grid.drawVertical(0, 0, 1);
        });

        String expectedMessage = "Line has already been drawn";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Expected an IllegalStateException for drawing a line that was already drawn");
    }

    @Test
    public void testBoxIncompleteAtLeftEdge() {
        DotsAndBoxesGrid grid = new DotsAndBoxesGrid(3, 3, 2);

        // Draw three lines around the box at (0,1)
        grid.drawHorizontal(0, 1, 1);
        grid.drawHorizontal(0, 2, 1);
        grid.drawVertical(0, 1, 1);

        assertFalse(grid.boxComplete(0, 1), "The box at (0,1) should not be complete with only three lines drawn");
    }

    @Test
    public void testBoxIncomplete() {
        DotsAndBoxesGrid grid = new DotsAndBoxesGrid(3, 3, 2);

        // Draw only one horizontal line
        grid.drawHorizontal(0, 0, 1);

        assertFalse(grid.boxComplete(0, 0), "The box at (0,0) should not be complete with only one line drawn");

        // Draw two lines (horizontal and vertical)
        grid.drawVertical(0, 0, 1);

        assertFalse(grid.boxComplete(0, 0), "The box at (0,0) should not be complete with only two lines drawn");

        // Draw three lines
        grid.drawHorizontal(0, 1, 1);

        assertFalse(grid.boxComplete(0, 0), "The box at (0,0) should not be complete with only three lines drawn");
    }


}
