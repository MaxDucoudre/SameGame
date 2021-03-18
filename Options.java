/**
* Classe Modèle : Options
* Classe permettant de gérer les fichiers en fonction des options
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import java.io.*;


public class Options {

	public Options() {
		
	}

	/**
	 * La méthode "getDifficulty" permet de récupérer le niveau de difficulté dans un fichier
	 * @return la difficluté normale ou difficile en String
	 */
	public String getDifficulty() {
		int difficulty;
		try {
			// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./files/difficulty.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {
				difficulty = flux.readInt(); // On récupère la valeur de la difficulté dans le fichier

				// on renvoi une chaîne de caractère à la place d'un 1 ou d'un 0
				if(difficulty == 0) { 
					return "normal";
				} else {
					return "hard";
				}

			} catch (IOException e) {
				System.err.println("Erreur de lecture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture en lecture");
		}    
		  
		return "normal";
	}

	/**
	 * La méthode "setDifficulty" permet de mettre à jour le niveau de difficulté
	 * @param difficulty_string représente le niveau de difficulté souhaité
	 */
	public void setDifficulty(String difficulty_string) {

		try { 
			// on ouvre le fichier en écriture
			FileOutputStream fichier = new FileOutputStream ("./files/difficulty.bin");

			DataOutputStream flux = new DataOutputStream (fichier);  


			try {

				if(difficulty_string == "normal") {

					flux.writeInt(0); // on met à jour la valeur en normal
				} else if (difficulty_string == "hard") {
					flux.writeInt(1); // on met à jour la valeur hard
				}
			}

			catch (IOException e) {
				System.err.println("Erreur lors de l'écriture");
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("Erreur lors de l'ouverture en écriture");
		}      
	}

/*
	public int getLanguage() {

	}

	public int getMod() {

	}
*/
}