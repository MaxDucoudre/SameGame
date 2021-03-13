/**
* Classe Chrono
* Cette classe permet de faire un chrono qui sera utilisé dans le jeux
*
* @version 1
* @author Max Ducoudré
* @author Loris Schnell
*/

import javax.swing.*;
import java.awt.*;


public class Chrono {

    // Attributs de la class chrono 
    private long timeStart = 0;
    private long timeEnd = 0;
    private long pauseStart = 0;
    private long pauseEnd = 0;
    private long duree = 0;

    private long now = 0;
    private long dureeNow = 0;

    private long dureePause = 0;

    private boolean stop = false;

    // Création d'un thread qui s'occupera d'actualiser le chrono à l'affichage
    private ChronoThread ct;



    public Chrono(GameFrame gameframe0) {
        // ChronoThread a besoin de gameframe pour actualiser le chrono 
        this.ct = new ChronoThread(gameframe0); 
    }


/**
* La méthode "startChrono" lance le chronomètre
*/
    public void startChrono() {
        this.timeStart = System.currentTimeMillis(); // On récupère le temps depuis que le programme est lancé
        System.out.println("Lancement du chrono... " + this.timeStart/1000 + " s"); // affichage à la console 
        // On remet à 0 les attributs
        this.timeEnd = 0;
        this.pauseStart = 0;
        this.pauseEnd = 0;
        this.duree = 0;
        this.dureePause = 0;

        this.stop = false;

        this.ct.start(); // On lance le thread qui vas bouclier tant qu'il est actif pour que le chrono s'actualise

    }

/**
* La méthode "endChrono" termine le chronomètre
*/
    public void endChrono() {
        this.ct.stop(); // On arrête le thread à la fin du chronomètre

        this.timeEnd = System.currentTimeMillis(); // On récupère le temps d'execution du programme
        System.out.println("Fin du chrono... ");

        this.duree = (this.timeEnd - this.timeStart) - (this.pauseEnd - this.pauseStart); // en soustrayant le temps depuis que le programme s'est lancé au début et à la fin du chrono, cela nous donne l'intervalle de temps entre la fin et le début du chrono
        System.out.println("Durée de la partie : " +  toString(this.duree));

        // On remet les attributs à 0
        this.stop = true;

        this.timeStart = 0;
        this.timeEnd = 0;
        this.pauseStart = 0;
        this.pauseEnd = 0;
        this.dureePause = 0;
    }

/**
* La méthode "pauseChrono" permet de mettre en pause le chronomètre en utilisant le même mécanisme que pour startChrono et endChrono
*/
    public void pauseChrono() {
        this.stop = true;

        this.pauseStart = 0;

        this.pauseStart = System.currentTimeMillis();
    }

/**
* La méthode "resumeChrono" permet de reprendre le chrono
*/
    public void resumeChrono() {
        this.pauseEnd = System.currentTimeMillis();

        this.dureePause = this.pauseEnd - this.pauseStart; // La durée de la pause est calculé ici

        this.timeEnd = 0;
        this.stop = false;

    }

/**
* La méthode "getDureeNow" permet de récupérer l'état du chrono, soit la variable "dureeNow"
*/
    public String getDureeNow() {
        if (this.stop == false) {
            this.now = System.currentTimeMillis();
            this.dureeNow = this.now - this.timeStart - (this.pauseEnd - this.pauseStart); // dureeNow est calculé en prenant le temps du chrono et en enlevant la durée de la pause

            this.dureePause = 0;
        }
            //System.out.println(this.toString(this.dureeNow));

        return this.toString(this.dureeNow);
        

    }

/**
* La méthode "toString" renvoie sous forme de "m:ss" les milisecondes qu'on y injecte en paramètre
* @param temps_ms représente le temps en miliseconde qu'on veut rentrer
*/
    public String toString(long temps_ms) {
        String dureeMinSec = "";
        long secondes_total;

        secondes_total = temps_ms/1000; // converti les milisecondes en secondes


        int minutes = (int) ((secondes_total % 3600) / 60); // récupération des minutes
        int secondes = (int) (secondes_total % 60);         // récupération des secondes

        // si les secondes sont inférieures à 10, on ajoute un 0 avant les secondes pour qu'à l'affichage, le chronomètre ne change pas de taille et reste sous forme "m:ss"
        if (secondes < 10) {
            dureeMinSec = minutes + ":0" + secondes;
        } else {
            dureeMinSec = minutes + ":" + secondes;
        }

        return dureeMinSec;

    }
}