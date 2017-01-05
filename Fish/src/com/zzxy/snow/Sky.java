package com.zzxy.snow;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
//继承
public class Sky extends JPanel{
	
	BufferedImage tk;
	//一个雪花
	//Snow snow;
	
	//多个雪花 --使用数组存储多个雪花对象
	Snow[] snows;
	//读取图片
	//无参构造方法
	public Sky(){
		try {
			
			tk=ImageIO.read(new File("images/sky.jpg"));
		//snow=new Snow();
		//snow.start();//通过start（）方法启动雪花线程
		
			//先创建数组容器大小
			snows=new Snow[50];
	        //使用循环往数组中放入雪花对象
			for (int i = 0; i < 50; i++) {
				//每一次循环创建一个雪花对象
				Snow s=new Snow();
				//将创建出来的雪花放入数组中
				snows[i]=s;
				//依次将数组中的每一个雪花对象的线程启动
				snows[i].start();
				
			}
			
		
		} catch (IOException e) {
			System.out.println("读取图片有误！");
		}
	}
	//添加一个绘画功能
	public void paint(Graphics g){
		super.paint(g);
		//用g将背景画出来
		g.drawImage(tk, 0, 0, 600, 600, null);
		//g.drawImage(snow.xh, snow.x, snow.y, snow.width, snow.height,null);
		//使用循环依次画出雪花
		for (int i=0;i<50;i++) {
			g.drawImage(snows[i].xh, snows[i].x, snows[i].y, snows[i].width, snows[i].height, null);
			
		}
	}
	//自定义一个方法--需要不停地调用上面的paint方法
    public void move(){
    	while (true) {
			repaint();
			//repaint()是一个方法，是父类JPanel中的方法
			//作用：该方法会重新调用paint方法执行
			
		}
    }
	
	/*
    方法定义的语法：
    public  方法返回值  方法名（参数列表）{
    方法体
    }
    例子1：  public void study（）{
        ........
        }
               调用方法：study（）；
    例子2：public int sum(int a,int b){
                   return a+b;
    }
    调用方法：  int s=sum(3,2);
  */
	
	
	
	
}















