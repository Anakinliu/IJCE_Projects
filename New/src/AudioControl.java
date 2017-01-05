/**
 * Created by Anakinliu.
 * On 2016/12/10.
 */

//声音控制类
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.swing.*;


public class AudioControl {

    AudioClip ac;
    boolean done;

    public AudioControl(String audioFileName) {
        try {

            File audioFile = new File(audioFileName);
            URI uri = audioFile.toURI();
            //根据JDK指示需要用URI类
            URL url = uri.toURL();
            ac = Applet.newAudioClip(url);
            done = true;
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "读取音频文件出错"
                    , "错误！", JOptionPane.ERROR_MESSAGE);
        }
    }

    //循环播放
    public void loop() {
        ac.loop();
    }

    //打次播放
    public void play() {
        ac.play();
    }

    //ֹͣ停止播放
    public void stop() {
        ac.stop();
    }


}
