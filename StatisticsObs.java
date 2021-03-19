/**
* Classe Contrôlleur : StatisticsObs
* Classe gérant l'interaction des boutons du menu statistiques
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class StatisticsObs implements ActionListener {

	private StatisticsMenuFrame smf;
	private JFrame fenetre;


/**
* le constructeur StatisticsObs
*/
	public StatisticsObs(StatisticsMenuFrame smf0, JFrame fenetre0) {
		this.smf = smf0;
		this.fenetre = fenetre0;
	}


	public void actionPerformed(ActionEvent e) { 

		// action quand on clique sur le bouton menu principal dans les statistiques
		if(e.getActionCommand() == this.smf.leftbuttonstring) {

			this.smf.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre); // on recréer un objet de type MainMenuFrame
			this.smf.refreshFrame();

		}
	}
}