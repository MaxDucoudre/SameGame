/**
* Classe Modèle : Statistics
* Classe gérant l'interaction des boutons du menu statistiques
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import java.io.*;

public class Statistics {


	/**
	* le constructeur Statistics
	*/
	public Statistics() {
	}


	/**
	 * La méthode "getBestChrono" permet de récupérer le temps du record de points
	 * @return le temps du chrono en string
	 */
	public String getBestChrono() {
		long besttime;
		String besttimestring;
		try {
			// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./saves/save1/timehightscore.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {
				besttime = flux.readLong(); // On récupère la valeur dans le fichier

				return this.toString(besttime); // on renvoi cette valeur en String

			} catch (IOException e) {
				System.err.println("Erreur de lecture");
				return "0:00"; 
			}

		} catch (FileNotFoundException e) {

			System.err.println("Erreur d'ouverture en lecture");
			return "0:00"; 
		}
	}



	/**
	* Cette méthode existe déjà dans Chrono.java, mais pour une raison qui m'échappe, je ne peux y accéder depuis game.java
	* La méthode "toString" renvoie sous forme de "m:ss" les milisecondes qu'on y injecte en paramètre
	* @param temps_ms représente le temps en miliseconde qu'on veut rentrer
	* @return un temps en format 0:00 en fonction des milisecondes données
	*/
	public String toString(long temps_ms) {
		String dureeMinSec = "";
		long secondes_total;

        secondes_total = temps_ms/1000; // converti les milisecondes en secondes


        int minutes = (int) ((secondes_total % 3600) / 60); // récupération des minutes
        int secondes = (int) (secondes_total % 60);         // récupération des secondes

        // si les secondes sont inférieures à 10, on ajoute un 0 avant les secondes pour qu'à l'affichage, le chronomètre ne change pas de taille et reste sous forme "m:ss"
        if (secondes < 10) {
        	dureeMinSec = minutes + ":0" + secondes;
        } else {
        	dureeMinSec = minutes + ":" + secondes;
        }

        return dureeMinSec;

    }
}