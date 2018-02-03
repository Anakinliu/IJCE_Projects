package Union_Find;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * Created by Anakinliu on 18.1.27.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Quick_Union_Weight extends Quick_Union{

    int sz[];

    public Quick_Union_Weight(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        if (connected(p, q))
            return;
        int pRoot = root(p);
        int qRoot = root(q);

        if (sz[pRoot] < sz[qRoot]) {
            a[pRoot] = qRoot;
//            sz[pRoot] += sz[qRoot];
        } else if (sz[pRoot] == sz[qRoot]) {
            a[qRoot] = pRoot;
            sz[pRoot] += 1;
        } else {
            a[qRoot] = pRoot;
        }
    }

    public static void main(String[] args) {
        Quick_Union_Weight quw = new Quick_Union_Weight(10);
        quw.union(0, 9);
//        Quick_Find.show(quw.a);
//        System.out.println("\n------");
//        Quick_Find.show(quw.sz);
//        System.out.println();
        quw.union(9, 5);

        quw.union(1,2);
        quw.union(2, 3);
//        quw.union(3,2);
        quw.union(2,9);
        quw.union(3,5);
        Quick_Find.show(quw.a);
        System.out.println("\n------");
        Quick_Find.show(quw.sz);
    }
}
