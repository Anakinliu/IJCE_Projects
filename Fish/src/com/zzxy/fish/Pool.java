package com.zzxy.fish;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//java中的Pool类表示池塘对象
//extends 继承  让Pool继承JPanel，因为JPanel中有画笔和绘画的功能,子类继承后也有此功能
public class Pool extends JPanel {
	//属性
    //1.水--环境
	BufferedImage bg;
	//2.多条鱼
	//一条鱼--不考虑面向对象的问题
	//一条鱼--以面向对象的设计思想设计一条鱼
	//Fish fish;
	//数组  多条鱼
	Fish[] fish;
	//3.渔网
	Net net;
	//4.统计鱼的条数
	int num;
	//5.计分板
	BufferedImage bars;
	//6.大炮
	Barrel barrel;
	//7.子弹
	
	
	//鼠标坐标
	int mouseX;
	int mouseY;
	//大炮旋转中心点
	int centerX;
	int centerY;
	//大炮弧度
	double f;
	//s使用ArrayList集合表示弹夹，用来存储子弹   <Bullet>表示泛型  规定该集合只能存储子弹类型的
	ArrayList<Bullet> bullets=new ArrayList<Bullet>();
	//构造方法-构造器构造方法：
   // 特点：1）构造方法以public开头
   // 2）构造方法的方法名和类名一致
   // 3）构造方法没有返回值，也没有void
   // 4）构造方法的内容是底层自动调用执行
//意义：对本类中的特征/属性赋值用的
	
	
	
	
	
	
	public Pool(){
		//java中的IO（input   output）流
		//ImageIO是工具类，很方便的读取某一位置的图片，ImageIO的read是以文件的方式读取图片
	     try {
	    	 bg=ImageIO.read(new File("images/bg.jpg"));
	    	 //创建一条鱼
	    	 //fish=new Fish();
	    	 //fish.start();
	    	
	    	 
	    	 fish=new Fish[11];
	    	 for (int i=0;i<9; i++) {
	    		 //每次创建一个鱼对象
	    		// Fish f=new Fish();
	    		 //将创建出来的鱼对象添加到数组中
	    		 //fish[i]=f;
	    		 //new Fish("fish01")--第一种鱼
	    		 //i     =0 1 2 3 4 5 6 7 8     *9  10
	    		 //i+1   =1 2 3 4 5 6 7 8 9     *10 11
	    		 
	    		 fish[i]=new Fish("fish0"+(i+1));//m每一次循环创建一条鱼放入数组中
	    		 fish[i].start();//每次启动一个线程
				}
	    	 //单独创建fish13和fish14
	    	 fish[9]=new Fish("fish13");
	    	 fish[9].start();
	    	 fish[10]=new Fish("fish14");
	    	 fish[10].start();
	    	 //创建一个渔网
	    	 net=new Net();
	    	//对变量bars计分板图片赋值
	    	 bars=ImageIO.read(new File("images/bottom-bar.png"));
	    	 //创建一个大炮
	    	 barrel=new Barrel();
	    	 
	     } catch (IOException e) {
			//在catch中处理异常
			System.out.println("文件读取有误！");
		} 	
	}
	
	
	
	
	
	
	
