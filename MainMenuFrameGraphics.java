public class MainMenuFrameGraphics extends JComponent {

	// Image de fond du menu principal
	private Image image_background = Toolkit.getDefaultToolkit().getImage("./ressources/backgroundjungle.jpg");


	public MainMenuFrameGraphics() {
		super();
	}

 	/**
 	* La méthode paintComponent change l'aspect graphique de la fenetre
 	*
 	*/
 	@Override
 	protected void paintComponent(Graphics pinceau) {
 		Graphics p = pinceau.create();	

 		super.paintComponent(pinceau);
 		pinceau.drawImage(this.image_background, 0, 0, null);

 	}
}