package btb_1;

import javax.swing.JFrame;

public class BeatTheBeat extends JFrame{

	public BeatTheBeat() {
		setTitle("Beat The Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // �̰� ��������(�޶�� �ϴϱ� 
		setLocationRelativeTo(null); // ȭ�� ���߾ӿ� �߰���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ȳ����� ������ ���α׷��� ��ǻ�� ���ο����� ��� ���ư�
		setVisible(true); // ȭ�鿡 ������
		
	}
}
