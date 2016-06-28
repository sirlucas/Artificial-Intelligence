package juego3;

/* paquetes que utilizaremos:
-la clase JFrame nos proporciona funcionalidad para crear ventanas
-la clase BorderLayout nos proporciona funcionalidad para distribuir los
 elemtnos graficos */


import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

/* clase VetanaPrincipal hereda de JFrame para obtener funcionalidad
de creacion de ventanas graficas*/

public class VentanaPrincipal extends JFrame implements Constantes{
 
 
 public JSplitPane panelSeparador; //panel separador
 public PanelDeJuego panelJuego; //panel del juego, 
 public PanelConfiguracion panelConfiguracion;
 
 //para los hilos de musica
 public HiloMusica player;
 
 
 //constructor
 public VentanaPrincipal() {
     
	 
     player=new HiloMusica(RUTA+"/musica/gravity.wav",2);
     player.run();
     
	 
     this.panelSeparador =new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	 this.panelSeparador.setOneTouchExpandable(true);
	 
	 System.out.println("si aparece esto, el panel se debe haber creado...");
	 System.out.println("new panel de juego y panelconfig");
	 
	 this.panelJuego= new PanelDeJuego();
	 this.panelConfiguracion=new PanelConfiguracion(panelJuego);
	
	 //setea al lado Izquierdo el panel del juego
	 this.panelSeparador.setLeftComponent(panelJuego);
	 //setea a la derecha el panel de configuracion
	 this.panelSeparador.setRightComponent(panelConfiguracion);
	 //posicion donde aparece la barra de separacion y el ancho.
	 this.panelSeparador.setDividerLocation(panelJuego.getWidth()+20);
	 this.panelSeparador.setDividerSize(10);
	 
	//configurador de elementos graficos
	 getContentPane().setLayout(new BorderLayout()); 
	 //añade el separador en la patte central
	 getContentPane().add(panelSeparador, BorderLayout.CENTER);
	 this.setSize(SCREEN_SIZE.width-100, SCREEN_SIZE.width-100);
	 
 } 
}