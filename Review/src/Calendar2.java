import java.util.Calendar;

/**
 * Created by Anakinliu on 2017/1/8.
 */

public class Calendar2 {
    public static void show(int year, int month) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MINUTE,month);
        calendar.set(Calendar.DAY_OF_MONTH,1);

        System.out.println("日\t一\t二\t三\t四\t五\t六\t");
        int dayOFWeek;
        for (int i = 1; i <= calendar.get(Calendar.DAY_OF_MONTH);i++) {

            dayOFWeek = calendar.get(Calendar.DAY_OF_WEEK);

            if (i == 1) {
                for (int j=1; j <= dayOFWeek; j++) {
                    System.out.print("\t");
                }
            }

            System.out.print(i + "\t");

            if (dayOFWeek == 7) {
                System.out.println();
            }

            calendar.roll(Calendar.DAY_OF_MONTH,1);

        }
    }

    public static void main(String[] args) {
        show(2017,1);
    }
}
