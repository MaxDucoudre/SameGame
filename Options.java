import java.io.*;

/**
* Classe Modèle : <code>Options</code>
* Classe permettant de gérer les fichiers en fonction des options
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/
public class Options {

	public Options() {

	}

	/**
	 * La méthode <b>getDifficulty<b>" permet de récupérer le niveau de difficulté dans un fichier
	 * @return la difficluté normale ou difficile en String
	 */
	public String getDifficulty() {
		int difficulty;
		try {
			// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./settings/difficulty.bin");
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
	 * La méthode <b>setDifficulty</b> permet de mettre à jour le niveau de difficulté
	 * @param difficulty_string représente le niveau de difficulté souhaité
	 */
	public void setDifficulty(String difficulty_string) {

		try { 
			// on ouvre le fichier en écriture
			FileOutputStream fichier = new FileOutputStream ("./settings/difficulty.bin");

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

	/**
	 * La méthode <b>getLanguage</b> permet de récupérer la langue actuellement en vigueur
	 * @return la langue sous forme de String
	 */
	public String getLanguage() {
		int language;
		try {
			// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./settings/language.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {
				language = flux.readInt(); // On récupère la valeur de la langue dans le fichier

				// on renvoi une chaîne de caractère à la place d'un 1 ou d'un 0
				if(language == 0) {  // pour 0, c'est en anglais
					return "english";
				} else if(language == 1) { // pour 1, c'est en français
					return "french";
				} else if(language == 2) {// pour 2, c'est en esperanto
					return "esperanto";
				} else if(language == 3) {
					return "german";
				} else if(language == 4) {
					return "russian";
				} else if(language == 5) {
					return "portuguese";
				} else if(language == 6) {
					return "spanish";
				} else if(language == 7) {
					return "chinese";
				}

			} catch (IOException e) {
				System.err.println("Erreur de lecture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture en lecture");
		}    
		  
		return "english";
	}
	
	/**
	 * La méthode <b>setLanguage</b> permet de mettre à jour la langue
	 * @param langue_string correspond à la langue souhaitée
	 */
	public void setLanguage(String langue_string) {
		try { 
			// on ouvre le fichier en écriture
			FileOutputStream fichier = new FileOutputStream ("./settings/language.bin");

			DataOutputStream flux = new DataOutputStream (fichier);  

			try {

				if(langue_string == "english") {
					flux.writeInt(0); // on met à jour la valeur en anglais (anglais = 0)
				} else if (langue_string == "french") {
					flux.writeInt(1); // on met à jour la valeur en français (français = 1)
				} else if (langue_string == "esperanto") {
					flux.writeInt(2); // on met à jour la valeur en esperanto (esperanto = 2)
				} else if (langue_string == "german") {
					flux.writeInt(3); // on met à jour la valeur en allemand (allemand = 3)
				} else if(langue_string == "russian") {
					flux.writeInt(4);
				} else if(langue_string == "portuguese") {
					flux.writeInt(5);
				} else if(langue_string == "spanish") {
					flux.writeInt(6);
				} else if(langue_string == "chinese") {
					flux.writeInt(7);
				}


			} catch (IOException e) {
				System.err.println("Erreur lors de l'écriture");
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("Erreur lors de l'ouverture en écriture");
		} 
	}

	
	/**
	 * La méthode <b>getMod</b> permet de récupérer le mod du jeux
	 * @return le mod sous forme de string (dual ou solo)
	 */
	public String getMod() {
		int mod;
		try {
			// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./settings/mod.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {
				mod = flux.readInt(); // On récupère la valeur de la langue dans le fichier

				// on renvoi une chaîne de caractère à la place d'un 1 ou d'un 0
				if(mod == 0) {  // pour 0, c'est en anglais
					return "solo";
				} else if(mod == 1) { // pour 1, c'est en français
					return "dual";
				}

			} catch (IOException e) {
				System.err.println("Erreur de lecture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture en lecture");
		}    
		  
		return "solo";
	}
	
	/**
	 * La méthode <b>setMod</b> permet de mettre à jour le mod du jeux
	 * @param mod_string correspond au mod souhaité (dual ou solo)
	 */
	public void setMod(String mod_string) {
		try { 
			// on ouvre le fichier en écriture
			FileOutputStream fichier = new FileOutputStream ("./settings/mod.bin");

			DataOutputStream flux = new DataOutputStream (fichier);  

			try {

				if(mod_string == "solo") {
					flux.writeInt(0); 

				} else if (mod_string == "dual") {
					flux.writeInt(1); 
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



}