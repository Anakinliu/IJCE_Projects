package InnerClass;

/**
 * Created by Anakinliu on 2017/2/6.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Parcel10 {

    //在内部类使用的参数必须是final的！！！
    public Destination destination (final String dest, final float price) {

        return new Destination() {
            private int cost;

            //初始化每个对象,加括号
            {
                cost = Math.round(price);   //返回最接近参数的int

                if (cost > 100)
                    System.out.println("Over budget");
            }
            private String label = dest;
            public String readLabel () {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();

        Destination d= parcel10.destination("N", 100.1f);
    }
}
