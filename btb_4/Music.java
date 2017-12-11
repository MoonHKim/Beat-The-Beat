package btb_4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{ // 쓰레드는 하나의 작은 프로그램같은거(뮤직 상속받기)

	private Player player; // 자바줌사이트의 라이브러리 중 하나
	private boolean isloop; // 이 곡이 무한반복인지 아닌지
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isloop) {
		try {
			this.isloop = isloop;
			file = new File(Main.class.getResource("../music/" + name).toURI()); // 해당 파일의 위치를 가져온다
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) { // 트라이 구문 안에서 오류 발생시 캐치로 넘어간다.
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() { // 현제 실행되고 있는 음악이 어떤위치에서 실행되고 있는지 알려준다. 0.001단위까지 알려줌 (10초면 10,000 return)
		// 나즁에 노트를 떨어트릴때 이 겟타임으로 속도를 알게됨
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() { // 곡 실행중 멈추고 싶을 때 아무때나 멈출 수 있게 (게임중에 뒤로가기 하기위해 필요하다)
		isloop = false; 
		player.close();
		this.interrupt(); // 해당 스레드를 중지상태로 만든다.
	}
	
	@Override
	public void run() { // 스레드 상속을 위해 반드시 필요한것 run
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isloop);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 오류발생시 해당 오류메세지 가져오기
		}
	}
}
