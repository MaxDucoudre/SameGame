/**
* Classe Vue : BackgroundImagePanel
* gère le redimensionnement de l'image de fond des menus
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;
import java.io.*;

class BackgroundImagePanel extends JPanel {

	private Image img;
	private JFrame fenetre;



/**
* Le constructeur récupère l'image et la fenêtre
* @param img0
* @param fenetre0
*/
	public BackgroundImagePanel(Image img0, JFrame fenetre0) {
		super();
		this.img = img0;
		this.fenetre = fenetre0;
		this.setOpaque(false);


	}

/**
* Cette méthode dessine l'image en fonction de la taille de la fenêtre
* @param g
*/
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.fenetre.getWidth(), this.fenetre.getHeight(), this);
		g.drawLine(0,0, 0, 0);
	}
}