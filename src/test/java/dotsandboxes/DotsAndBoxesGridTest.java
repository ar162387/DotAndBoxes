package dotsandboxes;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

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
}
