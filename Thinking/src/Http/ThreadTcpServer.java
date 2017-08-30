package Http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Anakinliu on 2017/8/29.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class ThreadTcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket =
                    new ServerSocket(81);
            Socket socket = serverSocket.accept();

            /*
            每次有一个新的连接进来的时候就会新起一个线程，
            专门负责与那个客户端通讯。这样的话，
            我们的服务端就有能力同时处理多个请求了。
            */
            while (socket != null) {
                new ClientConnection(socket).start();
                socket = serverSocket.accept();
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
