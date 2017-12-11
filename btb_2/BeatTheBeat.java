package btb_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BeatTheBeat extends JFrame{

	private Image screenImage;
	private Graphics screenGraphic; // 더블 버퍼링을 위해서 전체화면에 이미지룰 담는 두 인스턴스
	
	private Image introBackground; // 가져온 이미지를 담을 수 있는 객체
	
	public BeatTheBeat() {
		setTitle("Beat The Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 이거 가능한지(달라야 하니까 
		setLocationRelativeTo(null); // 화면 정중앙에 뜨게함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안넣으면 끄더라도 프로그램이 컴퓨터 내부에서는 계속 돌아감
		setVisible(true); // 화면에 나오게
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage(); // 메인클래스의 위치를 기반으로 
		//리소스 즉 인트로 백그라운드를 얻어온 뒤에 그것의 이미지 인스턴스를 이미지백그라운드라는 이름의 변수에다가 초기화를 해주겠다(초기화해야 사용가능)
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 미리 정해놓은 사이즈로 이미지를 만들어서 스크린이미지에 넣어주겠다
		screenGraphic = screenImage.getGraphics(); // 스르린 이미지를 이용해서 그래픽 객체를 얻어옴
		screenDraw(screenGraphic); // 스크린 그래픽에 
		g.drawImage(screenImage, 0, 0, null); // 스크린이미지 위치지정
	}
	
	public void screenDraw(Graphics g) { // 함수 = 메소드(이 양반이 말하는 것)
		g.drawImage(introBackground, 0, 0, null); //인트로 백그라운드를 전체이미지 즉, 스크린이미지에 그려주는 것
		this.repaint(); // 여기까지가 더블 버퍼링인데 여기에서   이 리페인트가 전체화면 이미지를 계속 반복 프로그램이 끝날 때까지
	}
}
