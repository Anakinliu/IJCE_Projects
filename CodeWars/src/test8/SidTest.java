package test8;

import kyu8.Sid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
    AUTHOR: linux
    TIME: 2019/11/11
    GOOD LUCK AND NO BUG.
*/
 class SidTest {
    @Test
    void test1() {
        assertEquals("I love you", Sid.howMuchILoveYou(1));
        assertEquals("a little", Sid.howMuchILoveYou_2(326));
        assertEquals("not at all", Sid.howMuchILoveYou(6));
    }
}
