	/**
	* Classe Vue : TitleMenuFrame
	* Affichage du menu titre du jeux
	*
	* @version 1
	* @author Max Ducoudré
	* @author Loris Schnell
	*/

	import javax.swing.*;
	import java.awt.*;


	public class TitleMenuFrame extends MenuFrame {

	private JLabel gamename = new JLabel("SameGame");

		// Constructeur
	 public TitleMenuFrame(JFrame fenetre0) {
		super(fenetre0);


		JPanel p = new JPanel();
		BackgroundImagePanel saveMenuPanel = new BackgroundImagePanel(Toolkit.getDefaultToolkit().getImage("./ressources/default_background.jpg"), super.fenetre);
		saveMenuPanel.setLayout(new GridLayout(4,1));

		// nom du jeux
		this.gamename.setHorizontalAlignment(JLabel.CENTER);
		this.gamename.setForeground(Color.YELLOW);
		this.gamename.setFont(new Font("Arial", Font.ITALIC, 60));
		this.gamename.addMouseListener(new TitleMenuObs(this, super.fenetre));

		saveMenuPanel.add(new JLabel());
		saveMenuPanel.add(gamename);

		JButton startbutton = new JButton(super.langue.getStartString()); // Bouton pour lancer le jeux
		startbutton.setFont(new Font("Century", Font.BOLD, 30));
		startbutton.setBackground(Color.GREEN);

		startbutton.addActionListener(new TitleMenuObs(this, super.fenetre));

		super.fenetre.add(saveMenuPanel, BorderLayout.CENTER);
		super.fenetre.add(startbutton, BorderLayout.SOUTH);

	}


	public void changeGameNameColor() {
		this.gamename.setForeground(Color.RED);
	}

	public void resetGameNameColor() {
		this.gamename.setForeground(Color.YELLOW);

	}

}

