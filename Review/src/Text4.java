/**
 * Created by Anakinliu on 2016/12/29.
 */



import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by liu_y.
 * On 2016/10/21.
 */
public class Text4 {
    public static void show(int year, int month) {
        Calendar rightNow = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。

        //根据输入的年月，初始化
        rightNow.set(Calendar.YEAR,year);//
        rightNow.set(Calendar.MONTH,month - 1);//
        rightNow.set(Calendar.DAY_OF_MONTH,1);//将天初始化成月份的第一天

        System.out.println("日\t一\t二\t三\t四\t五\t六\t");

        int dayOfWeek;

        //DATE与DAY_OF_MONTH是同义词

        for (int i=1;i <=rightNow.get(Calendar.DAY_OF_MONTH); i++) {

            //这天星期几
            dayOfWeek = rightNow.get(Calendar.DAY_OF_WEEK);

            //打印第一行的\t，只在i=1执行
            if (i == 1) {
                for (int j=1;j<dayOfWeek;j++) {
                    System.out.print("\t");
                }
            }

            System.out.print(i+ "\t");

            if (dayOfWeek == 7) {
                System.out.println();
            }

            //天数向前滚动一
            rightNow.roll(Calendar.DAY_OF_MONTH,1);
        }
    }
    public static void main(String[] args) {

        System.out.println("输入年，月");
        Scanner input = new Scanner(System.in);
        show(input.nextInt(),input.nextInt());
    }
}

