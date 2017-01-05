import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by Anakinliu.
 * On 2016/12/9.
 */
public class WindowFrame {

    JFrame window;
    Road road;
    Welcome wel;
    Thread runRoad;
    GameButton restart;
    static boolean playTimes;
    public WindowFrame() {
        restart = new GameButton(new ImageIcon("images/restart.png"));

        wel =  new Welcome();
        wel.repaint();


        while (!wel.buttons[0].clicked) {
            if (wel.buttons[1].clicked) {
                //System.out.println("buttons[1].clicked");
                Welcome.quit.play();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
            //System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        wel.welcomeWindow.dispose();

        window = new JFrame("Way");
        road = new Road();
//        road.addKeyListener(road);
        runRoad = new Thread(road);
        Welcome.bgm.loop();
        //aThread.start();
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //super.keyTyped(e);
                //JOptionPane.showMessageDialog(null, "你键入了一个键");
                // System.out.println("keyTyped" +" " + e.getKeyChar());

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //super.keyPressed(e);
                //System.out.println("keyPressed" +" " + e.getKeyChar());


               if (road.myCar.boomed()) {
                       Welcome.bgm.stop();
                       //Welcome.gameOver.play();
                   if (e.getKeyChar() == 'q') {
                       Welcome.quit.play();
                       try {
                           Thread.sleep(3000);
                           Welcome.quit.stop();
                       } catch (InterruptedException e1) {
                           e1.printStackTrace();
                       }

                       System.exit(0);
                   } else if (e.getKeyChar() == 'r') {
                       //System.out.println("r pressed");
                       road.myCar.aim = 200;
                       Welcome.gameOver.play();
                       try {
                           Thread.sleep(1500);
                       } catch (InterruptedException e1) {
                           e1.printStackTrace();
                       }
                       Welcome.bgm.play();
                       road.myCar.setBoomed(false);
                       road.myCar.setX(300);
                       road.myCar.setY(600);
                   }
               }else {
                   if (road.myCar.getAim()<=0) {
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e1) {
                           e1.printStackTrace();
                       }
                       //Welcome.gameOver.play();

                       if (e.getKeyChar() == 'q') {
                           Welcome.quit.play();
                           try {
                               Thread.sleep(3000);
                               Welcome.quit.stop();
                           } catch (InterruptedException e1) {
                               e1.printStackTrace();
                           }
                           System.exit(0);
                       } else if (e.getKeyChar() == 'r') {
                           System.out.println("r pressed");
                           road.myCar.aim = 200;
                           Welcome.succee.play();
                           Welcome.bgm.play();


                           Welcome.complete.stop();


                           //road.myCar.setBoomed(false);
                           road.myCar.boom = false;
                           road.myCar.setX(300);
                           road.myCar.setY(600);
                       }
                   }
               }
                if (!road.myCar.boomed()) {
                    //System.out.println("get key...");
                    road.myCar.which(e.getKeyChar());
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // super.keyReleased(e);
                //System.out.println("keyReleased" + " " + e.getKeyChar());
            }
        });

        window.add(road);
        //window.add(road.myCar);
        try {
            window.setIconImage(ImageIO.read(new File("images/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("icon error");
        }
        window.setVisible(true);
        window.setSize(605, 800);
        window.setDefaultCloseOperation(3);
        window.setLocationRelativeTo(null); //居中显示
//        window.setUndecorated(true);        //禁用此窗体的装饰
        window.setLocation(700, 100);
        window.setResizable(false);
        //road.runRoad();
        runRoad.start();
    }
    public static void main(String[] args) {
        WindowFrame wf = new WindowFrame();

    }

}
