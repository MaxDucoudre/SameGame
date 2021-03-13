    /**
    * Classe Vue : GameFrame gère l'affichage de l'interface du jeux
    * Affichage du menu principal du jeux
    *
    * @version 1 
    * @author Max Ducoudré
    * @author Loris Schnell
    */

    import javax.swing.*;
    import java.awt.*;

    public class GameFrame extends MenuFrame {

      // Initialisation des attributs
      private Game game; // game vas saisir les informations de la classe modèle
      private char[][] tab_grid = new char[10][15];
      public JPanel grid = new JPanel(); // JPanel contenant la grille
      private JPanel top = new JPanel(); // JPanel contenant les informations de la partie

      private JLabel[][] pions = new JLabel[10][15]; // tableau de JLabel contenant l'affichage des pions 

      private boolean endGameStatus = false; // Attribut disant si la partie est finie ou non

      // initialisation d'attributs contenant les chaines de caractère des nom des boutons
      // "langue" est un attribut de type "Langue" de la classe parent MenuFrame qui permet de récupérer les noms affichés
      public String resumeString   = super.langue.getResumeString();
      public String mainMenuString = super.langue.getMainMenuString();
      public String abandonString  = super.langue.getAbandonString();
      public String pauseString    = super.langue.getPauseString();
      public String restartString  = super.langue.getRestartString();

      // attributs JLabel informant de l'état de la partie en cours
      private JLabel scoreLabel = new JLabel(super.langue.getScoreString() + " : 0"); // le score
      private JLabel hightScoreLabel = new JLabel(super.langue.getHightScoreString() + " : Inexistant"); // le record
      private JLabel scoreGetLabel = new JLabel(); // les points gagnés
      private JLabel multiplicatorLabel = new JLabel(); // le nombre de pions détruits
      private JLabel timerLabel = new JLabel(super.langue.getTimeString() + " : 0:00"); // le chrono

      
      public JButton pauseButton; // bouton Pause durant la partie
      // attributs JButton du menu pause
      public JButton resumePauseButton = new JButton(this.resumeString);
      public JButton leftGamePauseButton = new JButton(this.abandonString);
      public boolean pauseStatus = false; // état du menu pause (si actif ou non), par défaut en false

      private JLabel chronoAtPause = new JLabel(); // temps sur le menu pause
      private JLabel scoreAtPause = new JLabel();  // score sur le menu pause

      private JPanel pauseButtonPanel = new JPanel();
      private JPanel pauseScorePanel = new JPanel();
      private JPanel pausePanel = new JPanel();

      // Panel qui s'affiche à la fin de la partie
      public JPanel endGamePanel = new JPanel();



      // Constructeur
      public GameFrame(JFrame fenetre0) {
       super(fenetre0);

       // observateur rendant interactif toute la fenêtre

       this.game = new Game(this);

       this.game.genereGrid(); // génère la grille

       System.out.println("Entrée dans le jeux");
       this.grid.setLayout(new GridLayout(10, 15)); // on met le JPanel de la grille sous forme de GridLayout 

       this.updateGrid(); // Remplissage du JPanel "grid"
       super.fenetre.add(this.grid, BorderLayout.CENTER); 

       // Informations sur la partie
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
       // fin informations sur la partie


       super.fenetre.addMouseListener(new GameObs(game, this, super.fenetre)); // la fenetre devient interactif au clique de la souris
       super.fenetre.addMouseMotionListener(new GameObs(game, this, super.fenetre)); // la fenetre devient interactif au survol de la souris
       this.pauseButton.addActionListener(new GameObs(game, this, super.fenetre)); // les boutons de la fenêtre deviennent interactifs
     }

/**
* La méthode "updateGrid" permet de mettre à jour l'affichage de la grille en prenant les informations de la classe modèle "Game"
*/
public void updateGrid() {
  int i,j;
      this.tab_grid = this.game.getGrid(); // on récupère le tableau de char comprenant la position des pions
      this.game.afficherGrid();
      System.out.println("Mise en forme visuelle de la grille...");

      // On remplie de JLabel représentant les pions le JPanel grid
      // On traverse donc toutes les cases du tableau via cette double boucle imbriquée
      for (i=0; i<10; i++) {
        for (j=0; j<15; j++) {

          if(this.tab_grid[i][j] == 'R') { // si il y a 'R' dans la case, alors on met à jour le visuel de la case
          this.pions[i][j] = new JLabel(); 
          this.pions[i][j].setOpaque(true);
          this.pions[i][j].setBackground(Color.RED);
          this.grid.add(this.pions[i][j]);
        }

          if(this.tab_grid[i][j] == 'V') { // si il y a 'V' dans la case, alors on met à jour le visuel de la case
          this.pions[i][j] = new JLabel(); 
          this.pions[i][j].setOpaque(true);
          this.pions[i][j].setBackground(Color.GREEN);
          this.grid.add(this.pions[i][j]);
        }

          if(this.tab_grid[i][j] == 'B') { // si il y a 'B' dans la case, alors on met à jour le visuel de la case
          this.pions[i][j] = new JLabel(); 
          this.pions[i][j].setOpaque(true);
          this.pions[i][j].setBackground(Color.BLUE);
          this.grid.add(this.pions[i][j]);

        }
      }
    }
  }

/**
* La méthode "changeBackgroundPion" permet de changer la couleur du groupe qu'on survole avec la souris
* @param color représente la couleur de la surbrillance
* @param tab_group_hover représente le groupe de la case qu'on survole à la souris
* @param i représente la colone
* @param j représente la ligne
*/
public void changeBackgroundPion(Color color, boolean[][] tab_group_hover, int i, int j) {
  for (i=0; i<10; i++) {
    for (j=0; j<15; j++) {
          if(tab_group_hover[i][j] == true) { // si le groupe est survolé
            this.pions[i][j].setBackground(color); // alors on lui applique une couleur
          } else {
            // Sinon on remet les couleurs par défaut
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

/*
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
    */


/**
* La méthode "getXPion" permet de récupérer la coordonée X du JPanel d'un pion
* @param i représente la colone du pion
* @param j représente la ligne du pion
*/    
public int getXPion(int i, int j) {
  return this.pions[i][j].getX();
}

/**
* La méthode "getYPion" permet de récupérer la coordonée Y du JPanel d'un pion
* @param i représente la colone du pion
* @param j représente la ligne du pion
*/    
public int getYPion(int i, int j) {
  return this.pions[i][j].getY();
}

/**
* La méthode "getWidthPion" permet de récupérer la largeur en pixel d'un pion
* @param i représente la colone du pion
* @param j représente la ligne du pion
*/  
public int getWidthPion(int i, int j) {
  return this.pions[i][j].getWidth();
}

/**
* La méthode "getHeightPion" permet de récupérer la longueur en pixel d'un pion
* @param i représente la colone du pion
* @param j représente la ligne du pion
*/  
public int getHeightPion(int i, int j) {
  return this.pions[i][j].getHeight();
}


/**
* La méthode "setScoreLabel" permet de mettre à jour les informations sur la partie
*/  
public void setScoreLabel() {
  // Met à jour l'affichage du score
  this.scoreLabel.setText("Score : " + this.game.scoreTotal());

  if(this.game.scoreCalcul() != 0) { // si le score gagné est supérieur à 0, alors
   this.scoreGetLabel.setVisible(true); // on affiche le score gagné
   this.scoreGetLabel.setBackground(Color.CYAN); 
   this.scoreGetLabel.setText("+" + this.game.scoreCalcul() + " points !" );
 } else {
   this.scoreGetLabel.setVisible(false); // sinon on le masque
 }

 if(this.game.sizeGroupPion() > 2) { // si la taille d'un groupe détruit est supérieure à 2
   this.multiplicatorLabel.setVisible(true); // alors on affiche le nombre de case détruites
   this.multiplicatorLabel.setBackground(Color.CYAN);
   this.multiplicatorLabel.setText("BONUS X" + this.game.sizeGroupPion());
 } else {
   this.multiplicatorLabel.setVisible(false); // sinon on le cache
 }
}

/**
* La méthode "setChrono" permet de mettre à jour l'affichage du chronomètre
*/  
public void setChrono() {
  this.timerLabel.setText(super.langue.getTimeString() + " : " + this.game.getChrono());
}

/**
* La méthode "endGameFrame" se lance à la fin de la partie pour afficher une nouvelle interface
*/ 
public void endGameFrame() {
  JLabel endScoreLabel = new JLabel(super.langue.getFinalScoreString() + " : " + this.game.scoreTotal()); // score de la partie
  JLabel endAncienRecordLabel = new JLabel(); // ancien record

  JLabel endChronoLabel = new JLabel(super.langue.getTimeString() + " : "+ this.game.getChrono());
  JPanel endGameLabelPanel = new JPanel();


  JButton endMainMenuButton = new JButton(this.mainMenuString);
  JButton endRestartButton = new JButton(this.restartString);
  JPanel endGameButtonPanel = new JPanel();


  this.endGameStatus = true; // le status de la partie change 
  this.top.setVisible(false); // On cache les informations de la partie

  // JLabel sur le menu de fin
  endGameLabelPanel.add(endScoreLabel); // étiquette affichant le score
  endGameLabelPanel.add(endChronoLabel); // étiquette affichant le temps final

  // JButton sur le menu de fin
  endGameButtonPanel.add(endMainMenuButton); // bouton pour retourner au menu principal
  endGameButtonPanel.add(endRestartButton); // bouton pour relancer la partie

  this.endGamePanel.setLayout(new BorderLayout());

  this.endGamePanel.add(endGameLabelPanel, BorderLayout.NORTH);
  this.endGamePanel.add(endGameButtonPanel, BorderLayout.CENTER);

  this.endGamePanel.setVisible(true);
  this.fenetre.add(this.endGamePanel, BorderLayout.CENTER);

  // On rend les deux boutons interactifs
  endMainMenuButton.addActionListener(new GameObs(game, this, super.fenetre)); 
  endRestartButton.addActionListener(new GameObs(game, this, super.fenetre));
}

/**
* La méthode "getEndGameStatus" renvoie un booléan disant si la partie est finie ou non
*/ 
public boolean getEndGameStatus() {
  return this.endGameStatus;
}

/**
* La méthode "startPause" permet de mettre en pause la partie
*/ 
public void startPause() {
  this.pauseStatus = true; // attribut disant si la partie se met en pause ou non passe en "true"
  this.pausePanel.setLayout(new BorderLayout());

  this.chronoAtPause.setText(super.langue.getTimeString() + " : " + this.game.getChrono());
  this.scoreAtPause.setText(this.scoreLabel.getText());

  this.game.pauseGame(); // on met sur pause le chronomètre

  this.pausePanel.setVisible(true); // on affiche le JPanel de la pause
  this.grid.setVisible(false); // on cache la grille
  this.top.setVisible(false); // on cache les informations de la partie

  this.pausePanel.setBackground(Color.GREEN);
  this.pausePanel.setOpaque(true);


  this.pauseButtonPanel.add(this.resumePauseButton);
  this.pauseButtonPanel.add(this.leftGamePauseButton);
  this.pausePanel.add(pauseButtonPanel, BorderLayout.CENTER);

  this.pauseScorePanel.add(this.scoreAtPause);
  this.pauseScorePanel.add(this.chronoAtPause);
  this.pausePanel.add(pauseScorePanel, BorderLayout.NORTH);


  this.fenetre.add(pausePanel, BorderLayout.CENTER);

  // On rend interactif les deux boutons
  this.resumePauseButton.addActionListener(new GameObs(game, this, super.fenetre));
  this.leftGamePauseButton.addActionListener(new GameObs(game, this, super.fenetre));

}

/**
* La méthode "endPause" permet de reprendre la partie en cours
*/ 
public void endPause() {
  this.game.resumeGame(); // on relance le chronomètre

  this.grid.setVisible(true); // on réaffiche la grille
  this.top.setVisible(true); // on réaffiche les informations de la partie
  this.pausePanel.setVisible(false);// on recache le menu pause

  this.pauseStatus = false; // attribut disant si la partie se met en pause ou non passe en "false"

}

/**
* La méthode "getPauseStatus" renvoie un booléen sur le fait que la partie soit en pause ou non
*/ 
public boolean getPauseStatus() {
  return this.pauseStatus;
}



}





