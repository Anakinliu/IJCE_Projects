package com.zzxy.fish;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//���в����������
public class Main {
	public static void main(String[] args) {
		// ����
		JFrame frame=new JFrame();
		//JPanel panel=new JPanel();//����һ�����
		//JButton ok=new JButton("��¼");//����һ����ť
		//JTextField text=new JTextField(10);//����һ�������ı������
		//ImageIcon icon=new ImageIcon("images/bg.jpg");//����ͼƬ--дͼƬ·��
		//JLabel lable=new JLabel(icon);//����һ����ǩ
		
		//panel.add(ok);//��ť���������
		//panel.add(text);//�ı�����������
		//panel.add(lable);//��ǩ���������
		//frame.add(panel);//�����봰����
		
		//����һ������
	    Pool p=new Pool();
	    //������p��ӵ�������
	    frame.add(p);
	    
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���java�����Ҳ�ر�
		frame.setResizable(false);//���ô����С���ɸı�
		frame.setLocation(200, 100);//����λ��
		frame.setTitle("�ҵĲ������");//�������
		frame.setSize(800, 600);//���ô����С
		frame.setVisible(true);//���ô����Ƿ�ɼ�
		
		p.move();
		
	}

}
