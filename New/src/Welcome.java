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

    public Welcome () {

        buttons = new GameButton[2];
        buttons[0] = new GameButton(new ImageIcon("images/play.png"));
        buttons[1] = new GameButton(new ImageIcon("images/quit.png"));
        buttons[0].addMouseListener(buttons[0]);
        buttons[1].addMouseListener(buttons[1]);

        jpbFileLoading = new JProgressBar();
        jpbFileLoading.setStringPainted(true);  //是否呈现字符串
        jpbFileLoading.setBorderPainted(true); //如果进度条应该绘制其边框，则此属性为 true。
        jpbFileLoading.setPreferredSize(new Dimension(40, 40)); //进度条大小



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
        timer.start();      //计时器开始
        JLabel text = new JLabel();
        text.setText("Loading Audio...");
        load.setBackground(new Color(244,153,11));
        text.setBackground(new Color(244,153,11));
        text.setOpaque(true);
        load.add(text,BorderLayout.WEST);
        jpbFileLoading.setBackground(new Color(244,153,11));
        jpbFileLoading.setToolTipText("Loading Audio...");
        load.add(jpbFileLoading, BorderLayout.CENTER);
        load.setSize(600, 30);
        load.setLocationRelativeTo(null); //设置窗口相对于指定组件的位置
        load.setUndecorated(true);        //禁用此窗体的装饰。
        load.getRootPane().setWindowDecorationStyle(JRootPane.NONE); //设置 JRootPane 应提供的 Window 装饰类型,NONE不应提供任何类型的 Window 装饰。
        try {
            load.setIconImage(ImageIO.read(new File("images/icon.png")));
            welcomeWindow.setIconImage(ImageIO.read(new File("images/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Welcome Icon error");
        }

        welcomeWindow.setSize(600,800);
        welcomeWindow.setLocationRelativeTo(null);
        welcomeWindow.setUndecorated(true);


        load.setVisible(true);
        //加载音频文件
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
//        this.add(buttons[0]);
//        this.add(buttons[1]);
//        welcomeWindow.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 2;
//        gbc.gridheight = 1;
        //this.setBounds(0,0,600,600);
        welcomeWindow.add(this,BorderLayout.CENTER);
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 1;
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
