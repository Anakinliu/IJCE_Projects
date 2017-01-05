/**
 * Created by Anakinliu.
 * On 2016/12/10.
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * Swing����������
 * @create Apr 24, 2013 1:52:44 PM
 * @author ����<http://blog.csdn.net/jadyer>
 */
public class JProgressBarDemo {
    Timer timer;
    JProgressBar jpbFileLoading;

    public JProgressBarDemo() {
        JFrame jf = new JFrame("����������");
        /**
         * ����һ������ģʽ�Ľ�����,��Ĭ��Ϊˮƽ����,��СֵΪ0,���ֵΪ100,��ʼֵΪ0
         */
        jpbFileLoading = new JProgressBar();
        jpbFileLoading.setStringPainted(true);  //���ý��������ֽ����ַ���,Ĭ��Ϊfalse
        jpbFileLoading.setBorderPainted(false); //�����Ʊ߿�,Ĭ��Ϊtrue
        jpbFileLoading.setPreferredSize(new Dimension(400, 40)); //������ѡ��С
        timer = new Timer(50, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int loadingValue = jpbFileLoading.getValue();
                if (loadingValue < 100){
                    jpbFileLoading.setValue(++loadingValue);
                }else {
                    timer.stop();
                }
            }
        });
        timer.start();
//        /**
//         * ����һ����ȷ��ģʽ�Ľ�����
//         */
//        JProgressBar jpbFileLoadingIndeterminate = new JProgressBar();
//        jpbFileLoadingIndeterminate.setIndeterminate(true); //���ý�����Ϊ��ȷ��ģʽ,Ĭ��Ϊȷ��ģʽ
//        jpbFileLoadingIndeterminate.setStringPainted(true);
//        jpbFileLoadingIndeterminate.setString("�ļ�������......");
        /**
         * �����ֽ������ŵ��������
         */
        jf.add(jpbFileLoading, BorderLayout.NORTH);
        jf.add(new JLabel("����Ϊ���������������Ϊ��ȷ��ģʽ������", SwingConstants.CENTER), BorderLayout.CENTER);
        //jf.add(jpbFileLoadingIndeterminate, BorderLayout.SOUTH);
        jf.setSize(300, 150);
        jf.setLocationRelativeTo(null); //������ʾ
        jf.setUndecorated(true);        //���ô˴����װ��
        jf.getRootPane().setWindowDecorationStyle(JRootPane.NONE); //����ָ���Ĵ���װ�η��
        jf.setVisible(true);
        /**
         * ��ȷ��ģʽ�Ľ���������
         */
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        jpbFileLoadingIndeterminate.setIndeterminate(false); //���ý�����Ϊȷ��ģʽ,������ģʽ,�����Ǹ�������������ȥ
//        jpbFileLoadingIndeterminate.setString("�ļ��������..");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * �رմ���
         */
        jf.setVisible(false); //���ش���
        jf.dispose();         //�ͷ���Դ,�رմ���
        jf = null;            //������ʹ���˾�����
    }


//    public static void main(String[] args) {
//        new JProgressBarDemo();
//    }
}
