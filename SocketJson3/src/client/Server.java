package client;

/*
    AUTHOR: linux
    TIME: 2019/12/24
    GOOD LUCK AND NO BUG.
*/
public class Server {
    public static void main(String[] args) {
        System.out.println("服务器启动了,等待客户端连接...\n" +
                "有客户端连接了\n" +
                "/127.0.0.1:60290\n" +
                "来自本机的Socket\n + " +
                "/192.168.1.11:43429\n" +
                "来自非本机的Socket\n");
    }
}
