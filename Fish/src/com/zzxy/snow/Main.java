package com.zzxy.snow;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		//创建一个窗口
		JFrame frame=new JFrame();
		
		Sky sky=new Sky();
		frame.add(sky);
		
		
		
		frame.setResizable(false);//窗体大小不可变
		frame.setLocation(200, 200);//窗体位置
		frame.setTitle("雪花飘落");//窗体标题
		frame.setSize(600, 600);//窗体大小
		frame.setVisible(true);//窗体是否可见
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体java虚拟机也关闭
		
		sky.move();//调用Sky类中自己定义的move方法
		
	}

}
