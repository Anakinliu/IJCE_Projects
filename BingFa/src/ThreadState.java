import java.util.Arrays;

public class ThreadState {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Thread.State.values()));
//        输出
//        [NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED]
    }
}
