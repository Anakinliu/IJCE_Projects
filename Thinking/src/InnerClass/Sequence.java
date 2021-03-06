package InnerClass;

/**
 * Created by Anakinliu.
 * On 2016/12/1.
 */
interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() {
            return i == items.length;
        }
        public Object current() {
            return items[i];
        }
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }
    public Selector reverseselector() {
        return new Selector() {
            private int i = items.length -1;
            public boolean end() {
                return i == -1;
            }
            public Object current() {
                return items[i];
            }
            public void next() {
                if (i > -1) {
                    i--;
                }
            }
        };
    }
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i< 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.reverseselector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
