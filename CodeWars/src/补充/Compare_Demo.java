package 补充;

/*
    AUTHOR: linux
    TIME: 2020/2/24
    GOOD LUCK AND NO BUG.
*/
public class Compare_Demo implements Comparable {
    @Override
    public int compareTo(Object o) {
        // 类的定义是否相同
        if (this.getClass() != o.getClass()) {
            throw new ClassCastException();
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("compare");
    }
}
