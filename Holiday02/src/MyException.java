/*
    AUTHOR: linux
    TIME: 2019/1/31
    GOOD LUCK AND NO BUG.
*/
public class MyException extends RuntimeException {
    static final long serialVersionUID = 172404351301239713L;

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
