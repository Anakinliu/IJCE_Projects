import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Anakinliu.
 * On 2016/11/5.
 */
class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
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

    @Override
    public int hashCode() {
        return (name == null ? 0 : name.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return this.getName().equals(((Student)obj).getName());
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return (-1) * (new Integer(this.getScore())).compareTo(new Integer(o.getScore())) ;
    }

    @Override
    public String toString() {
        return "姓名 ：" + name + "得分：" + score;
    }
}
public class TestTreeSet {
    /*
    2. 创建一个TreeSet对象，并在其中添加一些学生对象（Student），其中姓名和成绩分别为
    张三78分，李四89分，最后按照成绩降序输出。
提示：需要先定义Student类，并且该类要实现Comparable接口和实现该接口中的public int compareTo( )方法。
同时该类需要重写equals()方法和hashCode()方法。

     */
    private TreeSet<Student> studentSet;

    public TestTreeSet () {
        studentSet = new TreeSet<Student>();
    }

    public TreeSet<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(TreeSet<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public static void main(String[] args) {
        Student s1 = new Student("张三",78);
        Student s2 = new Student("李四",89);
        Student s3 = new Student("张三",60);
        TestTreeSet test = new TestTreeSet();
        test.getStudentSet().add(s1);
        test.getStudentSet().add(s2);
        test.getStudentSet().add(s3);
        System.out.println(test.getStudentSet());
    }
}
