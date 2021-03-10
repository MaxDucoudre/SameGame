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
    "Mieux vaut vivre un jour comme un lion que cent ans comme un mouton.",
    "Les larmes qui coulent sont amères mais plus amères encore sont celles qui ne coulent pas.",
    "Offrir l'amitié à qui veut l'amour, c'est donner du pain à qui meurt de soif.",
    "On ne peut empêcher le chien d'aboyer, ni le menteur de mentir.",
    "On peux tromper mille fois un homme, mais pas une fois mille ho... non, c'est l'inverse.",
    "Les chaussettes de l'achiduchesse sont-elles sèchent ? Archi-sèche ?",
    "Pierre qui roule n'amasse pas mousse !",
  };


  // Constructeur
    public void MainMenu() {
    }


    // Méthode renvoyant une des citations du tableau de manière aléatoire
    public String randomQuote() {
      int min = 0;
      int max = this.quote.length - 1;
      int range = (max - min) + 1;
      int rand = (int)(Math.random() * range) + min;

      return quote[rand];

    }



}