package juego3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;

/* interfaz constantes para variables de configuracion globales */

public interface Constantes {
	
    public final int anchuraCelda=32; //64
    public final int alturaCelda=32; //64 
    public final int anchuraMundoVirtual=29; //29
    public final int alturaMundoVirtual=19; //19
    
  //Para manejar los tipos de celdas
    public final char JUGADOR='J';
    public final char CAMINO='V';
    public final char OBSTACULO='O';
    public final char ADVERSARIO='A';
    public final char CUEVA='X';
    public final char PELOTA='P';
    
   
    
   //color trasnparente para la cuadricula en el fondo
    public final int ALFA=127;
    public final Color COLORFONDO=new Color(153,217,234,ALFA);
    public final Color TRANSPARENTE = new Color(0,0,0,1);
   
    //ruta global 
    public final String RUTA="file:///"+System.getProperty( "user.dir" );
   
    // constantes para el menu principal
    
    public int FUENTE_SIZE=18;
	public int celda_size=32;
	public int n = 21;
	public int m=21;
	
	 //fuentes
    public final Font fuente = new Font("Time New Roman",Font.BOLD,FUENTE_SIZE);
    
	//obtiene el tamaño de la pantalla
	public Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize(); 
	
	public final int velocidad_maxima=300;
	public final int velocidad_inicial=1000;
	public final int velocidad_minima=2000;
	
	
	
	public String RUTA_DIRECTORIO = System.getProperty("user.dir");
	
	
	
	
    //metodo nuemro aleatoreo
    default int numeroAleatorio(int minimo, int maximo) {
        Random random = new Random();
        int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
        return numero_aleatorio;
        
    }
    
   
    
}