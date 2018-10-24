package controller;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import entities.Food;
import entities.Ground;
import entities.Snake;
import listener.Listener;
import util.Global;
import view.GamePanel;

public class Controller extends KeyAdapter implements Listener{

	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamePanel;
	
	public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}

	/**
	 * ���Ƿ���
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			snake.changeDirection(snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(snake.RIGHT);
			break;

		}
	}

	@Override
	public void snakeMoved(Snake snake) {
		// TODO Auto-generated method stub
		if(food.isSnakeEatFood(snake)) {
			snake.eatFood();
			food.newFood(ground.getPoint());
		}
		if(ground.isSnakeEatRock(snake)) {
			snake.die();
		}
		if(snake.isEatBody()) {
			snake.die();
		}
		
		
		
		gamePanel.display(snake, food, ground);
	}
	
	
	
	public void newGame() {
		//for(int i=0;i<20;i++)
		
		food.newFood(ground.getPoint());
		snake.start();
		snake.life=true;
		
		
	}

	
}
