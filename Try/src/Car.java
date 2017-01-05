import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Anakinliu.
 * On 2016/12/10.
 */
public class Car extends Thread{
    BufferedImage carImg;
    int x,y;
    final static char LEFT = 'a';
    final static char RIGHT = 'd';

    boolean isLeft,isRight;

    int imgWidth,imgHeight;

    BufferedImage boomImg[];

    Integer aim = 200;

    boolean boom;

    boolean boomPlay;
    public Car() {
        super();
        boomImg = new BufferedImage[4];

        try {
            for (int i=0; i<boomImg.length; i++) {
                String boom = "images/boom" + i + ".png";
                boomImg[i] = ImageIO.read(new File(boom));
            }
            x = 300;
            y = 600;

            carImg = ImageIO.read(new File("images/car0.png"));
            imgWidth = carImg.getWidth();
            imgHeight = carImg.getHeight();
        } catch (IOException e) {
            System.out.println("car or boom img error");
            e.printStackTrace();
        }
    }



    public BufferedImage getCarImg() {
        return carImg;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public BufferedImage[] getBoomImg() {
        return boomImg;
    }

    @Override
    public void run() {
        while (true) {
            if (!boom) {
                Welcome.carHong.loop();
            }else {
                Welcome.carHong.stop();
                Welcome.carSkid.stop();
            }
            if (aim <=0) {
                Welcome.carHong.stop();
                Welcome.carSkid.stop();
            }
            //System.out.println(y);
            if (x>=0 && x <=600 - imgWidth && aim >=0) {
                try {

                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }//到达目的地后不能发出Boom声音

            }
            if (x<=0 || x >=600 - imgWidth) {
                boom = true;
            }
               if (!boomPlay && boom ) {
                   //System.out.println("???????????????????");
                   Welcome.boom.play();
                    boomPlay = true;
               }
                Welcome.bgm.stop();
                //boom = true;

            try {
                sleep(50);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                if (aim <= 0) {
                    Welcome.bgm.stop();

                }


                // if (!boom) {
                if (isLeft) {
                    x = x - 10;
                    Welcome.carSkid.play();
                    if (x <= 0) {
                        //System.out.println("boomed" + x + " " + y);
                        //System.out.println("boom play");
                        Welcome.boom.play();
                        boom = true;
                    }
                    isLeft = false;
                }
                if (isRight) {
                    x = x + 10;
                    Welcome.carSkid.play();
                    if (x >= (600 - imgWidth)) {
                        //System.out.println("boomed" + x + " " + y);
                        //System.out.println("boom play");
                        Welcome.boom.play();
                        boom = true;
                    }
                    isRight = false;
                }
                // }
            }

    }
    public void setBoomed(boolean t) {
        boom = t;
    }
    public boolean boomed() {
        return boom;

    }

    public void which(char c) {

       if (c == LEFT) {

            isLeft = true;
        } else if (c == RIGHT) {

            isRight = true;
        }
        if (c == 'r') {
           boomPlay = false;
        }
    }

    public Integer getAim() {
        return aim;
    }

    public void setAim(Integer aim) {
        this.aim = aim;
    }
}
