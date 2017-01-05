/**
 * Created by Anakinliu.
 * On 2016/12/10.
 */
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.swing.*;

//声音控制类
public class AudioControl {

    AudioClip ac;
    URL url;
    boolean done;
    JProgressBar bgmFileLoading;
    Timer timer;
    public AudioControl(String audioFileName) {
        try {
            //创建音频文件
            int loadingValue = 0;

            bgmFileLoading = new JProgressBar();
            bgmFileLoading.setStringPainted(true);  //设置进度条呈现进度字符串,默认为false
            bgmFileLoading.setBorderPainted(false); //不绘制边框,默认为true
            bgmFileLoading.setPreferredSize(new Dimension(400, 40)); //设置首选大小
            //System.out.println(bgmFileLoading.getValue()); //初始值0
            File audioFile = new File(audioFileName);
            URI uri = audioFile.toURI();
            URL url = uri.toURL();
            timer = new Timer(50, new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    int loadingValue = bgmFileLoading.getValue();
                    if (loadingValue < 100){
                        bgmFileLoading.setValue(++loadingValue);
                    }else {
                        timer.stop();
                    }
                }
            });
            ac = Applet.newAudioClip(url);
            done = true;
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "文件格式出错"
                    , "警告", JOptionPane.ERROR_MESSAGE);
            System.out.println("文件格式出错");
        }
    }

    //循环播放音乐
    public void loop() {
        ac.loop();
    }

    //播放音乐
    public void play() {
        ac.play();
    }

    //停止播放
    public void stop() {
        ac.stop();
    }


}
