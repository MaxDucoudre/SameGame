/**
* Classe Contrôleur : MainMenuObs
* Classe gérant l'interaction des boutons du menu principal
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuObs implements ActionListener {

	// attributs
	protected JFrame fenetre;
	protected MainMenuFrame mmf;

	// constructeur
	public MainMenuObs(JFrame fenetre0, MainMenuFrame mmf0) {
		this.fenetre = fenetre0;
		this.mmf = mmf0;
	}


	// Lors de la pression d'un bouton
	public void actionPerformed(ActionEvent e) { 
		
		// on affiche à la console le bouton cliqué
		System.out.println(e.getActionCommand());


		// Action du bouton qui lance la partie
		if(e.getActionCommand() == this.mmf.launchGameString) {

			this.mmf.eraseFrame();
			GameFrame smf = new GameFrame(this.fenetre, "NULL");
			this.mmf.refreshFrame();
		}


		// Action du bouton qui lance une partie à partir d'un fichier
		if(e.getActionCommand() == this.mmf.launchGameVs) {
			String chosed_file = "NULL";

			// Le JFile chooser pour choisir un fichier de grille
			JFileChooser chooser = new JFileChooser("./grid");
			chooser.setDialogTitle("Grid File Chooser");
			FileFilter filter = new FileNameExtensionFilter("File .txt", "txt");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(this.mmf);

			if(returnVal == JFileChooser.APPROVE_OPTION) {
				chosed_file = chooser.getSelectedFile().getName();
				System.out.println("Fichier utilisé : " + chooser.getSelectedFile().getName());

				// On lance la partie
				this.mmf.eraseFrame();
				GameFrame smf = new GameFrame(this.fenetre, "./grid/" + chosed_file);
				this.mmf.refreshFrame();
			}



		}

		// action du bouton qui lance le menu de la boutique
		if(e.getActionCommand() == this.mmf.shopString) {

			this.mmf.eraseFrame();
			ShopFrame sf = new ShopFrame(this.fenetre);
			this.mmf.refreshFrame();
		}

		// action du bouton qui lance le menu des options
		if(e.getActionCommand() == this.mmf.settingsString) {

			this.mmf.eraseFrame();
			OptionsFrame omf = new OptionsFrame(this.fenetre);
			this.mmf.refreshFrame();
		}

		// action du bouton qui lance le menu des statistiques
		if(e.getActionCommand() == this.mmf.statisticsString) {

			this.mmf.eraseFrame();
			StatisticsMenuFrame smf = new StatisticsMenuFrame(this.fenetre);
			this.mmf.refreshFrame();
		}

		// action du bouton qui lance le menu des sauvegardes
		if(e.getActionCommand() == this.mmf.saveString) {
			
			this.mmf.eraseFrame();
		   SaveMenuFrame smf = new SaveMenuFrame(this.fenetre);
			this.mmf.refreshFrame();
		}


		// action du bouton qui quitte la partie
		if(e.getActionCommand() == this.mmf.leftGameString) {

			fenetre.setVisible(false); // on cache la fenpetre
			System.exit(0);	// et on ferme le programme normalement

		}
	}
}



