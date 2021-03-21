	/**
	 * Classe Vue : GameFrame gère l'affichage de l'interface du jeux
	 * Affichage du menu principal du jeux
	 *
	 * @version 1 
	 * @author Max Ducoudré   
	 * @author Loris Schnell
	 */

	import javax.swing.*;
	import java.awt.*;

	public class GameFrame extends MenuFrame {

		// Initialisation des attributs
		private Game game; // game vas saisir les informations de la classe modèle
		public JPanel grid = new JPanel(); // JPanel contenant la grille
		private JPanel top = new JPanel(); // JPanel contenant les informations de la partie
		private JPanel hud = new JPanel();

		private JLabel[][] pions = new JLabel[10][15]; // tableau de JLabel contenant l'affichage des pions 
		private char[][] tab_grid = new char[10][15];

		private boolean endGameStatus = false; // Attribut disant si la partie est finie ou non

		// initialisation d'attributs contenant les chaines de caractère des nom des boutons
		// "langue" est un attribut de type "Langue" de la classe parent MenuFrame qui permet de récupérer les noms affichés
		public String resumeString   = super.langue.getResumeString();
		public String mainMenuString = super.langue.getMainMenuString();
		public String abandonString  = super.langue.getAbandonString();
		public String pauseString    = super.langue.getPauseString();
		public String restartString  = super.langue.getRestartString();

		// attributs JLabel informant de l'état de la partie en cours
		private JLabel scoreLabel = new JLabel(" " + super.langue.getScoreString() + " : 0 "); // le score
		private JLabel hightScoreLabel = new JLabel(); // le record
		private JLabel scoreGetLabel = new JLabel(); // les points gagnés
		private JLabel multiplicatorLabel = new JLabel(); // le nombre de pions détruits
		private JLabel timerLabel = new JLabel(" " + super.langue.getTimeString() + " : 0:00 "); // le chrono

		public JButton pauseButton; // bouton Pause durant la partie
		// attributs JButton du menu pause
		public JButton resumePauseButton = new JButton(this.resumeString);
		public JButton leftGamePauseButton = new JButton(this.abandonString);
		public boolean pauseStatus = false; // état du menu pause (si actif ou non), par défaut en false

		private JLabel chronoAtPause = new JLabel(); // temps sur le menu pause
		private JLabel scoreAtPause = new JLabel(); // score sur le menu pause

		private JPanel pauseButtonPanel = new JPanel();
		private JPanel pauseScorePanel = new JPanel();
		// JPanel du menu pause
		private JPanel pausePanel = new JPanel();
		private JLabel iconpause;
		// Panel qui s'affiche à la fin de la partie
		public JPanel endGamePanel = new JPanel();

	    	// On séléctionne une image pour le fond

		// On met une image de fond sur le jpanel principal
		private BackgroundImagePanel gamePanel = new BackgroundImagePanel(super.image_background, super.fenetre);


		
		// initialisation des icones des pions
		private ImageIcon icon_pion_red;
		private ImageIcon icon_pion_green;
		private ImageIcon icon_pion_blue;


	// Fichier de la grille

		public String fichier_grille_path;

		/**
		 * Le constructeur de GameFrame
		 * @param fenetre0
		 * @param fichier_grille
		 */
		public GameFrame(JFrame fenetre0, String fichier_grille) {
			super(fenetre0);

			// On récupère le chemin du fichier de la grille si il y a un
			this.fichier_grille_path = fichier_grille;


			this.gamePanel.setLayout(new BorderLayout());

			this.game = new Game(this, fichier_grille); // Appel du constructeur du jeux

			System.out.println("Entrée dans le jeux");
			this.grid.setLayout(new GridLayout(10, 15)); // on met le JPanel de la grille sous forme de GridLayout 

			this.grid.setBorder(BorderFactory.createLineBorder(super.contour_color, 3));


			//JPanel de l'interface
			this.hud.setLayout(new BorderLayout());
			this.hud.setBackground(super.top_color);

			// Informations sur la partie
			// LE SCORE
			this.scoreLabel.setOpaque(true);
			this.scoreLabel.setBackground(super.label_color);
			this.scoreLabel.setFont(super.font); 

			this.scoreLabel.setBorder(BorderFactory.createLineBorder(super.contour_color, 2));
			this.top.add(this.scoreLabel);

			// LE TIMER
			this.timerLabel.setOpaque(true);
			this.timerLabel.setBackground(super.label_color);
			this.timerLabel.setFont(super.font); 
			this.timerLabel.setBorder(BorderFactory.createLineBorder(super.contour_color, 2));
			this.top.add(this.timerLabel);

			// LE RECORD
			this.hightScoreLabel.setOpaque(true);
			this.hightScoreLabel.setText(" " + super.langue.getHightScoreString() + " : " + this.game.getHightscore() + " ");
			this.hightScoreLabel.setBackground(super.label_color);
			this.hightScoreLabel.setBorder(BorderFactory.createLineBorder(super.contour_color, 2));
			this.top.add(this.hightScoreLabel);

			// LES POINTS GAGNE
			this.scoreGetLabel.setOpaque(true);
			this.top.add(this.scoreGetLabel);

			// LES PIONS DETRUITS
			this.multiplicatorLabel.setOpaque(true);
			this.top.add(this.multiplicatorLabel);
			// fin informations sur la partie

			// LE BOUTON PAUSE
			JPanel buttonpan = new JPanel();
			this.pauseButton = new JButton(this.pauseString);
			this.pauseButton.setBackground(super.button_color);
			this.pauseButton.setFont(super.font); 
			this.pauseButton.setOpaque(true);

			// BOUTON DU JEUX
			buttonpan.setOpaque(true);
			buttonpan.setBackground(super.top_color);
			buttonpan.add(this.pauseButton);

			this.hud.add(this.top, BorderLayout.CENTER);
			this.hud.add(buttonpan, BorderLayout.EAST);

			// observateurs rendant interactif toute la fenêtre
			super.fenetre.addMouseListener(      new GameObs(game, this, super.fenetre)); // la fenetre devient interactif au clique de la souris
			super.fenetre.addMouseMotionListener(new GameObs(game, this, super.fenetre)); // la fenetre devient interactif au survol de la souris
			this.pauseButton.addActionListener(  new GameObs(game, this, super.fenetre)); // les boutons de la fenêtre deviennent interactifs



			this.setGridLabel(); // Remplissage du JPanel "grid"

			// PANEL DE LA PARTIE
			this.grid.setOpaque(false);
			this.top.setOpaque(false);

			this.gamePanel.setLayout(new BorderLayout());
			this.gamePanel.setOpaque(true);
			this.gamePanel.add(this.grid, BorderLayout.CENTER);
			this.gamePanel.add(this.hud, BorderLayout.NORTH);


			// On ajoute la grille et l'affichage des données sur le JPanel principal
			super.fenetre.add(this.gamePanel, BorderLayout.CENTER);



				// MENU PAUSE
			this.pausePanel.setLayout(new GridLayout(4,1));
			this.pausePanel.setOpaque(false);

			// Label "PAUSE"
			JLabel gamename = new JLabel(super.langue.getPauseString());
			gamename.setHorizontalAlignment(JLabel.CENTER);
			gamename.setFont(new Font("Serif", Font.BOLD, 40));
			this.pausePanel.add(gamename);

			// Partie informations
			this.pauseScorePanel.setLayout(new GridLayout(2,1));
			Font pauselabelFont;
			this.scoreAtPause.setFont(super.font);
			this.scoreAtPause.setHorizontalAlignment(JLabel.CENTER);
			this.pauseScorePanel.add(this.scoreAtPause);

			this.chronoAtPause.setFont(super.font);
			this.chronoAtPause.setHorizontalAlignment(JLabel.CENTER);
			this.pauseScorePanel.add(this.chronoAtPause);
			this.pauseScorePanel.setOpaque(false);

			this.pausePanel.add(pauseScorePanel);

			
			this.pausePanel.add(new JLabel()); // Vide


			// Partie Boutton
			this.pauseButtonPanel.add(this.resumePauseButton);
			this.resumePauseButton.setBackground(super.button_color);
			this.resumePauseButton.setFont(super.font); 

			this.pauseButtonPanel.add(this.leftGamePauseButton);
			this.leftGamePauseButton.setBackground(super.button_color);
			this.leftGamePauseButton.setFont(super.font); 

			this.pauseButtonPanel.setOpaque(false);

			// ICONE DU MENU PAUSE
			this.iconpause = new JLabel();
			this.iconpause.setIcon(new ImageIcon("./ressources/pauseicon1.png"));
			this.iconpause.setOpaque(false);

			this.pausePanel.add(this.pauseButtonPanel);

		}


		/**
		 * La méthode "updateGrid" permet de mettre à jour l'affichage de la grille en prenant les informations de la classe modèle "Game"
		 */
		public void setGridLabel() {
			int i, j;
			this.tab_grid = this.game.getGrid(); // on récupère le tableau de char comprenant la position des pions
			this.game.afficherGrid();
			System.out.println("Mise en forme visuelle de la grille...");

			this.ResizeIcon(); // on définit les images

			// On remplie de JLabel représentant les pions le JPanel grid sous forme de GridLayout(10, 15)
			// On traverse donc toutes les cases du tableau via cette boucle imbriquée

			for (i = 0; i < 10; i++) {
				for (j = 0; j < 15; j++) {

					if (this.tab_grid[i][j] == 'R') { // si il y a 'R' dans la case, alors on met à jour le visuel de la case
					this.pions[i][j] = new JLabel();
							this.pions[i][j].setBackground(null); // sinon on l'enlève
							this.pions[i][j].setOpaque(false);
							this.pions[i][j].setIcon(this.icon_pion_red);
							this.grid.add(this.pions[i][j]);

						}

					if (this.tab_grid[i][j] == 'V') { // si il y a 'V' dans la case, alors on met à jour le visuel de la case
					this.pions[i][j] = new JLabel();
							this.pions[i][j].setBackground(null); // sinon on l'enlève
							this.pions[i][j].setOpaque(false);
							this.pions[i][j].setIcon(this.icon_pion_green);
							this.grid.add(this.pions[i][j]);
						}

					if (this.tab_grid[i][j] == 'B') { // si il y a 'B' dans la case, alors on met à jour le visuel de la case
					this.pions[i][j] = new JLabel();
							this.pions[i][j].setBackground(null); // sinon on l'enlève
							this.pions[i][j].setOpaque(false);
							this.pions[i][j].setIcon(this.icon_pion_blue);
							this.grid.add(this.pions[i][j]);
						}
					}
				}


			}




		/**
		 * La méthode "changeBackgroundPion" permet de changer la couleur du groupe qu'on survole avec la souris
		 * @param color représente la couleur de la surbrillance
		 * @param tab_group_hover représente le groupe de la case qu'on survole à la souris
		 * @param i représente la colone du pion
		 * @param j représente la ligne du pion
		 */
		public void hoverBackgroundPion(Color color, boolean[][] tab_group_hover, int i, int j) {

			this.ResizeIcon(); // on redéfinit les icones


			for (i = 0; i < 10; i++) {
				for (j = 0; j < 15; j++) {
					if (tab_group_hover[i][j] == true) { // si le groupe est survolé
						this.pions[i][j].setOpaque(true);
						this.pions[i][j].setBackground(color); // alors on lui applique une couleur

					} else {
						// Sinon on remet les couleurs par défaut
						if (tab_grid[i][j] == 'R') {
							this.pions[i][j].setBackground(null); // sinon on l'enlève
							this.pions[i][j].setOpaque(false);
							this.pions[i][j].setIcon(this.icon_pion_red);
						}

						if (tab_grid[i][j] == 'V') {
						this.pions[i][j].setBackground(null); // sinon on l'enlève
						this.pions[i][j].setOpaque(false);
						this.pions[i][j].setIcon(this.icon_pion_green);
					}

					if (tab_grid[i][j] == 'B') {
						this.pions[i][j].setBackground(null); // sinon on l'enlève
						this.pions[i][j].setOpaque(false);
						this.pions[i][j].setIcon(this.icon_pion_blue);
					}

					if (tab_grid[i][j] == 'D') {
						this.pions[i][j].setBackground(null); // sinon on l'enlève
						this.pions[i][j].setOpaque(false);
						this.pions[i][j].setIcon(null);
					}
				}
			}
		}
	}

		/**
		 * La méthode "resetBackgroundPion" redessine la couleur des pions par défaut
		 */
		public void resetBackgroundPion() {

			this.ResizeIcon(); // on redéfinit les icones

			// on donne des valeurs aux attributs des images des pions
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 15; j++) {

					if (tab_grid[i][j] == 'R') {
						this.pions[i][j].setIcon(this.icon_pion_red);
						this.pions[i][j].setBackground(Color.WHITE);
						this.pions[i][j].setOpaque(false);
					}

					if (tab_grid[i][j] == 'V') {
						this.pions[i][j].setIcon(this.icon_pion_green);
						this.pions[i][j].setBackground(Color.WHITE);
						this.pions[i][j].setOpaque(false);
					}

					if (tab_grid[i][j] == 'B') {
						this.pions[i][j].setIcon(this.icon_pion_blue);
						this.pions[i][j].setBackground(Color.WHITE);
						this.pions[i][j].setOpaque(false);
					}

					if (tab_grid[i][j] == 'D') {
						this.pions[i][j].setIcon(null);	
						this.pions[i][j].setBackground(Color.WHITE);
						this.pions[i][j].setOpaque(false);
					}
				}
			}
		}

		/**
		 * La méthode "ResizeIcon" permet de redimensionner les images correctement en fonction des JPanel qui les contient
		 */
		public void ResizeIcon() {

			this.icon_pion_red = new ImageIcon("./ressources/ananas.png"); // On initialise une icone avec l'image
			//Image image_pion_red = icon_pion_red.getImage().getScaledInstance(this.pions[1][1].getWidth(), this.pions[1][1].getHeight(), Image.SCALE_SMOOTH); // on reprend l'image et on la redimensionne
			Image image_pion_red = icon_pion_red.getImage().getScaledInstance(super.fenetre.getWidth()/15, super.fenetre.getHeight()/10-5, Image.SCALE_SMOOTH); // on reprend l'image et on la redimensionne
			this.icon_pion_red = new ImageIcon(image_pion_red); // on met cette image redimensionnée dans l'icone

			this.icon_pion_green = new ImageIcon("./ressources/banana.png"); // On initialise une icone avec l'image
			//Image image_pion_green = icon_pion_green.getImage().getScaledInstance(this.pions[1][1].getWidth(), this.pions[1][1].getHeight(), Image.SCALE_SMOOTH); // on reprend l'image et on la redimensionne
			Image image_pion_green = icon_pion_green.getImage().getScaledInstance(super.fenetre.getWidth()/15, super.fenetre.getHeight()/10-5, Image.SCALE_SMOOTH); // on reprend l'image et on la redimensionne
			this.icon_pion_green = new ImageIcon(image_pion_green); // on met cette image redimensionnée dans l'icone

			this.icon_pion_blue = new ImageIcon("./ressources/coconut.png"); // On initialise une icone avec l'image
			//Image image_pion_blue = icon_pion_blue.getImage().getScaledInstance(this.pions[1][1].getWidth(), this.pions[1][1].getHeight(), Image.SCALE_SMOOTH); // on reprend l'image et on la redimensionne
			Image image_pion_blue = icon_pion_blue.getImage().getScaledInstance(super.fenetre.getWidth()/15, super.fenetre.getHeight()/10-5, Image.SCALE_SMOOTH); // on reprend l'image et on la redimensionne
			this.icon_pion_blue = new ImageIcon(image_pion_blue); // on met cette image redimensionnée dans l'icone



		}

		/**
		 * La méthode "getPionsLabel" permet de récupérer le tableau de JLabel de la grille
		 * @return le tableau de JLabel
		 */
		public JLabel[][] getPionsLabel() {
			return this.pions;
		}

		/**
		 * La méthode "getTabGrid" permet de récupérer le tableau de caractère de la grille
		 * @return le tableau de char de la grille
		 */
		public char[][] getTabGrid() {
			return this.tab_grid;
		}

		/**
		 * La méthode "getXPion" permet de récupérer la coordonée X du JPanel d'un pion
		 * @param i représente la colone du pion
		 * @param j représente la ligne du pion
		 * @return la position X d'un pion
		 */
		public int getXPion(int i, int j) {
			return this.pions[i][j].getX();
		}

		/**
		 * La méthode "getYPion" permet de récupérer la coordonée Y du JPanel d'un pion
		 * @param i représente la colone du pion
		 * @param j représente la ligne du pion
		 * @return la position Y d'un pion
		 */
		public int getYPion(int i, int j) {
			return this.pions[i][j].getY();
		}

		/**
		 * La méthode "getWidthPion" permet de récupérer la largeur en pixel d'un pion
		 * @param i représente la colone du pion
		 * @param j représente la ligne du pion
		 * @return la longueur d'un pion
		 */
		public int getWidthPion(int i, int j) {
			return this.pions[i][j].getWidth();
		}

		/**
		 * La méthode "getHeightPion" permet de récupérer la longueur en pixel d'un pion
		 * @param i représente la colone du pion
		 * @param j représente la ligne du pion
		 * @return la largeur d'un pion
		 */
		public int getHeightPion(int i, int j) {
			return this.pions[i][j].getHeight();
		}


		/**
		 * La méthode "setScoreLabel" permet de mettre à jour les informations sur la partie
		 */
		public void setScoreLabel() {
			// Met à jour l'affichage du score


			// mise à jour du label du score
			this.scoreLabel.setText(" Score : " + this.game.scoreTotal() + " ");


				// Si le score actuel est supérieur au record, alors on change la couleur de la police
			if(this.game.newHightscore() == true) {
				this.scoreLabel.setForeground(Color.ORANGE);
			}

			if (this.game.scoreCalcul() != 0) { // si le score gagné est supérieur à 0, alors
				this.scoreGetLabel.setVisible(true); // on affiche le score gagné
				this.scoreGetLabel.setBackground(super.label_color);
				this.scoreGetLabel.setBorder(BorderFactory.createLineBorder(super.contour_color, 2));

				this.scoreGetLabel.setText(" +" + this.game.scoreCalcul() + " points ! ");
			} else {
				this.scoreGetLabel.setVisible(false); // sinon on le masque
			}

			if (this.game.sizeGroupPion() > 2) { // si la taille d'un groupe détruit est supérieure à 2
				this.multiplicatorLabel.setVisible(true); // alors on affiche le nombre de case détruites
				this.multiplicatorLabel.setBackground(super.label_color);
				this.multiplicatorLabel.setBorder(BorderFactory.createLineBorder(super.contour_color, 2));

				this.multiplicatorLabel.setText(" BONUS X" + this.game.sizeGroupPion() + " ");
			} else {
				this.multiplicatorLabel.setVisible(false); // sinon on le cache
			}
		}

		/**
		 * La méthode "setChrono" permet de mettre à jour l'affichage du chronomètre
		 */
		public void setChrono() {
			this.timerLabel.setText(" " + super.langue.getTimeString() + " : " + this.game.getChrono() + " ");
		}

		/**
		 * La méthode "endGameFrame" se lance à la fin de la partie pour afficher une nouvelle interface
		 */
		public void endGameFrame() {

			Coins coins = new Coins();

			JLabel endScoreLabel = new JLabel(super.langue.getFinalScoreString() + " : " + this.game.scoreTotal()); // score de la partie
			JLabel endAncienRecordLabel = new JLabel(); // ancien record

			JLabel endChronoLabel = new JLabel("  " + super.langue.getTimeString() + " : " + this.game.getChrono());
			JPanel endGameLabelPanel = new JPanel();


			JButton endMainMenuButton = new JButton(this.mainMenuString);
			JButton endRestartButton = new JButton(this.restartString);
			JPanel endGameButtonPanel = new JPanel();

			JLabel oldhightscorelabel = new JLabel(); // ancien record JLabel
			oldhightscorelabel.setFont(super.font);

			// JLabel nouveau record
			JLabel newhightscorelabel = new JLabel(super.langue.getNewHightScoreString() + " : " + this.game.scoreTotal() + " ! ");
			newhightscorelabel.setForeground(Color.ORANGE);

			// JPanel des coins
			JPanel coinsObtPanel = new JPanel();
			coinsObtPanel.setOpaque(false);
			JLabel coinsObt = new JLabel("+ " + (int)this.game.scoreTotal()/1000);
			coinsObt.setForeground(Color.ORANGE);
			coinsObt.setFont(super.font);
			coinsObtPanel.add(coinsObt);
			JLabel coinsImage = new JLabel();


			if(this.game.grillefichier == false) { // on affiche l'argent obtenu que si la partie n'est pas lancée depuis un fichier
				ImageIcon icon_money = new ImageIcon("./ressources/coins.png"); // On initialise une icone avec l'image
				Image image_money = icon_money.getImage().getScaledInstance(super.fenetre.getWidth()/15, super.fenetre.getHeight()/10-5, Image.SCALE_SMOOTH); // on reprend l'image et on la redimensionne
				icon_money = new ImageIcon(image_money); // on met cette image redimensionnée dans l'icone

				coinsImage.setIcon(icon_money);
				coinsObtPanel.add(coinsImage);
				this.gamePanel.add(coinsObtPanel, BorderLayout.EAST); // JPanel des coins obtenus
			}

			this.endGamePanel.setLayout(new GridLayout(3,1));
			this.endGamePanel.setOpaque(false);




			// JLabel de la fin de partie
			JLabel endgame = new JLabel(super.langue.getEndString());
			endgame.setFont(new Font("Serif", Font.BOLD, 40));
			endgame.setHorizontalAlignment(JLabel.CENTER);
			endgame.setOpaque(false);
			this.endGamePanel.add(endgame);

			endGameLabelPanel.setLayout(new GridLayout(2,2));
			endGameLabelPanel.setOpaque(false);


			// JLabel sur le menu de fin
			if(this.game.newHightscore() == true) { // si le record est battu

				oldhightscorelabel.setText(super.langue.getOldHightScoreString() +" : " + this.game.getOldHightscore()); 
				oldhightscorelabel.setHorizontalAlignment(JLabel.RIGHT);
				endGameLabelPanel.add(oldhightscorelabel); // ancien record label

				if(this.game.grillefichier == false) {
					endGameLabelPanel.add(new JLabel()); // JLabel vide
				} else if(this.game.grillefichier == true) {
					JLabel nontakelabel = new JLabel("  --" + super.langue.getHightScoreNotCountedString() + "--");
					nontakelabel.setFont(super.font);
					nontakelabel.setForeground(Color.RED);
					endGameLabelPanel.add(nontakelabel); // La partie n'est pas comptabilisée si elle est lancée depuis un fichier
				}

				newhightscorelabel.setFont(super.font); 
				endGameLabelPanel.add(newhightscorelabel); // nouveau record label
				newhightscorelabel.setHorizontalAlignment(JLabel.RIGHT);

				endChronoLabel.setFont(super.font); 
				endGameLabelPanel.add(endChronoLabel); // étiquette affichant le temps final


			} else {


				oldhightscorelabel.setText("Record : " + this.game.getOldHightscore()); 
				oldhightscorelabel.setHorizontalAlignment(JLabel.RIGHT);
				endGameLabelPanel.add(oldhightscorelabel); // ancien record label

				endGameLabelPanel.add(new JLabel()); // JLabel vide

				endScoreLabel.setFont(super.font); 
				endScoreLabel.setHorizontalAlignment(JLabel.RIGHT);

				endGameLabelPanel.add(endScoreLabel); // étiquette affichant le score

				endChronoLabel.setFont(super.font); 
				endGameLabelPanel.add(endChronoLabel); // étiquette affichant le temps final

			}

			this.endGamePanel.add(endGameLabelPanel);


			// JButton sur le menu de fin
			endMainMenuButton.setBackground(super.button_color);
			endMainMenuButton.setFont(super.font);	
			endGameButtonPanel.add(endMainMenuButton); // bouton pour retourner au menu principal


			endRestartButton.setBackground(super.button_color);
			endRestartButton.setFont(super.font); 
			endGameButtonPanel.add(endRestartButton); // bouton pour relancer la partie

			endGameButtonPanel.setOpaque(false);

			this.endGamePanel.add(endGameButtonPanel);



			JLabel iconlabelend = new JLabel();
			iconlabelend.setIcon(new ImageIcon("./ressources/endicon.png"));
			iconlabelend.setHorizontalAlignment(JLabel.CENTER);
			iconlabelend.setOpaque(false);



			this.gamePanel.remove(this.grid); 
			this.gamePanel.remove(this.hud); 
			this.gamePanel.add(this.endGamePanel, BorderLayout.CENTER);
			this.gamePanel.add(iconlabelend, BorderLayout.SOUTH);

			super.fenetre.repaint();
			this.refreshFrame();


			// On rend les deux boutons interactifs
			endMainMenuButton.addActionListener(new GameObs(game, this, super.fenetre));
			endRestartButton.addActionListener(new GameObs(game, this, super.fenetre));
		}

		/**
		 * La méthode "getEndGameStatus" renvoie un booléan disant si la partie est finie ou non
		 * @return true si la parti est finie et false si non
		 */
		public boolean getEndGameStatus() {
			return this.endGameStatus;
		}

		/**
		 * La méthode "startPause" permet de mettre en pause la partie
		 */
		public void startPause() {
			this.pauseStatus = true; // attribut disant si la partie se met en pause ou non passe en "true"

			this.chronoAtPause.setText(super.langue.getTimeString() + " : " + this.game.getChrono());
			this.scoreAtPause.setText(this.scoreLabel.getText());

			this.game.pauseGame(); // on met sur pause le chronomètre

			this.gamePanel.remove(this.grid);
			this.gamePanel.remove(this.hud);
			this.gamePanel.add(this.iconpause, BorderLayout.EAST);
			this.gamePanel.add(this.pausePanel, BorderLayout.CENTER);

			super.fenetre.repaint();
			this.refreshFrame();

			// On rend interactif les deux boutons
			this.resumePauseButton.addActionListener(new GameObs(game, this, super.fenetre));
			this.leftGamePauseButton.addActionListener(new GameObs(game, this, super.fenetre));
		}

		/**
		 * La méthode "endPause" permet de reprendre la partie en cours
		 */
		public void endPause() {
			this.game.resumeGame(); // on relance le chronomètre



			this.gamePanel.add(this.hud, BorderLayout.NORTH); 
			this.gamePanel.add(this.grid, BorderLayout.CENTER);
			this.gamePanel.remove(this.iconpause);
			this.gamePanel.remove(this.pausePanel);
			this.gamePanel.repaint();



			super.fenetre.repaint();

			this.pauseStatus = false; // attribut disant si la partie se met en pause ou non passe en "false"
		}

		/** 
		 * La méthode "getPauseStatus" renvoie un booléen sur le fait que la partie soit en pause ou non
		 * @return true si la partie est en pause et false si non
		 */
		public boolean getPauseStatus() {
			return this.pauseStatus;
		}



	}