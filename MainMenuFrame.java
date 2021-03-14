/**
* Classe Vue : MainMenuFrame
* Classe gérant l'affichage du menu principal du jeux
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends MenuFrame {

	private MainMenu mm = new MainMenu();
	private MainMenuObs mainMenuObs = new MainMenuObs(this.fenetre, this);

	// On récupère les chaînes de caractère de chaque boutons pour que l'observateur puisse les comparer avec le clique sans passer par la classe "Langue"
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

	 // JLabel d'une citation aléatoire du tableau de citation dans la classe modèle
	 JLabel quote = new JLabel(mm.randomQuote());
	 quote.setHorizontalAlignment(JLabel.CENTER);
	 super.fenetre.add(quote, BorderLayout.NORTH);

	 // Panel qui contiendra tous les boutons du menu
	 JPanel p = new JPanel();

	 // Bouton de lancement d'une partie
	 JButton launchgame = new JButton(this.launchGameString);
	 p.add(launchgame);
	 launchgame.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement d'une partie à 2
	 JButton launchgamevs = new JButton(this.launchGameVs);
	 p.add(launchgamevs);
	 launchgamevs.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement de la boutique
	 JButton boutique = new JButton(this.shopString);
	 p.add(boutique);
	 boutique.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement des options
	 JButton options = new JButton(this.settingsString);
	 p.add(options);
	 options.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement du menu statistiques
	 JButton statistique = new JButton(this.statisticsString);
	 p.add(statistique);
	 statistique.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement du menu des sauvegardes
	 JButton savemenu = new JButton(this.saveString);
	 p.add(savemenu);   
	 savemenu.addActionListener(this.mainMenuObs); 

	 // Bouton pour quitter le jeux
	 JButton leftgame = new JButton(this.leftGameString);
	 p.add(leftgame);   
	 leftgame.addActionListener(this.mainMenuObs); 

	 p.setBackground(Color.GREEN);
	 p.setOpaque(true);
	 super.fenetre.add(p, BorderLayout.CENTER);

 }
}