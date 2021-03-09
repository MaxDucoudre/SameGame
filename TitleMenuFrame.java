/**
* Classe Vue : TitleMenuFrame
* Affichage du menu titre du jeux
*
* @version 1 - 08 march 2021
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;


public class TitleMenuFrame extends MenuFrame {

 TitleMenu tm = new TitleMenu(true);

  // Constructeur
 public TitleMenuFrame(JFrame fenetre0) {
  super(fenetre0);

  JLabel gamename = new JLabel("SameGame");
  gamename.setHorizontalAlignment(JLabel.CENTER);
  super.fenetre.add(gamename, BorderLayout.NORTH);

    // Bouton "Start" pour lancer le jeux
      System.out.println("test ");

  JButton startbutton = new JButton("Salutations");
  JPanel p = new JPanel();
  p.add(startbutton);
  super.fenetre.add(p, BorderLayout.CENTER);
  startbutton.addActionListener(new TitleMenuObs(tm, this, super.fenetre)); //observateur
}

public boolean isActive() {
  if(tm.check() == true) {
    return true;
  } else {
    return false;
  }
}

}