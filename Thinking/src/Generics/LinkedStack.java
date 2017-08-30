package Generics;

/**
 * Created by Anakinliu on 2017/6/14.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class LinkedStack<T> {
    /*
    节点内部类, 每个节点包含
    节点的内容--T item,
    下一个节点--Node<T> next,
     */
    private class Node {
        T item;
        Node next;
        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
        /*
        判断栈是否为空
        此栈在创建时, 会有一个"空的栈底"
         */
        boolean end () {
            return item == null && next == null;
        }
    }
    private Node top = new Node(); // 结束标记

    public void push(T item) {
        top = new Node(item, top);
    }
    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        for (String s : "Phasers on stun!".split(" "))
            linkedStack.push(s);
        String s;
        while ((s = linkedStack.pop()) != null) {
            System.out.println(s);
        }
    }

}
