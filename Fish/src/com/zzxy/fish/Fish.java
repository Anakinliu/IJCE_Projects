package com.zzxy.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

//�����
public class Fish extends Thread{
	//����������
	//1.����--���ͼƬ ������img��ֵ��Ϊ����ͼƬ����Ϊ��������
	BufferedImage img;
	//2.��С
	int width;
	int height;
	//3.λ��
	int x;
	int y;	
	//4.�ٶ�
	int step;
	//5.�������ʮ������
	BufferedImage[] images;// �����������洢���10������ͼƬ
	//6.����  isCatched��ʾ���Ƿ񱻲���   ���isCatchedΪtrue��ʾ�㱻����
	//                              ���isCatchedΪfalse��ʾ��û�б�����
	boolean isCatched;
	//7.����������ڶ�����ͼƬ
	BufferedImage cath01;
	BufferedImage cath02;
	
	//����޲ι��췽��
	//���޲ι��췽���޸�Ϊ��һ���ַ������Ͳ����Ĺ��췽��
	public Fish(String type){
		//type��ʾ���յ���ͬ�������  type=fish01 fish02.....
		try {
			img=ImageIO.read(new File("images/"+type+"_01.png"));
		    //��ȡͼƬ����ʵ�߶ȺͿ��
			width=img.getWidth();
		    height=img.getHeight();
		    Random r=new Random();
		    x=800;
			y=r.nextInt(500-height)+1;
			step=r.nextInt(6)+1;
			//����images����Ĵ�С
			images=new BufferedImage[10];
			//ʹ��ѭ�����붯��ͼƬ
			for (int i=0;i<10;i++) {
				images[i]=ImageIO.read(new File("images/"+type+"_0"+i+".png"));
				
			}
		    //������cath01��cath02��ֵ
			cath01=ImageIO.read(new File("images/"+type+"_catch_01.png"));
			cath02=ImageIO.read(new File("images/"+type+"_catch_02.png"));
		} catch (IOException e) {
			System.out.println("������ͼƬ��ȡ����");
		}
	}
	//��Ϊ������
	//run����
	 int index=0;//�ñ�����ʾimages�����±�   
     public void run() {
			
		while (true) {
			if (isCatched==true) {//�����������㱻����
				//���ڼ��£���ʧ�����볡
				turnOver();
				goOut();
			} else {//��������������δ������
				//������
				//����move����
				move();
		}
							
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}			
		}			
	}
     //����һ������---���εķ�����ֱ�������Σ�����Ķ���Ч����
     public void move(){
    	 x=x-step;
 		//��images����������ȡ��10�Ų�ͬ�Ķ���ͼƬ��img��ֵ
 		//��ɶ���Ч��--Ҫ����һ�����ٶȣ�һ����˳��ѭ�������Ĳ���10�Ŷ���ͼƬ
 		
 		//����ǰ�κ��Լ��Ķ���Ч����Ҫ���߳�����ɣ���run��������while��true����ѭ��
 		
 		img=images[index];
 		index++;
 		if (index==10) {
 			index=0;
 		}
 		//�ж����ȥ�����볡
 		if (x<=-width) {
 			goOut();//���÷���,���ȥ�����볡
 		}
     }
     //����һ������--���ȥ�����볡
     public void goOut(){
    	 x=800;
  		Random r=new Random();
  		y=r.nextInt(500-height)+1;
  		step=r.nextInt(6)+1; 
  		isCatched=false;//�����isCatched�޸�Ϊfalse��ʹ��������
     }
     //����һ������--�㱻�����ڵ�Ч��
     public void turnOver(){
    	 for (int i=0;i<5;i++) {//ѭ����Σ���η���
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
