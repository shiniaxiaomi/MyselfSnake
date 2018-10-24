package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import entities.Food;
import entities.Ground;
import entities.Snake;
import util.Global;

public class GamePanel extends JPanel{//�̳���JPanel��

	private Snake snake;
	private Food food;
	private Ground ground;
	
	public void display(Snake snake,Food food,Ground ground) {
		//System.out.println("��ʾ�����ʾ");
		this.snake=snake;
		this.food=food;
		this.ground=ground;
		this.repaint();//�ػ�
	}

	/**
	 * ����������
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//������ʾ
		/**
		 * ������
		 */
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Global.HEIGHT*Global.CELL_SIZE,Global.HEIGHT*Global.CELL_SIZE);
		
		if(snake!=null && food!=null && ground!=null) {
			snake.drawMe(g);
			ground.drawMe(g);
			food.drawMe(g);
		}
		
	}
	
	
}
