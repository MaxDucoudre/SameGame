
import java.io.*;


public class Shop {



	public Shop() {

	}



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


	public void unlockSkinPack(int save, int unlockedpack) {
		boolean pack0 = true; 
		boolean pack1 = false;
		boolean pack2 = false; 

		try {
			// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./saves/save"+save+"/unlockedskin.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {
				pack0 = flux.readBoolean(); 
				pack1 = flux.readBoolean();
				pack2 = flux.readBoolean(); 


					try { 
						FileOutputStream fichier_ecriture = new FileOutputStream ("./saves/save"+save+"/unlockedskin.bin");
						DataOutputStream flux_ecriture = new DataOutputStream (fichier_ecriture);  

					try {

						if (unlockedpack == 1) {
							flux_ecriture.writeBoolean(pack0);
							pack1 = true;
							flux_ecriture.writeBoolean(pack1);
							flux_ecriture.writeBoolean(pack2);
						} else if (unlockedpack == 2) {
							flux_ecriture.writeBoolean(pack0);
							flux_ecriture.writeBoolean(pack1);
							pack2 = true;
							flux_ecriture.writeBoolean(pack2);
						} else {
							flux_ecriture.writeBoolean(pack0);
							flux_ecriture.writeBoolean(pack1);
							flux_ecriture.writeBoolean(pack2);
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

				return pack_tab[pack];





			} catch (IOException e) {
				System.err.println("Erreur de lecture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture en lecture");
		}     
		return false;

	}
}