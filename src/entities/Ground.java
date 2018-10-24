package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import util.Global;

public class Ground {

	private int[][] rocks=new int[Global.WIDTH][Global.HEIGHT];
	
	public Ground(){
		for(int x=0;x<Global.WIDTH;x++) {
			rocks[x][0]=1;
			rocks[x][Global.HEIGHT-1]=1;
		}
	}
	
	public boolean isSnakeEatRock(Snake snake) {
		//System.out.println("���Ƿ�Ե�ʯͷ");
		
		for(int x=0;x<Global.WIDTH;x++) {
			for(int y=0;y<Global.HEIGHT;y++) {
				if(rocks[x][y]==1 && (x==snake.getHead().x && y==snake.getHead().y)) {
					return true;
				}
				
			}
		}
		
		return false;
	}
	
	public boolean isBody(Point point) {
		for(int i=0;i<Snake.body.size();i++) {
			if((Snake.body.get(i).x==point.x && Snake.body.get(i).y==point.y) || rocks[point.x][point.y]==1) {
				return true;
			}
		}
		return false;
	}
	

	public Point getPoint() {
		int x=0;
		int y=0;
		Point p=null;
		
		Random random=new Random();
		do {
			x=random.nextInt(Global.WIDTH);
			y=random.nextInt(Global.HEIGHT);
			p=new Point(x,y);
			
			
		}while(isBody(p));
		
		System.out.println("x:"+x+",y:"+y);

		return p;
	}
	
	public void drawMe(Graphics g) {
		//System.out.println("��ʾʯͷ");
		
		g.setColor(Color.DARK_GRAY);
		
		for(int x=0;x<Global.WIDTH;x++) {
			for(int y=0;y<Global.HEIGHT;y++) {
				if(rocks[x][y]==1) {
					g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
				}
				
			}
		}
	}
}
