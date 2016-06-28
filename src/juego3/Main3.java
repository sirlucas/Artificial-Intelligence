package juego3;



import java.awt.event.ActionEvent;

/* paquetes que utilizaremos:
-la clase JFrame nos proporciona funcionalidad para crear ventanas*/
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/* clase Main */

public class Main3 {
	
	public static void main (String[]args) {
		
		/*VentanaMenuInicial menuInicial = new VentanaMenuInicial();
		menuInicial.setVisible(true);
		menuInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
		
		VentanaPrincipal vp=new VentanaPrincipal();
        vp.setTitle("Futbolito");
        vp.setLocationRelativeTo(null); //ventana centrada
        vp.setVisible(true); //y visible (obivo xd)
        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vp.setVisible(true);
        
		
		

		
}
}