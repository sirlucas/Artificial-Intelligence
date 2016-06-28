package juego3;
import javax.swing.JFrame;

public class VentanaMenuInicial extends JFrame {
	
	public PanelMenuInicial panel;
	
	public VentanaMenuInicial(){
		panel= new PanelMenuInicial(this);
		
		this.getContentPane().add(panel);
		this.setSize(panel.getSize());
		
	}

}
