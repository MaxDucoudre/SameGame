/**
* Classe Modèle : TitleMenu
* Menu titre au lancement du jeux
*
* @version 1 
* @author Max Ducoudré
* @author Loris Schnell
*/

public class TitleMenu {
   /**
   * Attribut définissant si le Menu Titre est actif ou non à la fenêtre
   */
   private boolean enable;

   /**
   * Constructeur
   * @param enable Si le menu titre est actif ou non
   */
  public TitleMenu(boolean enable0) {
  	this.enable = enable0;
  }

  /**
  * Méthode "update" changeant l'état du menu titre
  */
  
  public void update() {
  	if(this.enable == true) {
  		this.enable = false;
  	} else {
  		this.enable = false;
  	}
  }
  /**
  * Méthode "check" permettant de récupérer l'état du menu titre
  * @return true si le menu titre est actif, si non false
  */

  public boolean check() {
  	if(this.enable == true) {
  		return true;
  	} else {
  		return false;
  	}
  }
}