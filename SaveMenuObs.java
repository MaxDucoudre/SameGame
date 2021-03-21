/**
* Classe Contrôleur : SaveMenuObs
* Classe gérant l'interaction des boutons de SaveMenuFrame
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.event.*;

public class SaveMenuObs implements ActionListener {

	private SaveMenuFrame savemenuframe;
	private JFrame fenetre;

	public SaveMenuObs(SaveMenuFrame savemenuframe0) {
		this.savemenuframe = savemenuframe0;
	}

	public SaveMenuObs(SaveMenuFrame savemenuframe0, JFrame fenetre0) {
		this.savemenuframe = savemenuframe0;
		this.fenetre = fenetre0;

	}	


	public void actionPerformed(ActionEvent e) { 


		// BOUTONS SAUVEGARDE NUMERO 1
		if(e.getActionCommand() == this.savemenuframe.nouveauxButton1String) {
			this.savemenuframe.writeSaveName(1);
		}
	
		if(e.getActionCommand() == this.savemenuframe.createButton1String) {
			this.savemenuframe.pressCreateButton(1);
		}

		if(e.getActionCommand() == this.savemenuframe.supprimerButton1String) {
			this.savemenuframe.pressDeleteButton(1);
		}

		if(e.getActionCommand() == this.savemenuframe.selectionerButton1String) {
			this.savemenuframe.pressSelectButton(1);

			this.savemenuframe.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre);
			this.savemenuframe.refreshFrame();
		}


		// BOUTONS SAUVEGARDE NUMERO 2
		if(e.getActionCommand() == this.savemenuframe.nouveauxButton2String) {
			this.savemenuframe.writeSaveName(2);
		}
	
		if(e.getActionCommand() == this.savemenuframe.createButton2String) {
			this.savemenuframe.pressCreateButton(2);
		}

		if(e.getActionCommand() == this.savemenuframe.supprimerButton2String) {
			this.savemenuframe.pressDeleteButton(2);
		}

		if(e.getActionCommand() == this.savemenuframe.selectionerButton2String) {
			this.savemenuframe.pressSelectButton(2);

			this.savemenuframe.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre);
			this.savemenuframe.refreshFrame();
		}

		// BOUTONS SAUVEGARDE NUMERO 3
		if(e.getActionCommand() == this.savemenuframe.nouveauxButton3String) {
			this.savemenuframe.writeSaveName(3);
		}
	
		if(e.getActionCommand() == this.savemenuframe.createButton3String) {
			this.savemenuframe.pressCreateButton(3);
		}

		if(e.getActionCommand() == this.savemenuframe.supprimerButton3String) {
			this.savemenuframe.pressDeleteButton(3);
		}

		if(e.getActionCommand() == this.savemenuframe.selectionerButton3String) {
			this.savemenuframe.pressSelectButton(3);

			this.savemenuframe.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre);
			this.savemenuframe.refreshFrame();
		}
		
	}
}
