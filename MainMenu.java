/**
* Classe Modèle : MainMenu
* Cette classe permet de gérer les valeurs du menu principal
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import java.lang.Math; 

public class MainMenu {

// Tableau de chaîne de caractère comprenant les différentes citations qui s'afficheront à l'écran du menu principal pour plus d'ambiance
// il est possible de rajouter des phrases à notre guise
	private String[] quote = {
		"Mieux vaut vivre un jour comme un lion que cent ans comme un mouton.",
		"Les larmes qui coulent sont amères mais plus amères encore sont celles qui ne coulent pas.",
		"Offrir l'amitié à qui veut l'amour, c'est donner du pain à qui meurt de soif.",
		"On ne peut empêcher le chien d'aboyer, ni le menteur de mentir.",
		"On peux tromper mille fois un homme, mais pas une fois mille ho... non, c'est l'inverse.",
		"Les chaussettes de l'achiduchesse sont-elles sèches ? Archi-sèche ?",
		"Pierre qui roule n'amasse pas mousse !",
	};


	// Constructeur
		public void MainMenu() {
		}

/**
* Méthode "randomQuote" renvoyant une des citations du tableau de manière aléatoire
* @return une citation aléatoire du tableau sous forme de String
*/
		public String randomQuote() {
			int min = 0;
			int max = this.quote.length - 1; // taille du tableau quote 
			int range = (max - min) + 1;
			int rand = (int)(Math.random() * range) + min;

			return this.quote[rand];

		}



}