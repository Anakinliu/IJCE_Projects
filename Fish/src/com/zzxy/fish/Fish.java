package com.zzxy.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

//鱼对象
public class Fish extends Thread{
	//特征、属性
	//1.种类--鱼的图片 给变量img赋值的为那张图片，就为那种类型
	BufferedImage img;
	//2.大小
	int width;
	int height;
	//3.位置
	int x;
	int y;	
	//4.速度
	int step;
	//5.鱼自身的十个动作
	BufferedImage[] images;// 该数组用来存储鱼的10个动作图片
	//6.被捕  isCatched表示鱼是否被捕到   如果isCatched为true表示鱼被捕到
	//                              如果isCatched为false表示鱼没有被捕到
	boolean isCatched;
	//7.鱼的两个翻腾动作的图片
	BufferedImage cath01;
	BufferedImage cath02;
	
	//添加无参构造方法
	//将无参构造方法修改为带一个字符串类型参数的构造方法
	public Fish(String type){
		//type表示接收到不同种类的鱼  type=fish01 fish02.....
		try {
			img=ImageIO.read(new File("images/"+type+"_01.png"));
		    //获取图片的真实高度和宽度
			width=img.getWidth();
		    height=img.getHeight();
		    Random r=new Random();
		    x=800;
			y=r.nextInt(500-height)+1;
			step=r.nextInt(6)+1;
			//创建images数组的大小
			images=new BufferedImage[10];
			//使用循环放入动作图片
			for (int i=0;i<10;i++) {
				images[i]=ImageIO.read(new File("images/"+type+"_0"+i+".png"));
				
			}
		    //给变量cath01和cath02赋值
			cath01=ImageIO.read(new File("images/"+type+"_catch_01.png"));
			cath02=ImageIO.read(new File("images/"+type+"_catch_02.png"));
		} catch (IOException e) {
			System.out.println("鱼类中图片读取有误！");
		}
	}
	//行为、方法
	//run方法
	 int index=0;//该变量表示images数组下表   
     public void run() {
			
		while (true) {
			if (isCatched==true) {//条件成立，鱼被捕到
				//翻腾几下，消失重新入场
				turnOver();
				goOut();
			} else {//条件不成立，鱼未被捕到
				//正常游
				//调用move方法
				move();
		}
							
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}			
		}			
	}
     //定义一个方法---鱼游的方法（直线往左游，自身的动画效果）
     public void move(){
    	 x=x-step;
 		//从images数组中依次取出10张不同的动作图片给img赋值
 		//完成动画效果--要按照一定的速度，一定的顺序循环往复的播放10张动作图片
 		
 		//鱼往前游和自己的动画效果都要在线程中完成，在run方法中有while（true）死循环
 		
 		img=images[index];
 		index++;
 		if (index==10) {
 			index=0;
 		}
 		//判断鱼出去重新入场
 		if (x<=-width) {
 			goOut();//调用方法,鱼出去重新入场
 		}
     }
     //定义一个方法--鱼出去重新入场
     public void goOut(){
    	 x=800;
  		Random r=new Random();
  		y=r.nextInt(500-height)+1;
  		step=r.nextInt(6)+1; 
  		isCatched=false;//将鱼的isCatched修改为false，使鱼正常游
     }
     //定义一个方法--鱼被捕后翻腾的效果
     public void turnOver(){
    	 for (int i=0;i<5;i++) {//循环五次，五次翻腾
    		 img=cath01;
    		 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	 img=cath02;
        	 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
     }
     
	

}
