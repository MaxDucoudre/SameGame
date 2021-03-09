/**
* Classe Contrôleur : TitleMenuObs
* Rendre le menu titre interactif
*
* @version 1 - 08 march 2021
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitleMenuObs implements ActionListener {

  private TitleMenuFrame tmf;
  private TitleMenu tm;
  private JFrame fenetre;


  public TitleMenuObs(TitleMenu tm0, TitleMenuFrame tmf0, JFrame fenetre0) {
    this.tm = tm0;
    this.tmf = tmf0;
    this.fenetre = fenetre0;
  }

  public void actionPerformed(ActionEvent e) { 

    this.tm.update(); // Change l'état du menu Title de false vers true

    this.tmf.eraseFrame();

    System.out.println("État du menu titre : " + this.tm.check());

    MainMenuFrame mainmenu = new MainMenuFrame(fenetre);
    mainmenu.refreshFrame();

    System.out.println("Main Menu");



  } 
}
