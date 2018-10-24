package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import util.Global;

public class Food extends Point{

	public void newFood(Point p) {
		this.setLocation(p);
	}
	
	public boolean isSnakeEatFood(Snake snake) {
		
		//System.out.println("���Ƿ�Ե�ʳ��");
		
		return this.equals(snake.getHead());
		
	}
	
	
	
	public void drawMe(Graphics g) {
		//System.out.println("��ʾʳ��");
		
		g.setColor(Color.RED);
		
		g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, 
				Global.CELL_SIZE, Global.CELL_SIZE, true);
	}
}
