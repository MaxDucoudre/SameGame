/**
* Classe Contrôleur : Main
* La classe principale du programme SameGame
*
* @version 1 - 08 march 2021
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {

  	// Initialisation de la fenêtre du jeux
		JFrame fenetre = new JFrame("SameGame");

		// Récupération des dimentions de l'écran sous forme de int
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();


		// Création du menu Titre sur la fenêtre
		TitleMenuFrame titlemenu = new TitleMenuFrame(fenetre);



		// Mise en forme de la fenêtre
		fenetre.setSize(1000, 600); // taille de la fenêtre en fonction des dimensions de l'écrans
		fenetre.setLocation(screenWidth/4, screenHeight/4); // position de la fenêtre en haut à droite de l'écran
		fenetre.setMinimumSize(new Dimension(1000,600)); // taille minimale de la fênêtre

		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on quitte le programme quand on ferme la fenetre
		fenetre.setIconImage(Toolkit.getDefaultToolkit().getImage("./ressources/icon3.png")); // icone du programme

		fenetre.setVisible(true);



	}
}
