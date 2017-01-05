package com.zzxy.snow;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
//让雪花对象成为线程，通过线程完成雪花下落，多个雪花的下落是一种“并发”执行的现象

public class Snow extends Thread{
	
	
	BufferedImage xh;
	//大小
	int width;
	int height;
	//位置
	int x;
	int y;
	//雪花移动的步伐
	int step;
	
	public Snow(){
		try {
			xh=ImageIO.read(new File("images/snow.png"));
			
			//读取图片大小
			width=xh.getWidth();
		    height=xh.getHeight();
		    
		    Random r=new Random();
		    //r.nextInt(5)产生的是0~4的随机数 r.nextInt(5)+1是产生的1~5之间的随机数
		    x=r.nextInt(600)+1;
		    y=500;
		    //给step赋值的内容为1~5之间的随机数
		    //Random     该类是java.util包中的一个工具类 主要是产生随机数的类
		    
		    //r.nextInt(5)产生的是0~4的随机数 r.nextInt(5)+1是产生的1~5之间的随机数
		    step=r.nextInt(5)+1;
		    
		
		} catch (IOException e) {
		System.out.println("图片读取有误！");
		}
	}
	
	//方法
    //调用run
	public void run() {
		while (true) {
			
			y=y+step;
			
			//当雪花落出窗体是，x和step重新赋值
			if (y>=600) {
		        y=-30;
		        
		        Random r=new Random();
				 x=r.nextInt(600)+1;
				 step=r.nextInt(5)+1;
				
			}
			System.out.println(x+"  "+y);//死循环中实现y++；让雪花不断下落
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	

}