    //方法	
    //1）添加一个绘画的行为  paint
	//该paint方法是父类JPanel中的
	public void paint(Graphics g) {	
		super.paint(g);
		//使用画笔g将背景bg画出来
		//参   数   1：画图片                             参数2和3：所画图片左上角位置
		//参数4和5：所画图片宽度和高度         参    数  6：无意义
		
		g.drawImage(bg,0,0,800,600,null);
		//使用画笔g将鱼画出来
		
		for (int i = 0;i<fish.length;i++) {
			g.drawImage(fish[i].img, fish[i].x, fish[i].y, fish[i].width, fish[i].height, null);
			
		}
		//画出渔网
		//将渔网左移width/2，上移height/2
		int x=net.x-net.width/2;
		int y=net.y-net.height/2;
		//控制渔网的显示
		if (net.isShow==true) {
			 g.drawImage(net.yw,x,y, net.width, net.height, null);
		}
		//修改画笔颜色
		g.setColor(new Color(255,0,0));
		//使用画笔将捕鱼数量num画在面板中
		g.drawString(num+"", 50, 30);
		//创建当前系统时间
		Date date=new Date();
		g.drawString(date.toString(), 50, 50);
		//使用画笔将计分板画在面板中
		g.drawImage(bars, -6, 502, 800, 71, null);
		//使用画笔画出大炮  Graphics类型的画笔只能画静止的 
		//g.drawImage(barrel.dp, barrel.x, barrel.y,barrel.width, barrel.height, null);
	    
		
		//获取大炮旋转中心点
		centerX=barrel.x+19;
		centerY=barrel.y+39;
		double x1=mouseX-centerX;
		double y1=mouseY-centerY;
		//变量f为大炮旋转弧度
		f=-Math.atan(x1/y1);
		
		//g.create()获得一个新的画笔Graphics类型，强制类型转换为Graphics2D类型
		Graphics2D gp=(Graphics2D)g.create();
		//参数1：图片旋转弧度   参数2和3：图片旋转中心点
		gp.rotate(f,centerX,centerY);
		gp.drawImage(barrel.dp, barrel.x, barrel.y,barrel.width, barrel.height, null);
	   //使用画笔将弹夹中的所有子弹画出来
		//size()求集合大小  length求数组大小
		for (int i = 0; i <bullets.size(); i++) {
			//根据下标取出子弹
			Bullet bullet=bullets.get(i);
			//因子弹有弧度，需要使用Graphics2D画子弹
			//先获得一个新的Graphics2D类型画笔
			Graphics2D g2d=(Graphics2D)g.create();
			//设置子弹的弧度和旋转中心
			g2d.rotate(bullet.roate,centerX,centerY);
			g2d.drawImage(bullet.img, bullet.x, bullet.y, bullet.width, bullet.height, null);
		}
	}
	
	
	
	
	
	
	
	public void move(){
		//添加鼠标的监听事件     MouseAdapter(抽象类) 鼠标适配器   匿名内部类  不能new抽象类
		MouseAdapter mouse=new MouseAdapter() {
		//鼠标进入事件监听--  -- 渔网的显示
		        public void mouseEntered(MouseEvent e) {
			        net.isShow=true;
		        }
		//鼠标离开事件监听--  -- 渔网的隐藏
			    public void mouseExited(MouseEvent e) {
			        net.isShow=false;
			    }
		//鼠标移动事件监听
				public void mouseMoved(MouseEvent e) {
					//
					mouseX=e.getX();
					mouseY=e.getY();
					//调用Net类中定义的moveTo方法
					net.moveTo(mouseX, mouseY);
					//System.out.println(mouseX+","+mouseY);
				}
		//鼠标按下事件的监听
				public void mousePressed(MouseEvent e) {
					//鼠标按下，调用本类中定义的捕鱼的方法
					//catchFish();
					//当鼠标按下的时候，创建子弹
					Bullet bullet=new Bullet(Pool.this);
					//对子弹类中的坐标和弧度赋值
					bullet.x=centerX-10;
					bullet.y=centerY-17;
					bullet.roate=f;
					//创建一个点
					bullet.p=new Point(centerX-10,centerY-17);
					
					bullets.add(bullet);
					bullet.start();//调用start方法启动子弹线程
				}
		};
		//将鼠标监听事件mouse绑定到当前所在的池塘面板中
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
		
		
		
		
		while (true) {
			repaint();
			
		}
	}
	
	
	
	
	
	
	
	
	//在池塘中添加一个捕鱼的方法
	public void catchFish(){
		//使用循环遍历池塘中的每一条鱼，判断渔网在哪一条鱼的身上
		for (int i=0;i<fish.length;i++) {
			Fish f=fish[i];//获取每一次循环 从数组中获取到鱼
			//每一次循环都要判断渔网是否在鱼身上
			
			if (net.isCanCatchFish(f)==true) {//条件成立，渔网捕到鱼
				//1）将鱼类中的特征isCatched修改为true
				f.isCatched=true;
				//2）统计分数
				num++;//每成功的捕到一条鱼，num++，累计捕鱼的数量
				
			}
		}
	}
	
}




























