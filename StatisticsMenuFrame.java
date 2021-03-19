/**
* Classe Vue : StatisticsMenuFrame
* Classe gérant l'affichage du menu statistiques
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;

public class StatisticsMenuFrame extends MenuFrame {

	private JFrame fenetre;

	public String leftbuttonstring = super.langue.getMainMenuString();

	// Attributs pour récupérer des données des parties 
	private Game game = new Game();
	private Statistics stat = new Statistics();


/**
* le constructeur StatisticsMenuFrame initialise tout l'affichage du menu statistiques
*/
	public StatisticsMenuFrame(JFrame fenetre0) {
		super(fenetre0);
		this.fenetre = fenetre0;


	BackgroundImagePanel statisticsMenuPanel = new BackgroundImagePanel(super.image_background, super.fenetre);
	statisticsMenuPanel.setLayout(new GridLayout(4,1));

	// JLabel au sommet
	JLabel statisticsLabel = new JLabel(super.langue.getStatisticsString());
	statisticsLabel.setFont(new Font("Serif", Font.BOLD, 40));
	statisticsLabel.setHorizontalAlignment(JLabel.CENTER);
	statisticsMenuPanel.add(statisticsLabel); // on rajoute au JPanel principal

	// JPanel record+timer
	JPanel recordtimerpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	recordtimerpanel.setOpaque(false);
	// JLabel record actuel 
	// on récupère le record via la méthode getHightscore()
	JLabel hightscorelabel = new JLabel(super.langue.getHightScoreString() + " : " + this.game.getHightscore() + " ");
	hightscorelabel.setFont(super.font);
	recordtimerpanel.add(hightscorelabel);  // on rajoute au JPanel principal

	// Temps du record
	// on récupère le chrono du meilleur score via la méthode getBestChrono() de la classe modèle
	JLabel chronolabel = new JLabel(" " + super.langue.getTimeString() + " : " + this.stat.getBestChrono());
	chronolabel.setFont(super.font);	
	recordtimerpanel.add(chronolabel);  // on rajoute au JPanel principal
	statisticsMenuPanel.add(recordtimerpanel); // on rajoute recordtimepanel au JPanel principal


	// Partie joués
	// on récupère le nombre de parties jouées via la méthode getNumberOfGame()
	JLabel numbergamelabel = new JLabel(super.langue.getPlayedGameString() + " : " + this.game.getNumberOfGame());
	numbergamelabel.setFont(super.font);	
	numbergamelabel.setHorizontalAlignment(JLabel.CENTER);
	statisticsMenuPanel.add(numbergamelabel); // on rajoute au JPanel principal


	// Temps de jeux total

	// Score en moyenne


	// Boutons retour au menu principal
	JPanel buttonpanel = new JPanel();
	buttonpanel.setOpaque(false);
	JButton leftbuttonstring = new JButton(this.leftbuttonstring);
	leftbuttonstring.setBackground(super.button_color);
	leftbuttonstring.setFont(super.font); 
	leftbuttonstring.addActionListener(new StatisticsObs(this, this.fenetre));
	buttonpanel.add(leftbuttonstring);
	statisticsMenuPanel.add(buttonpanel);

	super.fenetre.add(statisticsMenuPanel, BorderLayout.CENTER);

	}
}