package com.zzxy.thread;

import java.util.Date;

//�����߳�--���ӱ�
public class DateThreat extends Thread{
   //����run����
    public void run() {
    	while (true) {
			Date d=new Date();//�������ڣ�Ϊ��ǰϵͳʱ��
			System.out.println(d);
			//�õ�ǰ�߳�˯��1����
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    }
	
}
