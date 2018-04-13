package Union_Find;

/**
 * Created by Anakinliu on 18.1.25.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Quick_Find {
    private int[] a;

    public Quick_Find(int N) {
        this.a = new int[N];
        for (int i = 0; i < this.a.length; i++) {
            a[i] = i;
        }
    }

    /**
     * 连接p, q, 就是把数组中与a[q]相等的数替换成a[p], 以此表示相互联通
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        for (int i = 0; i < this.a.length; i++) {
            if (a[i] == a[q])
                a[i] = a[p];
        }
    }

    public boolean connected(int p, int q) {
        return a[p] == a[q];
    }

    public static void show(int a[]) {
        System.out.print("   n: " );
        int i = 0;
        while (i < 10) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
        System.out.print("a[n]: ");
        for (int anA : a) {
            System.out.print(anA + " ");
        }

    }

    public static void main(String[] args) {
        Quick_Find qf = new Quick_Find(10);
        qf.union(0, 1);
        qf.union(1, 9);
        qf.union(4,6);
        qf.union(9, 6);
        qf.show(qf.a);
    }
}
