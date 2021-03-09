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
import java.lang.Math; 


public class MainMenuFrame {

  JFrame fenetre;
  MainMenu mm = new MainMenu();

  // Constructeur
  public MainMenuFrame(JFrame fenetre0) {
   this.fenetre = fenetre0;


   // Citation aléatoire
   JLabel quote = new JLabel(mm.randomQuote());
   quote.setHorizontalAlignment(JLabel.CENTER);
   this.fenetre.add(quote, BorderLayout.NORTH);

   // Panel qui prend en compte les boutons
   JPanel p = new JPanel();

   // Bouton pour lancer la partie
   JButton launchgame = new JButton("Lancer la partie");
   p.add(launchgame);
   
   // Bouton pour lancer la partie
   JButton launchgamevs = new JButton("Lancer la partie à deux");
   p.add(launchgamevs);
   
   JButton boutique = new JButton("Boutique");
   p.add(boutique);

   JButton options = new JButton("Options");
   p.add(options);

   JButton statistique = new JButton("Statistiques");
   p.add(statistique);

   JButton sauvegarde = new JButton("Changer de sauvegarde");
   p.add(sauvegarde);   

   JButton leftgame = new JButton("Quitter jeux");
   p.add(leftgame);   

   this.fenetre.add(p, BorderLayout.CENTER);


}


}