/**
* Classe Vue : ShopFrame
* Classe gérant l'affichage du menu de la boytique
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;

public class ShopFrame extends MenuFrame {

	// Le JPanel principal :
	private BackgroundImagePanel shopFramePanel = new BackgroundImagePanel(super.image_background, super.fenetre);


	private JButton mainmenubutton; // bouton pour retourner au menu principal
	



	/**
	* Le constructeur de ShopFrame
	* @param fenetre
	*/
	public ShopFrame(JFrame fenetre0) {
		super(fenetre0);



		super.fenetre.add(shopFramePanel, BorderLayout.CENTER);

	}

}