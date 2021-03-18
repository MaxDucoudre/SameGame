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

		// On met une image de fond sur le jpanel principal
	private BackgroundImagePanel mainMenuPanel = new BackgroundImagePanel(super.image_background, super.fenetre);


	// Constructeur
	public MainMenuFrame(JFrame fenetre0) {
		super(fenetre0);

		



		// JPanel du North de la fenetre
		JPanel top = new JPanel(new GridLayout(2,1));
		top.setOpaque(false);
		top.add(new JLabel());

	 // JLabel d'une citation aléatoire du tableau de citations dans la classe modèle
		JLabel quote = new JLabel(mm.randomQuote());
		quote.setForeground(super.contour_color);
		quote.setFont(new Font("Serif", Font.BOLD, 19));
		quote.setHorizontalAlignment(JLabel.CENTER);
		quote.setOpaque(false);
		top.add(quote);

		
	 // Panel qui contiendra tous les boutons du menu
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,1));
		buttonPanel.setOpaque(false);

		buttonPanel.add(new JLabel()); // JLabel vide


		// Panel des boutons de lancement
		JPanel launchbuttonPanel = new JPanel();
		launchbuttonPanel.setOpaque(false);
	 // Bouton de lancement d'une partie
		JButton launchgame = new JButton(this.launchGameString);
		launchgame.setBackground(super.button_color);
		launchgame.setFont(super.font); 
		launchbuttonPanel.add(launchgame);

		launchgame.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement d'une partie à 2
		JButton launchgamevs = new JButton(this.launchGameVs);
		launchgamevs.setBackground(super.button_color);
		launchgamevs.setFont(super.font);
		launchbuttonPanel.add(launchgamevs);
		launchgamevs.addActionListener(this.mainMenuObs); 

		buttonPanel.add(launchbuttonPanel);


			// JPanel ligne 2
		JPanel line2panel = new JPanel();
		line2panel.setOpaque(false);

	 // Bouton de lancement des options
		JButton options = new JButton(this.settingsString);
		options.setBackground(super.button_color);
		options.setFont(super.font);
		line2panel.add(options);
		options.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement du menu statistiques
		JButton statistique = new JButton(this.statisticsString);
		statistique.setBackground(super.button_color);
		statistique.setFont(super.font);
		line2panel.add(statistique);
		statistique.addActionListener(this.mainMenuObs); 

		buttonPanel.add(line2panel);

		// JPanel ligne 3
		JPanel line3panel = new JPanel();
		line3panel.setOpaque(false);

	 // Bouton de lancement de la boutique
		JButton boutique = new JButton(this.shopString);
		boutique.setBackground(super.button_color);
		boutique.setFont(super.font);
		line3panel.add(boutique);
		boutique.addActionListener(this.mainMenuObs); 

	 // Bouton de lancement du menu des sauvegardes
		JButton savemenu = new JButton(this.saveString);
		savemenu.setBackground(super.button_color);
		savemenu.setFont(super.font);
		line3panel.add(savemenu);   
		savemenu.addActionListener(this.mainMenuObs); 

		buttonPanel.add(line3panel);

			// JPanel left game
		JPanel leftgamepanel = new JPanel();
		leftgamepanel.setOpaque(false);
	 // Bouton pour quitter le jeux
		JButton leftgame = new JButton(this.leftGameString);
		leftgame.setBackground(super.button_color);
		leftgame.setFont(super.font);
		leftgamepanel.add(leftgame);   
		leftgame.addActionListener(this.mainMenuObs); 

		buttonPanel.add(leftgamepanel);

		buttonPanel.setOpaque(false);

		// Image East
		JLabel westimage = new JLabel();
		westimage.setIcon(new ImageIcon("./ressources/giraffe.png"));


		// Et on ajoute les autres JPanel à ce JPanel principal avant de l'ajouter à la fenêtre
		mainMenuPanel.setLayout(new BorderLayout());


		mainMenuPanel.add(westimage, BorderLayout.EAST); // ajout de l'image
		mainMenuPanel.add(top, BorderLayout.NORTH); // ajout des citations
		mainMenuPanel.add(buttonPanel, BorderLayout.CENTER); // ajout des boutons

		super.fenetre.add(mainMenuPanel, BorderLayout.CENTER);

	}

}