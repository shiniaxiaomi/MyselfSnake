package game;




import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.Controller;
import entities.Food;
import entities.Ground;
import entities.Snake;
import util.Global;
import view.GamePanel;

public class Game {

	public static void main(String[] args) {
		
		Snake snake=new Snake();
		Food food=new Food();
		Ground ground=new Ground();
		GamePanel gamePanel=new GamePanel();
		
		Controller controller=new Controller(snake, food, ground, gamePanel);
		
		JFrame frame=new JFrame("С��̰����");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùر����˳�
		gamePanel.setSize(Global.WIDTH*Global.CELL_SIZE, Global.HEIGHT*Global.CELL_SIZE);
		frame.setSize(Global.WIDTH*Global.CELL_SIZE+17, Global.HEIGHT*Global.CELL_SIZE+45);
		frame.add(gamePanel,BorderLayout.CENTER);
		
		gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);
		frame.addKeyListener(controller);
		
		frame.setVisible(true);//���ÿɼ�
		controller.newGame();//��ʼ����Ϸ
	}
}


