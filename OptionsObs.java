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
	protected OptionsFrame optionsframe;

	// constructeur
	public OptionsObs(OptionsFrame optionsframe0) {
		this.optionsframe = optionsframe0;
	}


	// Lors de la pression d'un bouton
	public void actionPerformed(ActionEvent e) { 


		System.out.println(e.getActionCommand());


		// Bouton difficulté normale :
		if(e.getActionCommand() == this.optionsframe.difficulty_normal_string) {
					System.out.println("hard");

		}

		// Bouton difficulté Difficile :
		if(e.getActionCommand() == this.optionsframe.difficulty_hard_string) {


		}

	}
}