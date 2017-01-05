package com.zzxy.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Barrel {
	BufferedImage dp;
	int x;
	int y;
	int width;
	int height;
  public Barrel(){
	  try {
		dp=ImageIO.read(new File("images/barrel.png"));
	width=dp.getWidth();
	height=dp.getHeight();
	x=416;
	y=510;
	  
	  } catch (IOException e) {
		System.out.println("Õº∆¨∂¡»°”–ŒÛ£°");
	}
  }

}
