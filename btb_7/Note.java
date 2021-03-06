package btb_7;

import java.awt.Graphics;
import java.awt.Image;

import javax.security.auth.x500.X500Principal;
import javax.swing.ImageIcon;
import javax.swing.JList.DropLocation;

import org.omg.CORBA.IRObject;

public class Note extends Thread {

	private Image basicNoteImage = new ImageIcon(Main.class .getResource("../images/basicNote.png")).getImage();
	private int a, b = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME; // 노트 생성 후 정확히 1초뒤에 판정라인에 도달 (이미 고정된거라서 밑의 생성자에 '비'값을 쓸 필요가 없음요)
	private String typeOfNote;

	public Note(String typeOfNote) {
		if(typeOfNote.equals("A")) {
			a = 165;
		}
		else if(typeOfNote.equals("S")) {
			a = 269;
		}
		else if(typeOfNote.equals("K")) {
			a = 681;
		}
		else if(typeOfNote.equals("L")) {
			a = 785;
		}
		this.typeOfNote = typeOfNote;
	}
	
	public void screenDraw(Graphics g) {
	//	if(typeOfNote.equals("short")) {
			g.drawImage(basicNoteImage, a, b, null);
	//	}
//		else if(typeOfNote.equals("long")) {
//			g.drawImage(basicNoteImage, a, a, null);
//		}
	}
	
	public void drop() {
		b += Main.NOTE_SPEED;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME); // 한번 노트를 떨어 뜨렸다가 0.01초 동안 쉬고 다시 떨구기 sleep = 0.001초 슬립타임이 10초니까 10초에 100번 실행 1초에 400번?
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
