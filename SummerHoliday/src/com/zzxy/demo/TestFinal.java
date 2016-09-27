package com.zzxy.demo;

/**
 * Created by liu_y.
 * On 2016/8/23.
 */
public final class TestFinal {
    protected static  int x = 9;
    protected static final int fx = 6;
    final void sWord(){
        System.out.println("final");
    }
    public static void main(String[] a) {
    }
}

class NoFinal {

    protected static int x;
    protected  final int f( final int xxx ){
        return xxx;
    }
    public void x(TestFinal tf){
        tf.x=4;
    }
   public static void main(String[] args){
       TestFinal ttf = new TestFinal();
       TestFinal ttttf = new TestFinal();


       NoFinal nf = new NoFinal();
       nf.x(ttf);

       System.out.println("tt.x = " + ttf.x);
       System.out.println("tttt.x = " + ttttf.x);
       System.out.println(nf.f(ttf.fx));
   }
}
