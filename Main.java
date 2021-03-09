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

  	// Initialisation de la fenêtre
		JFrame fenetre = new JFrame("SameGame");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocation(30, 30);
		fenetre.setSize(800, 500);
		fenetre.setVisible(true);


		TitleMenuFrame titlemenu = new TitleMenuFrame(fenetre);



    /*
    SaveMenu sm = new SaveMenu();

    MainMenu mm = new MainMenu();

    Game g = new Game();
*/
}
}