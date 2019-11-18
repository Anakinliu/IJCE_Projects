package test6;
/*
    AUTHOR: linux
    TIME: 2019/11/11
    GOOD LUCK AND NO BUG.
*/

import kyu6.Array2PhoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Array2PhoneNumberTest {
    @Test
    void shouldEEEEqual() throws Exception {
        assertEquals("(123) 456-7890", Array2PhoneNumber.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

}
