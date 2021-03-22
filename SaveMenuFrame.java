/**
* Classe Vue : SaveMenuFrame
* Classe qui gère l'affichage du menu des sauvegardes
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;


public class SaveMenuFrame extends MenuFrame {

	private BackgroundImagePanel saveMenuPanel = new BackgroundImagePanel(Toolkit.getDefaultToolkit().getImage("./ressources/default_background.jpg"), super.fenetre);

	private JPanel savePanel = new JPanel();

	// Objet classe modèle Save
	private Save save = new Save();

	// Objet Coins pour récupérer combien d'argent a une sauvegarde
	private Coins coins = new Coins();


	// 1ER SAUVEGARDE
	private JPanel save1panel = new JPanel();

	private JLabel save1label;
	private JButton nouveauxButton1;
	public String nouveauxButton1String = super.langue.getNewString();
	private	JButton selectionerButton1;
	public String selectionerButton1String = super.langue.getSelectString();
	private	JButton supprimerButton1;
	public String supprimerButton1String = super.langue.getDeleteString();
	private	JButton createButton1;
	public String createButton1String = super.langue.getCreateString();
	private JTextField textfield1 = new JTextField(super.langue.getSaveNameString() + "...   ");

	private JLabel labelmoney1 = new JLabel("+ " + this.coins.getNumberOfCoins(1));


	// 2EME SAUVEGARDE
	private JPanel save2panel = new JPanel();

	private JLabel save2label;
	private JButton nouveauxButton2;
	public String nouveauxButton2String = super.langue.getNewString()+ " ";
	private	JButton selectionerButton2;
	public String selectionerButton2String = super.langue.getSelectString() + " ";
	private	JButton supprimerButton2;
	public String supprimerButton2String = super.langue.getDeleteString()+ " ";
	private	JButton createButton2;
	public String createButton2String = super.langue.getCreateString()+ " ";
	private JTextField textfield2 = new JTextField(super.langue.getSaveNameString() + "...   ");



	// 3EME SAUVEGARDE
	private JPanel save3panel = new JPanel();

	private JLabel save3label;
	private JButton nouveauxButton3;
	public String nouveauxButton3String = super.langue.getNewString() + "  ";
	private	JButton selectionerButton3;
	public String selectionerButton3String = super.langue.getSelectString() + "  ";
	private	JButton supprimerButton3;
	public String supprimerButton3String = super.langue.getDeleteString() + "  ";
	private	JButton createButton3;
	public String createButton3String = super.langue.getCreateString() + "  ";
	private JTextField textfield3 = new JTextField(super.langue.getSaveNameString() + "...   ");

	// attribut image
	private ImageIcon icon_money;
	private JPanel coin_panel1 = new JPanel();
	private JLabel coinsImageLabel1 = new JLabel();
	private JLabel coin_get1 = new JLabel(this.coins.getNumberOfCoins(1) + " ");

	private JPanel coin_panel2 = new JPanel();
	private JLabel coinsImageLabel2 = new JLabel();
	private JLabel coin_get2 = new JLabel(this.coins.getNumberOfCoins(2) + " ");

	private JPanel coin_panel3 = new JPanel();
	private JLabel coinsImageLabel3 = new JLabel();
	private JLabel coin_get3 = new JLabel(this.coins.getNumberOfCoins(3) + " ");


 	/**
 	* Le constructeur de SaveMenuFrame qui affichent tous les JComponents
 	* @param fenetre
 	*/	
 	public SaveMenuFrame(JFrame fenetre0) {
		super(fenetre0);

		this.saveMenuPanel.setLayout(new BorderLayout());

		GridLayout layout = new GridLayout(6,1);
		layout.setVgap(20);

		this.savePanel.setLayout(layout);
		this.savePanel.setOpaque(false);

		// JPANEL DES PIECES
		this.icon_money = new ImageIcon("./ressources/coins.png"); // On initialise une icone avec l'image
		Image image_money = this.icon_money.getImage().getScaledInstance(super.fenetre.getWidth()/15, super.fenetre.getHeight()/10-5, Image.SCALE_SMOOTH); // on reprend l'image et on la redimensionne
		this.icon_money = new ImageIcon(image_money); // on met cette image redimensionnée dans l'icone
		this.coinsImageLabel1.setIcon(icon_money);
		this.coinsImageLabel2.setIcon(icon_money);
		this.coinsImageLabel3.setIcon(icon_money);

		this.coin_get1.setFont(super.font);
		this.coin_get2.setFont(super.font);
		this.coin_get3.setFont(super.font);

		this.coin_panel1.setOpaque(false);
		this.coin_panel1.add(this.coin_get1);
		this.coin_panel1.add(this.coinsImageLabel1);

		this.coin_panel2.setOpaque(false);
		this.coin_panel2.add(this.coin_get2);
		this.coin_panel2.add(this.coinsImageLabel2);

		this.coin_panel3.setOpaque(false);
		this.coin_panel3.add(this.coin_get3);
		this.coin_panel3.add(this.coinsImageLabel3);


		JLabel sauvegardesMenulabel = new JLabel(super.langue.getSaveString());
		sauvegardesMenulabel.setFont(new Font("Serif", Font.BOLD, 40));

		sauvegardesMenulabel.setHorizontalAlignment(JLabel.CENTER);
		this.savePanel.add(sauvegardesMenulabel); // JLabel du menu

		this.savePanel.add(new JLabel()); // JLabel vide

		// JPANEL DE LA 1ER SAUVEGARDE
		this.save1panel.setBorder(BorderFactory.createLineBorder(super.contour_color, 3));
		this.save1panel.setBackground(Color.GRAY);

		this.save1label = new JLabel(super.langue.getEmptySlotString());
		this.save1label.setHorizontalAlignment(JLabel.LEFT);
		this.save1label.setFont(super.font);

		this.nouveauxButton1 = new JButton(nouveauxButton1String); // bouton nouvelle sauvegarde
		this.nouveauxButton1.setHorizontalAlignment(JButton.RIGHT);
		nouveauxButton1.setBackground(super.button_color);
		nouveauxButton1.setFont(super.font);
		this.nouveauxButton1.addActionListener(new SaveMenuObs(this));

		this.selectionerButton1 = new JButton(selectionerButton1String); // Bouton selectionner sauvegarde
		this.selectionerButton1.setBackground(super.button_color);
		this.selectionerButton1.setFont(super.font);
		this.selectionerButton1.addActionListener(new SaveMenuObs(this, super.fenetre));

		this.supprimerButton1 = new JButton(supprimerButton1String); // bouton supprimer
		this.supprimerButton1.setBackground(super.button_color);
		this.supprimerButton1.setFont(super.font);
		this.supprimerButton1.addActionListener(new SaveMenuObs(this));

		this.createButton1 = new JButton(createButton1String);
		createButton1.setBackground(super.button_color);
		createButton1.setFont(super.font);
		this.createButton1.addActionListener(new SaveMenuObs(this));






		if (this.save.isActiveSave(1) == false) {
			this.save1panel.add(save1label);
			this.save1panel.add(nouveauxButton1);
		} else {
			
			this.save1label.setText(this.save.getSaveName(1));
			this.save1panel.add(save1label);
			this.save1panel.add(coin_panel1);
			this.save1panel.add(selectionerButton1);
			this.save1panel.add(supprimerButton1);			
		}

		this.savePanel.add(save1panel);


		// JPANEL DE LA 2EME SAUVEGARDE
		this.save2panel.setBorder(BorderFactory.createLineBorder(super.contour_color, 3));
		this.save2panel.setBackground(Color.GRAY);

		this.save2label = new JLabel(super.langue.getEmptySlotString());
		this.save2label.setHorizontalAlignment(JLabel.LEFT);
		this.save2label.setFont(super.font);

		this.nouveauxButton2 = new JButton(nouveauxButton2String); // bouton nouvelle sauvegarde
		this.nouveauxButton2.setHorizontalAlignment(JButton.RIGHT);
		nouveauxButton2.setBackground(super.button_color);
		nouveauxButton2.setFont(super.font);
		this.nouveauxButton2.addActionListener(new SaveMenuObs(this));

		this.selectionerButton2 = new JButton(selectionerButton2String); // Bouton selectionner sauvegarde
		this.selectionerButton2.setBackground(super.button_color);
		this.selectionerButton2.setFont(super.font);
		this.selectionerButton2.addActionListener(new SaveMenuObs(this, super.fenetre));

		this.supprimerButton2 = new JButton(supprimerButton2String); // bouton supprimer
		this.supprimerButton2.setBackground(super.button_color);
		this.supprimerButton2.setFont(super.font);
		this.supprimerButton2.addActionListener(new SaveMenuObs(this));

		this.createButton2 = new JButton(createButton2String);
		createButton2.setBackground(super.button_color);
		createButton2.setFont(super.font);
		this.createButton2.addActionListener(new SaveMenuObs(this));

		if (this.save.isActiveSave(2) == false) {
			this.save2panel.add(save2label);
			this.save2panel.add(nouveauxButton2);
		} else {
			this.save2label.setText(this.save.getSaveName(2));
			this.save2panel.add(save2label);
			this.save2panel.add(coin_panel2);
			this.save2panel.add(selectionerButton2);
			this.save2panel.add(supprimerButton2);			
		}

		this.savePanel.add(save2panel);



		// JPANEL DE LA 3EME SAUVEGARDE
		this.save3panel.setBorder(BorderFactory.createLineBorder(super.contour_color, 3));
		this.save3panel.setBackground(Color.GRAY);

		this.save3label = new JLabel(super.langue.getEmptySlotString());
		this.save3label.setHorizontalAlignment(JLabel.LEFT);
		this.save3label.setFont(super.font);

		this.nouveauxButton3 = new JButton(nouveauxButton3String); // bouton nouvelle sauvegarde
		this.nouveauxButton3.setHorizontalAlignment(JButton.RIGHT);
		nouveauxButton3.setBackground(super.button_color);
		nouveauxButton3.setFont(super.font);
		this.nouveauxButton3.addActionListener(new SaveMenuObs(this));

		this.selectionerButton3 = new JButton(selectionerButton3String); // Bouton selectionner sauvegarde
		this.selectionerButton3.setBackground(super.button_color);
		this.selectionerButton3.setFont(super.font);
		this.selectionerButton3.addActionListener(new SaveMenuObs(this, super.fenetre));

		this.supprimerButton3 = new JButton(supprimerButton3String); // bouton supprimer
		this.supprimerButton3.setBackground(super.button_color);
		this.supprimerButton3.setFont(super.font);
		this.supprimerButton3.addActionListener(new SaveMenuObs(this));

		this.createButton3 = new JButton(createButton3String);
		createButton3.setBackground(super.button_color);
		createButton3.setFont(super.font);
		this.createButton3.addActionListener(new SaveMenuObs(this));

		if (this.save.isActiveSave(3) == false) {
			this.save3panel.add(save3label);
			this.save3panel.add(nouveauxButton3);
		} else {
			this.save3label.setText(this.save.getSaveName(3));
			this.save3panel.add(save3label);
			this.save3panel.add(coin_panel3);
			this.save3panel.add(selectionerButton3);
			this.save3panel.add(supprimerButton3);			
		}

		this.savePanel.add(save3panel);


		this.savePanel.add(new JLabel()); // JLabel vide



		// RAJOUT A LA FENETRE
		this.saveMenuPanel.add(savePanel, BorderLayout.CENTER);
		this.saveMenuPanel.add(this.spacelabel(), BorderLayout.EAST);
		this.saveMenuPanel.add(this.spacelabel(), BorderLayout.WEST);

		super.fenetre.add(saveMenuPanel, BorderLayout.CENTER);
	}


	public JLabel spacelabel() {
		JLabel spacelabel = new JLabel("                 ");
		return spacelabel;
	}


 	/**
 	* La méthode "writeSaveName" se déclenche lorsqu'il faut entrer le nom de la sauvegarde
 	* @param save correspond à la sauvegarde qui doit être nommée
 	*/
	public void writeSaveName(int save) {
		if(save == 1) {
			this.textfield1.setFont(super.font);

			this.save1panel.remove(this.save1label);
			this.save1panel.remove(this.nouveauxButton1);

			this.save1panel.add(this.textfield1);
			this.save1panel.add(this.createButton1);

			super.fenetre.repaint();
			super.fenetre.setVisible(true);

		} else if (save == 2) {
			this.textfield2.setFont(super.font);

			this.save2panel.remove(this.save2label);
			this.save2panel.remove(this.nouveauxButton2);

			this.save2panel.add(this.textfield2);
			this.save2panel.add(this.createButton2);

			super.fenetre.repaint();
			super.fenetre.setVisible(true);

		} else if (save == 3) {
			this.textfield3.setFont(super.font);

			this.save3panel.remove(this.save3label);
			this.save3panel.remove(this.nouveauxButton3);

			this.save3panel.add(this.textfield3);
			this.save3panel.add(this.createButton3);

			super.fenetre.repaint();
			super.fenetre.setVisible(true);
		}

	}

 	/**
 	* La méthode "pressCreateButton" se déclenche lorsqu'une sauvegarde est créée
 	* @param save correspond à l'emplacement de la sauvegarde a créer
 	*/
	public void pressCreateButton(int save) {
		if(save == 1) {
			this.save1panel.remove(this.textfield1);
			this.save1panel.remove(this.createButton1);

			this.save.createSave(1, this.textfield1.getText());

			this.save1label.setText(this.save.getSaveName(1));

			this.save1panel.add(save1label);
			this.coin_get1.setText("0");
			this.save1panel.add(coin_panel1);
			this.save1panel.add(selectionerButton1);
			this.save1panel.add(supprimerButton1);

			super.fenetre.repaint();
			super.fenetre.setVisible(true);
		} else if (save == 2) {
			this.save2panel.remove(this.textfield2);
			this.save2panel.remove(this.createButton2);

			this.save.createSave(2, this.textfield2.getText());

			this.save2label.setText(this.save.getSaveName(2));

			this.save2panel.add(save2label);
			this.coin_get2.setText("0");
			this.save2panel.add(coin_panel2);
			this.save2panel.add(selectionerButton2);
			this.save2panel.add(supprimerButton2);

			super.fenetre.repaint();
			super.fenetre.setVisible(true);			
		} else if (save == 3) {
			this.save3panel.remove(this.textfield3);
			this.save3panel.remove(this.createButton3);

			this.save.createSave(3, this.textfield3.getText());

			this.save3label.setText(this.save.getSaveName(3));

			this.save3panel.add(save3label);
			this.coin_get3.setText("0");
			this.save3panel.add(coin_panel3);
			this.save3panel.add(selectionerButton3);
			this.save3panel.add(supprimerButton3);

			super.fenetre.repaint();
			super.fenetre.setVisible(true);			
		}


	}
 	/**
 	* La méthode "pressSelectButton" se lorsqu'on séléctionne la sauvegarde et charge la sauvegarde
 	* @param save correspond à la sauvegarde a charger
 	*/
	public void pressSelectButton(int save) {
		this.save.loadSave(save);

	}

 	/**
 	* La méthode "pressDeleteButton" supprime une sauvegarde 
 	* @param save correspond à la sauvegarde a supprimer
 	*/
	public void pressDeleteButton(int save) {
		if(save == 1) {
			this.save.deleteSave(save);

			this.save1panel.remove(this.selectionerButton1);
			this.save1panel.remove(this.supprimerButton1);
			this.save1panel.remove(this.coin_panel1);

			this.save1label.setText(super.langue.getEmptySlotString());
			this.save1panel.add(this.nouveauxButton1);


			super.fenetre.repaint();
			super.fenetre.setVisible(true);
		} else if (save == 2) {
			this.save.deleteSave(save);

			this.save2panel.remove(this.selectionerButton2);
			this.save2panel.remove(this.supprimerButton2);
			this.save2panel.remove(this.coin_panel2);

			this.save2label.setText(super.langue.getEmptySlotString());
			this.save2panel.add(this.nouveauxButton2);


			super.fenetre.repaint();
			super.fenetre.setVisible(true);

		} else if (save == 3) {
			this.save.deleteSave(save);

			this.save3panel.remove(this.selectionerButton3);
			this.save3panel.remove(this.supprimerButton3);
			this.save3panel.remove(this.coin_panel3);

			this.save3label.setText(super.langue.getEmptySlotString());
			this.save3panel.add(this.nouveauxButton3);

			super.fenetre.repaint();
			super.fenetre.setVisible(true);
		}
	}

}