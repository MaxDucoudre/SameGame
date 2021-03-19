/**
 * Classe Modèle : Game
 * Cette classe permet de gérer les données du jeux
 *
 * @version 1
 * @author Max Ducoudré
 * @author Loris Schnell
 */


import java.lang.Math;
import java.util.Arrays;
import java.io.*;

public class Game {

	// Initialisation de tableaux des dimensions de la grille 
	private char[][] tab_grid = new char[10][15]; // tableau de caractères qui définit ce que contient une case de la grille
	private boolean[][] tab_group = new boolean[10][15]; // tableau de booléen qui sera en TRUE aux endroits où un groupe de même pion est formé
	private boolean[][] tab_destroyed = new boolean[10][15];
	private boolean[][] tab_col = new boolean[10][15];
	private boolean[][] tab_nb_group = new boolean[10][15];

	// attribut qui sera rempli du score actuel
	private int actualScore;

	// initialisation d'un Chrono qui sera utile dans le jeux pour le timer 
	private Chrono chrono;

	// ancien reocrd
	private int old_hightscore;


	private int i = 0;
	private	int j = 0;
	private char[] char_line;

	// attribut contenant le nombre de parties jouées en tout
	private int numberofgame;

	/**
	 * Le constructeur a besoin de gameframe car le chrono en a besoin pour activer le thread qui actualisera l'affichage du chrono
	 * @param gameframe0
	 * @param fichier_grille (Mettre à "NULL" si aucun fichier n'est utilisé)
	 */
	public Game(GameFrame gameframe0, String fichier_grille) {
		this.chrono = new Chrono(gameframe0);
		this.chrono.startChrono(); // On lance le chrono au début de la partie
		this.numberofgame = this.getNumberOfGame();


		if(fichier_grille == "NULL") { // si il n'y a pas de fichier
		System.out.println("Génération d'une grille aléatoire...");
			this.genererGrille(); // on génère une grille aléatoire			
		} else {
			this.genererGrilleFichier(fichier_grille); // on génère une grille à partir d'un fichier
		}


	}

	/**
	 * Ce second constructeur permet de créer un objet Game pour récupérer des données des méthodes get

	 */
	public Game() {
		this.numberofgame = this.getNumberOfGame();
	}



	/**
	 * la méthode "genererGrilleFichier" permet de générer une grille à partie d'un fichier
	 * @param fichier_path est le chemin vers le fichier en question
	 */
	public void genererGrilleFichier(String fichier_path) {


		int c = 0; 
		String line = "";
		this.i = 0;
		this.j = 0;


		try {

			FileReader fichier = new FileReader(fichier_path);
			BufferedReader flux = new BufferedReader(fichier);

			try {

				while (i < 10) {

					line = flux.readLine();
					this.char_line = line.toCharArray();

					System.out.println(line); 

					for (j = 0; j < 15; j++) {

						this.tab_grid[i][j] = this.char_line[j];

					}
					this.j = 0;
					this.i++;

				}

			} catch(IOException e) { 
				System.out.println("Erreur lors de la lecture");
			}

		}catch(FileNotFoundException e) {
			System.out.println("Erreur lors de l'ouverture du fichier");
		}
	} 


	/**
	 * La méthode "genererGrille" génère une grille de manière aléatoire
	 */
	public void genererGrille() {
		System.out.println("Génération d'une grille aléatoire...");
		int i, j;
		int num;

		// on remplie tab_grid de caractères R, V, B aléatoirement

		for (i = 0; i < 10; i++) {
			for (j = 0; j < 15; j++) {

				num = (int)(Math.random() * (4 - 1)) + 1; // génère un nombre aléatoire entre 1 et 3

				if (num == 1) {
					this.tab_grid[i][j] = 'R'; // R représente les pions rouges
				}
				if (num == 2) {
					this.tab_grid[i][j] = 'V'; // V représente les pions verts
				}
				if (num == 3) {
					this.tab_grid[i][j] = 'B'; // B représente les pions bleus
				}
			}
		}
	}

	/**	
	 * La méthode "afficherGrid" affiche la grille à la console
	 */
	public void afficherGrid() {
		int i, j;
		System.out.println("Valeurs de la grille :");
		for (i = 0; i < 10; i++) {
			for (j = 0; j < 15; j++) {
				System.out.print("" + tab_grid[i][j]);
			}
			System.out.println("");
		}
	}

	/**
	 * La méthode "getGrid" permet de récupérer la le tableau de caractère de la grille
	 * @return tableau de char représentant la grille
	 */
	public char[][] getGrid() {
		return this.tab_grid;
	}


