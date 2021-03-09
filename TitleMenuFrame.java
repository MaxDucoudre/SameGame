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


public class TitleMenuFrame {

 TitleMenu tm = new TitleMenu(true);
 JFrame fenetre;

  // Constructeur
 public TitleMenuFrame(JFrame fenetre0) {
  this.fenetre = fenetre0;

  JLabel gamename = new JLabel("SameGame");
  gamename.setHorizontalAlignment(JLabel.CENTER);
  this.fenetre.add(gamename, BorderLayout.NORTH);

    // Bouton "Start" pour lancer le jeux
  JButton startbutton = new JButton("Start");
  JPanel p = new JPanel();
  p.add(startbutton);
  this.fenetre.add(p, BorderLayout.CENTER);
  
    // Observateur pour le bouton start
  startbutton.addActionListener(new TitleMenuObs(tm, this.fenetre)); 
}

public boolean isActive() {
  if(tm.check() == true) {
    return true;
  } else {
    return false;
  }
}

}