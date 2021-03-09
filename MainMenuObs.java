/**
* 
* @version 1 - 08 march 2021
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuObs implements ActionListener {

  private JFrame fenetre;

  public MainMenuObs(JFrame fenetre0) {
    this.fenetre = fenetre0;
  }

  public void actionPerformed(ActionEvent e) { 

    String button_text = e.getActionCommand();


    System.out.println(button_text);

  } 
}

