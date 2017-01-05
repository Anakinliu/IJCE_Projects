package com.zzxy.fish;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//运行捕鱼达人主类
public class Main {
	public static void main(String[] args) {
		// 窗体
		JFrame frame=new JFrame();
		//JPanel panel=new JPanel();//创建一个面板
		//JButton ok=new JButton("登录");//创建一个按钮
		//JTextField text=new JTextField(10);//创建一个单行文本输入框
		//ImageIcon icon=new ImageIcon("images/bg.jpg");//处理图片--写图片路径
		//JLabel lable=new JLabel(icon);//创建一个标签
		
		//panel.add(ok);//按钮放入面板中
		//panel.add(text);//文本框放入面板中
		//panel.add(lable);//标签放入面板中
		//frame.add(panel);//面板放入窗体中
		
		//创建一个池塘
	    Pool p=new Pool();
	    //将池塘p添加到窗体中
	    frame.add(p);
	    
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体java虚拟机也关闭
		frame.setResizable(false);//设置窗体大小不可改变
		frame.setLocation(200, 100);//窗体位置
		frame.setTitle("我的捕鱼达人");//窗体标题
		frame.setSize(800, 600);//设置窗体大小
		frame.setVisible(true);//设置窗体是否可见
		
		p.move();
		
	}

}
