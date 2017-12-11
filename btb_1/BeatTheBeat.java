package btb_1;

import javax.swing.JFrame;

public class BeatTheBeat extends JFrame{

	public BeatTheBeat() {
		setTitle("Beat The Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 이거 가능한지(달라야 하니까 
		setLocationRelativeTo(null); // 화면 정중앙에 뜨게함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안넣으면 끄더라도 프로그램이 컴퓨터 내부에서는 계속 돌아감
		setVisible(true); // 화면에 나오게
		
	}
}
