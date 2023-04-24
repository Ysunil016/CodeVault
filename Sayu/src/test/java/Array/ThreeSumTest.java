package Array;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    public void  act(){
        List<List<Integer>> threeSum = new ThreeSum(new int[]{-1,0,1,2,-1,-4}).play();

        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(List.of(-1,-1,2));
        expectedResult.add(List.of(-1,0,1));
        assertEquals(threeSum, expectedResult);
    }

}