package com.anakinliu.servlet;

/**
 * Created by Anakinliu on 17.11.8.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/authImg")
public class AuthImage extends HttpServlet {

    private static final long serialVersionUID = 1L;
    // 设置图形验证码中的字符串的字体的大小
    private Font mFont = new Font("Arial Black", Font.PLAIN, 16);

    public Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);

    }

    public static String code;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 阻止生成的页面内容被缓存，保证每次重新生成随机验证码
//		response.setHeader("Pragma", "No-cache");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 指定图形验证码图片的大小；
        int width = 80;// 宽度
        int height = 20;// 高度
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        // 准备在图片中绘制内容

        Graphics2D g = image.createGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(1, 1, width - 1, height - 1);

        //以随机的背景色填充验证码图片背景
        g.setColor(new Color(102, 102, 102));
        g.drawRect(0, 0, width - 1, height - 1);

        g.setFont(mFont);


        String sRand = "";
        // 生成随机的字符串并加入到图片中
        int LEN = 4; // 控制随机码的长度
        for (int i = 0; i < LEN; i++) {

            String tmp = getRandomChar();
            sRand += tmp;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random
                    .nextInt(110), 20 + random.nextInt(110)));
            g.drawString(tmp, 15 * i + 10, 15);
        }
        code = sRand;

        // 生成干扰线条
        g.setStroke(new BasicStroke(1));
        for (int i = 0; i < 8; i++) {
            g.setColor(getRandColor(100, 200));
            int x1 = 4 + random.nextInt(5);
            int y1 = 5 * i;
            int x2 = width - i;
            int y2 = y1;
            g.draw(new Line2D.Float(x1, y1, x2, y2));
            g.draw(new Line2D.Float(random.nextInt(width),
                    3.0f,
                    width - random.nextInt(width),
                    height - random.nextInt(height)));
        }

        HttpSession session = request.getSession(true);
        // 将其自动转换为小写。也就是说用户在输入验证码的时候，不需要区分大小写，方便输入。
        session.setAttribute("randomImageStr", sRand.toLowerCase());

        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());

    }

    private String getRandomChar() {
        int rand = (int) Math.round(Math.random() * 2);
        char c;
        switch(rand) {
            case 1:
                c = (char)(Math.random() * 9 + 48);
                break;
            case 2:
//                c = (char) (Math.random() * 26 + 65);
//                break;
                c = (char)(Math.random() * 9 + 48);
                break;
            default:
//                c = (char) (Math.random() * 26 + 97);
//                break;
                c = (char)(Math.random() * 9 + 48);
                break;
        }
        return String.valueOf(c);
    }

}
