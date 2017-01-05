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

//java�е�Pool���ʾ��������
//extends �̳�  ��Pool�̳�JPanel����ΪJPanel���л��ʺͻ滭�Ĺ���,����̳к�Ҳ�д˹���
public class Pool extends JPanel {
	//����
    //1.ˮ--����
	BufferedImage bg;
	//2.������
	//һ����--������������������
	//һ����--�������������˼�����һ����
	//Fish fish;
	//����  ������
	Fish[] fish;
	//3.����
	Net net;
	//4.ͳ���������
	int num;
	//5.�Ʒְ�
	BufferedImage bars;
	//6.����
	Barrel barrel;
	//7.�ӵ�
	
	
	//�������
	int mouseX;
	int mouseY;
	//������ת���ĵ�
	int centerX;
	int centerY;
	//���ڻ���
	double f;
	//sʹ��ArrayList���ϱ�ʾ���У������洢�ӵ�   <Bullet>��ʾ����  �涨�ü���ֻ�ܴ洢�ӵ����͵�
	ArrayList<Bullet> bullets=new ArrayList<Bullet>();
	//���췽��-���������췽����
   // �ص㣺1�����췽����public��ͷ
   // 2�����췽���ķ�����������һ��
   // 3�����췽��û�з���ֵ��Ҳû��void
   // 4�����췽���������ǵײ��Զ�����ִ��
//���壺�Ա����е�����/���Ը�ֵ�õ�
	
	
	
	
	
	
	public Pool(){
		//java�е�IO��input   output����
		//ImageIO�ǹ����࣬�ܷ���Ķ�ȡĳһλ�õ�ͼƬ��ImageIO��read�����ļ��ķ�ʽ��ȡͼƬ
	     try {
	    	 bg=ImageIO.read(new File("images/bg.jpg"));
	    	 //����һ����
	    	 //fish=new Fish();
	    	 //fish.start();
	    	
	    	 
	    	 fish=new Fish[11];
	    	 for (int i=0;i<9; i++) {
	    		 //ÿ�δ���һ�������
	    		// Fish f=new Fish();
	    		 //�������������������ӵ�������
	    		 //fish[i]=f;
	    		 //new Fish("fish01")--��һ����
	    		 //i     =0 1 2 3 4 5 6 7 8     *9  10
	    		 //i+1   =1 2 3 4 5 6 7 8 9     *10 11
	    		 
	    		 fish[i]=new Fish("fish0"+(i+1));//mÿһ��ѭ������һ�������������
	    		 fish[i].start();//ÿ������һ���߳�
				}
	    	 //��������fish13��fish14
	    	 fish[9]=new Fish("fish13");
	    	 fish[9].start();
	    	 fish[10]=new Fish("fish14");
	    	 fish[10].start();
	    	 //����һ������
	    	 net=new Net();
	    	//�Ա���bars�Ʒְ�ͼƬ��ֵ
	    	 bars=ImageIO.read(new File("images/bottom-bar.png"));
	    	 //����һ������
	    	 barrel=new Barrel();
	    	 
	     } catch (IOException e) {
			//��catch�д����쳣
			System.out.println("�ļ���ȡ����");
		} 	
	}
	
	
	
	
	
	
	
