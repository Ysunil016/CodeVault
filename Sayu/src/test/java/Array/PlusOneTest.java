package Array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PlusOneTest {

    @Test
    public void act() {
        assertArrayEquals(new int[]{1, 0, 0, 0, 0, 0, 0, 0}, new PlusOne(new int[]{9, 9, 9, 9, 9, 9, 9}).play());
        assertArrayEquals(new int[]{1, 0}, new PlusOne(new int[]{9}).play());
        assertArrayEquals(new int[]{9, 8, 8, 8}, new PlusOne(new int[]{9, 8, 8, 7}).play());
    }

}