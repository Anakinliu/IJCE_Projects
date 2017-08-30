package Java8;

import java.time.LocalDate;

/**
 * Created by Anakinliu on 2017/7/27.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class TimeAndDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(LocalDate.of(2018,1,1));
        System.out.println(Math.floorDiv(-60, 59));
    }
}
