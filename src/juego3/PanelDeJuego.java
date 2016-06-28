package juego3;

import java.awt.BorderLayout;
import javax.swing.*;

public class PanelDeJuego extends JPanel implements Constantes {

	public Lienzo lienzo;
	
	public PanelDeJuego(){
		
		
		this.setLayout(new BorderLayout());
		
		lienzo=new Lienzo();
		
		lienzo.setFocusable(true);
		lienzo.requestFocus();
		this.add(lienzo);
		
		lienzo.requestFocus();
		this.setSize(lienzo.getWidth(), lienzo.getHeight());

	}

	
}
