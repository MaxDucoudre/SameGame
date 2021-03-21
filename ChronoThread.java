/**
* Classe ChronoThread
* Cette classe permet de boucler pour mettre à jour l'affichage du chrono
* Cette nouvelle instance dure tout le long d'une partie
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

public class ChronoThread extends Thread {



	private GameFrame gameframe;

	public ChronoThread(GameFrame gameframe0) {
		super();
		this.gameframe = gameframe0;
	}

@Override
	public void run() {
		System.out.println("Thread du chrono actif...");

		while(true) {
			this.gameframe.setChrono(); // méthode pour mettre à jour le chrono à l'affichage
		}
	}


}