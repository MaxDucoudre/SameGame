
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuObsStatistique extends MainMenuObs implements ActionListener  {


	public MainMenuObsStatistique(JFrame fenetre0, MainMenuFrame mmf0) {
		super(fenetre0, mmf0);
	}

	public void actionPerformed(ActionEvent e) { 
		
		System.out.println(e.getActionCommand());
		super.mmf.eraseFrame();
		// StatistiqueMenuFrame smf = new StatistiqueMenuFrame();
	} 

}



