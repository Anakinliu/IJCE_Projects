package Tests;

/**
 * Created by Anakinliu on 17.10.24.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public final class TestPrivateConstructor {

    private static TestPrivateConstructor privateConstructor
        = new TestPrivateConstructor();

    private TestPrivateConstructor() {
        System.out.println(">............<");
    }

    public static void showInfo() {
        System.out.println(">>>>>>>>>>>>");
    }

}
