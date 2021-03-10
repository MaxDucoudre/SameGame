import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuObsSavemenu extends MainMenuObs implements ActionListener  {

	public MainMenuObsSavemenu(JFrame fenetre0, MainMenuFrame mmf0) {
		super(fenetre0, mmf0);
	}

	public void actionPerformed(ActionEvent e) { 
		
		System.out.println(e.getActionCommand());
		super.mmf.eraseFrame();
		SaveMenuFrame smf = new SaveMenuFrame(super.fenetre);
		super.mmf.refreshFrame();

	} 

}



