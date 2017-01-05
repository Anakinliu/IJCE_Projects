package com.zzxy.fish;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//子弹对象
public class Bullet extends Thread{
	//特征
	//1.子弹种类--图片
	BufferedImage img;
	//2.坐标
	int x;
	int y;
	//3.大小
	int width;
	int height;
	//4.子弹弧度
	
	double roate;
	Point p;//定义为子弹发射前的起始坐标（p.x,p.y)
	
	Pool pl;//定义池塘
	int xx;
	int yy;
	
	boolean isLive;//子弹的线程是否存活
	
	//添加构造方法
	//将无参改为有参
	public Bullet(Pool pol){
		try {
			img=ImageIO.read(new File("images/bullet1.png"));
			width=img.getWidth();
			height=img.getHeight();
			pl=pol;
			//表示子弹刚创建时线程启动正常
			isLive=true;
		} catch (IOException e) {
		System.out.println("子弹图片有误");
		}
	}
	//行为
//调用线程中的run方法
	public void run(){
	   while (isLive==true) {
		//调用move（）方法
		   move();
		   try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	}
	//x=a+Math.sin(弧度)*r
	//y=b-Math.cos(弧度)*r		
	//定义一个方法---实现子弹移动
	public void move(){
		y=y-10;
		int r=p.y-y;//求出半径
		//xx表示子弹发射后运行中的x坐标
		//Math.sin(roate)得到double的类型的结果（float）Math.sin（roate）将结果强制转换为float类型
		//Math.round(float类型)四舍五入，返回一个int类型的结果
		xx=p.x+Math.round((float)Math.sin(roate))*r;
		yy=p.y-Math.round((float)Math.cos(roate))*r;
	    //调用hint方法   子弹每走一步都要检测
		hint();
	
	}
	//定义一个方法----检测子弹是否击中鱼
	
	public void hint(){
		//使用循环遍历池塘中的每一条鱼
		Fish[] fishes=pl.fish;
		for (int i = 0; i <fishes.length; i++) {
			//从数组中取出每一条鱼
			Fish f=fishes[i];
			//判断子弹是否击中鱼
			if (xx>=f.x && xx<=f.x+f.width && yy>=f.y && yy<=f.height) {
				f.isCatched=true;//将鱼的isCatched修改为true，鱼会消失
				pl.num++;//统计鱼的条数
				pl.bullets.remove(this);//子弹从面板中消失，线程仍然运行
				isLive=false;//子弹击中鱼后，子弹线程停止
			}
			
			
			
		}
		
	}
	
	
	
	
	
	
}

















