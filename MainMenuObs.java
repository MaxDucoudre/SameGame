/**
* Classe Contrôleur : MainMenuObs
* Classe gérant l'interaction des boutons du menu principal
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
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
			GameFrame smf = new GameFrame(this.fenetre, "./grilles_prefab/grille1.bin");
			this.mmf.refreshFrame();
		}


		// Action du bouton qui lance une partie à 2
		if(e.getActionCommand() == this.mmf.launchGameVs) {

			this.mmf.eraseFrame();
		// GameFrameVS smf = new GameFrameVS();
			this.mmf.refreshFrame();
		}

		// action du bouton qui lance le menu de la boutique
		if(e.getActionCommand() == this.mmf.shopString) {

			this.mmf.eraseFrame();
		// BoutiqueMenuFrame smf = new BoutiqueMenuFrame();
			this.mmf.refreshFrame();
		}

		// action du bouton qui lance le menu des options
		if(e.getActionCommand() == this.mmf.settingsString) {

			this.mmf.eraseFrame();
		//OptionsMenuFrame omf = new OptionMenuFrame();
			this.mmf.refreshFrame();
		}

		// action du bouton qui lance le menu des statistiques
		if(e.getActionCommand() == this.mmf.statisticsString) {

			this.mmf.eraseFrame();
		//StatisicsMenuFrame omf = new StatisicsMenuFrame();
			this.mmf.refreshFrame();
		}

		// action du bouton qui lance le menu des sauvegardes
		if(e.getActionCommand() == this.mmf.saveString) {
			
			this.mmf.eraseFrame();
		//SaveMenuFrame omf = new SaveMenuFrame();
			this.mmf.refreshFrame();
		}


		// action du bouton qui quitte la partie
		if(e.getActionCommand() == this.mmf.leftGameString) {

			fenetre.setVisible(false); // on cache la fenpetre
			System.exit(0);	// et on ferme le programme normalement

		}
	}
}



