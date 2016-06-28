package juego3;

/*busqueda en anchura para el jugador. se crea una clase homologa para el adversario:
busquedaProfundidad*/
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Laberinto extends JComponent implements Constantes {
	
	public int anchuraLaberinto,alturaLaberinto;//dimensiones del laberinto
    public Celda[][] celdas;//las casillas n x m
    public Lienzo lienzoPadre;

    
     public Celda fichar1, fichar2, fichar3, fichav1, fichav2, fichav3, fichaa1, fichaa2, fichaa3;
     				
    
    //constructor
    public Laberinto(Lienzo lienzoPadre){
    	
    	
    	
    	this.lienzoPadre = lienzoPadre;
    	
    	//ancho y largo del laberinto
        this.anchuraLaberinto=anchuraMundoVirtual*anchuraCelda;
        this.alturaLaberinto=alturaMundoVirtual*alturaCelda;
        this.setSize(anchuraLaberinto,alturaLaberinto);
    	celdas= new Celda[anchuraMundoVirtual][alturaMundoVirtual];
    	//inicializar el array de celdas
    	for(int i=0; i < anchuraMundoVirtual; i++)
    		for ( int j=0 ; j <  alturaMundoVirtual ; j++)
    			celdas[i][j]= new Celda(i+(i*anchuraCelda), j+(j*alturaCelda),'V');
    	
    	
    	//creamos las fichas 
    	
    	fichar1= new Celda(numeroAleatorio(0,anchuraMundoVirtual-1), numeroAleatorio(0, alturaMundoVirtual-1),'G'); 
    	celdas[fichar1.x][fichar1.y].tipo='G';
    	fichar2= new Celda(numeroAleatorio(0,anchuraMundoVirtual-1), numeroAleatorio(0, alturaMundoVirtual-1),'G');
    	celdas[fichar2.x][fichar2.y].tipo='G';
    	fichar3= new Celda(numeroAleatorio(0,anchuraMundoVirtual-1), numeroAleatorio(0, alturaMundoVirtual-1),'G');
    	celdas[fichar3.x][fichar3.y].tipo='G';
    	
    	
    	fichav1= new Celda(numeroAleatorio(0,anchuraMundoVirtual-1), numeroAleatorio(0, alturaMundoVirtual-1),'K'); // ficha verde
    	celdas[fichav1.x][fichav1.y].tipo='K';
    	fichav2= new Celda(numeroAleatorio(0,anchuraMundoVirtual-1), numeroAleatorio(0, alturaMundoVirtual-1),'K'); // ficha verde		
    	celdas[fichav2.x][fichav2.y].tipo='K';
    	fichav3= new Celda(numeroAleatorio(0,anchuraMundoVirtual-1), numeroAleatorio(0, alturaMundoVirtual-1),'K'); // ficha verde
    	celdas[fichav3.x][fichav3.y].tipo='K';
    	
    	/*fichav1= new Celda(0, 1,'K'); // ficha verde
    	celdas[fichav1.x][fichav1.y].tipo='K';
    	fichav2= new Celda(1, 0,'K'); // ficha verde		
    	celdas[fichav2.x][fichav2.y].tipo='K';
    	fichav3= new Celda(1,1,'K'); // ficha verde
    	celdas[fichav3.x][fichav3.y].tipo='K';*/
    	
    	
    	fichaa1 = new Celda(numeroAleatorio(0,anchuraMundoVirtual-1), numeroAleatorio(0, alturaMundoVirtual-1),'L'); // ficha azul
    	celdas[fichaa1.x][fichaa1.y].tipo='L';
    	fichaa2 = new Celda(numeroAleatorio(0,anchuraMundoVirtual-1), numeroAleatorio(0, alturaMundoVirtual-1),'L'); // ficha azul
    	celdas[fichaa2.x][fichaa2.y].tipo='L';
    	fichaa3 = new Celda(numeroAleatorio(0,anchuraMundoVirtual-1), numeroAleatorio(0, alturaMundoVirtual-1),'L'); // ficha azul
    	celdas[fichaa3.x][fichaa3.y].tipo='L';
    	
    	//obstaculos
        
    	/*celdas[10][5].tipo='O';
    	celdas[2][8].tipo='O';
    	celdas[16][9].tipo='O';
    	celdas[4][4].tipo='O';
    	celdas[15][10].tipo='O';
    	celdas[18][0].tipo='O';
    	
    	celdas[15][9].tipo='O';
    	celdas[18][10].tipo='O';
    	
    	//obstaculos
    	celdas[5][5].tipo='O';
       	celdas[5][7].tipo='O';
        celdas[anchuraMundoVirtual-1][alturaMundoVirtual-1].tipo='P';*/
    	
    	
    	
 
 
    }  
    @Override
    public void update(Graphics g) {
    	
 
    	for(int i=0; i < anchuraMundoVirtual ; i++)
    		for ( int j=0 ; j < alturaMundoVirtual; j++)
    			celdas[i][j].paintComponent(g);
    }
    @Override
    public void paintComponent(Graphics g) {
    update(g); }

    
    
 public void chequearTecla(KeyEvent evento){
        

    	switch( evento.getKeyCode() ) {
        case KeyEvent.VK_W: //VL_UP Arriba
           System.out.println("Mover arriba");
           lienzoPadre.jugador.moverJugadorArriba();
        break;
        case KeyEvent.VK_S: //VK_DOWN
        	System.out.println("Mover abajo");
           lienzoPadre.jugador.moverJugadorAbajo();
        break;
        case KeyEvent.VK_A: //VK_LEFT
           System.out.println("Mover izquierda");
           lienzoPadre.jugador.moverJugadorIzquierda();
        break;
        case KeyEvent.VK_D: //VK_R
            System.out.println("Mover derecha");
            lienzoPadre.jugador.moverJugadorDerecha();
        break; 
        case KeyEvent.VK_E: //arriba derecha
            System.out.println("Mover Arriba-derecha(diagonal)");
            lienzoPadre.jugador.moverJugadorAD();
        break;
        case KeyEvent.VK_Q: //arriba izquiera
            System.out.println("Mover Arriba-Izqueirda (diagonal)");
            lienzoPadre.jugador.moverJugadorAI();
        break;
        case KeyEvent.VK_Z: //Abajo Izquierda
            System.out.println("Mover Abajo-Izqierda(Diagonal)");
            lienzoPadre.jugador.moverJugadorABAI();
        break;
        case KeyEvent.VK_C: //VK_R
            System.out.println("Mover derecha");
            lienzoPadre.jugador.moverJugadorABAD();
        break;
    	}
   }
}
