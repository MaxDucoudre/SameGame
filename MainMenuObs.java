
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class MainMenuObs implements ActionListener {

	protected JFrame fenetre;
	protected MainMenuFrame mmf;

	public MainMenuObs(JFrame fenetre0, MainMenuFrame mmf0) {
		this.fenetre = fenetre0;
		this.mmf = mmf0;
	}


	public void actionPerformed(ActionEvent e) { 
		
	}

}



