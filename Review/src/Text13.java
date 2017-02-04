
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by Anakinliu on 2017/1/5.
 */
public class Text13 {
    public static void fileCopy(String in, String out) {
        //ÉùÃ÷in,outÍ¨µÀ
        FileChannel inChannel;
        FileChannel outChannel;
        try {
            FileInputStream inputStream = new FileInputStream(in);

            FileOutputStream outputStream = new FileOutputStream(out);

            inChannel = inputStream.getChannel();
            outChannel = outputStream.getChannel();

            //System.out.println(inChannel.size());
            //outChannel.transferFrom(inChannel,0,inChannel.size());
            inChannel.transferTo(0,inChannel.position(),outChannel);

            outChannel.close();
            inChannel.close();
            outputStream.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
    }

    }

    public static void main(String[] args) {
        fileCopy("F:/java¿¼/a.txt","F:/java¿¼/b.txt");
    }
}
