import javax.swing.*;
import java.awt.*;


public abstract class MenuFrame {

	public JFrame fenetre;
	private int i = 1;

	public MenuFrame(JFrame fenetre0) {
		System.out.println("--Nouveau menu généré--");
		this.fenetre = fenetre0;
	}


	public void refreshFrame() {
		if (this.i == 1) {
			fenetre.setSize(this.fenetre.getWidth()-1, this.fenetre.getHeight());
			this.i = this.i - 1;
		} else {
			fenetre.setSize(this.fenetre.getWidth()+1, this.fenetre.getHeight());
			this.i = 1;

		}
	}


	public void eraseFrame() {
		this.fenetre.getContentPane().removeAll();
		this.fenetre.repaint();
	}
}