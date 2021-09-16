/**
* Interface : API
* Interface a implémenter dans le moteur du jeu permettant aux bots de fonctionner
* @version 1.0
* @author Le Conseil des 5
* 
*/
public interface API {

	/**
	* Méthode permettant de récupérer la grille de caractère représentant l'état de la partie.
	* @return tableau bidimentionnel de caractère représentant l'état de la grille 
	*/
	char[][] getGrille();

	/**
	* Méthode permettant de séléctionner un groupe de pion en fonction des coordonées X et Y données.
	* @param x entier représentant la position X du pion séléctionné dans la grille 
	* @param y entier représentant la position Y du pion séléctionné dans la grille 
	*/
	void selectGroup(int x, int y);

	/**
	* Méthode permettant de détruire le groupe de pion séléctionné.
	* Nécéssite d'avoir utilisé la méthode selectGroup() avant.
	*/
	void destroyGroup();

	/**
	* Permet d'obtenir le score généré par le groupe séléctionné
	* @return le score obtenu par un groupe séléctionné.
	*/
	int getScore();

	/**
	* @return le total du score actul de la partie en cours
	*/
	int getTotalScore();


}