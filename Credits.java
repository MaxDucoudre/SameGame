/**
* Classe Vue : Credits
* Classe permettant l'affichage des crédits
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;


public class Credits extends MenuFrame {

	public String leftbuttonstring = super.langue.getMainMenuString();

	public Credits(JFrame fenetre) {
		super(fenetre);



		JPanel leftbuttonpanel = new JPanel();
		leftbuttonpanel.setOpaque(false);
		JButton leftcredit = new JButton();
		leftcredit.setText(leftbuttonstring);
		leftcredit.addActionListener(new CreditsObs(this, fenetre));
		leftbuttonpanel.add(leftcredit);

		fenetre.add(leftbuttonpanel, BorderLayout.SOUTH);

	}

}