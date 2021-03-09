
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuObsOptions extends MainMenuObs implements ActionListener  {



	public MainMenuObsOptions(JFrame fenetre0, MainMenuFrame mmf0) {
		super(fenetre0, mmf0);
	}

	public void actionPerformed(ActionEvent e) { 
		String button_text = e.getActionCommand();

		System.out.println(button_text);
		super.mmf.eraseFrame();
	} 

}



