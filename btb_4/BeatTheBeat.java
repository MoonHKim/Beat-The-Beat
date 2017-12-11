package btb_4;

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

public class BeatTheBeat extends JFrame{

	private Image screenImage;
	private Graphics screenGraphic; // 더블 버퍼링을 위해서 전체화면에 이미지룰 담는 두 인스턴스
	
		
	// 종료 아이콘 색깔 바꾸기
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage); // 원래 22라인에 있던거 안에거 지우고 베이직 이미지로 바꿔서 여기에 잘,붙 (즉, 기본이미지는 이거라는 거임)
	
	private int mouseX, mouseY; // 프로그램안에서 마우스의 좌표(라인38으로 이동해서 마저)
	
	public BeatTheBeat() {
		setUndecorated(true); // 이거만 쓰면 기본적으로 뜨는 메뉴바가 존재하지 않게 된다
		setTitle("Beat The Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 이거 가능한지(달라야 하니까 
		setLocationRelativeTo(null); // 화면 정중앙에 뜨게함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안넣으면 끄더라도 프로그램이 컴퓨터 내부에서는 계속 돌아감
		setVisible(true); // 화면에 나오게
		setBackground(new Color(0, 0, 0, 0)); // 페인트컴포넌트시 배경을 하얗게 해줌
		setLayout(null); // 버튼이나 제이라벨 넣었을 때 재위치에 꽃히게 된다
		
		exitButton.setBounds(1245, 0, 30, 30); // 여기 입력한거는 메뉴바 가장 오른쪽으로 지정하는 명령 (나가기 버튼(색깔 바꾸기와 함께 하는 중)
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false); 
		exitButton.setFocusPainted(false); // 위 3라인이 나가기 버튼의 테두리 네모를 없애고 자연스럽게 만들어 주는거 (제이버튼은 하나의 템플릿이 존재하는데 그게 우리가 원하는 모양이 아닌 네모안에 담겨있기에 그걸 없애야한다.
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 이거
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 이거 마우스 커서 손꾸락모양으로 바꾸는거
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0); // 클릭시 끄기
			}
		}); 
		
		add(exitButton); // 이 객체가 여기(라인 61부터)있으면 화면에뜨긴 뜨는데 안눌림 메뉴바 뒤에 가 있는 상황 그렇기에 라인 43으로 이동
		
		menuBar.setBounds(0, 0, 1280, 30); // (위치, 위치, 크기(가로), 크기(세로)) 지정 -> 
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { // 마우스가 눌렸을 때의 이벤트 처리
				mouseX = e.getX();
				mouseY = e.getY(); // 실제로 이벤트가 발생했을 때 x,y좌표를 가져옴
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) { // drag이벤트가 발생했을 때의 이벤트 처리
				int x = e.getXOnScreen();
				int y = e.getYOnScreen(); // 좌표가져옴
				setLocation(x - mouseX, y - mouseY); // 드레그 할때 좌표가져와서 제이프레임의 위치 자체를 바꿔줌(창 자체를 움직일 수 있게 해준당)
			}
		});
		add(menuBar);
		

		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 미리 정해놓은 사이즈로 이미지를 만들어서 스크린이미지에 넣어주겠다
		screenGraphic = screenImage.getGraphics(); // 스르린 이미지를 이용해서 그래픽 객체를 얻어옴
		screenDraw(screenGraphic); // 스크린 그래픽에 
		g.drawImage(screenImage, 0, 0, null); // 스크린이미지 위치지정
	}
	
	public void screenDraw(Graphics g) { // 함수 = 메소드(이 양반이 말하는 것)
		g.drawImage(introBackground, 0, 0, null); //인트로 백그라운드를 전체이미지 즉, 스크린이미지에 그려주는 것
		paintComponents(g); // 페인트컴포넌트라는 것은 이미지를 단순하게 해당 스크린이미지라는 변수안에 그려주는 것 이외에 제이바나 제이프레임 안에 추가하면 그것을 그려주는것(고정되는 이미지(메뉴바 같은거)는 이것으로 하는게 더 편함)
		this.repaint(); 
	}
}
