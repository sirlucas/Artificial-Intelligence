package juego3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class PanelConfiguracion extends JPanel implements Constantes {
	
	//aqui pondremos todas las configuraciones que ingresara el usuario al juego
	
	public JLabel velocidad;
	public JSlider cambiarVelocidad;
	public PanelDeJuego panelJuego;
	
	
	public PanelConfiguracion(PanelDeJuego panelJuego){
		
		this.panelJuego=panelJuego;
		
		//configuramos la etiqueta
		velocidad=new JLabel("Cambiar velocidad");
		velocidad.setForeground(Color.yellow);
		velocidad.setFont(fuente);
		
		//en lienzo cambiar la velocidad, y lanarlos con la velocidad 1, (adversario,0,1);
		
		cambiarVelocidad=new JSlider(JSlider.VERTICAL, velocidad_maxima, velocidad_minima, velocidad_inicial); //(int min, int max, int value)
		

		cambiarVelocidad.addChangeListener(this::escuchadorSlider);
		cambiarVelocidad.setMajorTickSpacing(100);
		cambiarVelocidad.setPaintTicks(true);
		
		this.setBackground(Color.gray);
		this.setLayout(new BorderLayout());
		
		add(velocidad,BorderLayout.WEST);
		add(cambiarVelocidad,BorderLayout.CENTER);
	}
	
	public void escuchadorSlider(ChangeEvent ev){
		JSlider source= (JSlider)ev.getSource();
		if(!source.getValueIsAdjusting()){
			System.out.println("velocidad"+source.getValue());
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	   
	
	
	
	
	
}
