package S1;

public class Simple {

    public static void main(String[] args) {

        Thread thread3 = new Thread(new Runnable() {
            int i = 1;
            @Override
            public void run() {
                while (i < 22) {
                    System.out.println(i);
                    i++;
                }
            }
        });
        thread3.start();
    }
}
