  import javax.swing.*;
  import java.awt.*;


  public class Chrono {

    private long timeStart = 0;
    private long timeEnd = 0;
    private long pauseStart = 0;
    private long pauseEnd = 0;
    private long duree = 0;

    private long now = 0;
    private long dureeNow = 0;


    private boolean stop = false;

    private ChronoThread ct;



    public Chrono(GameFrame gameframe0) {
        this.ct  = new ChronoThread(gameframe0);


    }

    public void startChrono() {
        this.timeStart = System.currentTimeMillis();
        System.out.println("Lancement du chrono... " + this.timeStart);
        this.pauseStart = 0;
        this.ct.start();
    }

    public void endChrono() {
        this.timeEnd = System.currentTimeMillis();
        System.out.println("Fin du chrono... " + this.timeEnd + " ms");

        this.duree = (this.timeEnd - this.timeStart) /*- (this.pauseEnd - this.pauseStart)*/;
        System.out.println("Durée :" + this.duree + " ms");

        this.stop = true;

        this.timeStart = 0;
        this.timeEnd = 0;
        this.pauseStart = 0;
        this.pauseEnd = 0;

        this.ct.stop();
        

    }

    public String getDureeNow() {
        if (this.stop == false) {
            this.now = System.currentTimeMillis();
            this.dureeNow = (this.now - this.timeStart) /*- (this.pauseEnd - this.pauseStart) */;
            return this.toString(this.dureeNow);
        } else {
            return this.toString(this.duree);
        }

    }


    public String toString(long temps_ms) {
        String dureeMinSec = "";
        long secondes_total;

        secondes_total = temps_ms/1000;


        int minutes = (int) ((secondes_total % 3600) / 60);
        int secondes = (int) (secondes_total % 60);

        if (secondes < 10) {
            dureeMinSec = minutes + ":0" + secondes;
        } else {
            dureeMinSec = minutes + ":" + secondes;
        }

        return dureeMinSec;

    }
}