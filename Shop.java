
import java.io.*;

/**
* Classe Modèle : Shop
* Classe les fichiers liés au shop
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/
public class Shop {



	public Shop() {
	}


	/**
	* Méthode "setSkinPack" permet de mettre à jour le pack de skin d'une sauvegarde
	* @param save correspond au numéro de la sauvegarde
	* @param pack correspond au numéro du pack
	*/
	public void setSkinPack(int save, int pack) {

		try { 
			// on ouvre le fichier en écriture
			FileOutputStream fichier_ecriture = new FileOutputStream ("./saves/save"+save+"/activeskin.bin");
			DataOutputStream flux_ecriture = new DataOutputStream (fichier_ecriture);  

			try {
				flux_ecriture.writeInt(pack);

			} catch (IOException e) {
				System.err.println("Erreur lors de la ecriture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur lors de l'ouverture en écriture");
		}      
	}


	/**
	* Méthode "getSkinPack" permet de récupérer le numéro du skin appliqué sur une sauvegarde
	* @param save correspond au numéro de la sauvegarde
	*/
	public int getSkinPack(int save) {
		int pack;
		try {
			// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./saves/save"+save+"/activeskin.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {
				pack = flux.readInt(); // On récupère la valeur dans le fichier
				return pack; // on renvoi la valeur qui est dans le fichier

			} catch (IOException e) {
				System.err.println("Erreur de lecture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture en lecture");
		}      
		return 0; 
	}

	/**
	* Méthode "unlockSkinPack" permet de débloquer un pack de skin sur une sauvegarde
	* @param save correspond au numéro de la sauvegarde
	* @param unlockedpack correspond au numéro du pack a débloquer
	*/
	public void unlockSkinPack(int save, int unlockedpack) {
		boolean pack1 = true; 
		boolean pack2 = false;
		boolean pack3 = false; 

		try {
			// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./saves/save"+save+"/unlockedskin.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {
				pack1 = flux.readBoolean(); 
				pack2 = flux.readBoolean();
				pack3 = flux.readBoolean(); 


					try { 
						FileOutputStream fichier_ecriture = new FileOutputStream ("./saves/save"+save+"/unlockedskin.bin");
						DataOutputStream flux_ecriture = new DataOutputStream (fichier_ecriture);  

					try {

						if (unlockedpack == 2) {
							flux_ecriture.writeBoolean(pack1);
							pack2 = true;
							flux_ecriture.writeBoolean(pack2);
							flux_ecriture.writeBoolean(pack3);
						} else if (unlockedpack == 3) {
							flux_ecriture.writeBoolean(pack1);
							flux_ecriture.writeBoolean(pack2);
							pack3 = true;
							flux_ecriture.writeBoolean(pack3);
						} else { // Le pack 1 est par défaut débloqué
							flux_ecriture.writeBoolean(pack1);
							flux_ecriture.writeBoolean(pack2);
							flux_ecriture.writeBoolean(pack3);
						}
					

					} catch (IOException e) {
						System.err.println("Erreur lors de la ecriture");
					}

				} catch (FileNotFoundException e) {
					System.err.println("Erreur lors de l'ouverture en écriture");
				}      



			} catch (IOException e) {
				System.err.println("Erreur de lecture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture en lecture");
		}      
	}


	/**
	* Méthode "getIsUnlockedSkinPack" permet de récupérer un booléen disant si un pack de skin est débloqué
	* @param save correspond au numéro de la sauvegarde
	* @param pack correspond au numéro du pack
	* @return true si le pack est débloqué
	*/
	public boolean getIsUnlockedSkinPack(int save, int pack) {
		boolean[] pack_tab = new boolean[3];

		try {
			// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./saves/save"+save+"/unlockedskin.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {

				pack_tab[0] = flux.readBoolean(); 
				pack_tab[1] = flux.readBoolean();
				pack_tab[2] = flux.readBoolean();

				return pack_tab[pack-1];


			} catch (IOException e) {
				System.err.println("Erreur de lecture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture en lecture");
		}     
		return false;

	}
}