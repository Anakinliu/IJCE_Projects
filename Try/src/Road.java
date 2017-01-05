import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

/**s
 * Created by Anakinliu.
 * On 2016/12/9.
 */
public class Road extends JPanel implements Runnable{
    BufferedImage roadImg[] = new BufferedImage[5] ;
    int x,y;
    static int roadI;
    static int boomI;
    Car myCar ;

    boolean play;
    int boomImgX,boomImgY;

    BufferedImage loading;
    BufferedImage gameOver;

    BufferedImage aimImg[] = new BufferedImage[4];
    static int aimI;

    int aimCarX;
    int aimCarY;

    public Road() {
        try {
            /**
             * 创建一个常规模式的进度条,其默认为水平方向,最小值为0,最大值为100,初始值为0
             */
            myCar = new Car();
            myCar.start();
            for (int i=0; i<aimImg.length; i++) {
                aimImg[i] = ImageIO.read(new File("images/aim" + i + ".png"));
            }
            for (int i=0; i<roadImg.length; i++) {
                roadImg[i] = ImageIO.read(new File("images/bg" + (i) + ".png"));
            }
            loading = ImageIO.read(new File("images/loading.png"));
            gameOver = ImageIO.read(new File("images/bad.png"));
            x = y = 0;
        } catch (IOException e) {
            System.out.println("bg,png error");
            e.printStackTrace();
        }
    }

    public BufferedImage[] getRoadImg() {
        return roadImg;
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        Graphics2D g2d = (Graphics2D)g.create();
        //System.out.println(  i + " " + "times");

//        if (myCar.boom && boomI >= myCar.getBoomImg().length) {
//
//
//        }else {
        //画出路面
        if (!myCar.boom && myCar.getAim()>0) {  //正常路面
            if (myCar.aim >=0) {
                myCar. aim =myCar. aim - 1;
            }
            //x = x + (int) (Math.random() * 50) - 25;
           myCar.setX(myCar.getX() + (int)(Math.random() * 100) - 50);
                if (roadI == this.getRoadImg().length) {
                    roadI = 0;
                }
                if (roadI < this.getRoadImg().length) {
                    BufferedImage t = this.getRoadImg()[roadI];
                    g2d.drawImage(t, this.getX(), this.getY(), 600, 800, null);
                    roadI++;
                }
                g2d.drawImage(myCar.getCarImg(), myCar.getX(), myCar.getY(), myCar.getImgWidth(), myCar.getImgHeight(), null);
                //Graphics2D g2d2 = (Graphics2D)g;
                g2d.setFont(new Font("微软雅黑", Font.BOLD, 50));
                g2d.setColor(new Color(255, (int) (Math.random() * 255), (int) (Math.random() * 255), 255));
                //米数
                g2d.drawString("AIM:" + myCar.aim.toString() + "M", 50, 50);
                if (myCar.isRight) {
                    g2d.drawString("R", 500, 50);
                }
                if (myCar.isLeft) {
                    g2d.drawString("L", 400, 50);
                }
                //System.out.println(Car.aim.toString());
                boomImgX = myCar.getX();
                boomImgY = myCar.getY();
                // System.out.println( myCar.getX() + " " + myCar.getY());
                g2d.drawImage(myCar.getBoomImg()[boomI], boomImgX, boomImgY, myCar.getBoomImg()[boomI].getWidth(), myCar.getBoomImg()[boomI].getHeight(), null);

                boomI++;
                if (boomI == myCar.getBoomImg().length) {
                    boomI = 0;
                }
                // System.out.println(myCar.getX() + " " + myCar.getY());
        }
        if (!myCar.boom && myCar.getAim()<=0){ //正常到达目的地
            //System.out.println("aim reached!!....");
            //Graphics2D g2d2 = (Graphics2D)g.create();
            //g.setFont(new Font("微软雅黑",Font.BOLD,50));
            //g.setColor(new Color(255,(int)(Math.random() * 255),(int)(Math.random() * 255),255));
            //g.drawString("GAME    OVER !",100,100);
            //g.drawString("Press Q to quit",100,600);
            //g.drawString("Press R ro restart",100,700);


                //g2d2.drawImage(aimImg[aimI], 0, 0, 600, 800, null);
            Welcome.complete.play();
            System.out.println("aim reached");
            if (aimI >= aimImg.length) {
                    aimI = 0;
            }
            System.out.println(myCar.getAim());
            //System.out.println("GAME OVER!!!");
            g.drawImage(aimImg[aimI],0,0,600,800,null);
            g.drawImage(myCar.getCarImg(), boomImgX, boomImgY, myCar.getImgWidth(), myCar.getImgHeight(), null);
            aimI++;
            g.setFont(new Font("微软雅黑",Font.BOLD,50));
            g.setColor(new Color(255,(int)(Math.random() * 255),(int)(Math.random() * 255),255));
            g.drawString("MISSION COMPLETE!",20,100);
            g.drawString("Press Q to quit",100,600);
            g.drawString("Press R ro restart",100,700);
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
//            if (myCar.getAim() <=0 && !myCar.boom &&  aimI >= aimImg.length) {
//               // aimI = 0;
//                System.out.println("GAME OVER!!!");
//                g.drawImage(roadImg[0],0,0600,600,800,null);
//                g.setFont(new Font("微软雅黑",Font.BOLD,50));
//                g.setColor(new Color(255,(int)(Math.random() * 255),(int)(Math.random() * 255),255));
//                g.drawString("MISSION COMPLETE!",100,100);
//                g.drawString("Press Q to quit",100,600);
//                g.drawString("Press R ro restart",100,700);
//                try {
//                    sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                myCar.boom = false;
//            }

        //车爆炸
            if (myCar.boom){
            //System.out.println("GAME OVER!!!");
               // myCar.setAim(1000);
            g.drawImage(gameOver, 0, 0, 600, 800, null);
            g.setFont(new Font("微软雅黑", Font.BOLD, 50));
            g.setColor(new Color(255, (int) (Math.random() * 255), (int) (Math.random() * 255), 255));
            g.drawString("GAME    OVER !", 100, 100);
            g.drawString("Press Q to quit", 100, 600);
            g.drawString("Press R ro restart", 100, 700);
            try {
                sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
//        if (myCar.boom && boomI < myCar.getBoomImg().length) {
//            System.out.println("draw boom");
//            g2d.drawImage(myCar.getBoomImg()[boomI], boomImgX, boomImgY, myCar.getBoomImg()[boomI].getWidth(), myCar.getBoomImg()[boomI].getHeight(), null);
//            boomI++;
//        }



    }



    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {

        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void run() {
//        while (true)
//        System.out.println("run()......");
        while (true) {
            //System.out.println("road running");
            if (myCar.boomed()) {
                //System.out.println("car has been boom");
                add(new JButton("restart"));
            }
            try {
                repaint();
                sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
