import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameObs implements MouseListener, MouseMotionListener {

	public JFrame fenetre;
	public Game game;
	public GameFrame gameframe;
	private int taille_group;
	private boolean[][] tab_group = new boolean[10][15];
	private boolean[][] tab_group_hover;
	private char[][] tab_grid;

	public GameObs(JFrame fenetre0, Game game0, GameFrame gameframe0) {
		this.fenetre = fenetre0;
		this.game = game0;
		this.gameframe = gameframe0;
	}

	public void mouseClicked(MouseEvent e) {
		int l;

		for (int i=0; i<10; i++) {

			for (int j=0; j<15; j++) {


				if (e.getX() >= this.gameframe.getXPion(i, j) + this.gameframe.grid.getX() && e.getX() < this.gameframe.getXPion(i, j)  + this.gameframe.grid.getX() + this.gameframe.getWidthPion(i, j)
					&& 	e.getY() >= this.gameframe.getYPion(i, j) + this.gameframe.grid.getY() && e.getY() < this.gameframe.getYPion(i, j) + this.gameframe.grid.getY() + this.gameframe.getHeightPion(i, j) ){
					System.out.println("Point du clique : ligne " + i + " | colonne : " + j);




				this.game.groupPions(i, j);


				//Action quand on clique sur un groupe
				this.tab_grid = this.game.getGrid();

				if(this.game.sizeGroupPion() >= 2 && this.tab_grid[i][j] != 'D') {

					this.game.groupDestruct();
					System.out.println("Pion détruits : " + this.game.sizeGroupPion());
					System.out.println("+ " + this.game.scoreCalcul() + " au score");
					System.out.println("Score actuel : " + this.game.scoreTotal());
					this.gameframe.scoreLabel(); // met à jour le score dans l'affichage

					this.game.resetgroupPions();


					this.game.cascadePionHorizontal();
					this.game.cascadePionVertical();
					this.game.afficherGrid();
				}

				if(this.game.endGame() == true) {
					System.out.println("Fin de la partie");


				}

				System.out.println();
			}
		}
	}
}

public void mouseMoved(MouseEvent e) {
	this.gameframe.resetBackgroundPion();

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