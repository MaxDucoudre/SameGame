
	/**
	 * Le constructeur a besoin de gameframe car le chrono en a besoin pour activer le thread qui actualisera l'affichage du chrono
	 * Ce second constructeur permet d'ajouter une grille préfabriquée au lieu d'en générer une aléatoirement
	 * @param gameframe0
	 * @param fichier_grille_préfabriquée 
	 */
	public Game(GameFrame gameframe0, String fichier_grille) {
		this.chrono = new Chrono(gameframe0);
		this.chrono.startChrono(); // On lance le chrono au début de la partie

		System.out.println("Génération d'une grille à partir d'un fichier...");

		try {
			
			FileInputStream fichier_grille_flux = new FileInputStream(fichier_grille);

		} catch (FileNotFoundException erreur) {
			System.err.println("Fichier introuvable");

		}





		// on génère une grille aléatoire dès la création de l'objet si on utilise aucun fichier
		int i, j;
		int num;
		System.out.println("Génération d'une grille aléatoire...");

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