package polymorphismANDinterface;


import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Anakinliu on 2017/1/26.
 */

public class RandomWords implements Readable{

    private static Random rand = new Random(47);

    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    //private static final char[] capitals = null;
    private static final char[] lowers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().toCharArray();
    //private static final char[] lowers = null;
    private static final char[] vowels = "aeiou".toCharArray();
    //private static final char[] vowels = null;
    private int count;

    public RandomWords(int count) {
        this.count = count;
    }


    public int read(CharBuffer cb) {
        if (count-- == 0) {
            return  -1; //如果不是-1则一直读取
        }
        //System.out.println(count);
        cb.append(capitals[rand.nextInt(26)]);

        for (int i=0; i<4; i++) {
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }

        cb.append(" "); //Scanner的默认分隔符，会分成count个
        return 1;

    }

    public static void main(String[] args) {
//        try {
//            Scanner s = new Scanner(new File("com.jpg"));
//            while (s.hasNext()) {
//                System.out.println(s.next());
//            }
//        }
//        catch (Exception r)
//        {
//            System.out.println("error");
//        }
        Scanner s = new Scanner(new RandomWords(1));


        while (s.hasNext()) {
            System.out.println(s.hasNext());
            System.out.println("s.next():" + s.next());
        }

    }











}
