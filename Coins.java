/**
 * Classe : Coins
  * Cette classe permet de gérer les coins d'un joueur
 *
 * @version 1
 * @author Max Ducoudré
 * @author Loris Schnell
 */

import java.io.*;

public class Coins {



	public Coins() {
		
	}


	/**
	 * La méthode "increaseCoins" permet d'augmenter l'argent dans le porte monnaie
	 * @param save correspond au numero de la sauvegarde sur laquelle on veut augmenter les coins
	 * @param coinsObt le nombre de coins obtenus (en int)
	 */
	public void increaseCoins(int coinsObt, int save) {
		int coins;

		try { 

			// on ouvre le fichier en écriture
			FileOutputStream fichier_ecriture = new FileOutputStream ("./saves/save"+save+"/coins.bin");
			DataOutputStream flux_ecriture = new DataOutputStream (fichier_ecriture);  

			try {
				coins = this.getNumberOfCoins(save); // on récupère le nombre d'argent 
				coins = coins + coinsObt; // on l'incrémente du nombre de coins souhaité
				flux_ecriture.writeInt(coins); // et on l'écrit dans le fihcier
			} catch (IOException e) {
				System.err.println("Erreur lors de l'ecriture");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Erreur lors de l'ouverture en écriture !");
		}      

	}


	/**
	 * La méthode "getNumberOfCoins" permet de récupérer le nombre de coins d'un joueur
	 * @param save correspond au numero de la sauvegarde
	 * @return le nombre de coins du joueur (en int)
	 */
		public int getNumberOfCoins(int save) {
			int coins;

			try { 
			// on ouvre le fichier lecture
				FileInputStream fichier_lecture = new FileInputStream ("./saves/save"+save+"/coins.bin");
				DataInputStream flux_lecture = new DataInputStream (fichier_lecture);  

				try {

				coins = flux_lecture.readInt(); // on récupère le nombre de coins
				return coins; // puis on le return

			} catch (IOException e) {
				System.err.println("Erreur lors de la lecture !");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Erreur lors de l'ouverture en écriture");
		}    

		return 0;
	}

}
