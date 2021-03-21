/**
* Classe Modèle : Save
* Classe qui gère les sauvegardes du jeux
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import java.io.*;

public class Save {


	private int activeSave; 

	private boolean save1exist;
	private boolean save2exist;
	private boolean save3exist;


	/**
	 * Le constructeur de Save
	 */
	public Save() {

	}

	/**
	 * La méthode "createSave" permet de créer une nouvelle sauvegarde
	 * @param save correspond au numéro de la sauvegarde (entre 1 et 3)
	 * @param savename correspond au nom de la sauvegarde (String)
	 */
	public void createSave(int save, String savename) {
		if(save >= 1 && save <= 3) { // Il n'y a que 3 emplacements maximum

			try { 
				FileOutputStream fichier = new FileOutputStream ("./saves/save"+save+"/savename.bin");
				DataOutputStream flux = new DataOutputStream (fichier);  

				try {
					flux.writeChars(savename);
					this.setActiveSave(save, true);

				}  catch (IOException e) {
					System.err.println("Erreur lors de l'écriture");
				}
			} catch (FileNotFoundException e) {
				System.err.println("Erreur lors de l'ouverture en écriture");
			}      
		}
	}

	/**
	 * La méthode "getSaveName" permet d'obtenir le nom de la sauvegarde
	 * @param save correspond au numéro de la sauvegarde (entre 1 et 3)
	 * @return le nom correspondant au numéro de la sauvegarde
	 */
	public String getSaveName(int save) {

		if(save >= 1 && save <= 3) { // Il n'y a que 3 emplacements maximum
			String saveName;
			boolean eof = false;
			int i = 0;
			int j = 0;
			int maxcarac = 25;
			char[] stringsavename = new char[maxcarac];

			try {
				// On ouvre le fichier
				FileInputStream fichier = new FileInputStream("./saves/save"+save+"/savename.bin");
				DataInputStream flux = new DataInputStream(fichier);  

				try {
					while(eof == false) {
						if(i < maxcarac) {
							stringsavename[i] = flux.readChar();
							i++;
						} else {
							System.out.println("Chaine de caractère trop longue");
							return "Name too much long       ";
						}


				}

				} catch (EOFException e) {
					eof = true;
					for(j = i; j < maxcarac; j++) {
						stringsavename[i] = ' ';
						i++;
					}

					return String.valueOf(stringsavename);
				
				} catch (IOException e) {
					System.err.println("Erreur de lecture");
				}


			} catch (FileNotFoundException e) {
				System.err.println("Erreur d'ouverture en lecture");
			}      
			return "Emplacement vide"; 
		}
			return "Emplacement vide"; 
	}

	/**
	 * La méthode "deleteSave" permet de réinitialiser une sauvegarde
	 * @param save correspond au numéro de la sauvegarde a détruire
	 */
	public void deleteSave(int save) {	
		if(save >= 1 && save <= 3) { // Il n'y a que 3 emplacements maximum

			try { 
				// on ouvre tous les fichiers a mettre à zero lorsqu'on supprime une sauvegarde
				FileOutputStream fichier = new FileOutputStream ("./saves/save"+save+"/hightscore.bin");
				DataOutputStream flux = new DataOutputStream (fichier);  

				FileOutputStream fichier2 = new FileOutputStream ("./saves/save"+save+"/timehightscore.bin");
				DataOutputStream flux2 = new DataOutputStream (fichier2);  

				FileOutputStream fichier3 = new FileOutputStream ("./saves/save"+save+"/coins.bin");
				DataOutputStream flux3 = new DataOutputStream (fichier3);  

				FileOutputStream fichier4 = new FileOutputStream ("./saves/save"+save+"/numbergame.bin");
				DataOutputStream flux4 = new DataOutputStream (fichier4);  

				FileOutputStream fichier5 = new FileOutputStream ("./saves/save"+save+"/savename.bin");
				DataOutputStream flux5 = new DataOutputStream (fichier5);  

				try {
					flux.writeInt(0); 
					flux2.writeLong(0); 
					flux3.writeInt(0);
					flux4.writeInt(0);
					flux5.writeChars("Empty Slot");
					this.setActiveSave(save, false);
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


	/**
	 * La méthode "loadSave" permet de charger une sauvegarde
	 * @param save correspond au numéro de la sauvegarde a charger
	 */
	public void loadSave(int save) {
		if(save >= 1 && save <= 3) { // Il n'y a que 3 emplacements maximum

			try { 
				FileOutputStream fichier = new FileOutputStream ("./saves/activeSave.bin");
				DataOutputStream flux = new DataOutputStream (fichier);  

				try {
					flux.writeInt(save); 

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

	/**
	 * La méthode "getLoadedSave" permet de récupérer une le numéro de la sauvegarde actuellement chargée
	 * @return le numéro de la sauvegarde actuellement chargée
	 */
	public int getLoadedSave() {
		int loadedSave;

		try {
				// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./saves/activeSave.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {
				loadedSave = flux.readInt();
				return loadedSave;

			} catch (IOException e) {
				System.err.println("Erreur de lecture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture en lecture");
		}      
		return 1; 
	}




	/**
	 * La méthode "setActiveSave" permet de changer le status d'une sauvegarde
	 * @param enable est un booléen, true si on veut activer la save, false si non
	 * @param save correspond au numéro de la sauvegarde à mettre à jour
	 */
	public void setActiveSave(int save, boolean enable) {
		if(save >= 1 && save <= 3) { // Il n'y a que 3 emplacements maximum

			try { 
				FileOutputStream fichier = new FileOutputStream ("./saves/save"+save+"/enablesave.bin");
				DataOutputStream flux = new DataOutputStream (fichier);  

				try {
					flux.writeBoolean(enable); 

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


	/**
	 * La méthode "isActiveSave" permet de savoir si une sauvegarde est utilisée
	 * @param save correspond au numero de la sauvegarde qu'on veut vérifier
	 * @return true si la sauvegarde est utilisée
	 */
	public boolean isActiveSave(int save) {
		boolean isActive;

		try {
				// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./saves/save"+save+"/enablesave.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {
				isActive = flux.readBoolean();
				return isActive;

			} catch (IOException e) {
				System.err.println("Erreur de lecture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture en lecture");
		}      
		return false; 
	}

}