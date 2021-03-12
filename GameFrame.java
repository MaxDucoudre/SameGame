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


    private Game game;
    private char[][] tab_grid = new char[10][15];
    public JPanel grid = new JPanel();
    private JPanel top = new JPanel();

    private JLabel[][] pions = new JLabel[10][15];

    private JLabel scoreLabel = new JLabel("Score : 0");
    private JLabel hightScoreLabel = new JLabel("Record : Inexistant");
    private JLabel scoreGetLabel = new JLabel();
    private JLabel multiplicatorLabel = new JLabel();

    private JLabel timerLabel = new JLabel("Chrono : 0:00");

    private JButton pause = new JButton("Pause");

    // 


    // Constructeur
    public GameFrame(JFrame fenetre0) {
     super(fenetre0);
     this.game = new Game(this);

     this.game.genereGrid();

     System.out.println("Entrée dans le jeux");
     this.grid.setLayout(new GridLayout(10, 15));

     this.updateGrid();
     super.fenetre.add(this.grid, BorderLayout.CENTER);


     this.scoreLabel.setOpaque(true);
     this.scoreLabel.setBackground(Color.CYAN);
     this.top.add(this.scoreLabel);

     this.timerLabel.setOpaque(true);
     this.timerLabel.setBackground(Color.CYAN);
     this.top.add(this.timerLabel);



     this.hightScoreLabel.setOpaque(true);
     this.hightScoreLabel.setBackground(Color.CYAN);
     this.top.add(this.hightScoreLabel);

     this.scoreGetLabel.setOpaque(true);
     this.top.add(this.scoreGetLabel);

     this.multiplicatorLabel.setOpaque(true);
     this.top.add(this.multiplicatorLabel);

     this.top.add(this.pause);

     super.fenetre.add(this.top, BorderLayout.NORTH);


     super.fenetre.addMouseListener(new GameObs(fenetre, game, this));
     super.fenetre.addMouseMotionListener(new GameObs(fenetre, game, this));

   }

   public void updateGrid() {
    int i,j;
    this.tab_grid = this.game.getGrid();
    this.game.afficherGrid();
    System.out.println("Mise en forme visuelle de la grille...");


    for (i=0; i<10; i++) {
      for (j=0; j<15; j++) {

        if(this.tab_grid[i][j] == 'R') {
          this.pions[i][j] = new JLabel(); 
          this.pions[i][j].setOpaque(true);
          this.pions[i][j].setBackground(Color.RED);
          this.grid.add(pions[i][j]);
        }

        if(this.tab_grid[i][j] == 'V') {
          this.pions[i][j] = new JLabel(); 
          this.pions[i][j].setOpaque(true);
          this.pions[i][j].setBackground(Color.GREEN);
          this.grid.add(pions[i][j]);
        }

        if(this.tab_grid[i][j] == 'B') {
          this.pions[i][j] = new JLabel(); 
          this.pions[i][j].setOpaque(true);
          this.pions[i][j].setBackground(Color.BLUE);
          this.grid.add(pions[i][j]);

        }
      }
    }
  }


  public void changeBackgroundPion(Color color, boolean[][] tab_group_hover, int i, int j) {
    for (i=0; i<10; i++) {
      for (j=0; j<15; j++) {
        if(tab_group_hover[i][j] == true) {
          this.pions[i][j].setBackground(color);
        } else {
          if(tab_grid[i][j] == 'R') {
            this.pions[i][j].setBackground(Color.RED);
          }
          if(tab_grid[i][j] == 'V') {
            this.pions[i][j].setBackground(Color.GREEN);
          }
          if(tab_grid[i][j] == 'B') { 
            this.pions[i][j].setBackground(Color.BLUE);
          }
          if(tab_grid[i][j] == 'D') { 
            this.pions[i][j].setBackground(Color.WHITE);
          }
        }
      }
    }
  }

  public void resetBackgroundPion() {
    for (int i=0; i<10; i++) {
      for (int j=0; j<15; j++) {
        if(tab_grid[i][j] == 'R') {
          this.pions[i][j].setBackground(Color.RED);
        }
        if(tab_grid[i][j] == 'V') {
          this.pions[i][j].setBackground(Color.GREEN);
        }
        if(tab_grid[i][j] == 'B') { 
          this.pions[i][j].setBackground(Color.BLUE);
        }
        if(tab_grid[i][j] == 'D') { 
          this.pions[i][j].setBackground(Color.WHITE);
        }

      }
    }
  }
  
  public int getXPion(int i, int j) {
    return this.pions[i][j].getX();
  }

  public int getYPion(int i, int j) {
    return this.pions[i][j].getY();
  }

  public int getWidthPion(int i, int j) {
    return this.pions[i][j].getWidth();
  }

  public int getHeightPion(int i, int j) {
    return this.pions[i][j].getHeight();
  }



  public void scoreLabel() {
    this.scoreLabel.setText("Score : " + this.game.scoreTotal());

    if(this.game.scoreCalcul() != 0) {
     this.scoreGetLabel.setVisible(true);
     this.scoreGetLabel.setBackground(Color.CYAN);
     this.scoreGetLabel.setText("+" + this.game.scoreCalcul() + " points !" );
   } else {
     this.scoreGetLabel.setVisible(false);
   }

   if(this.game.sizeGroupPion() > 2) {
     this.multiplicatorLabel.setVisible(true);
     this.multiplicatorLabel.setBackground(Color.CYAN);
     this.multiplicatorLabel.setText("BONUS X" + this.game.sizeGroupPion());
   } else {
     this.multiplicatorLabel.setVisible(false);
   }
 }

 public void setChrono() {
  this.timerLabel.setText("Chrono : " + this.game.getChrono());

}







}





