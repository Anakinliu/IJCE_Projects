/**
 * Created by Anakinliu on 2017/1/8.
 */

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet
 * 使用元素的自然顺序对元素进行排序，(无参的构造方法)
 * 或者根据创建 set 时提供的 Comparator 进行排序，
 * 具体取决于使用的构造方法。
 */
class Student implements Comparable{
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Student s = (Student)o;
        if (this.score < s.score) {
            return -1;
        }
        else if (this.score == s.score) {
            return 0;
        }
        else {
            return 1;
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
public class Text10 {
    private TreeSet stus;

    public Text10 (){
        stus = new TreeSet();
        addE();
    }
    public void addE() {
        Student s1 = new Student("张三",78);
        Student s2 = new Student("李四",89);
        stus.add(s1);
        stus.add(s2);
    }
    public  void show () {

        //迭代器
        Iterator iterator = stus.iterator();
        while(iterator.hasNext()) {
            //System.out.println(1);
            Student t = ((Student)(iterator.next()));
            System.out.println(t.getName() + " : " + t.getScore());

        }
    }

    public static void main(String[] args) {
        Text10 test = new Text10();
        test.show();
    }
}
