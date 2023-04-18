package Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductExceptSelfTest {

    @Test
    public void act() {
        int[] array = new int[]{-1, 1, 0, -3, 3};

        int[] actualResult = new ProductExceptSelf(array).play();

        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, actualResult);
    }

}