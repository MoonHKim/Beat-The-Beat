package btb_4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{ // ������� �ϳ��� ���� ���α׷�������(���� ��ӹޱ�)

	private Player player; // �ڹ��ܻ���Ʈ�� ���̺귯�� �� �ϳ�
	private boolean isloop; // �� ���� ���ѹݺ����� �ƴ���
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isloop) {
		try {
			this.isloop = isloop;
			file = new File(Main.class.getResource("../music/" + name).toURI()); // �ش� ������ ��ġ�� �����´�
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) { // Ʈ���� ���� �ȿ��� ���� �߻��� ĳġ�� �Ѿ��.
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() { // ���� ����ǰ� �ִ� ������ ���ġ���� ����ǰ� �ִ��� �˷��ش�. 0.001�������� �˷��� (10�ʸ� 10,000 return)
		// ���O�� ��Ʈ�� ����Ʈ���� �� ��Ÿ������ �ӵ��� �˰Ե�
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() { // �� ������ ���߰� ���� �� �ƹ����� ���� �� �ְ� (�����߿� �ڷΰ��� �ϱ����� �ʿ��ϴ�)
		isloop = false; 
		player.close();
		this.interrupt(); // �ش� �����带 �������·� �����.
	}
	
	@Override
	public void run() { // ������ ����� ���� �ݵ�� �ʿ��Ѱ� run
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isloop);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // �����߻��� �ش� �����޼��� ��������
		}
	}
}
