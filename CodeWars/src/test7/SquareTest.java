package test7;

import kyu7.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    AUTHOR: linux
    TIME: 2019/11/10
    GOOD LUCK AND NO BUG.
*/
class SquareTest {
    @Test
    void shouldWorkForSomeExamples() throws Exception {
        assertFalse(Square.isSquare(-1), "negative numbers aren't square numbers");
//        assertTrue("0 is a square number (0 * 0)", Square.isSquare(0));
//        assertFalse("3 isn't a square number", Square.isSquare(3));
//        assertTrue("4 is a square number (2 * 2)", Square.isSquare(4));
//        assertTrue("25 is a square number (5 * 5)", Square.isSquare(25));
//        assertFalse("26 isn't a square number", Square.isSquare(26));
    }
}
