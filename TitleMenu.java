/**
* Classe Modèle : TitleMenu
* Menu titre au lancement du jeux
*
* @version 1 - 08 march 2021
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
  * Méthode changeant l'état du menu titre
  */
  
  public void update() {
  	if(this.enable == true) {
  		this.enable = false;
  	} else {
  		this.enable = false;
  	}
  }

  public boolean check() {
  	if(this.enable == true) {
  		return true;
  	} else {
  		return false;
  	}
  }




}