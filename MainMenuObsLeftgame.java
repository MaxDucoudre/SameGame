
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuObsLeftgame extends MainMenuObs implements ActionListener  {


	public MainMenuObsLeftgame(JFrame fenetre0, MainMenuFrame mmf0) {
		super(fenetre0, mmf0);
	}

	public void actionPerformed(ActionEvent e) { 
		System.out.println( e.getActionCommand());

		fenetre.setVisible(false);
		System.exit(0);		
	} 

}



