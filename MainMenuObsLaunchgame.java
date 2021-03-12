
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuObsLaunchgame extends MainMenuObs implements ActionListener  {


	public MainMenuObsLaunchgame(JFrame fenetre0, MainMenuFrame mmf0) {
		super(fenetre0, mmf0);
	}

	public void actionPerformed(ActionEvent e) { 
		
		System.out.println(e.getActionCommand());
		super.mmf.eraseFrame();

		GameFrame smf = new GameFrame(super.fenetre);

		super.mmf.refreshFrame();

	} 

}



