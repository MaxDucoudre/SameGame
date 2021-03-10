import javax.swing.*;
		import java.awt.*;
		import java.awt.event.*;

		public class GameObs implements MouseListener {

			public JFrame fenetre;
			public Game game;
			public GameFrame gameframe;
			private int taille_group;
			private boolean[][] tab_group = new boolean[10][15];

			public GameObs(JFrame fenetre0, Game game0, GameFrame gameframe0) {
				this.fenetre = fenetre0;
				this.game = game0;
				this.gameframe = gameframe0;
			}

			public void mouseClicked(MouseEvent e) {

				System.out.println("CliqueX : " + e.getX());
				System.out.println("CliqueY : " + e.getY());
				game.resetgroupPions();

				for (int i=0; i<10; i++) {

						for (int j=0; j<15; j++) {

							
							if (e.getX() >= this.gameframe.getXPion(i, j) && e.getX() < this.gameframe.getXPion(i, j) + this.gameframe.getWidthPion(i, j) + this.gameframe.getXPion(0, 0)
							&& 	e.getY() >= this.gameframe.getYPion(i, j) && e.getY() < this.gameframe.getYPion(i, j) + this.gameframe.getHeightPion(i, j) + this.gameframe.getYPion(0, 0) ){ {


							 this.game.groupPions(i, j);

								this.game.afficheGroup();
								System.out.println("i : " + i + " | j : " + j);
							}
						}
					}
				}
			}

	/*

							game.groupPions(i, j);
						taille_group = game.tailleGroupPion();
							if(taille_group >= 2) { // 2 corresponds à la taille maximale d'un groupe
							System.out.println("Clique sur un groupe");

						}

						System.out.println("Clique sur la fenetre");

					}
				}
			}
			*/


			public void mouseEntered(MouseEvent evenement) {
			}  
			public void mouseExited(MouseEvent evenement) {
			}           
			public void mousePressed(MouseEvent evenement) {
			}          
			public void mouseReleased(MouseEvent evenement) {
			}
			public void mouseDragged(MouseEvent evenement) {
			}      
			public void mouseMoved(MouseEvent evenement) {
			}
		}
