package Http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Anakinliu on 2017/8/23.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class TcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(81);
            Socket socket = ss.accept(); // 阻塞直到浏览器去请求URL
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String s = null;
            while ((s = br.readLine()) != null && !s.equals(""))  //浏览器请求URL后条件True了
                System.out.println(s);  // readLine()一行行地输出浏览器发送给服务器的内容

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 以下是服务器发送给浏览器显示的内容
            bw.write("HTTP/1.1 200 OK\n");
            bw.write("Content-Type: text/html; charset=UTF-8\n\n");
            bw.write("<html>\n" +
                    "<head>\n" +
                    "    <title>first page</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1>Hello World!</h1>\n" +
                    "</body>\n" +
                    "</html>\n");
            bw.flush();

            br.close();
            bw.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}