package com.zzxy.thread;

public class SecondThread extends Thread{
	public void run(){
		for (int i =1; i<=100; i++) {
			System.out.println("我是修水管的!"+i);
			
		}
	}

}
