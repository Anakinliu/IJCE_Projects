package package1;

/**
 * Created by Anakinliu on 2017/2/6.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Test {
    private int cost;
    private double pay = 99;
    {
        if (cost == 0)
        System.out.println("error");

        pay = Math.random();
        System.out.println(pay);
        if (pay >0.1) {
            System.out.println("pay:" + pay);
        }
    }
    private String name = "liu";
    public Test(int x) {
        cost = x;
    }


    public static void main(String[] args) {
        //Test test = new Test(66);
        String[] s = new String[] {
          "s"
        };
        System.out.println(s.length);
    }
}
