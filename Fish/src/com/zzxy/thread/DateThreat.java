package com.zzxy.thread;

import java.util.Date;

//日期线程--电子表
public class DateThreat extends Thread{
   //调出run方法
    public void run() {
    	while (true) {
			Date d=new Date();//创建日期，为当前系统时间
			System.out.println(d);
			//让当前线程睡眠1秒钟
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    }
	
}
