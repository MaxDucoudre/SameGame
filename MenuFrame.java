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

	private Shop shop = new Shop();
	private Save save = new Save();
	private int activeSave = this.save.getLoadedSave();

		// Attributs couleur et police 

		public Color contour_color = new Color(102,51,0);

		public Color label_color = new Color(138,172,42);

		public Color button_color = new Color(138,172,42);

		public Font font = new Font("Arial", Font.BOLD, 20);

		public Color top_color = new Color(131,218,202);

		public Image image_background = Toolkit.getDefaultToolkit().getImage("./ressources/skinpack1/background.png");


	/**
	* Le constructeur de MenuFrame
	* @param fenetre est la fenêtre du jeux
	*/
		public MenuFrame(JFrame fenetre0) {
		this.fenetre = fenetre0; // on récupère la fenêtre du jeux
		this.fenetre.add(this, BorderLayout.CENTER);

		this.setSkinFrame(this.shop.getSkinPack(this.activeSave));


		this.langue = new Langue(this.options.getLanguage()); // set la langue du jeux en fonction des options
		this.refreshFrame();

	}
	




	
	/**
	* Constructeur sans la fenetre si on en a pas besoin (pour des sous-menu qui sont dans des menus)
	*/
	public MenuFrame() {

	}

	/**
	* Méthode "refreshFrame" réactualise l'affichage de la fenetre
	*/
	public void refreshFrame() {

		this.fenetre.repaint();
		this.fenetre.setVisible(true);

	}

	/**
	* méthode "eraseFrame" qui efface tous les JComponents de de la fenêtre 
	*/
	public void eraseFrame() {
		this.fenetre.getContentPane().removeAll();
		this.fenetre.repaint();
	}

	/**
	* méthode "setSkinFrame" qui permet de mettre à jour l'affichage en fonction du pack de skin
	* @param pack correspond au pack de skin souhaité (1, 2 ou 3)
	*/
	public void setSkinFrame(int pack) {

		if(pack == 2) { this.contour_color = Color.YELLOW;

		this.label_color = Color.GRAY;

		this.button_color = Color.WHITE;

		this.font = new Font("Dialog", Font.ITALIC, 20);

		this.top_color = Color.GRAY;

		this.image_background = Toolkit.getDefaultToolkit().getImage("./ressources/skinpack2/background.png");


		} else if(pack == 3) {
		this.contour_color = Color.ORANGE;

		this.label_color = Color.GREEN;

		this.button_color = Color.YELLOW;

		this.font = new Font("TimesRoman", Font.BOLD, 20);

		this.top_color = Color.GREEN;

		this.image_background = Toolkit.getDefaultToolkit().getImage("./ressources/skinpack3/background.png");


		} else {
		this.contour_color = new Color(102,51,0);

		this.label_color = new Color(138,172,42);

		this.button_color = new Color(138,172,42);

		this.font = new Font("Arial", Font.BOLD, 20);

		this.top_color = new Color(131,218,202);

		this.image_background = Toolkit.getDefaultToolkit().getImage("./ressources/skinpack1/background.png");

		}

	}


}