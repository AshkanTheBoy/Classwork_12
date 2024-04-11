package Class_0404;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void testCalcOne() {
        System.out.println("======TEST ONE EXECUTED=======");
        int res = Task_00.getResult(2,2);
        Assertions.assertEquals(4, res);
        int res1 = Task_00.getResult(3,2);
        Assertions.assertEquals(9, res1);
        int res2 = Task_00.getResult(3,4);
        Assertions.assertEquals(1, res2);
        int res3 = Task_00.getResult(124,567);
        //System.out.println(res3);
        Assertions.assertEquals(4, res3);
        int res6 = Task_00.getResult(10,9);
        Assertions.assertEquals(0, res6);
    }
} 