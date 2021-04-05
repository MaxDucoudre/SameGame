/**
* Classe Vue : ShopFrame
* Classe gérant l'affichage du menu de la boytique
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ShopFrame extends MenuFrame {

	private Save save = new Save();
	private int saveActive = this.save.getLoadedSave();

	private Coins coins = new Coins();
	private int numberofcoins =  this.coins.getNumberOfCoins(this.saveActive);

	private JLabel walletmoney;


	private Shop shop = new Shop();

	// Le JPanel principal :
	private BackgroundImagePanel backgroundPanel = new BackgroundImagePanel(super.image_background, super.fenetre);


	private JButton mainmenubutton; // bouton pour retourner au menu principal
	

	public String mainmenustring = super.langue.getRegisterString();


	public JRadioButton skin1 = new JRadioButton("Skin Pack JUNGLE");
	public JRadioButton skin2 = new JRadioButton("Skin Pack GREEK");
	public JRadioButton skin3 = new JRadioButton("Skin Pack PIXEL");

	private JLabel isLockLabel1 = new JLabel();
	private JLabel isLockLabel2 = new JLabel();
	private JLabel isLockLabel3 = new JLabel();

	private BackgroundImagePanel pack1panel = new BackgroundImagePanel(Toolkit.getDefaultToolkit().getImage("./ressources/skinpack1/background.png"), super.fenetre);
	private BackgroundImagePanel pack2panel = new BackgroundImagePanel(Toolkit.getDefaultToolkit().getImage("./ressources/skinpack2/background.png"), super.fenetre);
	private BackgroundImagePanel pack3panel = new BackgroundImagePanel(Toolkit.getDefaultToolkit().getImage("./ressources/skinpack3/background.png"), super.fenetre);


	/**
	* Le constructeur de ShopFrame
	* @param fenetre
	*/
	public ShopFrame(JFrame fenetre0) {
		super(fenetre0);


		this.backgroundPanel.setLayout(new BorderLayout());

		this.walletmoney = new JLabel(String.valueOf(this.numberofcoins));


		JPanel shopPanel = new JPanel();
		shopPanel.setOpaque(false);

		GridLayout layout = new GridLayout(7,1);
		layout.setVgap(15);
		shopPanel.setLayout(layout);

		JLabel shoplabel = new JLabel(super.langue.getShopString());
		shoplabel.setFont(new Font("Serif", Font.BOLD, 40));
		shoplabel.setHorizontalAlignment(JLabel.CENTER);


		// PORTE MONNAIE
		JPanel wallet = new JPanel();
		wallet.setOpaque(false);

		walletmoney.setForeground(Color.ORANGE);
		walletmoney.setFont(new Font("ARIAL", Font.BOLD, 28));
		wallet.add(walletmoney);
		wallet.add(this.getIconLabel("./ressources/coins.png"));


		// PACK JUNGLE
		pack1panel.setOpaque(false);
		pack1panel.setBorder(BorderFactory.createLineBorder(new Color(102,51,0), 3));
		skin1.setBackground(new Color(138,172,42));
		skin1.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel price1 = new JLabel("0");
		price1.setFont(new Font("Arial", Font.PLAIN, 20));

		isLockLabel1.setFont(new Font("Arial", Font.BOLD, 20));
		isLockLabel1.setOpaque(true);

		if(this.shop.getIsUnlockedSkinPack(saveActive, 1) == true) {
			isLockLabel1.setBackground(new Color(138,172,42));
			isLockLabel1.setText("UNLOCKED");
		} else {
			isLockLabel1.setBackground(Color.RED);
			isLockLabel1.setText("LOCKED");			
		}



		pack1panel.add(price1);
		pack1panel.add(this.getIconLabel("./ressources/coins.png"));
		pack1panel.add(skin1);
		pack1panel.add(this.getIconLabel("./ressources/skinpack1/red.png"));
		pack1panel.add(this.getIconLabel("./ressources/skinpack1/green.png"));
		pack1panel.add(this.getIconLabel("./ressources/skinpack1/blue.png"));
		pack1panel.add(this.isLockLabel1);



		// PACK GREEK
		pack2panel.setOpaque(false);
		pack2panel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
		skin2.setBackground(Color.GRAY);
		skin2.setFont(new Font("Dialog", Font.ITALIC, 20));

		JLabel price2 = new JLabel("10");
		price2.setFont(new Font("Arial", Font.PLAIN, 20));
		
		isLockLabel2.setFont(new Font("Arial", Font.BOLD, 20));
		isLockLabel2.setOpaque(true);

		if(this.shop.getIsUnlockedSkinPack(saveActive, 2) == true) {
			isLockLabel2.setBackground(new Color(138,172,42));
			isLockLabel2.setText("UNLOCKED");
		} else {
			isLockLabel2.setBackground(Color.RED);
			isLockLabel2.setText("LOCKED");			
		}

		pack2panel.add(price2);
		pack2panel.add(this.getIconLabel("./ressources/coins.png"));
		pack2panel.add(skin2);
		pack2panel.add(this.getIconLabel("./ressources/skinpack2/red.png"));
		pack2panel.add(this.getIconLabel("./ressources/skinpack2/green.png"));
		pack2panel.add(this.getIconLabel("./ressources/skinpack2/blue.png"));
		pack2panel.add(this.isLockLabel2);


		// PACK PIXEL
		pack3panel.setOpaque(false);
		pack3panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		skin3.setBackground(Color.ORANGE);
		skin3.setFont(new Font("TimesRoman", Font.BOLD, 20));

		JLabel price3 = new JLabel("20");
		price3.setFont(new Font("Arial", Font.PLAIN, 20));

		isLockLabel3.setFont(new Font("Arial", Font.BOLD, 20));
		isLockLabel3.setOpaque(true);

		if(this.shop.getIsUnlockedSkinPack(saveActive, 3) == true) {
			isLockLabel3.setBackground(new Color(138,172,42));
			isLockLabel3.setText("UNLOCKED");
		} else {
			isLockLabel3.setBackground(Color.RED);
			isLockLabel3.setText("LOCKED");			
		}

		pack3panel.add(price3);
		pack3panel.add(this.getIconLabel("./ressources/coins.png"));
		pack3panel.add(skin3);
		pack3panel.add(this.getIconLabel("./ressources/skinpack3/red.png"));
		pack3panel.add(this.getIconLabel("./ressources/skinpack3/green.png"));
		pack3panel.add(this.getIconLabel("./ressources/skinpack3/blue.png"));
		pack3panel.add(this.isLockLabel3);


		skin1.addItemListener(new ShopObs(this, super.fenetre));
		skin2.addItemListener(new ShopObs(this, super.fenetre));
		skin3.addItemListener(new ShopObs(this, super.fenetre));



		ButtonGroup choix = new ButtonGroup();
		choix.add(skin1);
		choix.add(skin2);
		choix.add(skin3);


		if(this.shop.getSkinPack(this.saveActive) == 1) {
			skin1.setSelected(true);
		}
		else if(this.shop.getSkinPack(this.saveActive) == 2) {
			skin2.setSelected(true);
		}
		else if(this.shop.getSkinPack(this.saveActive) == 3) {
			skin3.setSelected(true);
		}


		JPanel mainmenubuttonpanel = new JPanel();
		mainmenubuttonpanel.setOpaque(false);
		JButton mainmenubutton = new JButton(this.mainmenustring);
		mainmenubutton.setBackground(super.button_color);
		mainmenubutton.setFont(super.font); 
		mainmenubutton.addActionListener(new ShopObs(this, super.fenetre));
		mainmenubuttonpanel.add(mainmenubutton);


		shopPanel.add(shoplabel);
		shopPanel.add(wallet);
		shopPanel.add(pack1panel);
		shopPanel.add(pack2panel);
		shopPanel.add(pack3panel);
		shopPanel.add(new JLabel());

		shopPanel.add(mainmenubuttonpanel);

		this.backgroundPanel.add(shopPanel, BorderLayout.CENTER);
		this.backgroundPanel.add(new JLabel("           "), BorderLayout.EAST);
		this.backgroundPanel.add(new JLabel("           "), BorderLayout.WEST);

		super.fenetre.add(this.backgroundPanel, BorderLayout.CENTER);

	}



	public JLabel getIconLabel(String path_image) {
		JLabel imageLabel = new JLabel();
		ImageIcon icon = new ImageIcon(path_image); // On initialise une icone avec l'image
		Image image = icon.getImage().getScaledInstance(super.fenetre.getWidth()/15, super.fenetre.getHeight()/10-5, Image.SCALE_SMOOTH); // on reprend l'image et on la redimensionne
		icon = new ImageIcon(image); // on met cette image redimensionnée dans l'icone
		imageLabel.setIcon(icon);
		return imageLabel;
	}



	public void setSkinPackFrame(int save, int pack) {

		if(pack == 1) {
			this.isLockLabel1.setText("UNLOCKED");
			this.isLockLabel1.setBackground(new Color(138,172,42));
		}

		if(pack == 2) {
			this.isLockLabel2.setText("UNLOCKED");
			this.isLockLabel2.setBackground(new Color(138,172,42));
			
		}

		if(pack == 3) {
			this.isLockLabel3.setText("UNLOCKED");
			this.isLockLabel3.setBackground(new Color(138,172,42));
		}


		super.fenetre.repaint();
		this.shop.unlockSkinPack(save, pack);
		this.shop.setSkinPack(save, pack);
	}

	public void setWalletLabel() {
		this.walletmoney.setText(String.valueOf(this.coins.getNumberOfCoins(this.saveActive)));
	}




}