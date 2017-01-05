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

//����������
public class AudioControl {

    AudioClip ac;
    URL url;
    boolean done;
    JProgressBar bgmFileLoading;
    Timer timer;
    public AudioControl(String audioFileName) {
        try {
            //������Ƶ�ļ�
            int loadingValue = 0;

            bgmFileLoading = new JProgressBar();
            bgmFileLoading.setStringPainted(true);  //���ý��������ֽ����ַ���,Ĭ��Ϊfalse
            bgmFileLoading.setBorderPainted(false); //�����Ʊ߿�,Ĭ��Ϊtrue
            bgmFileLoading.setPreferredSize(new Dimension(400, 40)); //������ѡ��С
            //System.out.println(bgmFileLoading.getValue()); //��ʼֵ0
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
            JOptionPane.showMessageDialog(null, "�ļ���ʽ����"
                    , "����", JOptionPane.ERROR_MESSAGE);
            System.out.println("�ļ���ʽ����");
        }
    }

    //ѭ����������
    public void loop() {
        ac.loop();
    }

    //��������
    public void play() {
        ac.play();
    }

    //ֹͣ����
    public void stop() {
        ac.stop();
    }


}
