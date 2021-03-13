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
  private MainMenuObs mainMenuObs = new MainMenuObs(this.fenetre, this);

  public String launchGameString = super.langue.getLaunchGameString();
  public String launchGameVs     = super.langue.getLaunchGameVsString();
  public String shopString       = super.langue.getShopString();
  public String settingsString   = super.langue.getSettingsString();
  public String statisticsString = super.langue.getStatisticsString();
  public String saveString       = super.langue.getSavesString();
  public String leftGameString   = super.langue.getLeftGameString();

  // Constructeur
  public MainMenuFrame(JFrame fenetre0) {
   super(fenetre0);

   // Citation aléatoire
   JLabel quote = new JLabel(mm.randomQuote());
   quote.setHorizontalAlignment(JLabel.CENTER);
   super.fenetre.add(quote, BorderLayout.NORTH);

   // Panel qui prend en compte les boutons
   JPanel p = new JPanel();

   JButton launchgame = new JButton(this.launchGameString);
   p.add(launchgame);
   launchgame.addActionListener(this.mainMenuObs); 

   JButton launchgamevs = new JButton(this.launchGameVs);
   p.add(launchgamevs);
   launchgamevs.addActionListener(this.mainMenuObs); 

   JButton boutique = new JButton(this.shopString);
   p.add(boutique);
   boutique.addActionListener(this.mainMenuObs); 

   JButton options = new JButton(this.settingsString);
   p.add(options);
   options.addActionListener(this.mainMenuObs); 

   JButton statistique = new JButton(this.statisticsString);
   p.add(statistique);
   statistique.addActionListener(this.mainMenuObs); 

   JButton savemenu = new JButton(this.saveString);
   p.add(savemenu);   
   savemenu.addActionListener(this.mainMenuObs); 

   JButton leftgame = new JButton(this.leftGameString);
   p.add(leftgame);   
   leftgame.addActionListener(this.mainMenuObs); 

   p.setBackground(Color.GREEN);
   p.setOpaque(true);
   super.fenetre.add(p, BorderLayout.CENTER);

 }
}