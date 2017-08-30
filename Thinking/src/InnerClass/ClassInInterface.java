package InnerClass;

/**
 * Created by Anakinliu on 2017/2/9.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public interface ClassInInterface {

    //此类还可以实现外围接口
    class PublicImplements {

        public static String getName() {
            return "Yes!";
        }
    }

}
