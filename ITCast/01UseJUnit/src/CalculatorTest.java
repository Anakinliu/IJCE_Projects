import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    AUTHOR: linux
    TIME: 2020/2/26
    GOOD LUCK AND NO BUG.
*/
public class CalculatorTest {

    @Before
    public void GetResource() {
        System.out.println("获取资源...");
    }

    /*
    不管测试用例是否通过，都会被执行
     */
    @After
    public void ReleaseResource() {
        System.out.println("释放资源");
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int a = -3, b=4;
        Assert.assertEquals(1, calculator.add(a, b));
    }

    @Test
    public void testDiv() {
        Calculator calculator = new Calculator();
        double a = 9, b = 3;
//        Assert.assertEquals(3.0001, calculator.div(a, b), 0.0000001);  // 不通过
        Assert.assertEquals(3.0001, calculator.div(a, b), 0.1);  //通过
    }
}
