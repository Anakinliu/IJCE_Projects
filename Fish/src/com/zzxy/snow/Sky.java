package com.zzxy.snow;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
//�̳�
public class Sky extends JPanel{
	
	BufferedImage tk;
	//һ��ѩ��
	//Snow snow;
	
	//���ѩ�� --ʹ������洢���ѩ������
	Snow[] snows;
	//��ȡͼƬ
	//�޲ι��췽��
	public Sky(){
		try {
			
			tk=ImageIO.read(new File("images/sky.jpg"));
		//snow=new Snow();
		//snow.start();//ͨ��start������������ѩ���߳�
		
			//�ȴ�������������С
			snows=new Snow[50];
	        //ʹ��ѭ���������з���ѩ������
			for (int i = 0; i < 50; i++) {
				//ÿһ��ѭ������һ��ѩ������
				Snow s=new Snow();
				//������������ѩ������������
				snows[i]=s;
				//���ν������е�ÿһ��ѩ��������߳�����
				snows[i].start();
				
			}
			
		
		} catch (IOException e) {
			System.out.println("��ȡͼƬ����");
		}
	}
	//���һ���滭����
	public void paint(Graphics g){
		super.paint(g);
		//��g������������
		g.drawImage(tk, 0, 0, 600, 600, null);
		//g.drawImage(snow.xh, snow.x, snow.y, snow.width, snow.height,null);
		//ʹ��ѭ�����λ���ѩ��
		for (int i=0;i<50;i++) {
			g.drawImage(snows[i].xh, snows[i].x, snows[i].y, snows[i].width, snows[i].height, null);
			
		}
	}
	//�Զ���һ������--��Ҫ��ͣ�ص��������paint����
    public void move(){
    	while (true) {
			repaint();
			//repaint()��һ���������Ǹ���JPanel�еķ���
			//���ã��÷��������µ���paint����ִ��
			
		}
    }
	
	/*
    ����������﷨��
    public  ��������ֵ  �������������б�{
    ������
    }
    ����1��  public void study����{
        ........
        }
               ���÷�����study������
    ����2��public int sum(int a,int b){
                   return a+b;
    }
    ���÷�����  int s=sum(3,2);
  */
	
	
	
	
}















