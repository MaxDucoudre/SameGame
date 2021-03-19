/**
* Classe Contrôleur : OptionsObs
* Classe gérant l'interaction des boutons sur le menu des options
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionsObs implements ActionListener {

	// attributs
	private OptionsFrame optionsframe;
	private JFrame fenetre;

	// constructeur pour les boutons qui ont besoin de la fenêtre
	public OptionsObs(OptionsFrame optionsframe0, JFrame fenetre0) {
		this.optionsframe = optionsframe0;
		this.fenetre = fenetre0;
	}

	// Constructeur pour les boutons qui n'ont pas besoin de la fenêtre
	public OptionsObs(OptionsFrame optionsframe0) {
		this.optionsframe = optionsframe0;
	}


	// Lors de la pression d'un bouton
	public void actionPerformed(ActionEvent e) { 


			// BOUTONS DIFFICULTE
		// Bouton difficulté normale :
		if(e.getActionCommand() == this.optionsframe.difficulty_normal_string) {
			this.optionsframe.setDifficultyButton();
			System.out.println("Difficulté mise sur difficile");
		}

		// Bouton difficulté Difficile :
		if(e.getActionCommand() == this.optionsframe.difficulty_hard_string) {
			this.optionsframe.setDifficultyButton();
			System.out.println("Difficulté mise sur normale");
		}


			// BOUTONS LANGUE
		// Bouton langue englaise 
		if(e.getActionCommand() == this.optionsframe.langue_english_string) {
			this.optionsframe.setLanguageButton();
			System.out.println("Langue changée");
		}

		// Bouton langue française 
		if(e.getActionCommand() == this.optionsframe.langue_french_string) {
			this.optionsframe.setLanguageButton();
			System.out.println("Langue changée");
		}


			// BOUTONS MOD
		// Bouton mod duel
		if(e.getActionCommand() == this.optionsframe.mod_dual_string) {
			this.optionsframe.setModButton();
			System.out.println("Mod solo actif");
		}

		// Bouton mod solo
		if(e.getActionCommand() == this.optionsframe.mod_solo_string) {
			this.optionsframe.setModButton();
			System.out.println("Mod duel actif");
		}

		// Bouton RESET
		if(e.getActionCommand() == this.optionsframe.reset_string) {

			System.out.println("Réinitialisation des options");

			this.optionsframe.resetSettings(); // remise des settings par défaut
		}


		// Bouton SAUVEGARDER
		if(e.getActionCommand() == this.optionsframe.save_string) {

			System.out.println("Sauvegarder les options");

			this.optionsframe.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre); // on recréer un objet de type MainMenuFrame
			this.optionsframe.refreshFrame();
		}
	}
}