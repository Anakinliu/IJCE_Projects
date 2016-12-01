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
        return "���� ��" + name + "�÷֣�" + score;
    }
}
public class TestTreeSet {
    /*
    2. ����һ��TreeSet���󣬲����������һЩѧ������Student�������������ͳɼ��ֱ�Ϊ
    ����78�֣�����89�֣�����ճɼ����������
��ʾ����Ҫ�ȶ���Student�࣬���Ҹ���Ҫʵ��Comparable�ӿں�ʵ�ָýӿ��е�public int compareTo( )������
ͬʱ������Ҫ��дequals()������hashCode()������

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
        Student s1 = new Student("����",78);
        Student s2 = new Student("����",89);
        Student s3 = new Student("����",60);
        TestTreeSet test = new TestTreeSet();
        test.getStudentSet().add(s1);
        test.getStudentSet().add(s2);
        test.getStudentSet().add(s3);
        System.out.println(test.getStudentSet());
    }
}
