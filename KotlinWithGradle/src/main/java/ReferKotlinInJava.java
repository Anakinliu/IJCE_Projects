/*
    AUTHOR: linux
    TIME: 2018/5/13
    GOOD LUCK AND NO BUG.
*/
public class ReferKotlinInJava {
    public static void main(String[] args) {
        User user = new User(1, "female");
        System.out.println(user);

        user = new User(2, null);
        System.out.println(user);
    }
}
