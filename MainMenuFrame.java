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
import java.awt.event.*;


public class MainMenuFrame extends MenuFrame {

  private MainMenu mm = new MainMenu();

  String string_launchgame   = new String("Lance la partie");
  String string_launchgamevs = new String("Lance une partie à 2");
  String string_boutique     = new String("Boutique");
  String string_options      = new String("Options");
  String string_statistique  = new String("Statistiques");
  String string_savemenu     = new String("Sauvegardes");
  String string_leftgame     = new String("Quitter le jeux");


  // Constructeur
  public MainMenuFrame(JFrame fenetre0) {
   super(fenetre0);

   // Citation aléatoire
   JLabel quote = new JLabel(mm.randomQuote());
   quote.setHorizontalAlignment(JLabel.CENTER);
   super.fenetre.add(quote, BorderLayout.NORTH);

   // Panel qui prend en compte les boutons
   JPanel p = new JPanel();


   JButton launchgame = new JButton(string_launchgame);
   p.add(launchgame);
   // launchgame.addActionListener(new MainMenuObs(this.fenetre)); 

   JButton launchgamevs = new JButton(string_launchgamevs);
   p.add(launchgamevs);
  // launchgamevs.addActionListener(new MainMenuObs(this.fenetre)); 

   JButton boutique = new JButton(string_boutique);
   p.add(boutique);
  // boutique.addActionListener(new MainMenuObs(this.fenetre)); 

   JButton options = new JButton(string_options);
   p.add(options);
   MainMenuObsOptions optionsObs = new MainMenuObsOptions(this.fenetre, this);
   options.addActionListener(optionsObs); 

   JButton statistique = new JButton(string_statistique);
   p.add(statistique);
  // statistique.addActionListener(new MainMenuObs(this.fenetre)); 

   JButton savemenu = new JButton(string_savemenu);
   p.add(savemenu);   
  // savemenu.addActionListener(new MainMenuObs(this.fenetre)); 

   JButton leftgame = new JButton(string_leftgame);
   p.add(leftgame);   
  // leftgame.addActionListener(new MainMenuObs(this.fenetre)); 

   p.setBackground(Color.GREEN);
   p.setOpaque(true);
   super.fenetre.add(p, BorderLayout.CENTER);

 }




}