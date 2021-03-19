/**
* Classe Contrôlleur : CreditsObs
* Classe gérant l'interaction des boutons des crédits
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CreditsObs implements ActionListener {

	private Credits credits;
	private JFrame fenetre;

	public CreditsObs(Credits credits0, JFrame fenetre0) {
		this.credits = credits0;
	}

	public void actionPerformed(ActionEvent e) { 

		// action quand on quitte les crédits
		if(e.getActionCommand() == this.credits.leftbuttonstring) {
			this.credits.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre); // on recréer un objet de type MainMenuFrame
			this.credits.refreshFrame();

		}

	}

}
