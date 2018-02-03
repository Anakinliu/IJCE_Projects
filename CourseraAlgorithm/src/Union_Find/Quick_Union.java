package Union_Find;

/**
 * Created by Anakinliu on 18.1.27.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Quick_Union {
    int[] a;

    public Quick_Union(int N) {
        a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }

    /***
     * 找到给定节点的跟节点
     * @param i
     * @return 给定节点的跟节点
     */
    protected int root(int i) {
        while (i != a[i]) {
            i = a[i];
        }
        return i;  //这时a[i]==i
    }

    /***
     * 将p的根节点连接到q的根上
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        a[pRoot] = qRoot;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }



    public static void main(String[] args) {
        Quick_Union qu = new Quick_Union(10000);
        qu.union(0,9);
        qu.union(9,1);
        Quick_Find.show(qu.a);
    }
}
