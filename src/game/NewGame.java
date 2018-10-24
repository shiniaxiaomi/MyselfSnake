package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import entities.Food;
import entities.Ground;
import entities.Snake;
import util.Global;
import view.GamePanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Panel;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewGame extends JFrame {

	private JPanel contentPane;

	private static Snake snake = new Snake();
	private static Food food = new Food();
	private static Ground ground = new Ground();
	private static GamePanel gamePanel = new GamePanel();
	private static Controller controller = new Controller(snake, food, ground, gamePanel);

	private static boolean newGame = false;

	private JButton Button1;
	public static JTextArea textArea;
	private JLabel label;
	private JTextArea textArea_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public static JTextField textField;
	private JLabel label_1;
	public static JTextField v_textField;
	private JPanel panel;
	private JButton btnNewButton;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		NewGame frame = new NewGame();
		frame.setVisible(true);

		gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);

		gamePanel.requestFocus();// ��gamePanel�Ȼ�ȡ����

	}

	/**
	 * Create the frame.
	 */
	public NewGame() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(NewGame.class.getResource("/images/year_of_snake_48px_1168436_easyicon.net.png")));
		setTitle("\u5C0F\u7C73\u8D2A\u5403\u86C7");// С��̰����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 485);// ��������������Ļ�е�λ��
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// ����JPanel�Ͽؼ��ĵ�JPanel�ϵļ��

		setContentPane(contentPane);

		Button1 = new JButton("\u5F00\u59CB\u6E38\u620F");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Snake.life == false) {
					controller.newGame();// ��ʼ����Ϸ
				}
				gamePanel.requestFocus();// ��gamePanel��ȡ����
			}
		});

		panel = new JPanel();
		panel.setBorder(null);

		btnNewButton = new JButton("\u6682\u505C\u6E38\u620F");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Snake.isStop == false) {
					Snake.isStop = true;
					btnNewButton.setText("");
					NewGame.textArea.setText("");
				} else if (Snake.isStop == true) {
					Snake.isStop = false;
					btnNewButton.setText("");
					NewGame.textArea.setText("");
				}

				gamePanel.requestFocus();// ��gamePanel��ȡ����
			}
		});

		panel_1 = new JPanel();
		panel_1.setBorder(null);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
						.addComponent(gamePanel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE).addGap(31)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(Button1)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addGap(183)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(Button1)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton).addGap(18)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addComponent(gamePanel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
				.addGap(15)));

		lblNewLabel_1 = new JLabel("\u8BBE\u7F6E\u86C7\u8EAB\u957F\u5EA6\uFF1A");

		textField = new JTextField();
		textField.setText("3");
		textField.setColumns(10);

		label_1 = new JLabel("\u8BBE\u7F6E\u901F\u5EA6\uFF1A");

		v_textField = new JTextField();
		v_textField.setText("200");
		v_textField.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(2).addComponent(label_1)
								.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
								.addComponent(v_textField, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField, 0, 0, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(
						v_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(37, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		label = new JLabel("\u6E38\u620F\u8BF4\u660E\uFF1A");

		lblNewLabel = new JLabel("\u6D88\u606F:");

		textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gamePanel.requestFocus();// ��gamePanel��ȡ����
			}
		});
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 27));

		textArea_1 = new JTextArea();
		textArea_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gamePanel.requestFocus();// ��gamePanel��ȡ����
			}
		});
		textArea_1.setEditable(false);
		textArea_1.setText(
				"\u8D2A\u5403\u86C7\u901A\u8FC7\u65B9\u5411\u952E\u8FDB\u884C\u63A7\u5236\uFF0C\u5403\u5230\u81EA\u5DF1\u7684\u8EAB\u4F53\u548C\u77F3\u5934\u5219\u6E38\u620F\u7ED3\u675F\uFF01");
		textArea_1.setLineWrap(true);
		textArea_1.setToolTipText("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
						.addComponent(label, Alignment.LEADING)
						.addComponent(textArea_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING)).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addComponent(label).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel).addGap(4).addComponent(textArea,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(44, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		contentPane.setLayout(gl_contentPane);
	}
}
