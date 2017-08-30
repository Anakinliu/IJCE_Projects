package InnerClass;
/**
 * Created by Anakinliu on 2017/2/6.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

interface Contents {
    int value();
}

//在这个匿名内部类中，使用默认构造器生成contents

public class Parcel7 {
    public Contents contents() {
        return new Contents() {
            private int i = 9;
            public int value() {
              return i;
            }
        };
    }

    //内部类是下面的简化形式
    class MyContents implements Contents {

        private int i = 9;

        @Override
        public int value() {
            return i;
        }
    }

}
