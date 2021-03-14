	/**
	* Classe Vue : TitleMenuFrame
	* Affichage du menu titre du jeux
	*
	* @version 1
	* @author Max Ducoudré
	* @author Loris Schnell
	*/

	import javax.swing.*;
	import java.awt.*;


	public class TitleMenuFrame extends MenuFrame {

	 Langue langue = new Langue("French");

	 TitleMenu tm = new TitleMenu(true);

		// Constructeur
	 public TitleMenuFrame(JFrame fenetre0) {
		super(fenetre0);

		// affichage du nom du jeux 
		JLabel gamename = new JLabel("SameGame");
		gamename.setHorizontalAlignment(JLabel.CENTER);
		super.fenetre.add(gamename, BorderLayout.NORTH);

		// Gestion du bouton Start pour entrer dans le jeux
		JButton startbutton = new JButton(super.langue.getStartString()); // Bouton pour lancer le jeux
		JPanel p = new JPanel();
		p.add(startbutton);
		super.fenetre.add(p, BorderLayout.CENTER);
		startbutton.addActionListener(new TitleMenuObs(this.tm, this, super.fenetre)); //observateur
	}

	public boolean isActive() {
		if(tm.check() == true) {
			return true;
		} else {
			return false;
		}
	}
}

