import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ShopObs implements ItemListener, ActionListener {

	private ShopFrame sf;
	private JFrame fenetre;

	public Save save = new Save();
	public int saveActive = this.save.getLoadedSave();

	public Coins coins = new Coins();

	public ShopObs(ShopFrame sf0, JFrame fenetre0) {
		this.sf = sf0;
		this.fenetre = fenetre0;
	}


	public void itemStateChanged(ItemEvent e) { 
		String buttonString = ((AbstractButton) e.getItemSelectable()).getActionCommand();
			System.out.println(buttonString + " selected !");


		// LE PACK JUNGLE
		if (e.getStateChange() == ItemEvent.SELECTED && buttonString == "Skin Pack JUNGLE") {


			this.sf.setSkinPackFrame(this.saveActive, 0);



    	} else if (e.getStateChange() == ItemEvent.DESELECTED && buttonString == "Skin Pack JUNGLE") {

		}


		if (e.getStateChange() == ItemEvent.SELECTED && buttonString == "Skin Pack GREEK") {
			this.sf.setSkinPackFrame(this.saveActive, 1);

    	} else if (e.getStateChange() == ItemEvent.DESELECTED && buttonString == "Skin Pack JUNGLE") {

		}

		if (e.getStateChange() == ItemEvent.SELECTED && buttonString == "Skin Pack PIXEL") {
			this.sf.setSkinPackFrame(this.saveActive, 2);


    	} else if (e.getStateChange() == ItemEvent.DESELECTED && buttonString == "Skin Pack JUNGLE") {

		}


	}


	public void actionPerformed(ActionEvent e) { 

		if(e.getActionCommand() == this.sf.mainmenustring) {

			this.sf.eraseFrame();
			MainMenuFrame mmf = new MainMenuFrame(this.fenetre); // on recréer un objet de type MainMenuFrame
			this.sf.refreshFrame();

		}
	}






}