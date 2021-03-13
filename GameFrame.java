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

      private boolean endGameStatus = false;


      public String resumeString = super.langue.getResumeString();
      public String mainMenuString = super.langue.getMainMenuString();
      public String abandonString = super.langue.getAbandonString();
      public String pauseString = super.langue.getPauseString();
      public String restartString = super.langue.getRestartString();

      private JLabel scoreLabel = new JLabel(super.langue.getScoreString() + " : 0");
      private JLabel hightScoreLabel = new JLabel(super.langue.getHightScoreString() + " : Inexistant");
      private JLabel scoreGetLabel = new JLabel();
      private JLabel multiplicatorLabel = new JLabel();

      private JLabel timerLabel = new JLabel(super.langue.getTimeString() + " : 0:00");

      public JButton pauseButton;
      public JButton resumePauseButton = new JButton(this.resumeString);
      public JButton leftGamePauseButton = new JButton(this.abandonString);
      public boolean pauseStatus = false;

      private JPanel pausePanel = new JPanel();

      private JPanel pauseButtonPanel = new JPanel();
      private JPanel pauseScorePanel = new JPanel();
      private JLabel chronoAtPause = new JLabel();
      private JLabel scoreAtPause = new JLabel();



      public JPanel endGamePanel = new JPanel();






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

       this.hightScoreLabel.setOpaque(true);
       this.hightScoreLabel.setBackground(Color.CYAN);
       this.top.add(this.hightScoreLabel);

       this.timerLabel.setOpaque(true);
       this.timerLabel.setBackground(Color.CYAN);
       this.top.add(this.timerLabel);


       this.scoreGetLabel.setOpaque(true);
       this.top.add(this.scoreGetLabel);

       this.multiplicatorLabel.setOpaque(true);
       this.top.add(this.multiplicatorLabel);

       this.pauseButton = new JButton(this.pauseString);
       this.top.add(this.pauseButton);

       super.fenetre.add(this.top, BorderLayout.NORTH);


       super.fenetre.addMouseListener(new GameObs(game, this, super.fenetre));
       super.fenetre.addMouseMotionListener(new GameObs(game, this, super.fenetre));


       this.pauseButton.addActionListener(new GameObs(game, this, super.fenetre));
       pausePanel.setLayout(new BorderLayout());

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



    public void setScoreLabel() {
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
    this.timerLabel.setText(super.langue.getTimeString() + " : " + this.game.getChrono());
  }


  public void endGameFrame() {
    JLabel endScoreLabel = new JLabel(super.langue.getFinalScoreString() + " : " + this.game.scoreTotal());
    JLabel endAncienRecordLabel = new JLabel();

    JLabel endChronoLabel = new JLabel(super.langue.getTimeString() + " : "+ this.game.getChrono());
    JPanel endGameLabelPanel = new JPanel();

    JButton endMainMenuButton = new JButton(this.mainMenuString);
    JButton endRestartButton = new JButton(this.restartString);
    JPanel endGameButtonPanel = new JPanel();

    this.endGameStatus = true;
    this.top.setVisible(false);

    
    endGameLabelPanel.add(endScoreLabel);
    endGameLabelPanel.add(endChronoLabel);

    endGameButtonPanel.add(endMainMenuButton);
    endGameButtonPanel.add(endRestartButton);

    this.endGamePanel.setLayout(new BorderLayout());

    this.endGamePanel.add(endGameLabelPanel, BorderLayout.NORTH);
    this.endGamePanel.add(endGameButtonPanel, BorderLayout.CENTER);

    this.endGamePanel.setVisible(true);
    this.fenetre.add(this.endGamePanel, BorderLayout.CENTER);

    endMainMenuButton.addActionListener(new GameObs(game, this, super.fenetre));
    endRestartButton.addActionListener(new GameObs(game, this, super.fenetre));
  }

  public boolean getEndGameStatus() {
    return this.endGameStatus;
  }


  public void startPause() {
    this.pauseStatus = true;

    this.chronoAtPause.setText(super.langue.getTimeString() + " : " + this.game.getChrono());
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

    this.pauseStatus = false;

  }

  public boolean getPauseStatus() {
    return this.pauseStatus;
  }



}





