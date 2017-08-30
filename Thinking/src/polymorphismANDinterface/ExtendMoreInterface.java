package polymorphismANDinterface;

/**
 * Created by Anakinliu on 2017/1/24.
 */
interface Ai {
    void Ai1();

    void Ai2();
}

interface Bi {
    void Bi1();

    void Bi2();
}

interface Ci {
    void Ci1();

    void Ci2();
}




public class ExtendMoreInterface extends Object implements Di {
    @Override
    public void Ai1() {

    }

    @Override
    public void Ai2() {

    }

    @Override
    public void Bi1() {

    }

    @Override
    public void Bi2() {

    }

    @Override
    public void Ci1() {

    }

    @Override
    public void Ci2() {

    }

    @Override
    public void D11() {

    }

    public void inAi(Ai ai) {
        System.out.println(ai.getClass().getSimpleName() + " got ! " );
    }

    public void inBi(Bi bi) {
        System.out.println(bi.getClass().getSimpleName() + " got ! " );
    }

    public void inCi(Ci ci) {
        System.out.println(ci.getClass().getSimpleName() + " got ! "  );
    }

    public void inDi(Di di) {
        System.out.println(di.getClass().getSimpleName() + " got ! "  );
    }

    public void inEMI (Object emi) {
        System.out.println(emi.getClass().getSimpleName() + " got ! ");
    }

    public static void main(String[] args) {
        ExtendMoreInterface emi = new ExtendMoreInterface();

        emi.inAi(emi);
        emi.inBi(emi);
        emi.inCi(emi);
        emi.inDi(emi);

        //向上转型,别忘了
        emi.inEMI(new ExtendMoreInterface());
    }
}
