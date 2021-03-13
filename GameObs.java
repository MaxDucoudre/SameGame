import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

	public void actionPerformed(ActionEvent e){


		// réaction du bouton pause pendant la partie
		if (e.getActionCommand() == this.gameframe.pauseString) {
			System.out.println("Pause");
			this.gameframe.startPause();
		}

		// Réaction des boutons du menu pause
		if (e.getActionCommand() == this.gameframe.resumeString) {
			System.out.println("Resume");
			this.gameframe.endPause();
		}

		if (e.getActionCommand() == this.gameframe.abandonString) {
			System.out.println("Main Menu");

			this.gameframe.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre);
			this.gameframe.refreshFrame();

		}

		// Réaction des boutons à l'écran de fin

		if (e.getActionCommand() == this.gameframe.mainMenuString) {
			System.out.println("Main Menu");

			this.gameframe.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre);
			this.gameframe.refreshFrame();
		}

		if (e.getActionCommand() == this.gameframe.restartString) {
			System.out.println("Restart");

			this.gameframe.eraseFrame();
			GameFrame gf = new GameFrame(fenetre);
			this.gameframe.refreshFrame();
		}



	}



	public void mouseClicked(MouseEvent e) {
		int l;

		// vérifie si la partie n'est pas sur pause et n'est pas terminée
		if(this.gameframe.getPauseStatus() == false && this.gameframe.getEndGameStatus() == false) { 
			for (int i=0; i<10; i++) {
				for (int j=0; j<15; j++) {

					if (e.getX() >= this.gameframe.getXPion(i, j) + this.gameframe.grid.getX() && e.getX() < this.gameframe.getXPion(i, j)  + this.gameframe.grid.getX() + this.gameframe.getWidthPion(i, j)
						&& 	e.getY() >= this.gameframe.getYPion(i, j) + this.gameframe.grid.getY() && e.getY() < this.gameframe.getYPion(i, j) + this.gameframe.grid.getY() + this.gameframe.getHeightPion(i, j) ){




						this.game.resetgroupPions();
					this.game.groupPions(i, j);


					this.tab_grid = this.game.getGrid();

				if(this.game.sizeGroupPion() > 1 && this.tab_grid[i][j] != 'D') { 	//Action quand on clique sur un groupe de plus de 1 de taille
					System.out.println("Ligne " + i + " | Colonne : " + j);
					System.out.println("Pion détruits : " + this.game.sizeGroupPion());
					System.out.println("+ " + this.game.scoreCalcul() + " au score");
					System.out.println("Score actuel : " + this.game.scoreTotal());


					this.game.groupDestruct();

					this.gameframe.setScoreLabel(); // met à jour le score dans l'affichage

					this.game.cascadePionHorizontal();
					this.game.cascadePionVertical();
					this.game.afficherGrid();
					System.out.println();

					if(this.game.endGame() == true) {
						this.gameframe.eraseFrame();

						this.gameframe.endGameFrame();
						
						this.gameframe.refreshFrame();


					}
				}
			}
		}
	}
}
}

public void mouseMoved(MouseEvent e) {
	this.gameframe.resetBackgroundPion();

	this.gameframe.setChrono();

	for (int i=0; i<10; i++) {
		for (int j=0; j<15; j++) {
			if (e.getX() >= this.gameframe.getXPion(i, j) + this.gameframe.grid.getX() && e.getX() < this.gameframe.getXPion(i, j)  + this.gameframe.grid.getX() + this.gameframe.getWidthPion(i, j)
				&& 	e.getY() >= this.gameframe.getYPion(i, j) + this.gameframe.grid.getY() && e.getY() < this.gameframe.getYPion(i, j) + this.gameframe.grid.getY() + this.gameframe.getHeightPion(i, j) ){


				this.game.groupPions(i, j);

			this.tab_grid = this.game.getGrid();
			if(this.game.sizeGroupPion() >= 2 && this.tab_grid[i][j] != 'D') {

				this.tab_group = this.game.getTabGroup(i, j);
				this.gameframe.changeBackgroundPion(Color.ORANGE, this.tab_group, i, j);
				
			}

		} else 	{

			this.game.resetgroupPions();

		}

	}
}
}



public void mouseEntered(MouseEvent evenement) {}  
public void mouseExited(MouseEvent evenement) {}           
public void mousePressed(MouseEvent evenement) {}          
public void mouseReleased(MouseEvent evenement) {}
public void mouseDragged(MouseEvent evenement) {}      

}