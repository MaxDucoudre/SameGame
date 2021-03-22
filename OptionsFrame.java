/**
* Classe Vue : OptionsFrame
* Classe gérant l'affichage du menu des options
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;

public class OptionsFrame extends MenuFrame {

	private Options options = new Options();

	// JPanel principal
	private BackgroundImagePanel optionsPanel = new BackgroundImagePanel(super.image_background, super.fenetre);

	// OPTIONS JLABEL
	private JLabel pauselabel = new JLabel(super.langue.getSettingsString());


	// OPTIONS BUTTON
	private JButton difficulty_button = new JButton();
	public String difficulty_hard_string = super.langue.getDifficultyString() + " : " + super.langue.getHardString();
	public String difficulty_normal_string = super.langue.getDifficultyString() + " : " + super.langue.getNormalString();


	private JButton mod_button = new JButton();
	public String mod_solo_string = super.langue.getModString() + " : " + super.langue.getSoloString();
	public String mod_dual_string = super.langue.getModString() + " : " + super.langue.getDualString();


	private JComboBox<String> combobox = new JComboBox<String>(); // Objet JComboBox pour séléctionner la langue
	public String langue_french_string = super.langue.getFrenchString();
	public String langue_english_string = super.langue.getEnglishString();
	public String langue_esperanto_string = super.langue.getEsperantoString();
	public String langue_german_string = super.langue.getGermanString();

	private JButton save_button = new JButton();
	public String save_string = super.langue.getRegisterString();

	private JButton cancel_button = new JButton();
	public String cancel_string = super.langue.getCancelString();

	private JButton reset_button = new JButton();
	public String reset_string = super.langue.getResetString();


	public String credits_string = super.langue.getCreditsString();



	public OptionsFrame(JFrame fenetre) {
		super(fenetre);

		this.pauselabel.setHorizontalAlignment(JLabel.CENTER);
		this.pauselabel.setFont(new Font("Serif", Font.BOLD, 40));

			// GRAPHISME DES BOUTONS
		JPanel line1panel = new JPanel();
		line1panel.setOpaque(false);
		// Bouton difficulté
		this.difficulty_button.setBackground(super.button_color);
		// Set le text du bouton difficulté
		if(this.options.getDifficulty() == "normal") {
			this.difficulty_button.setText(this.difficulty_normal_string);
		} else if(this.options.getDifficulty() == "hard") {
			this.difficulty_button.setText(this.difficulty_hard_string);
		}	
		this.difficulty_button.setFont(super.font); 
		this.difficulty_button.addActionListener(new OptionsObs(this));
		line1panel.add(this.difficulty_button);


		JPanel line2panel = new JPanel();
		line2panel.setOpaque(false);
		// Bouton mod
		this.mod_button.setBackground(super.button_color);
		// set le texte du bouton mod
		if(this.options.getMod() == "solo") {
			this.mod_button.setText(this.mod_solo_string);
		} else if(this.options.getMod() == "dual") {
			this.mod_button.setText(this.mod_dual_string);
		}		
		this.mod_button.setFont(super.font); 
		this.mod_button.addActionListener(new OptionsObs(this));
		line2panel.add(this.mod_button);


		JPanel line3panel = new JPanel();
		line3panel.setOpaque(false);

		// Combobox de la langue

		this.combobox.setBackground(super.button_color); // on change la couleur
		this.combobox.setFont(super.font); // on change la police
		this.combobox.setMaximumRowCount(4); // Ne pas afficher plus de 4 selection en même temps sans scrollbar

		this.combobox.addItem(langue_english_string);
		this.combobox.addItem(langue_french_string);
		this.combobox.addItem(langue_esperanto_string);
		this.combobox.addItem(langue_german_string);

		this.combobox.addActionListener(new OptionsObs(this));
		//super.langue.getLanguageString() + " : " + 
		line3panel.add(combobox); // on ajoute la combobox au panel




		JPanel line5panel = new JPanel();
		line5panel.setOpaque(false);
		// Bouton sauvegarde
		this.save_button.setBackground(super.button_color);
		this.save_button.setText(this.save_string);
		this.save_button.setFont(super.font); 
		this.save_button.addActionListener(new OptionsObs(this, super.fenetre));
		line5panel.add(this.save_button);

		// bouton reset
		this.reset_button.setBackground(super.button_color);
		this.reset_button.setText(this.reset_string);
		this.reset_button.setFont(super.font);
		this.reset_button.addActionListener(new OptionsObs(this));
		line5panel.add(this.reset_button);


		line5panel.add(new JLabel());
		line5panel.add(new JLabel());

		// credits button
		JButton credits_button = new JButton();
		credits_button.setBackground(super.button_color);
		credits_button.setText(this.credits_string);
		credits_button.setFont(super.font);
		credits_button.addActionListener(new OptionsObs(this));		
		line5panel.add(credits_button);



		// Rajout du JPanel principal
		this.optionsPanel.setLayout(new GridLayout(7,1));
		this.optionsPanel.add(this.pauselabel);
		this.optionsPanel.add(new JLabel()); // JLabel vide
		this.optionsPanel.add(line1panel);
		this.optionsPanel.add(line2panel);
		this.optionsPanel.add(line3panel);
		this.optionsPanel.add(new JLabel()); // JLabel vide
		this.optionsPanel.add(line5panel);

		super.fenetre.add(optionsPanel, BorderLayout.CENTER);

	}

	/**
	 * La méthode "getLanguageComboBoxString" nous obtient la séléction du JComboBox de la langue
	 * @return la langue selectionée sous forme de String
	 */
	public String getLanguageComboBoxString() {
		String langue = this.combobox.getSelectedItem().toString();
		return langue;
	}

	/**
	 * La méthode "setDifficultyButton" permet de mettre à jour l'affichage du bouton "difficulté" et change la difficulté
	 */
	public void setDifficultyButton() {
		if (this.options.getDifficulty() == "hard") { // si la difficulté est difficile

			this.difficulty_button.setText(this.difficulty_normal_string); // alors on change le texte du bouton
			this.options.setDifficulty("normal"); // et on met la difficulté en normale


		} else if(this.options.getDifficulty() == "normal") {// si la difficulté est normale

			this.difficulty_button.setText(this.difficulty_hard_string);// alors on change le texte du bouton
			this.options.setDifficulty("hard"); // et on met la difficulté en difficile

		}
	}

	/**
	 * La méthode "setLanguageButton" permet de mettre à jour l langue
	 * @param langue est la langue choisie
	 */
	public void setLanguageButton(String langue) {
		this.options.setLanguage(langue); // on change la langue

		}
	

	/**
	 * La méthode "setModButton" permet de mettre à jour l'affichage du bouton "mod" et change le mod
	 */
	public void setModButton() {
		if (this.options.getMod() == "solo") { // si le mod est en solo

			this.mod_button.setText(this.mod_dual_string); // alors on change le texte du bouton
			this.options.setMod("dual"); // et on met le mod en duel


		} else if(this.options.getMod() == "dual") {// si le mod est en duel

			this.mod_button.setText(this.mod_solo_string);// alors on change le texte du bouton
			this.options.setMod("solo"); // et on met le mod en solo

		}
	}


	public void resetSettings() {

		this.options.setDifficulty("normal"); //  on met la difficulté en normale
		this.difficulty_button.setText(this.difficulty_normal_string); 

		this.options.setMod("solo"); // on met le mod en solo
		this.mod_button.setText(this.mod_solo_string);

	}


	public void creditDisplay() {
		BackgroundImagePanel creditPanel = new BackgroundImagePanel(Toolkit.getDefaultToolkit().getImage("./ressources/credits/credits.png"), super.fenetre);
		creditPanel.setLayout(new BorderLayout());

		super.fenetre.remove(optionsPanel);
		super.fenetre.add(creditPanel, BorderLayout.CENTER);

		JPanel button_left_panel = new JPanel();
		button_left_panel.setOpaque(false);
		button_left_panel.add(this.save_button);
		creditPanel.add(button_left_panel, BorderLayout.SOUTH);

		super.fenetre.repaint();
		super.fenetre.setVisible(true);

	}

}