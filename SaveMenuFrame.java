/**
* Classe Vue : 
*
*
* @version 1 - 08 march 2021
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;


public class SaveMenuFrame extends MenuFrame {

 TitleMenu tm = new TitleMenu(true);

 String text_creer = new String("Créer");
 String text_supprimer = new String("Supprimer");

  // Constructeur
 public SaveMenuFrame(JFrame fenetre0) {
  super(fenetre0);

  System.out.println("Entrée dans le menu des sauvegardes");

  JButton creer = new JButton(this.text_creer);
  JButton supprimer = new JButton(this.text_supprimer);

  JPanel panel_save1 = new JPanel();
  panel_save1.add(creer);
  panel_save1.add(supprimer);
  JPanel panel_save2 = new JPanel();
  JPanel panel_save3 = new JPanel();

  JPanel panel_allsave = new JPanel();
  panel_allsave.setLayout(new GridLayout(1,3));
  panel_allsave.add(panel_save1);
  panel_allsave.add(panel_save2);
  panel_allsave.add(panel_save3);
  super.fenetre.add(panel_allsave, BorderLayout.CENTER);


}

public boolean isActive() {
  if(tm.check() == true) {
    return true;
  } else {
    return false;
  }
}

}