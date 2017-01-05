package com.zzxy.fish;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Net {
	BufferedImage yw;
	//1.定义
	//2.大小
	int width;
    int height;
	//3.位置
    int x;
	int y;
	//4.表示渔网的显示或隐藏   
	//isShow为true，渔网显示，
	//isShow为false，渔网隐藏
	boolean isShow;
	//无参构造法方法
	public Net(){
		try {
			yw=ImageIO.read(new File("images/net09.png"));
		    width=yw.getWidth();
		    height=yw.getHeight();
		    //x=300;
		   // y=300;
		
		
		
		} catch (IOException e) {
			System.out.println("图片读取有误！");
		}
		
	}
	
	
	//行为
	//添加一个方法---将鼠标坐标赋值给渔网坐标
	public void moveTo(int mouseX,int mouseY){
		x=mouseX;
		y=mouseY;
	}
	//添加一个方法-----制定渔网捕鱼的规则
	//该方法返回的true，表示该渔网在鱼的身上，能捕到鱼
	//返回false，表示该渔网不在鱼的身上，不能捕到鱼
	public boolean isCanCatchFish(Fish f){
		int dx=x-f.x;
		int dy=y-f.y;
		 return dx>=0 && dx<=f.width && dy>=0 && dy<=f.height;
		
	}

}












