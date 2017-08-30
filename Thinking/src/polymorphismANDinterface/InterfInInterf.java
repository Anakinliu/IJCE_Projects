package polymorphismANDinterface;

/**
 * Created by Anakinliu on 2017/1/29.
 */
interface QW{
    //接口中嵌套类
    class ER {
        public void ERf() {
            System.out.println("QW.ERf()");
        }
    }
    void QWf();
}

class ExtQW_ER extends QW.ER {

}

class ImpQW  implements QW {
    @Override
    public void QWf() {

    }
}

class ExtAndImp extends QW.ER implements QW {
    @Override
    public void QWf() {

    }
}


//-----------------晕了-----------

//接口中嵌套接口
interface Out {
    interface In {
        void Inf();
    }
    void Outf();
}
class ImpOut implements Out {
    @Override
    public void Outf() {

    }


    //不需要实现嵌套在Out的In接口的方法


}
class ImpIn implements Out.In {
    @Override
    public void Inf() {

    }
    //不需要实现Out接口方法
}
class ImpAll implements Out,Out.In{
    @Override
    public void Inf() {

    }

    @Override
    public void Outf() {

    }
}
public class InterfInInterf {

}
