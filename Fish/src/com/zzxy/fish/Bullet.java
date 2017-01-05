package com.zzxy.fish;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//�ӵ�����
public class Bullet extends Thread{
	//����
	//1.�ӵ�����--ͼƬ
	BufferedImage img;
	//2.����
	int x;
	int y;
	//3.��С
	int width;
	int height;
	//4.�ӵ�����
	
	double roate;
	Point p;//����Ϊ�ӵ�����ǰ����ʼ���꣨p.x,p.y)
	
	Pool pl;//�������
	int xx;
	int yy;
	
	boolean isLive;//�ӵ����߳��Ƿ���
	
	//��ӹ��췽��
	//���޲θ�Ϊ�в�
	public Bullet(Pool pol){
		try {
			img=ImageIO.read(new File("images/bullet1.png"));
			width=img.getWidth();
			height=img.getHeight();
			pl=pol;
			//��ʾ�ӵ��մ���ʱ�߳���������
			isLive=true;
		} catch (IOException e) {
		System.out.println("�ӵ�ͼƬ����");
		}
	}
	//��Ϊ
//�����߳��е�run����
	public void run(){
	   while (isLive==true) {
		//����move��������
		   move();
		   try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	}
	//x=a+Math.sin(����)*r
	//y=b-Math.cos(����)*r		
	//����һ������---ʵ���ӵ��ƶ�
	public void move(){
		y=y-10;
		int r=p.y-y;//����뾶
		//xx��ʾ�ӵ�����������е�x����
		//Math.sin(roate)�õ�double�����͵Ľ����float��Math.sin��roate�������ǿ��ת��Ϊfloat����
		//Math.round(float����)�������룬����һ��int���͵Ľ��
		xx=p.x+Math.round((float)Math.sin(roate))*r;
		yy=p.y-Math.round((float)Math.cos(roate))*r;
	    //����hint����   �ӵ�ÿ��һ����Ҫ���
		hint();
	
	}
	//����һ������----����ӵ��Ƿ������
	
	public void hint(){
		//ʹ��ѭ�����������е�ÿһ����
		Fish[] fishes=pl.fish;
		for (int i = 0; i <fishes.length; i++) {
			//��������ȡ��ÿһ����
			Fish f=fishes[i];
			//�ж��ӵ��Ƿ������
			if (xx>=f.x && xx<=f.x+f.width && yy>=f.y && yy<=f.height) {
				f.isCatched=true;//�����isCatched�޸�Ϊtrue�������ʧ
				pl.num++;//ͳ���������
				pl.bullets.remove(this);//�ӵ����������ʧ���߳���Ȼ����
				isLive=false;//�ӵ���������ӵ��߳�ֹͣ
			}
			
			
			
		}
		
	}
	
	
	
	
	
	
}

















