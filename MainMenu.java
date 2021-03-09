/**
* Classe Modèle : MainMenu
* Menu principal du jeux
*
* @version 1 - 08 march 2021
* @author Max Ducoudré
* @author Loris Schnell
*/

import java.lang.Math; 


public class MainMenu {

// Tableau de chaîne de caractère comprenant les différentes citations
  private String[] quote = {
    "Citation du jour - 1",
    "Citation du jour - 2",
    "Citation du jour - 3",
  };

  // Constructeur
    public void MainMenu() {
    }

/*
    // Méthode renvoyant une des citations du tableau de manière aléatoire
    public String randomQuote() {
      int min = 1;
      int max = this.quote.length;
      int range = (max - min) + 1;
      int rand = (int)(Math.random() * range) + min;

      return quote[rand];

    }

*/

}