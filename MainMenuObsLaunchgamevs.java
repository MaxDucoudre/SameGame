
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuObsLaunchgamevs extends MainMenuObs implements ActionListener  {

	public MainMenuObsLaunchgamevs(JFrame fenetre0, MainMenuFrame mmf0) {
		super(fenetre0, mmf0);
	}


	public void actionPerformed(ActionEvent e) { 
		
		System.out.println(e.getActionCommand());
		super.mmf.eraseFrame();
		// GameFrameVS smf = new GameFrameVS();
	} 

}



