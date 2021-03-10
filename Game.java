	import java.lang.Math; 
	import java.util.Arrays;

	public class Game {

		private char[][] tab_grid = new char[10][15];
		private boolean[][] tab_group = new boolean[10][15];

		public Game() {
		}

		public void genereGrid() {
			int i, j;
			int num;

			System.out.println("-Génération d'une grille aléatoire-");

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

		if(i >= 0 && i < 10 && j >= 0 &&  j < 15) {
			this.tab_group[i][j] = true;
		}

		if(i >= 0 && i < 10 && j >= 0 &&  j < 15) {
			if (this.tab_grid[i][j] == this.tab_grid[i+1][j] ) {
				this.tab_group[i+1][j] = true;
				groupPions(i+1, j);
			}
		}

		if(i >= 0 && i < 10 && j >= 0 &&  j < 15) {
			if (this.tab_grid[i][j] == this.tab_grid[i-1][j] ) {
				this.tab_group[i-1][j] = true;
				groupPions(i-1, j);
			}
		}

		if(i >= 0 && i < 10 && j >= 0 &&  j < 15) {
			if (this.tab_grid[i][j] == this.tab_grid[i][j+1] ) {
				this.tab_group[i][j+1] = true;
				groupPions(i, j+1);
			}
		}

		if(i >= 0 && i < 10 && j >= 0 &&  j < 15) {
			if (this.tab_grid[i][j] == this.tab_grid[i][j-1] ) {
				this.tab_group[i][i+1] = true;
				groupPions(i, j-1);
			}
		}
	}




	public boolean[][] getTabGroup(int i, int j) {
		return this.tab_group;

	}

	public int tailleGroupPion() {
		int compte = 0;

		for (int i=0; i<10; i++) {
			for (int j=0; j<15; j++) {
				if(tab_group[i][j] == true) {
					compte = compte + 1;
				}
			}
		}

		return compte;
	}

	public void afficherGrid() {
		int i,j;
		System.out.println("-Affichage des valeurs de la grille-");
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


}




