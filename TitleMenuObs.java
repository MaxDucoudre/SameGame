/**
* Classe Contrôleur : TitleMenuObs
* Rendre le menu titre interactif
*
* @version 1 - 08 march 2021
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitleMenuObs implements ActionListener, MouseListener {

	private TitleMenuFrame tmf;
	private JFrame fenetre;


	public TitleMenuObs(TitleMenuFrame tmf0, JFrame fenetre0) {
		this.tmf = tmf0;
		this.fenetre = fenetre0;
	}

	// gère l'interactivité du bouton Start du menu titre
	public void actionPerformed(ActionEvent e) { 


		this.tmf.eraseFrame();
		SaveMenuFrame smf = new SaveMenuFrame(this.fenetre);
		this.tmf.refreshFrame();

		System.out.println("Main Menu");

	} 


	public void mouseEntered(MouseEvent e) {
			this.tmf.changeGameNameColor();
		
	}

	public void mouseExited(MouseEvent e) {
			this.tmf.resetGameNameColor();
	}


	public void mouseClicked(MouseEvent evenement) {}
	public void mousePressed(MouseEvent evenement) {}
	public void mouseReleased(MouseEvent evenement) {}
	public void mouseDragged(MouseEvent evenement) {}

}
