package HoldingObjects;

/**
 * Created by Anakinliu on 2017/3/22.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
import java.util.*;
import static print.Print.*;

public class ListFeatures {
    // method to make a List<Integer> with random values < n:
    public static List<String> listOfRandInteger(int length, int n) {
        Random rand = new Random();
        List<String> li = new ArrayList<String>();
        for(int i = 0; i < length; i++)
            li.add(String.valueOf("i" + rand.nextInt(10)));
        return li;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        List<String> li = listOfRandInteger(7, 10);
        print("1: " + li);
        String h = "i" + rand.nextInt(10);
        li.add(h);
        print("2: " + li);
        print("3: " + li.contains(h));
        // removes the first instance equivalent to Integer h:
        li.remove(h);
        print("3.5: " + li);
        String p = li.get(2);
        print("4: " + p + " " +  li.indexOf(p));
        Integer cy = rand.nextInt(10);
        //Compares this object to the specified object.
        // The result is true if and only if
        // the argument is not null and
        // is an Integer object that contains
        // the same int value as this object.
        print("5: " + cy +" " + li.indexOf(cy));
        print("6: " + li.remove(cy));
        print("7: " + li.remove(p));
        print("8: " + li);
        li.add(3, "i" + rand.nextInt(10));
        print("9: " + li);
        List<String> sub = li.subList(1, 4);
        // 不包含下标为第二个参数的
        print("sublist: " + sub);
        print("10: " + li.containsAll(sub));

        sub.add("i" + 999);
        print("sublist is added 999: " + sub);

        print("li" + li);

        // will also sort sub elements within li:
        Collections.sort(sub);
        print("sorted sublist: " + sub);
        print("Collections.sort(sub) sorted li: " + li);
        print("11: " + li.containsAll(sub));
        print("11.25: " + li);
        // will also shuffle sub elements within li:
        Collections.shuffle(sub, rand);
        print("11.5: " + li);
        print("shuffled sublist: " + sub);
        print("12: " + li.containsAll(sub));
        List<String> copy = new ArrayList<>(li);
        print("12.5: " + li);
        sub = Arrays.asList(li.get(1), li.get(4));
        print("sub: " + sub);
        copy.retainAll(sub);
        print("13: " + copy);
        copy = new ArrayList<>(li);
        copy.remove(2);
        print("14: " + copy);
        copy.removeAll(sub);
        print("15: " + copy);
        if(copy.size() > 1) // to avoid out of bounds exception
            copy.set(1, "i" + 8); // autoboxing int -> Integer
        print("16: " + copy);
        if(copy.size() > 2)
            copy.addAll(2, sub);
        print("17: " + copy);
        print("18: " + li.isEmpty());
        li.clear();
        print("19: " + li);
        print("20: " + li.isEmpty());
        li.addAll(listOfRandInteger(4, 10));
        print("21: " + li);
        Object[] o = li.toArray();
        print("22: " + o[3]);
        String[] ia = li.toArray(new String[0]);
        println("23: ");
        for (String e : ia) {
            println(e + " ");
        }
    }
}