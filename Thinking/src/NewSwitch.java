/**
 * Created by Anakinliu on 2017/1/7.
 */
public class NewSwitch {
    static void switchIt (String s) {
        switch (s) {
            case "red" :
                System.out.println("red");
                break;
            case "black" :
                System.out.println("black");
                break;

        }
    }

    public static void main(String[] args) {
        switchIt("red");
    }
}
