/*
    AUTHOR: linux
    TIME: 2019/10/11
    GOOD LUCK AND NO BUG.
*/
class Operation {
    private double _numberA;
    private double _numberB;

    public double get_numberA() {
        return _numberA;
    }

    public void set_numberA(double _numberA) {
        this._numberA = _numberA;
    }

    public double get_numberB() {
        return _numberB;
    }

    public void set_numberB(double _numberB) {
        this._numberB = _numberB;
    }

    public  double GetResult() throws Exception {
        return 0.0;
    }
}
class OperationAdd extends Operation {
    @Override
    public double GetResult() {
        double result = 0.0;
        result = get_numberA() + get_numberB();
        return result;
    }
}
class OperationSub extends Operation {
    @Override
    public double GetResult() {
        double result = 0.0;
        result = get_numberA() - get_numberB();
        return result;
    }
}
class OperationMul extends Operation {
    @Override
    public double GetResult() {
        double result = 0.0;
        result = get_numberA() * get_numberB();
        return result;
    }
}
class OperationDiv extends Operation {
    @Override
    public double GetResult() throws Exception {
        double result = 0.0;
        if (get_numberB() == 0) {
            throw new Exception("除数不能为0！");
        }
        result = get_numberA() / get_numberB();
        return result;
    }
}
public class SimpleFactory {
    public static Operation createOperate(String opStr) {
        Operation oper = null;
        switch (opStr) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }

    public static void main(String[] args) throws Exception{
        Operation oper = SimpleFactory.createOperate("+");
        oper.set_numberA(1);
        oper.set_numberB(.99);
        oper.GetResult();
    }
}
