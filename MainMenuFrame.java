/**
* Classe Vue : MainMenuFrame
* Affichage du menu principal du jeux
*
* @version 1 - 08 march 2021
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;


public class MainMenuFrame {

 JFrame fenetre;
 MainMenu mm = new MainMenu();

  // Constructeur
 public MainMenuFrame(JFrame fenetre0) {
   this.fenetre = fenetre0;


   JButton launchgame = new JButton("Lancer la partie");
   JPanel p = new JPanel();
   p.add(launchgame);
   this.fenetre.add(p);
   
   JLabel quote = new JLabel("mm.randomQuote()");
   quote.setHorizontalAlignment(JLabel.CENTER);
   quote.setVerticalAlignment(JLabel.BOTTOM);
   this.fenetre.add(quote, BorderLayout.NORTH);


}


}