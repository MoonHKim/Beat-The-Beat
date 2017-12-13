package btb_7;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.omg.CORBA.PUBLIC_MEMBER;

public class BeatTheBeat extends JFrame{

	private Image screenImage;
	private Graphics screenGraphic; // ���� ���۸��� ���ؼ� ��üȭ�鿡 �̹����� ��� �� �ν��Ͻ�
	
	
	// ���� ������ ���� �ٲٱ�
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButton2.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButton1.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButton2.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButton1.png"));
	
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage); // ���� 22���ο� �ִ��� �ȿ��� ����� ������ �̹����� �ٲ㼭 ���⿡ ��,�� (��, �⺻�̹����� �̰Ŷ�� ����)
	private JButton startButton = new JButton(startButtonBasicImage); // ���� 22���ο� �ִ��� �ȿ��� ����� ������ �̹����� �ٲ㼭 ���⿡ ��,�� (��, �⺻�̹����� �̰Ŷ�� ����)
	private JButton quitButton = new JButton(quitButtonBasicImage); // ���� 22���ο� �ִ��� �ȿ��� ����� ������ �̹����� �ٲ㼭 ���⿡ ��,�� (��, �⺻�̹����� �̰Ŷ�� ����)
	
	
	private int mouseX, mouseY; // ���α׷��ȿ��� ���콺�� ��ǥ(����38���� �̵��ؼ� ����)
	
	private boolean isMainScreen = false; // ó������ ����ȭ���� �ƴϴϱ�
	private boolean isGameScreen = false;
	
	private Music selectedMusic;
	
	public static GameYo game = new GameYo();
	
	public BeatTheBeat() {
		setUndecorated(true); // �̰Ÿ� ���� �⺻������ �ߴ� �޴��ٰ� �������� �ʰ� �ȴ�
		setTitle("Beat The Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // �̰� ��������(�޶�� �ϴϱ� 
		setLocationRelativeTo(null); // ȭ�� ���߾ӿ� �߰���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ȳ����� ������ ���α׷��� ��ǻ�� ���ο����� ��� ���ư�
		setVisible(true); // ȭ�鿡 ������
		setBackground(new Color(0, 0, 0, 0)); // ����Ʈ������Ʈ�� ����� �Ͼ�� ����
		setLayout(null); // ��ư�̳� ���̶� �־��� �� ����ġ�� ������ �ȴ�

		addKeyListener(new KeyListener());
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		exitButton.setBounds(1245, 0, 30, 30); // ���� �Է��ѰŴ� �޴��� ���� ���������� �����ϴ� ��� (������ ��ư(���� �ٲٱ�� �Բ� �ϴ� ��)
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false); 
		exitButton.setFocusPainted(false); // �� 3������ ������ ��ư�� �׵θ� �׸� ���ְ� �ڿ������� ����� �ִ°� (���̹�ư�� �ϳ��� ���ø��� �����ϴµ� �װ� �츮�� ���ϴ� ����� �ƴ� �׸�ȿ� ����ֱ⿡ �װ� ���־��Ѵ�.
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // �̰�
				Music buttonEnteredMusic = new Music("button1.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �̰� ���콺 Ŀ�� �ղٶ�������� �ٲٴ°�
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("button2.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			} // ������ ��ư �ð� ������Ű�� �׷��� �뷡�� ����
		}); 
		add(exitButton); // �� ��ü�� ����(���� 61����)������ ȭ�鿡�߱� �ߴµ� �ȴ��� �޴��� �ڿ� �� �ִ� ��Ȳ �׷��⿡ ���� 43���� �̵�
		
		
		startButton.setBounds(20, 350, 300, 100); // ���� �Է��ѰŴ� �޴��� ���� ���������� �����ϴ� ��� (������ ��ư(���� �ٲٱ�� �Բ� �ϴ� ��)
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false); 
		startButton.setFocusPainted(false); // �� 3������ ������ ��ư�� �׵θ� �׸� ���ְ� �ڿ������� ����� �ִ°� (���̹�ư�� �ϳ��� ���ø��� �����ϴµ� �װ� �츮�� ���ϴ� ����� �ƴ� �׸�ȿ� ����ֱ⿡ �װ� ���־��Ѵ�.
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // �̰�
				Music buttonEnteredMusic = new Music("button1.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �̰� ���콺 Ŀ�� �ղٶ�������� �ٲٴ°�	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("button2.mp3", false);
				buttonPressedMusic.start();
				//���� ���� �̺�Ʈ
				introMusic.close();
				Music selectedMusic = new Music("Kenshi Yonezu - Peace Sign.mp3", true);
				selectedMusic.start();
				// 7�� 1��26�ʺ���
				
				startButton.setVisible(false);
				quitButton.setVisible(false);
				introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();
				
				isMainScreen = true; //
			}
		}); 
		add(startButton); // �� ��ü�� ����(���� 61����)������ ȭ�鿡�߱� �ߴµ� �ȴ��� �޴��� �ڿ� �� �ִ� ��Ȳ �׷��⿡ ���� 43���� �̵�
		
		
		quitButton.setBounds(20, 450, 300, 100); // ���� �Է��ѰŴ� �޴��� ���� ���������� �����ϴ� ��� (������ ��ư(���� �ٲٱ�� �Բ� �ϴ� ��)
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false); 
		quitButton.setFocusPainted(false); // �� 3������ ������ ��ư�� �׵θ� �׸� ���ְ� �ڿ������� ����� �ִ°� (���̹�ư�� �ϳ��� ���ø��� �����ϴµ� �װ� �츮�� ���ϴ� ����� �ƴ� �׸�ȿ� ����ֱ⿡ �װ� ���־��Ѵ�.
		
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // �̰�
				Music buttonEnteredMusic = new Music("button1.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // �̰� ���콺 Ŀ�� �ղٶ�������� �ٲٴ°�	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("button2.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		}); 
		add(quitButton); // �� ��ü�� ����(���� 61����)������ ȭ�鿡�߱� �ߴµ� �ȴ��� �޴��� �ڿ� �� �ִ� ��Ȳ �׷��⿡ ���� 43���� �̵�
		
	
		
		
		
		
		
		menuBar.setBounds(0, 0, 1280, 30); // (��ġ, ��ġ, ũ��(����), ũ��(����)) ���� -> 
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� ������ ���� �̺�Ʈ ó��
				mouseX = e.getX();
				mouseY = e.getY(); // ������ �̺�Ʈ�� �߻����� �� x,y��ǥ�� ������
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) { // drag�̺�Ʈ�� �߻����� ���� �̺�Ʈ ó��
				int x = e.getXOnScreen();
				int y = e.getYOnScreen(); // ��ǥ������
				setLocation(x - mouseX, y - mouseY); // �巹�� �Ҷ� ��ǥ�����ͼ� ������������ ��ġ ��ü�� �ٲ���(â ��ü�� ������ �� �ְ� ���ش�)
			}
		});
		add(menuBar);
		

		
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // �̸� ���س��� ������� �̹����� ���� ��ũ���̹����� �־��ְڴ�
		screenGraphic = screenImage.getGraphics(); // ������ �̹����� �̿��ؼ� �׷��� ��ü�� ����
		screenDraw(screenGraphic); // ��ũ�� �׷��ȿ� 
		g.drawImage(screenImage, 0, 0, null); // ��ũ���̹��� ��ġ����
	}
	
	public void screenDraw(Graphics g) { // �Լ� = �޼ҵ�(�� ����� ���ϴ� ��)
		
		g.drawImage(introBackground, 0, 0, null); //��Ʈ�� ��׶��带 ��ü�̹��� ��, ��ũ���̹����� �׷��ִ� ��
		
		game.screenDraw(g);
		
//		if(isMainScreen) {
//			g.drawImage(img, x, y, observer)
//		}
		
		if(isGameScreen) {
			game.screenDraw(g);
		}
		
		paintComponents(g); // ����Ʈ������Ʈ��� ���� �̹����� �ܼ��ϰ� �ش� ��ũ���̹������ �����ȿ� �׷��ִ� �� �̿ܿ� ���̹ٳ� ���������� �ȿ� �߰��ϸ� �װ��� �׷��ִ°�(�����Ǵ� �̹���(�޴��� ������)�� �̰����� �ϴ°� �� ����)
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint(); 
	}
	
	public void gameStart() {
		if(selectedMusic != null) {
	//		selectedMusic.close();	
			isMainScreen = false; 
			isGameScreen = true;
			
			game.start();
			setFocusable(true);
		}		
	}
	
//	public void backMain() {
//		isMainScreen = true;
//		isGameScreen = false;
//	}
//	
}
