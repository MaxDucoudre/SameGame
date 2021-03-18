/**
* Classe Vue : MenuFrame
* Classe parent de toutes les classes Menu du jeux permettant de leur donner des méthodes communes
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;


public abstract class MenuFrame extends JComponent {

	// attributs
	public JFrame fenetre;
	private int i = 1;
	protected Langue langue;
	private Options options = new Options(); // On a besoin des options pour récupérer la langue active


		// Attributs couleur et police 

		public Color contour_color = new Color(102,51,0);

		public Color label_color = new Color(138,172,42);

		public Color button_color = new Color(138,172,42);

		public Font font = new Font("Arial", Font.BOLD, 20);

		public Color top_color = new Color(131,218,202);

		public Image image_background = Toolkit.getDefaultToolkit().getImage("./ressources/background_jungle2.jpg");


	// Constructeur
	public MenuFrame(JFrame fenetre0) {
		this.fenetre = fenetre0; // on récupère la fenêtre du jeux
		this.fenetre.add(this, BorderLayout.CENTER);
		this.langue = new Langue(this.options.getLanguage()); // set la langue du jeux en fonction des options
		System.out.println("Langue : " + this.options.getLanguage());

		this.refreshFrame();
	}
	
	
	// Constructeur sans la fenetre si on en a pas besoin (pour des sous-menu qui sont dans des menus)
	public MenuFrame() {
		System.out.println("--Nouveau menu généré--");

	}

/**
* Méthode "refreshFrame" qui réactualise les dimensions de la fenêtre pour mettre à jour l'affichage lorsqu'il ne se met pas à jour
*/
	public void refreshFrame() {
		if (this.i == 1) {
			fenetre.setSize(this.fenetre.getWidth()-1, this.fenetre.getHeight());
			this.i = this.i - 1;
		} else {
			fenetre.setSize(this.fenetre.getWidth()+1, this.fenetre.getHeight());
			this.i = 1;
		}
			this.fenetre.repaint();

	}

/**
* méthode "eraseFrame" qui efface tous les composants de de la fenêtre pour en refaire de nouveaux
*/
	public void eraseFrame() {
		this.fenetre.getContentPane().removeAll();
		this.fenetre.repaint();
	}
}