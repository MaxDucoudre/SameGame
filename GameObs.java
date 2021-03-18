/**
 * Classe Contrôleur : GameObs
 * Cette classe permet de rendre interactive la fenêtre du jeux
 *
 * @version 1
 * @author Max Ducoudré
 * @author Loris Schnell
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameObs implements MouseListener, MouseMotionListener, ActionListener {

	public Game game;
	public GameFrame gameframe;
	private int taille_group;
	private boolean[][] tab_group = new boolean[10][15];
	private boolean[][] tab_group_hover;
	private char[][] tab_grid;
	private JFrame fenetre;



	public GameObs(Game game0, GameFrame gameframe0, JFrame fenetre0) {
		this.game = game0;
		this.gameframe = gameframe0;
		this.fenetre = fenetre0;
	}


	// La méthode actionPerformed : se lance au clique de la souris sur un bouton
	public void actionPerformed(ActionEvent e) {

		// réaction du bouton pause pendant la partie
		if (e.getActionCommand() == this.gameframe.pauseString) { // si le nom du bouton appuyé est identique à celui du bouton pause
			System.out.println("Pause");
			this.gameframe.startPause();
		}

		// Réaction du bouton "reprendre" dans le menu pause
		if (e.getActionCommand() == this.gameframe.resumeString) { // si le nom du bouton appuyé est identique à celui du bouton "reprendre"
		System.out.println("Resume");
			this.gameframe.endPause(); // lance la méthode endPause de GameFrame
		}

		if (e.getActionCommand() == this.gameframe.abandonString) { // si le nom du bouton appuyé est identique à celui du bouton "abandonner"
		System.out.println("Main Menu");

		this.gameframe.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre); // on relance un objet de type MainMenuFrame
			this.gameframe.refreshFrame();

		}

		// Réaction des boutons de l'écran de fin
		if (e.getActionCommand() == this.gameframe.mainMenuString) { // si le nom du bouton appuyé est identique à celui du bouton "Main Menu"
		System.out.println("Main Menu");

		this.gameframe.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre); // on recréer un objet de type MainMenuFrame
			this.gameframe.refreshFrame();
		}


		// On récupère le nom du fichier de la grille si il y a un
		String fichier_grille = this.gameframe.fichier_grille_path;

		if (e.getActionCommand() == this.gameframe.restartString) { // si le nom du bouton appuyé est identique à celui du bouton "relancer"
		System.out.println("Restart");

		this.gameframe.eraseFrame();
			GameFrame gf = new GameFrame(this.fenetre, fichier_grille); // on recréer un objet de type GameFrame
			this.gameframe.refreshFrame();
		}



	}


	// La méthode actionPerformed : se lance au clique de la souris l'écran
	public void mouseClicked(MouseEvent e) {
		int l;



		// vérifie si la partie n'est pas sur pause et n'est pas terminée
		if (this.gameframe.getPauseStatus() == false && this.gameframe.getEndGameStatus() == false) {

			// on rentre dans une double boucle pour vérifier chaque points de la grille 
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 15; j++) {

					// cette condition compare la position X et Y du clique de la souris avec la position X et Y d'un pion dand la partie
					if (e.getX() >= this.gameframe.getXPion(i, j) + this.gameframe.grid.getX() && e.getX() < this.gameframe.getXPion(i, j) + this.gameframe.grid.getX() + this.gameframe.getWidthPion(i, j) &&
						e.getY() >= this.gameframe.getYPion(i, j) + this.gameframe.grid.getY() && e.getY() < this.gameframe.getYPion(i, j) + this.gameframe.grid.getY() + this.gameframe.getHeightPion(i, j)) {



						this.game.resetgroupPions(); // remise à 0 des groupes
						this.game.groupPions(i, j); // vérification du groupe de la case cliqué

						this.tab_grid = this.game.getGrid(); // on récupère la grille sous forme de tableau de char

						if (this.game.sizeGroupPion() > 1 && this.tab_grid[i][j] != 'D') { // Si la taille du groupe est supérieure à 1 et que la case n'est pas vide
						System.out.println("Ligne " + i + " | Colonne : " + j);
						System.out.println("Pion détruits : " + this.game.sizeGroupPion());
						System.out.println("+ " + this.game.scoreCalcul() + " au score");
						System.out.println("Score actuel : " + this.game.scoreTotal());


							this.destructionSound(); // lance le son de destruction des pions
							this.game.groupDestruct(); // on détruit le groupe

							this.gameframe.setScoreLabel(); // on met à jour le score dans l'affichage

							this.game.cascadePionHorizontal(); // on fait tomber les pions vers le bas
							this.game.cascadePionVertical(); // on décale une colone si sa voisine est vide
							this.game.afficherGrid(); // affichage de la grille à la console

							

							System.out.println();

							if (this.game.endGame() == true) { // si la partie est terminée

								this.gameframe.endGameFrame(); // on affiche l'écran de fin
								this.gameframe.refreshFrame();


							}
						}
						this.gameframe.resetBackgroundPion(); // mise à jour de l'affichage

					}
				}
			}
		}
	}

	// La méthode mouseMoved vérifie la position de la souris sur l'écran
	public void mouseMoved(MouseEvent e) {


		// on rentre dans une double boucle pour vérifier chaque points de la grille 
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {

				// cette condition compare la position X et Y  de la souris avec la position X et Y d'un pion dand la partie
				if (e.getX() >= this.gameframe.getXPion(i, j) + this.gameframe.grid.getX() && e.getX() < this.gameframe.getXPion(i, j) + this.gameframe.grid.getX() + this.gameframe.getWidthPion(i, j) &&
					e.getY() >= this.gameframe.getYPion(i, j) + this.gameframe.grid.getY() && e.getY() < this.gameframe.getYPion(i, j) + this.gameframe.grid.getY() + this.gameframe.getHeightPion(i, j)) {

					this.game.groupPions(i, j); // on calcule le groupe du pion survolé

					this.tab_grid = this.game.getGrid(); // on récupère la grille de la partie sous forme de tableau de char

					if (this.game.sizeGroupPion() >= 2 && this.tab_grid[i][j] != 'D') { // si le groupe est plus grand que 2 et que la case n'est pas vide

						this.tab_group = this.game.getTabGroup(i, j); // alors on récupère le tableau de booléen du grouoe en question
						this.gameframe.hoverBackgroundPion(Color.ORANGE, this.tab_group, i, j); // et on applique un changement de couleur là où les cases du tableau sont en true

					} else {
						this.gameframe.resetBackgroundPion(); // redonne la couleur initiale aux pions quand la souris quitte un groupe

					}

				} else {
					// sécurité pour être sur que les groupes soient reset et qu'ils ne rentrent pas en conflit avec ceux du clique
					this.game.resetgroupPions();
				}

			}
		}


	}
		/**
		 * La méthode "destructionSound" joue le son de destruction des pions
		 */
		public void destructionSound() {
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("./ressources/destruction.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();

			} catch (IllegalArgumentException ex) {
				System.out.println("Son de destruction non joué");

			} catch (Exception ex) {
				ex.printStackTrace();

			}
		}



		public void mouseEntered(MouseEvent evenement) {}
		public void mouseExited(MouseEvent evenement) {}
		public void mousePressed(MouseEvent evenement) {}
		public void mouseReleased(MouseEvent evenement) {}
		public void mouseDragged(MouseEvent evenement) {}

	}