/*
    AUTHOR: linux
    TIME: 2020/2/26
    GOOD LUCK AND NO BUG.
*/
public class IAmAClass {
    public int pub;
    protected int pro;
    int def;
    private int pri;
    private String ID;

    public int getPri() {
        return pri;
    }

    public IAmAClass(String ID) {
        this.ID = ID;
    }

    public IAmAClass() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void pubMethod() {

    }

    protected void proMethod(String say) {
        System.out.println("protected void method " + say);
    }

    void defMethod() {
    }

    private void priMethod() {

    }

    public static void pubStaMethod() {

    }

    protected static void proStaMethod() {
    }

    static void defStaMethod() {

    }

    private static void priStaMethod() {

    }

}
