package com.zzxy.fish;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Net {
	BufferedImage yw;
	//1.����
	//2.��С
	int width;
    int height;
	//3.λ��
    int x;
	int y;
	//4.��ʾ��������ʾ������   
	//isShowΪtrue��������ʾ��
	//isShowΪfalse����������
	boolean isShow;
	//�޲ι��취����
	public Net(){
		try {
			yw=ImageIO.read(new File("images/net09.png"));
		    width=yw.getWidth();
		    height=yw.getHeight();
		    //x=300;
		   // y=300;
		
		
		
		} catch (IOException e) {
			System.out.println("ͼƬ��ȡ����");
		}
		
	}
	
	
	//��Ϊ
	//���һ������---��������긳ֵ����������
	public void moveTo(int mouseX,int mouseY){
		x=mouseX;
		y=mouseY;
	}
	//���һ������-----�ƶ���������Ĺ���
	//�÷������ص�true����ʾ��������������ϣ��ܲ�����
	//����false����ʾ����������������ϣ����ܲ�����
	public boolean isCanCatchFish(Fish f){
		int dx=x-f.x;
		int dy=y-f.y;
		 return dx>=0 && dx<=f.width && dy>=0 && dy<=f.height;
		
	}

}












