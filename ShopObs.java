import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
* Classe Observateur : ShopObs
* classe gérant les boutons de la boutique
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/
public class ShopObs implements ItemListener, ActionListener {

	private ShopFrame sf;
	private JFrame fenetre;

	public Save save = new Save();
	public int saveActive = this.save.getLoadedSave();

	private Coins coins = new Coins();
	private int numberofcoins =  this.coins.getNumberOfCoins(this.saveActive);

	private Shop shop = new Shop();


	public ShopObs(ShopFrame sf0, JFrame fenetre0) {
		this.sf = sf0;
		this.fenetre = fenetre0;
	}


	public void itemStateChanged(ItemEvent e) { 
		String buttonString = ((AbstractButton) e.getItemSelectable()).getActionCommand();


		// LE PACK JUNGLE (par défaut)
		if (e.getStateChange() == ItemEvent.SELECTED && buttonString == "Skin Pack JUNGLE") {

			this.sf.setSkinPackFrame(this.saveActive, 1);

		}



		// LE PACK GREEK
		if (e.getStateChange() == ItemEvent.SELECTED && buttonString == "Skin Pack GREEK") {

			if( this.shop.getIsUnlockedSkinPack(this.saveActive, 2) == true ) {
				this.sf.setSkinPackFrame(this.saveActive, 2);

				} else if(this.numberofcoins >= 10 && this.shop.getIsUnlockedSkinPack(this.saveActive, 2) == false) {
					this.sf.setSkinPackFrame(this.saveActive, 2);
					this.coins.decreaseCoins(10, this.saveActive);

				} else {
				this.sf.skin2.setSelected(false);
				this.sf.skin1.setSelected(true);

			}
		}



		// LE PACK PIXEL
		if (e.getStateChange() == ItemEvent.SELECTED && buttonString == "Skin Pack PIXEL") {


			if( this.shop.getIsUnlockedSkinPack(this.saveActive, 3) == true ) {
				this.sf.setSkinPackFrame(this.saveActive, 3);

				} else if(this.numberofcoins >= 20  && this.shop.getIsUnlockedSkinPack(this.saveActive, 3) == false) {
					this.sf.setSkinPackFrame(this.saveActive, 3);
					this.coins.decreaseCoins(20, this.saveActive);
					
				} else {

				this.sf.skin2.setSelected(false);
				this.sf.skin1.setSelected(true);

			}
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