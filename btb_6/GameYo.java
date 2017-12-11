package btb_6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GameYo extends Thread {

	
	private Image dividingLineImage = new ImageIcon(Main.class.getResource("../images/dividingLine.png")).getImage();
	private Image redLineImage = new ImageIcon(Main.class.getResource("../images/redLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
		
	private Image noteFieldAImage = new ImageIcon(Main.class.getResource("../images/noteField.png")).getImage();
	private Image noteFieldSImage = new ImageIcon(Main.class.getResource("../images/noteField.png")).getImage();
	private Image noteFieldKImage = new ImageIcon(Main.class.getResource("../images/noteField.png")).getImage();
	private Image noteFieldLImage = new ImageIcon(Main.class.getResource("../images/noteField.png")).getImage();
	
	
	private String bTB;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public GameYo() {
		dropNotes(bTB);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(noteFieldAImage, 124, 30, null);
		g.drawImage(noteFieldSImage, 228, 30, null);
		g.drawImage(noteFieldKImage, 640, 30, null);
		g.drawImage(noteFieldLImage, 744, 30, null);
		
		g.drawImage(dividingLineImage, 120, 30, null);
		g.drawImage(dividingLineImage, 224, 30, null);
		g.drawImage(dividingLineImage, 328, 30, null);
		g.drawImage(dividingLineImage, 636, 30, null);
		g.drawImage(dividingLineImage, 740, 30, null);
		g.drawImage(dividingLineImage, 844, 30, null);
		
	
		
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(redLineImage, 0, 580, null);
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			note.screenDraw(g);
		}
		
		
		g.setColor(Color.white);
		
		
		
		g.setFont(new Font("Stencil", Font.BOLD, 30));
		g.drawString("Kenji Yonezu - PEACE SIGN", 20, 702);
		g.setFont(new Font("FuturaBlack BT", Font.BOLD, 30));
		g.setColor(Color.RED);
		g.drawString("A", 165, 609);
		g.drawString("S", 269, 609);
		g.drawString("K", 681, 609);
		g.drawString("L", 785, 609);
		
		g.setColor(Color.CYAN);
		g.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 70));
		g.drawString("00000", 960, 500);
		
				
	}
	
	public void pressA() {
		noteFieldAImage = new ImageIcon(Main.class.getResource("../images/noteFieldPressed.png")).getImage(); // 경로를 보라빛으로 바꾸는 것
		new Music("kickDrum.mp3", false).start();
	}
	
	public void releaseA() {
		noteFieldAImage = new ImageIcon(Main.class.getResource("../images/noteField.png")).getImage(); // 경로를 보라빛으로 바꾸는 것
		new Music("snareDrum1.mp3", false).start();
	}
	
	public void pressS() {
		noteFieldSImage = new ImageIcon(Main.class.getResource("../images/noteFieldPressed.png")).getImage(); // 경로를 보라빛으로 바꾸는 것
		new Music("hiHat.mp3", false).start();
	}
	
	public void releaseS() {
		noteFieldSImage = new ImageIcon(Main.class.getResource("../images/noteField.png")).getImage(); // 경로를 보라빛으로 바꾸는 것
		new Music("snareDrum2.mp3", false).start();
	}
	
	public void pressK() {
		noteFieldKImage = new ImageIcon(Main.class.getResource("../images/noteFieldPressed.png")).getImage(); // 경로를 보라빛으로 바꾸는 것
	}
	
	public void releaseK() {
		noteFieldKImage = new ImageIcon(Main.class.getResource("../images/noteField.png")).getImage(); // 경로를 보라빛으로 바꾸는 것
	}
	
	public void pressL() {
		noteFieldLImage = new ImageIcon(Main.class.getResource("../images/noteFieldPressed.png")).getImage(); // 경로를 보라빛으로 바꾸는 것
	}
	
	public void releaseL() {
		noteFieldLImage = new ImageIcon(Main.class.getResource("../images/noteField.png")).getImage(); // 경로를 보라빛으로 바꾸는 것
	}
	
	
	@Override
	public void run() {
		
	}
	
	public void dropNotes(String bTB) {
//		noteList.add(new Note(124, 30, "short"));
//		noteList.add(new Note(228, 580, "short"));
//		noteList.add(new Note(640, 90, "short"));
//		noteList.add(new Note(744, 120, "short"));
		
		Note note = new Note(124, "short");
		note.start();
		noteList.add(note);
		
	}
	
	
}