    //����	
    //1�����һ���滭����Ϊ  paint
	//��paint�����Ǹ���JPanel�е�
	public void paint(Graphics g) {	
		super.paint(g);
		//ʹ�û���g������bg������
		//��   ��   1����ͼƬ                             ����2��3������ͼƬ���Ͻ�λ��
		//����4��5������ͼƬ��Ⱥ͸߶�         ��    ��  6��������
		
		g.drawImage(bg,0,0,800,600,null);
		//ʹ�û���g���㻭����
		
		for (int i = 0;i<fish.length;i++) {
			g.drawImage(fish[i].img, fish[i].x, fish[i].y, fish[i].width, fish[i].height, null);
			
		}
		//��������
		//����������width/2������height/2
		int x=net.x-net.width/2;
		int y=net.y-net.height/2;
		//������������ʾ
		if (net.isShow==true) {
			 g.drawImage(net.yw,x,y, net.width, net.height, null);
		}
		//�޸Ļ�����ɫ
		g.setColor(new Color(255,0,0));
		//ʹ�û��ʽ���������num���������
		g.drawString(num+"", 50, 30);
		//������ǰϵͳʱ��
		Date date=new Date();
		g.drawString(date.toString(), 50, 50);
		//ʹ�û��ʽ��Ʒְ廭�������
		g.drawImage(bars, -6, 502, 800, 71, null);
		//ʹ�û��ʻ�������  Graphics���͵Ļ���ֻ�ܻ���ֹ�� 
		//g.drawImage(barrel.dp, barrel.x, barrel.y,barrel.width, barrel.height, null);
	    
		
		//��ȡ������ת���ĵ�
		centerX=barrel.x+19;
		centerY=barrel.y+39;
		double x1=mouseX-centerX;
		double y1=mouseY-centerY;
		//����fΪ������ת����
		f=-Math.atan(x1/y1);
		
		//g.create()���һ���µĻ���Graphics���ͣ�ǿ������ת��ΪGraphics2D����
		Graphics2D gp=(Graphics2D)g.create();
		//����1��ͼƬ��ת����   ����2��3��ͼƬ��ת���ĵ�
		gp.rotate(f,centerX,centerY);
		gp.drawImage(barrel.dp, barrel.x, barrel.y,barrel.width, barrel.height, null);
	   //ʹ�û��ʽ������е������ӵ�������
		//size()�󼯺ϴ�С  length�������С
		for (int i = 0; i <bullets.size(); i++) {
			//�����±�ȡ���ӵ�
			Bullet bullet=bullets.get(i);
			//���ӵ��л��ȣ���Ҫʹ��Graphics2D���ӵ�
			//�Ȼ��һ���µ�Graphics2D���ͻ���
			Graphics2D g2d=(Graphics2D)g.create();
			//�����ӵ��Ļ��Ⱥ���ת����
			g2d.rotate(bullet.roate,centerX,centerY);
			g2d.drawImage(bullet.img, bullet.x, bullet.y, bullet.width, bullet.height, null);
		}
	}
	
	
	
	
	
	
	
	public void move(){
		//������ļ����¼�     MouseAdapter(������) ���������   �����ڲ���  ����new������
		MouseAdapter mouse=new MouseAdapter() {
		//�������¼�����--  -- ��������ʾ
		        public void mouseEntered(MouseEvent e) {
			        net.isShow=true;
		        }
		//����뿪�¼�����--  -- ����������
			    public void mouseExited(MouseEvent e) {
			        net.isShow=false;
			    }
		//����ƶ��¼�����
				public void mouseMoved(MouseEvent e) {
					//
					mouseX=e.getX();
					mouseY=e.getY();
					//����Net���ж����moveTo����
					net.moveTo(mouseX, mouseY);
					//System.out.println(mouseX+","+mouseY);
				}
		//��갴���¼��ļ���
				public void mousePressed(MouseEvent e) {
					//��갴�£����ñ����ж���Ĳ���ķ���
					//catchFish();
					//����갴�µ�ʱ�򣬴����ӵ�
					Bullet bullet=new Bullet(Pool.this);
					//���ӵ����е�����ͻ��ȸ�ֵ
					bullet.x=centerX-10;
					bullet.y=centerY-17;
					bullet.roate=f;
					//����һ����
					bullet.p=new Point(centerX-10,centerY-17);
					
					bullets.add(bullet);
					bullet.start();//����start���������ӵ��߳�
				}
		};
		//���������¼�mouse�󶨵���ǰ���ڵĳ��������
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
		
		
		
		
		while (true) {
			repaint();
			
		}
	}
	
	
	
	
	
	
	
	
	//�ڳ��������һ������ķ���
	public void catchFish(){
		//ʹ��ѭ�����������е�ÿһ���㣬�ж���������һ���������
		for (int i=0;i<fish.length;i++) {
			Fish f=fish[i];//��ȡÿһ��ѭ�� �������л�ȡ����
			//ÿһ��ѭ����Ҫ�ж������Ƿ���������
			
			if (net.isCanCatchFish(f)==true) {//��������������������
				//1���������е�����isCatched�޸�Ϊtrue
				f.isCatched=true;
				//2��ͳ�Ʒ���
				num++;//ÿ�ɹ��Ĳ���һ���㣬num++���ۼƲ��������
				
			}
		}
	}
	
}




























