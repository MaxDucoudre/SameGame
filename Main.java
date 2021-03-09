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

		TitleMenuFrame titlemenu = new TitleMenuFrame(fenetre);

		// Récupération des dimentions de l'écran sous forme de int
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();

		fenetre.setSize(screenWidth, screenHeight);
		fenetre.setLocation(0, 0);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);



	}
}
