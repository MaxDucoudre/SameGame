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


	private JButton langue_button = new JButton();
	public String langue_french_string = super.langue.getLanguageString() + " : " + super.langue.getFrenchString();
	public String langue_english_string = super.langue.getLanguageString() + " : " + super.langue.getEnglishString();


	private JButton save_button = new JButton();
	public String save_string = super.langue.getSaveString();

	private JButton cancel_button = new JButton();
	public String cancel_string = super.langue.getCancelString();

	private JButton reset_button = new JButton();
	public String reset_string = super.langue.getResetString();



	public OptionsFrame(JFrame fenetre) {
		super(fenetre);

		this.pauselabel.setHorizontalAlignment(JLabel.CENTER);
		this.pauselabel.setFont(new Font("Serif", Font.BOLD, 40));

			// GRAPHISME DES BOUTONS
		JPanel line1panel = new JPanel();
		line1panel.setOpaque(false);
		this.difficulty_button.setBackground(super.button_color);
		this.difficulty_button.setText(this.difficulty_normal_string);
		this.difficulty_button.setFont(super.font); 
		this.difficulty_button.addActionListener(new OptionsObs(this));
		line1panel.add(this.difficulty_button);

		JPanel line2panel = new JPanel();
		line2panel.setOpaque(false);
		this.mod_button.setBackground(super.button_color);
		this.mod_button.setText(mod_solo_string);
		this.mod_button.setFont(super.font); 
		line2panel.add(this.mod_button);

		JPanel line3panel = new JPanel();
		line3panel.setOpaque(false);
		this.langue_button.setBackground(super.button_color);
		this.langue_button.setText(langue_english_string);
		this.langue_button.setFont(super.font); 
		line3panel.add(this.langue_button);


		JPanel line5panel = new JPanel();
		line5panel.setOpaque(false);
		this.save_button.setBackground(super.button_color);
		this.save_button.setText(save_string);
		this.save_button.setFont(super.font); 
		line5panel.add(this.save_button);

		this.cancel_button.setBackground(super.button_color);
		this.cancel_button.setText(cancel_string);
		this.cancel_button.setFont(super.font); 
		line5panel.add(this.cancel_button);

		this.reset_button.setBackground(super.button_color);
		this.reset_button.setText(reset_string);
		this.reset_button.setFont(super.font); 
		line5panel.add(this.reset_button);



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

}
