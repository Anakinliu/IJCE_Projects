package polymorphismANDinterface;

import javax.swing.*;

/**
 * Created by Anakinliu on 2017/1/24.
 */
interface Di extends Ai,Bi,Ci {
    void D11();
}
abstract class E extends JFrame implements Di {
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
}
public class AbstractExtendsInterface extends E {
    public static void main(String[] args) {
        AbstractExtendsInterface aei = new AbstractExtendsInterface();

        aei.inAi(aei);
        aei.inBi(aei);
        aei.inCi(aei);
        aei.inDi(aei);
    }
}
