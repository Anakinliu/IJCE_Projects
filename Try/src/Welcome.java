import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



/**
 * Created by Anakinliu.
 * On 2016/12/10.
 */
public class Welcome extends JPanel {
    Timer timer;
    BufferedImage img;
    JProgressBar jpbFileLoading;
    JFrame load = new JFrame("Loading...");
    JFrame welcomeWindow = new JFrame("WAY");
    static AudioControl bgm,boom,gameOver,quit,succee,carSkid,carHong,complete;

    GameButton buttons[];
    boolean end = true;
    /**
         * 关闭窗体
         */
        //jf.setVisible(false); //隐藏窗体
        //jf.dispose();         //释放资源,关闭窗体
        //jf = null;            //若不再使用了就这样

    public Welcome () {

        buttons = new GameButton[2];
        buttons[0] = new GameButton(new ImageIcon("images/play.png"));
        buttons[1] = new GameButton(new ImageIcon("images/quit.png"));
        buttons[0].addMouseListener(buttons[0]);
        buttons[1].addMouseListener(buttons[1]);

        jpbFileLoading = new JProgressBar();
        jpbFileLoading.setStringPainted(true);  //设置进度条呈现进度字符串,默认为false
        jpbFileLoading.setBorderPainted(false); //不绘制边框,默认为true
        jpbFileLoading.setPreferredSize(new Dimension(40, 40)); //设置首选大小



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
        timer.start();      //开始加载
        //jf.add(new Welcome(),BorderLayout.NORTH);
        JLabel text = new JLabel();
        text.setText("加载音频文件...");
        load.setBackground(new Color(244,153,11));
        text.setBackground(new Color(244,153,11));
        text.setOpaque(true);

        jpbFileLoading.setBackground(new Color(244,153,11));
        jpbFileLoading.setToolTipText("加载音频文件...");

        load.add(text,BorderLayout.WEST);
        load.add(jpbFileLoading, BorderLayout.CENTER);
        load.setSize(600, 30);
        load.setLocationRelativeTo(null); //居中显示
        load.setUndecorated(true);        //禁用此窗体的装饰
        load.getRootPane().setWindowDecorationStyle(JRootPane.NONE); //采用指定的窗体装饰风格
        try {
            load.setIconImage(ImageIO.read(new File("images/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Load Icon error");
        }
        try {
            welcomeWindow.setIconImage(ImageIO.read(new File("images/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Welcome Icon error");
        }

        welcomeWindow.setSize(600,800);
        welcomeWindow.setLocationRelativeTo(null); //居中显示
        welcomeWindow.setUndecorated(true);        //禁用此窗体的装饰
        welcomeWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("welcome clicked");
                if (e.getKeyChar() == 'q') {
                    Welcome.quit.play();
                    System.exit(0);
                }
                if (e.getKeyChar() == 'r') {

                }
            }
        });


        load.setVisible(true);
        //读取文件
        bgm = new AudioControl("sounds/POB.mid");
        boom = new AudioControl("sounds/carBoom.au");
        gameOver = new AudioControl("sounds/over.au");
        quit = new AudioControl("sounds/quit.au");
        succee = new AudioControl("sounds/succeed.au");
        carHong = new AudioControl("sounds/hong.au");
        carSkid = new AudioControl("sounds/skid.au");
        complete = new AudioControl("sounds/complete.au");

        load.setVisible(false);
        load.dispose();

        //添加图片Panel
        welcomeWindow.add(this,BorderLayout.CENTER);

        //添加按钮Panel
        JPanel panel = new JPanel();
        panel.add(buttons[0]);
        panel.add(buttons[1]);
        panel.setSize(600,200);
        panel.setBackground(new Color(244,153,11));
        //panel.setBounds(0,600,600,200);
        welcomeWindow.add(panel,BorderLayout.SOUTH);

        welcomeWindow.setAlwaysOnTop(true);
        welcomeWindow.setVisible(true);
        //welcomeWindow.setCursor(new Cursor());
        //
        try {
            img = ImageIO.read(new File("images/loading.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img,0,0,600,800,null);
    }
}
