import java.net.*;
import java.io.*;
public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL web = new URL("http://111.13.100.91");
        URLConnection webc=web.openConnection();
        //get an instance of URLConnection
        BufferedReader in = new BufferedReader(new InputStreamReader(
                webc.getInputStream()));           //use of URLConnection
        String inputLine;
        while ((inputLine = in.readLine()) != null) System.out.println(inputLine);
        in.close();
    }
}
