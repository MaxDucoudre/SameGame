  /**
  * 
  * Affichage du menu principal du jeux
  *
  * @version 1 - 08 march 2021
  * @author Max Ducoudré
  * @author Loris Schnell
  */

  import javax.swing.*;
  import java.awt.*;

  public class GameFrame extends MenuFrame {


    private Game game = new Game();
    private char[][] tab_grid = new char[10][15];
    private JPanel grid = new JPanel();

    private JLabel[][] pions = new JLabel[10][15];

    // 


    // Constructeur
    public GameFrame(JFrame fenetre0, Game game0) {
     super(fenetre0);
     this.game = game0;
     this.game.genereGrid();

     System.out.println("Entrée dans le jeux");

     this.grid.setLayout(new GridLayout(10, 15));

     this.updateGrid();
     super.fenetre.add(this.grid, BorderLayout.CENTER);

     JLabel label_highscore = new JLabel("Record : ");
     JLabel label_score = new JLabel("Score : ");


     super.fenetre.addMouseListener(new GameObs(fenetre, game, this));

   }

   public void updateGrid() {
    int i,j;
    this.tab_grid = this.game.getGrid();
    this.game.afficherGrid();
    System.out.println("Mise à jour visuelle de la grille");



    for (i=0; i<10; i++) {
      for (j=0; j<15; j++) {

        if(tab_grid[i][j] == 'R') {
          this.pions[i][j] = new JLabel("R"); 
          this.pions[i][j].setOpaque(true);
          this.pions[i][j].setBackground(Color.RED);
          this.grid.add(pions[i][j]);
        }

        if(tab_grid[i][j] == 'V') {
          this.pions[i][j] = new JLabel("V"); 
          this.pions[i][j].setOpaque(true);
          this.pions[i][j].setBackground(Color.GREEN);
          this.grid.add(pions[i][j]);
        }

        if(tab_grid[i][j] == 'B') {
          this.pions[i][j] = new JLabel("B"); 
          this.pions[i][j].setOpaque(true);
          this.pions[i][j].setBackground(Color.BLUE);
          this.grid.add(pions[i][j]);

        }
      }
    }

  }

  public JLabel getPion(int i, int j) {
    return this.pions[i][j];
  }

  public int getXPion(int i, int j) {

    return this.pions[i][j].getX();
  }

  public int getYPion(int i, int j) {
    return this.pions[i][j].getY();
  }

  public int getYGrid() {
    return this.grid.getY();
  }

  public int getXGrid() {
    return this.grid.getX();
  }



  public int getWidthPion(int i, int j) {
    return this.pions[i][j].getWidth();
  }

  public int getHeightPion(int i, int j) {
    return this.pions[i][j].getHeight();
  }


}





