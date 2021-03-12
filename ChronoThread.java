public class ChronoThread extends Thread {

	private GameFrame gameframe;

	public ChronoThread(GameFrame gameframe0) {
		super();
		this.gameframe = gameframe0;
	}

	public void run() {
		
		while(true) {
			this.gameframe.setChrono();
		}

	}


}