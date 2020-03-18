import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KClosestTest {
    KClosest k = new KClosest();
    @Test
    void kClosest() {
        int[][] test = new int[][]{{0,1},{-4,3},{2,2}};
        int[][] expected = new int[][]{{2,2},{0,1}};
        Assert.assertEquals(expected, k.kClosest(test, 2));
    }

    @Test
    void getSquareSum() {
        int[] arr = new int[]{0,0};
        Assert.assertEquals(0, k.getSquareSum(arr));

        arr = new int[]{-1, -1};
        Assert.assertEquals(2, k.getSquareSum(arr));

        arr = new int[]{1, 1};
        Assert.assertEquals(2, k.getSquareSum(arr));

        arr = new int[]{-2, 5};
        Assert.assertEquals(29, k.getSquareSum(arr));

    }
}