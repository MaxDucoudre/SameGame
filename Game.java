import java.lang.Math; 
import java.util.Arrays;

public class Game {

	private char[][] tab_grid = new char[10][15];
	private boolean[][] tab_group = new boolean[10][15];
	private boolean[][] tab_destroyed = new boolean[10][15];
	private	boolean[][] tab_col = new boolean[10][15];
	private int nb_group = 0;
	private boolean[][] tab_nb_group = new boolean[10][15];

	private int actualScore;


	// Attributs pour le chrono
	private long timeStart ;
	private long timeEnd ;
	private long pauseStart;
	private long pauseEnd;
	private long duree;

	public Game() {

	}

	public void genereGrid() {
		int i, j;
		int num;

		System.out.println("Génération d'une grille aléatoire...");

		for (i=0; i<10; i++) {
			for (j=0; j<15; j++) {

				num = (int)(Math.random() * (4 - 1)) + 1; // génère un nombre aléatoire entre 1 et 3

				if (num == 1) {
					this.tab_grid[i][j]='R';
				}
				if (num == 2) {
					this.tab_grid[i][j]='V';
				}
				if (num == 3) {
					this.tab_grid[i][j]='B';
				}
			}

		}
	}

	public void afficherGrid() {
		int i,j;
		System.out.println("Valeurs de la grille :");
		for (i=0; i<10; i++) {
			for (j=0; j<15; j++) {
				System.out.print("" + tab_grid[i][j]);
			}
			System.out.println("");
		}
	}


	public char[][] getGrid() {
		return this.tab_grid;
	}



	public void resetgroupPions() {
		for (int i=0; i<10; i++) {
			for (int j=0; j<15; j++) {
				this.tab_group[i][j] = false;
			}
		}
	}
	
	public void afficheGroup() {
		for (int i=0; i<10; i++) {
			for (int j=0; j<15; j++) {
				if(tab_group[i][j] == false){
					System.out.print("0");
				} else {
					System.out.print("1");
				}
			}
			System.out.println("");
		}
	}

// Fonction récursive pour comparer tous les voisins du point i j 
	public void groupPions(int i, int j) {

		if(i >= 0 && i <= 9 && j >= 0 &&  j <= 14 && this.tab_grid[i][j] != 'D') {

			if (this.tab_group[i][j] == false) {
				this.tab_group[i][j] = true;

				if(i < 9) {
					if (this.tab_grid[i][j] == this.tab_grid[i+1][j] ) {
						this.groupPions(i+1, j);
					}
				}
				if(i > 0) {
					if (this.tab_grid[i][j] == this.tab_grid[i-1][j] ) {
						this.groupPions(i-1, j);
					}
				}
				if(j < 14) {
					if (this.tab_grid[i][j] == this.tab_grid[i][j+1] ) {
						this.groupPions(i, j+1);
					}
				}
				if(j > 0) {
					if (this.tab_grid[i][j] == this.tab_grid[i][j-1] ) {
						this.groupPions(i, j-1);

					}
				}
			}
		}
	}


	public void groupDestruct() {

		for (int i=0; i<10; i++) {
			for (int j=0; j<15; j++) {

				if(this.tab_group[i][j] == true) {
					this.tab_grid[i][j] = 'D';
				}
			}
		}
	}

	public boolean[][] getTabGroup(int i, int j) {
		return this.tab_group;
	}

	public int sizeGroupPion() {
		int compte = 0;

		for (int i=0; i < 10; i++) {
			for (int j=0; j < 15; j++) {
				if(this.tab_group[i][j] == true) {
					compte = compte + 1;
				}
			}
		}	
		return compte;
	}


	public void cascadePionHorizontal() {
		int i, j, l;
		char previous_grid;
		for (l = 0; l < 10; l++) {
			for (i = 0; i  <9; i++) {
				for (j = 0; j < 15 ; j++) {
					if (this.tab_grid[i+1][j] == 'D' && this.tab_grid[i][j] != 'D') {
						this.tab_grid[i+1][j] = this.tab_grid[i][j];
						this.tab_grid[i][j] = 'D';
					}
				}
			}
		}
	}


	public void cascadePionVertical() {
		int i, j, l;
		char next_col;

		for (l = 0; l < 10; l++) {
			for (j = 0; j < 14; j++) {

				if (destroyedCol(j) == true) {

					for (i = 0; i < 10; i++) {
						this.tab_grid[i][j] = this.tab_grid[i][j+1];
						this.tab_grid[i][j+1]= 'D';
					}
				}
			}
		}
	}

	public boolean destroyedCol(int j) {
		for (int i=0; i<10; i++) {
			if (this.tab_grid[i][j]!='D') {
				return false;
			}
		}
		return true;
	}

	public boolean endGame() {
		this.resetgroupPions();
		for (int i=0; i<10; i++) {
			for (int j=0; j<15; j++) {
				if (this.tab_grid[i][j] != 'D') {

					this.groupPions(i, j);
					// La partie ne finie pas tant qu'il reste des groupes de taille supérieures à 1
					if (this.sizeGroupPion() > 1) { 
						this.resetgroupPions();
						return false;
					}
				}
			}
		}
		// Sinon, la partie se termine
		this.resetgroupPions();
		return true;
	}

	public int scoreCalcul() {
		return ( (this.sizeGroupPion() - 2 ) * (this.sizeGroupPion() - 2 ) );
	}

	public int scoreTotal() {
		this.actualScore = this.actualScore + this.scoreCalcul();
		return this.actualScore;
	}




	// Méthodes pour le chronomètre
	public void startChrono() {
		this.timeStart  = System.currentTimeMillis();
		this.pauseStart = 0;
	}

	public void endChrono() {
		if(this.timeStart == 0) {
			return;
		}
		this.timeEnd = System.currentTimeMillis();
		this.duree = (this.timeEnd - this.timeStart) - (this.pauseEnd - this.pauseStart);
		this.timeStart = 0;
		this.timeEnd = 0;
		this.pauseStart = 0;
		this.pauseEnd = 0;

	}

	public void pauseChrono() {
		if(this.timeStart == 0) {
			return;
		}
		this.pauseStart = System.currentTimeMillis();
	}

	public void resumeChrono() {
		if(this.timeStart == 0) {
			return;
		}

		if(this.pauseStart == 0) {
			return;
		}

		pauseEnd = System.currentTimeMillis();
		this.timeStart = this.timeStart + this.pauseEnd - this.pauseStart;
		this.timeEnd = 0;
		this.pauseStart = 0;
		this.pauseEnd = 0;
		this.duree = 0;
	}

	public String getChronoString() {
		System.out.println("Timer");

		String dureeMinSec;
		long secondes;
		long minutes = 0;	

		secondes = this.duree/1000;


		while(secondes <= 60) {
			minutes = minutes + 1;
			secondes = secondes - 60;
		}

		dureeMinSec = (minutes + ":" + secondes);
		return dureeMinSec;
	}

}


