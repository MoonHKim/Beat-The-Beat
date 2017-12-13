package btb_7;

public class Beat {
	
	private int time;
	private String noteName;
	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}
	/**
	 * @return the noteName
	 */
	public String getNoteName() {
		return noteName;
	}
	/**
	 * @param noteName the noteName to set
	 */
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public Beat(int time, String noteName) {
		super();
		this.time = time;
		this.noteName = noteName;
	}
	
	
	
}