	/**
	 * La méthode "resetgroupPions" permet de remplir le tableau tab_group de "false"
	 */
	public void resetgroupPions() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				this.tab_group[i][j] = false;
			}
		}
	}

	public void afficheGroup() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				if (tab_group[i][j] == false) {
					System.out.print("0");
				} else {
					System.out.print("1");
				}
			}
			System.out.println("");
		}
	}

	/**
	 * La méthode "groupPions" permet de trouver le groupe d'un point du tableau en remplissant de "true" tab_group tous les poibts liés à i et j
	 * @param i représente la ligne choisie
	 * @param j représente la colone choisie
	 */
	public void groupPions(int i, int j) {

		// On vérifie si i et j ne sont pas trop grands ou trop petit, et si le point en question n'est pas vide ('D' signifie Détruit)
		if (i >= 0 && i <= 9 && j >= 0 && j <= 14 && this.tab_grid[i][j] != 'D') {

			if (this.tab_group[i][j] == false) { // si la case n'est pas déjà dans le groupe, alors on entre dans la condition
				this.tab_group[i][j] = true; // la case en question pase en true

				// La cas en question retourne dans la méthode via la récursivitéet passe en "true" si elle vérifie les conditions
				if (i < 9) {
					if (this.tab_grid[i][j] == this.tab_grid[i + 1][j]) { // vérification de la case à droite 
						this.groupPions(i + 1, j);
					}
				}
				if (i > 0) {
					if (this.tab_grid[i][j] == this.tab_grid[i - 1][j]) { // vérification de la case à gauche 
						this.groupPions(i - 1, j);
					}
				}
				if (j < 14) {
					if (this.tab_grid[i][j] == this.tab_grid[i][j + 1]) { // vérification de la case en dessous
						this.groupPions(i, j + 1);
					}
				}
				if (j > 0) {
					if (this.tab_grid[i][j] == this.tab_grid[i][j - 1]) { // vérification de la case au dessus
						this.groupPions(i, j - 1);

					}
				}
			}
		}
	}

	/**
	 * la méthode "groupDestruct" permet de détruire toutes les cases du group
	 */
	public void groupDestruct() {

		System.out.println("Chrono : " + this.chrono.getDureeNow());

		// double boucle imbriquée pour vérifier toutes les cases du tableau
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {

				if (this.tab_group[i][j] == true) { // On regarde les cases true du tableau
					this.tab_grid[i][j] = 'D'; // et on les passe en 'D' (détruite) dans le tableau tab_grid

				}
			}
		}
	}

	/**
	 * la méthode "getTabGroup" permet de récupérer tab_group 
	 * @param i représente la ligne du point
	 * @param j représente la colone du point
	 * @return un tableau de booléen représentant un groupe donnée en fonction de la colone et de la ligne
	 */
	public boolean[][] getTabGroup(int i, int j) {
		return this.tab_group;
	}

	/**
	 * la méthode "groupRemaining" de calculer le nombre de groupe restant dans la partie
	 * @return le nombre de groupes qui reste dans la partie
	 */
	public int groupRemaining() {
		int nb_group = 0;

		// double boucle imbriquée pour vérifier toutes les cases du tableau
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {

				if (this.tab_grid[i][j] != 'D') { // si la case n'est pas détruite

					if (this.tab_group[i][j] == true) { // et que la case fait partie d'un group
						nb_group++; // alors nb_group augmente de 1
					}
				}
			}
		}
		return nb_group; // nb_group contient le nombre de groupe de la partie
	}

	/**
	 * la méthode "sizeGroupPionpermet" de calculer la taille du groupe tab_group
	 * @return la taille du groupe actuellement séléctionné
	 */
	public int sizeGroupPion() {
		int compte = 0;

		// double boucle imbriquée pour vérifier toutes les cases du tableau
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				if (this.tab_group[i][j] == true) { // si la case en question est true
					compte = compte + 1; // alors le compteur augment
				}
			}
		}
		return compte; // compte renvoie donc le nombre de cases en "true" de tab_group
	}

	/**
	 * la méthode "cascadePionHorizontal" permet de faire tomber toutes les pions si la case en dessosu est vide
	 */
	public void cascadePionHorizontal() {
		int i, j, l;
		char previous_grid;

		for (l = 0; l < 10; l++) { // on effectue l'action 10 fois pour que les cases tombent 10 fois si elles le peuvent car le tableau fait 10 de haut

			// double boucle imbriquée pour vérifier toutes les cases du tableau
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 15; j++) {

					if (this.tab_grid[i + 1][j] == 'D' && this.tab_grid[i][j] != 'D') { //si la case en question n'est pas détruite et la case en dessous l'est aussis
						this.tab_grid[i + 1][j] = this.tab_grid[i][j]; // alors la case en dessous gagne la valeur de la case en question
						this.tab_grid[i][j] = 'D'; // et la case en question se détruit
					}
				}
			}
		}
	}

	/**
	 * la méthode "cascadePionVertical" de décaler une colone de pion si la colone à sa gauche est vide
	 */
	public void cascadePionVertical() {
		int i, j, l;
		char next_col;

		// on effectue 14 fois l'action pour être sur que la colone se décale le plus possible à gauche de la grille
		for (l = 0; l < 14; l++) {

			for (j = 0; j < 14; j++) {
				if (this.destroyedCol(j) == true) { // si la colone (j) est détruite

					// alors chaque case (i) de cette colone est est remplacé par la case à sa gauche, de la colone j+1
					for (i = 0; i < 10; i++) {
						this.tab_grid[i][j] = this.tab_grid[i][j + 1];
						this.tab_grid[i][j + 1] = 'D';
					}
				}
			}
		}
	}

	/**
	 * la méthode "destroyedCol" renvoie un booléen true si la colone est détruite et false si non
	 * @param j représente le numéro de la colonne allant de 0 à 14 de la grille
	 * @return true si la colone j est détruite entièrement et false si la colone j ne l'est pas
	 */
	public boolean destroyedCol(int j) {

		for (int i = 0; i < 10; i++) { // on regarde les 10 lignes de la colonne
			if (this.tab_grid[i][j] != 'D') { // si c'est 10 ligne ne sont pas toutes détruites
				return false; // alors la colone n'est pas détruite et on renvoi false
			}
		}

		return true; // sinon on renvoie true
	}


	/**
	 * La méthode "pionRemaining" renvoie le nombre (int) de pions qui reste dans la grille
	 * @return le nombre de pion qu'il reste dans la partie
	 */
	public int pionRemaining() {
		int nb_pion = 0;
		this.resetgroupPions();

		// double boucle imbriquée pour vérifier chaque case de la grille
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				if (this.tab_grid[i][j] != 'D') { // si la case n'est pas vide

					//this.groupPions(i, j); //

					nb_pion = nb_pion + 1; // alors le compteur augmente de 1

				}
			}
		}
		//this.resetgroupPions();

		return nb_pion; // on renvoie le compteur (int)
	}


	/**
	 * La méthode "endGame" vérifie si la partie est terminée ou non en renvoyant un booléen
	 * @return true si la partie est finie et false si elle ne l'est pas
	 */
	public boolean endGame() {

		// Double boucle imbriquée pour vérifier chaque case de la grille
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {

				if (this.tab_grid[i][j] != 'D') { // si la case de la grille n'est pas vide

					this.resetgroupPions(); // alors on met les cases de tab_group à "false"
					this.groupPions(i, j); // et on modifie tab_group pour trouver le groupe de la case i j

					if (this.groupRemaining() > 1 && this.sizeGroupPion() > 1) { // si il reste plus d'un groupe, et que ce groupe est de taille supérieure à 1
					System.out.println("Partie en cours...");
						return false; // alors on renvoie false et la partie continue
					}
					this.resetgroupPions();
				}
			}
		}
		// Fin de la partie ici
		this.resetgroupPions();
		System.out.println("Fin de la partie...");

		this.old_hightscore = this.getHightscore();

		// Si le record est inférieure au score à la fin de la partie
		if (this.getHightscore() < this.actualScore) {
			// alors on change le record
			this.setHightscore(this.actualScore);
		}


		this.incrementNumberOfGame(); // on incrémente de 1 le nombre de partie
		this.chrono.endChrono(); // on arrête le chrono quand la partie se termine
		return true; // sinon la partie se termine
	}


	/**
	 * La méthode "scoreCalcul" renvoie le nombre de points que gagne le joueur sous forme d'int
	 * @return le score actuellement gagné en détruisant un groupe
	 */
	public int scoreCalcul() {
		// le calcul du score se fait (n-2)^2, n étant le nombre de pion qu'on détruit, qui sera récupérer grace à la méthode sizeGroupPion
		return ((this.sizeGroupPion() - 2) * (this.sizeGroupPion() - 2));
	}

	/**
	 * La méthode "scoreTotal" renvoie le score total du joueur sous forme d'int
	 * @return le score total du joueur
	 */
	public int scoreTotal() {
		// on incrémente une variable (actuelScore) de "scoreCalcul" (étant le nombre de points obtenu)
		this.actualScore = this.actualScore + this.scoreCalcul();
		return this.actualScore;
	}


		// A partir d'ici, ce n'est plus dans la consigne


	/**
	 * La méthode "setHightscore" permet de mettre à jour le record dans un fichier
	 * @param score Le nouveau record en int 
	 */
	public void setHightscore(int score) {
		int hightscore;

		try { 
			// on ouvre le fichier en écriture pour noter le record
			FileOutputStream fichier = new FileOutputStream ("./saves/save1/hightscore.bin");
			DataOutputStream flux = new DataOutputStream (fichier);  
			// on note le temps du record dans un autre fichier
			FileOutputStream fichier2 = new FileOutputStream ("./saves/save1/timehightscore.bin");
			DataOutputStream flux2 = new DataOutputStream (fichier2);  

			try {
				flux.writeInt(score); // on met à jour la valeur dans le fichier pour mettre le record
				flux2.writeLong(this.chrono.getDureeNowLong()); // on met à jour le temps du record
			}

			catch (IOException e) {
				System.err.println("Erreur lors de l'écriture");
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("Erreur lors de l'ouverture en écriture");
		}      
	}


	/**
	 * La méthode "getHightscore" permet de récupérer le record dans un fichier
	 * @return le record en int
	 */
	public int getHightscore() {
		int hightscore;

		try {
			// On ouvre le fichier
			FileInputStream fichier = new FileInputStream("./saves/save1/hightscore.bin");
			DataInputStream flux = new DataInputStream(fichier);  

			try {
				hightscore = flux.readInt(); // On récupère la valeur dans le fichier
				return hightscore; // on renvoi la valeur qui est dans le fichier

			} catch (IOException e) {
				System.err.println("Erreur de lecture");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture en lecture");
		}      
		return 0; 
	}


	/**
	 * La méthode "incrementNumberOfGame" d'incrémenter de 1 le nombre de partie 
	 */
	public void incrementNumberOfGame() {
		int numberofgame; // variable contenant le nombre de parties jouées

		try { 

			// on ouvre le fichier en écriture
			FileOutputStream fichier_ecriture = new FileOutputStream ("./saves/save1/numbergame.bin");
			DataOutputStream flux_ecriture = new DataOutputStream (fichier_ecriture);  

			try {
				this.numberofgame++; // on l'incrémente de 1
				flux_ecriture.writeInt(this.numberofgame);
			}

			catch (IOException e) {
				System.err.println("Erreur lors de la ecriture");
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("Erreur lors de l'ouverture en écriture");
		}      
	}



	/**
	 * La méthode "getNumberOfGame" permet de récupérer le nombre de parties joués
	 * @return le nombre de parties jouées (en int)
	 */
	public int getNumberOfGame() {

		try { 
			// on ouvre le fichier lecture
			FileInputStream fichier_lecture = new FileInputStream ("./saves/save1/numbergame.bin");
			DataInputStream flux_lecture = new DataInputStream (fichier_lecture);  

			try {
				this.numberofgame = flux_lecture.readInt(); // on récupère le nombre de partie
				return this.numberofgame; // puis on le return
			}

			catch (IOException e) {
				System.err.println("Erreur lors de la lecture");
			}
		}

		catch (FileNotFoundException e) {
			System.err.println("Erreur lors de l'ouverture en écriture");
		}    

		return 0;
	}

	/**
	 * La méthode "newHightscore" nous dis si le record est battu ou non
	 * @return true si le record est battu, sinon false.
	 */
	public boolean newHightscore() {
	 	if(this.actualScore > this.getHightscore()) { // si le score actuel est supérieur au record
	 		return true; // alors le record est battu
	 	} else {
	 		return false; // sinon il ne l'est pas
	 	}
	 }


	/**
	 * La méthode "getOldHightscore" nous donne l'ancien record
	 * @return l'ancien record sous forme de int
	 */
	public int getOldHightscore() {

	 	return this.old_hightscore; // sinon il ne l'est pas
	 }

	/**
	 * la méthode "getChrono" permet renvoie le chrono sous forme de String à l'instant où elle est appelée
	 * @return renvois le chrono sous forme de chaine de caractère
	 */
	public String getChrono() {
		return this.chrono.getDureeNow();
	}

	/**
	 * la méthode "pauseGame" met la partie en pause
	 */
	public void pauseGame() {
		this.chrono.pauseChrono(); // lorsqu'on met en pause, on met en pause le chrono
	}

	/**
	 * la méthode "resumeGame" permet de reprendre la partie
	 */
	public void resumeGame() {
		this.chrono.resumeChrono(); // losqu'on reprend la partie, on relance le chrono

	}
}