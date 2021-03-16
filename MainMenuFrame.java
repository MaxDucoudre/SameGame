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
import java.io.*;

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


	 // JLabel d'une citation aléatoire du tableau de citations dans la classe modèle
		JLabel quote = new JLabel(mm.randomQuote());
		quote.setHorizontalAlignment(JLabel.CENTER);

	 // Panel qui contiendra tous les boutons du menu
		JPanel buttonPanel = new JPanel();

	 // Bouton de lancement d'une partie
		JButton launchgame = new JButton(this.launchGameString);
		buttonPanel.add(launchgame);
		launchgame.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement d'une partie à 2
		JButton launchgamevs = new JButton(this.launchGameVs);
		buttonPanel.add(launchgamevs);
		launchgamevs.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement de la boutique
		JButton boutique = new JButton(this.shopString);
		buttonPanel.add(boutique);
		boutique.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement des options
		JButton options = new JButton(this.settingsString);
		buttonPanel.add(options);
		options.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement du menu statistiques
		JButton statistique = new JButton(this.statisticsString);
		buttonPanel.add(statistique);
		statistique.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement du menu des sauvegardes
		JButton savemenu = new JButton(this.saveString);
		buttonPanel.add(savemenu);   
		savemenu.addActionListener(this.mainMenuObs); 

	 // Bouton pour quitter le jeux
		JButton leftgame = new JButton(this.leftGameString);
		buttonPanel.add(leftgame);   
		leftgame.addActionListener(this.mainMenuObs); 


		buttonPanel.setOpaque(false);


		// On séléctionne une image pour le fond
		Image image_background = Toolkit.getDefaultToolkit().getImage("./ressources/background_jungle2.jpg");
		
		// On applique cette image à la classe BackgroundImagePanel qui renvoie un JPanel
		BackgroundImagePanel mainMenuPanel = new BackgroundImagePanel(image_background, fenetre);

		// Et on ajoute les autres JPanel à ce JPanel principal avant de l'ajouter à la fenêtre
		mainMenuPanel.setLayout(new BorderLayout());

		mainMenuPanel.add(quote, BorderLayout.NORTH);
		mainMenuPanel.add(buttonPanel, BorderLayout.CENTER);

		super.fenetre.add(mainMenuPanel, BorderLayout.CENTER);

	}

}