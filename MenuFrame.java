import javax.swing.*;
import java.awt.*;


public abstract class MenuFrame {

	public JFrame fenetre;

	public MenuFrame(JFrame fenetre0) {
		 System.out.println("Nouveau menu généré");
		this.fenetre = fenetre0;
	}


	public void refreshFrame() {
		fenetre.setSize(this.fenetre.getWidth()-1, this.fenetre.getHeight());
	}


	public void eraseFrame() {
		this.fenetre.getContentPane().removeAll();
		this.fenetre.repaint();
	}
}