package com.zzxy.snow;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
//��ѩ�������Ϊ�̣߳�ͨ���߳����ѩ�����䣬���ѩ����������һ�֡�������ִ�е�����

public class Snow extends Thread{
	
	
	BufferedImage xh;
	//��С
	int width;
	int height;
	//λ��
	int x;
	int y;
	//ѩ���ƶ��Ĳ���
	int step;
	
	public Snow(){
		try {
			xh=ImageIO.read(new File("images/snow.png"));
			
			//��ȡͼƬ��С
			width=xh.getWidth();
		    height=xh.getHeight();
		    
		    Random r=new Random();
		    //r.nextInt(5)��������0~4������� r.nextInt(5)+1�ǲ�����1~5֮��������
		    x=r.nextInt(600)+1;
		    y=500;
		    //��step��ֵ������Ϊ1~5֮��������
		    //Random     ������java.util���е�һ�������� ��Ҫ�ǲ������������
		    
		    //r.nextInt(5)��������0~4������� r.nextInt(5)+1�ǲ�����1~5֮��������
		    step=r.nextInt(5)+1;
		    
		
		} catch (IOException e) {
		System.out.println("ͼƬ��ȡ����");
		}
	}
	
	//����
    //����run
	public void run() {
		while (true) {
			
			y=y+step;
			
			//��ѩ����������ǣ�x��step���¸�ֵ
			if (y>=600) {
		        y=-30;
		        
		        Random r=new Random();
				 x=r.nextInt(600)+1;
				 step=r.nextInt(5)+1;
				
			}
			System.out.println(x+"  "+y);//��ѭ����ʵ��y++����ѩ����������
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	

}
