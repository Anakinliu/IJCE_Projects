package com.ZZ;

/**
 * Created by liu_y.
 * On 2016/9/19.
 */
public class Count3Quit2 {
    public static void main(String[] args) {
        KidCircle c = new KidCircle(500);
        Kid delete = new Kid();
        int countNumber = 0;
        int i=c.first.id;
        delete = c.first;
        for (;c.count > 1;) {
            countNumber ++;
            delete = delete.right;
            if (countNumber == 3) {
                countNumber = 0;
                c.deleteKid(delete);
            }

        }
        System.out.println(c.first.id);
//        int countNumber = 0;
//
//        while (c.count > 1) {
//            countNumber ++;
//            c.first.id
//        }
    }
}
class Kid {
    int id;

    public void setId(int id) {
        this.id = id;
    }

    Kid left;
    Kid right;
}

class KidCircle {
    int count = 0;
    Kid first,last;

    KidCircle(int c) {
        for (int i=0; i<c; i++) {
            addKid();
        }
    }

    void addKid() {
        Kid k = new Kid();
        k.id = count;

        if (count <= 0) {
            first = k;
            last = k;
            k.right = k;
            k.left = k;
        }
        else {
            last.right = k;
            k.left = last;
            k.right = first;
            first.left = k;
            last = k;
        }
        count ++;
    }

    void deleteKid(Kid k) {
        if (count <= 0) {
            System.out.println("目前数量为零，无法操作！！！");
            return;
        }
        else if (count == 1) {
            first = last = null;
        }
        else {
            k.left.right = k.right;
            k.right.left = k.left;

            if (k == first) {
                first = k.right;
            }else if (k == last) {
                last = k.left;
            }
        }
        count --;
    }
}
