
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuObs implements ActionListener {

	protected JFrame fenetre;
	protected MainMenuFrame mmf;

	public MainMenuObs(JFrame fenetre0, MainMenuFrame mmf0) {
		this.fenetre = fenetre0;
		this.mmf = mmf0;
	}


	public void actionPerformed(ActionEvent e) { 
		
		// Action du bouton qui lance la partie
		if(e.getActionCommand() == this.mmf.launchGameString) {

			System.out.println(e.getActionCommand());

			this.mmf.eraseFrame();
			GameFrame smf = new GameFrame(this.fenetre);
			this.mmf.refreshFrame();
		}


		// Action du bouton qui lance une partie à 2
		if(e.getActionCommand() == this.mmf.launchGameVs) {

			System.out.println(e.getActionCommand());

			this.mmf.eraseFrame();
		// GameFrameVS smf = new GameFrameVS();
			this.mmf.refreshFrame();
		}

		if(e.getActionCommand() == this.mmf.shopString) {

			System.out.println(e.getActionCommand());

			this.mmf.eraseFrame();
		// BoutiqueMenuFrame smf = new BoutiqueMenuFrame();
			this.mmf.refreshFrame();
		}

		if(e.getActionCommand() == this.mmf.settingsString) {

			System.out.println(e.getActionCommand());

			this.mmf.eraseFrame();
		//OptionsMenuFrame omf = new OptionMenuFrame();
			this.mmf.refreshFrame();
		}

		if(e.getActionCommand() == this.mmf.statisticsString) {

			System.out.println(e.getActionCommand());

			this.mmf.eraseFrame();
		//StatisicsMenuFrame omf = new StatisicsMenuFrame();
			this.mmf.refreshFrame();
		}

		if(e.getActionCommand() == this.mmf.saveString) {

			System.out.println(e.getActionCommand());
			
			this.mmf.eraseFrame();
		//SaveMenuFrame omf = new SaveMenuFrame();
			this.mmf.refreshFrame();
		}


		if(e.getActionCommand() == this.mmf.leftGameString) {

			System.out.println( e.getActionCommand());

			fenetre.setVisible(false);
			System.exit(0);		

		}
	}

}



