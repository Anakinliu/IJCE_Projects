package test6;
/*
    AUTHOR: linux
    TIME: 2019/11/11
    GOOD LUCK AND NO BUG.
*/

import kyu6.MultiplesOf3Or5;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

class MultiplesOf3Or5Test {
    @Test
    void shouldEEEEqual() throws Exception {
        assertEquals(10000, new MultiplesOf3Or5().solution(1000000000));
    }

}
