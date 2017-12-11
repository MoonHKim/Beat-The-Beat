package btb_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BeatTheBeat extends JFrame{

	private Image screenImage;
	private Graphics screenGraphic; // ���� ���۸��� ���ؼ� ��üȭ�鿡 �̹����� ��� �� �ν��Ͻ�
	
	private Image introBackground; // ������ �̹����� ���� �� �ִ� ��ü
	
	public BeatTheBeat() {
		setTitle("Beat The Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // �̰� ��������(�޶�� �ϴϱ� 
		setLocationRelativeTo(null); // ȭ�� ���߾ӿ� �߰���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ȳ����� ������ ���α׷��� ��ǻ�� ���ο����� ��� ���ư�
		setVisible(true); // ȭ�鿡 ������
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage(); // ����Ŭ������ ��ġ�� ������� 
		//���ҽ� �� ��Ʈ�� ��׶��带 ���� �ڿ� �װ��� �̹��� �ν��Ͻ��� �̹�����׶����� �̸��� �������ٰ� �ʱ�ȭ�� ���ְڴ�(�ʱ�ȭ�ؾ� ��밡��)
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // �̸� ���س��� ������� �̹����� ���� ��ũ���̹����� �־��ְڴ�
		screenGraphic = screenImage.getGraphics(); // ������ �̹����� �̿��ؼ� �׷��� ��ü�� ����
		screenDraw(screenGraphic); // ��ũ�� �׷��ȿ� 
		g.drawImage(screenImage, 0, 0, null); // ��ũ���̹��� ��ġ����
	}
	
	public void screenDraw(Graphics g) { // �Լ� = �޼ҵ�(�� ����� ���ϴ� ��)
		g.drawImage(introBackground, 0, 0, null); //��Ʈ�� ��׶��带 ��ü�̹��� ��, ��ũ���̹����� �׷��ִ� ��
		this.repaint(); // ��������� ���� ���۸��ε� ���⿡��   �� ������Ʈ�� ��üȭ�� �̹����� ��� �ݺ� ���α׷��� ���� ������
	}
}
