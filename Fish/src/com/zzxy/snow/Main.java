package com.zzxy.snow;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		//����һ������
		JFrame frame=new JFrame();
		
		Sky sky=new Sky();
		frame.add(sky);
		
		
		
		frame.setResizable(false);//�����С���ɱ�
		frame.setLocation(200, 200);//����λ��
		frame.setTitle("ѩ��Ʈ��");//�������
		frame.setSize(600, 600);//�����С
		frame.setVisible(true);//�����Ƿ�ɼ�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���java�����Ҳ�ر�
		
		sky.move();//����Sky�����Լ������move����
		
	}

}
