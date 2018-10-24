package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import game.NewGame;
import listener.Listener;
import util.Global;

public class Snake {

	public static final int UP=-1;
	public static final int DOWN=1;
	public static final int LEFT=2;
	public static final int RIGHT=-2;
	
	private int oldDirection;
	private int newDirection;
	
	private Point oldTail;
	
	public static boolean life=false;
	public static boolean isStop=false;
	
	public static LinkedList<Point> body=new LinkedList<Point>();
	
	public Set<Listener> listeners=new HashSet<Listener>();//����ע����������

	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}

	public Snake() {
		//init();
	}

	/**
	 * ��ʼ��
	 */
	private void init() {
		// TODO Auto-generated method stub

		body.clear();
		NewGame.textArea.setText("");
		
		int bodyInit=Integer.valueOf(NewGame.textField.getText());
		
		int x=Global.WIDTH/2-bodyInit;//��ʼ����
		int y=Global.HEIGHT/2;
		
		for(int i=0;i<bodyInit;i++) {
			body.addFirst(new Point(x++, y));//��ͷ���ұ�
		}
		
		oldDirection=newDirection=RIGHT;
		
	}

	public void move() {
		//System.out.println("���ƶ�");
		
		if(oldDirection+newDirection!=0) {
			oldDirection=newDirection;
		}
		
		//1.ȥβ
		oldTail=body.getLast();
		body.removeLast();
		
		int x=body.getFirst().x;
		int y=body.getFirst().y;
		switch (oldDirection) {
		case UP:
			y--;
			if(y<0)	y=Global.HEIGHT-1;
			break;
		case DOWN:
			y++;
			if(y>Global.HEIGHT-1)	y=0;
			break;
		case LEFT:
			x--;
			if(x<0)	x=Global.WIDTH-1;
			break;
		case RIGHT:
			x++;
			if(x>Global.WIDTH-1)	x=0;
			break;

		}
		
		Point newHead=new Point(x,y);
		
		//2.��ͷ
		body.addFirst(newHead);
	}
	
	public void changeDirection(int direction) {
		//System.out.println("�߸ı䷽��");
			
		newDirection=direction;
	}
	
	public void eatFood() {
		//System.out.println("�߳�ʳ��");

		body.addLast(oldTail);//��ȥ����β�����¼���
	}
	
	public boolean isEatBody() {
		//System.out.println("���Ƿ�Ե�����");
		
		for(int i=1;i<body.size();i++) {
			if(body.get(i).equals(getHead())) {
				return true;
			}
		}
		
		return false;
	}
	
	public void drawMe(Graphics g) {
		//System.out.println("��ʾ��");
		
		g.setColor(Color.BLUE);
		for(Point p:body) {
			g.fill3DRect(p.x*Global.CELL_SIZE, p.y*Global.CELL_SIZE,
					Global.CELL_SIZE, Global.CELL_SIZE, true);
		}
		
		g.setColor(Color.YELLOW);
		g.fill3DRect(body.getFirst().x*Global.CELL_SIZE, body.getFirst().y*Global.CELL_SIZE,
				Global.CELL_SIZE, Global.CELL_SIZE, true);
	}
	
	public Point getHead() {
		
		return body.getFirst();
		
	}
	
	//�ڲ���
	private class SnakeDriver implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub

			while(life) {
					move();
					for(Listener l: listeners) {
						l.snakeMoved(Snake.this);
					}
					try {
						Thread.sleep(Integer.valueOf(NewGame.v_textField.getText()));
						while(Snake.isStop) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
		
	}
	
	public void start() {
		init();
		new Thread(new SnakeDriver()).start();
	}
	
	public void addSnakeListener(Listener l) {//ע�������
		if(l!=null) {
			this.listeners.add(l);
		}
	}

	public void die() {
		// TODO Auto-generated method stub
		life=false;
		//System.out.println("��Ϸ����");
		//JOptionPane.showMessageDialog(null, "��Ϸ����");
		NewGame.textArea.setText("");
		
	}
	
}
