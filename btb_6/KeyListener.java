package btb_6;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		if(BeatTheBeat.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			BeatTheBeat.game.pressA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			BeatTheBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			BeatTheBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			BeatTheBeat.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(BeatTheBeat.game == null) {
			return; // 게임이 진행되고 있지 않다면 멈춘다
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			BeatTheBeat.game.releaseA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			BeatTheBeat.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			BeatTheBeat.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			BeatTheBeat.game.releaseL();
		}
	}
}
