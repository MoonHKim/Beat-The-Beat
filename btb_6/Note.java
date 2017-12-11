package btb_6;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JList.DropLocation;

import org.omg.CORBA.IRObject;

public class Note extends Thread {

	private Image basicNoteImage = new ImageIcon(Main.class .getResource("../images/basicNote.png")).getImage();
	private int a, b = 580 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED; // ��Ʈ ���� �� ��Ȯ�� 1�ʵڿ� �������ο� ���� (�̹� �����ȰŶ� ���� �����ڿ� '��'���� �� �ʿ䰡 ������)
	private String typeOfNote;

	public Note(int a, String typeOfNote) {
		this.a = a;
		this.typeOfNote = typeOfNote;
	}
	
	public void screenDraw(Graphics g) {
		if(typeOfNote.equals("short")) {
			g.drawImage(basicNoteImage, a, b, null);
		}
		else if(typeOfNote.equals("long")) {
			g.drawImage(basicNoteImage, a, a, null);
		}
	}
	
	public void drop() {
		b += Main.NOTE_SPEED;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME); // sleep = 0.001�� ����Ÿ���� 10�ʴϱ� 10�ʿ� 100�� ���� 1�ʿ� 400��?
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
