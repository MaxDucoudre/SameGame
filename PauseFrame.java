public class PauseFrame extends MenuFrame {


	public JButton resumePauseButton = new JButton("Resume");
	public JButton leftGamePauseButton = new JButton("Main Menu");

	private JPanel pausePanel = new JPanel();

	private JPanel pauseButtonPanel = new JPanel();
	private JPanel pauseScorePanel = new JPanel();
	private JLabel chronoAtPause = new JLabel();
	private JLabel scoreAtPause = new JLabel();

	public PauseFrame(){
		super();
		this.pausePanel.setLayout(new BorderLayout());

	}


	public void startPause() {

		this.chronoAtPause.setText("Temps actuel : " + this.game.getChrono());
		this.scoreAtPause.setText(this.scoreLabel.getText());

		this.game.pauseGame();

		this.pausePanel.setVisible(true);
		this.grid.setVisible(false);
		this.top.setVisible(false);

		this.pausePanel.setBackground(Color.GREEN);
		this.pausePanel.setOpaque(true);


		this.pauseButtonPanel.add(this.resumePauseButton);
		this.pauseButtonPanel.add(this.leftGamePauseButton);
		this.pausePanel.add(pauseButtonPanel, BorderLayout.CENTER);

		this.pauseScorePanel.add(this.scoreAtPause);
		this.pauseScorePanel.add(this.chronoAtPause);
		this.pausePanel.add(pauseScorePanel, BorderLayout.NORTH);


		this.fenetre.add(pausePanel, BorderLayout.CENTER);


		this.resumePauseButton.addActionListener(new GameObs(game, this, super.fenetre));
		this.leftGamePauseButton.addActionListener(new GameObs(game, this, super.fenetre));

	}

	public void endPause() {
		this.game.resumeGame();

		this.grid.setVisible(true);
		this.top.setVisible(true);
		this.pausePanel.setVisible(false);

	}
}
