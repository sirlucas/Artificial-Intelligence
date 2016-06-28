package juego3;

/* Version Lienzo.java de la sesion 0.1 */


/* paquetes que utilizaremos */


import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Canvas;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;




/* la clase Lienzo hereda de Canvas */
public class Lienzo extends Canvas implements Constantes{
    
	//para pintar el lienzo
    public Laberinto laberinto;
    public TimerTask Segundos;
    public int distancia;
    public int temp;
   
    
    public Image fondo;
    
  //para implementar el doble buffer
    public Graphics graficoBuffer;
    public Image imagenBuffer;
    
    public String  ordenbusqueda = "VRVRVRAAA";
    

  //Para animacion basica
    public Adversario adversario,adversario2;
    public Timer lanzadorTareas;
    
   // public Tiempo tiempo;
    public Jugador jugador,jugador2;
   
   
    //Constructor
    
    public Lienzo(){
      	laberinto=new Laberinto(this);
    	
        adversario=new Adversario(laberinto); 
        //adversario2=new Adversario(laberinto);
        
        jugador=new Jugador(laberinto, velocidad_inicial, temp);
       // jugador2=new Jugador(laberinto, velocidad_inicial);
       
        
        
        //para fondo de laberinto
    	try {
            fondo = ImageIO.read(new File("img/desierto2.png"));
         } catch (IOException e) {
            System.out.println(e.toString());
         }
        
        //dimensiones del lienzo
        this.setSize(laberinto.anchuraLaberinto,laberinto.alturaLaberinto);
        
     /*   //añadimos el escuchador del raton
        addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent evt) {
              activarCelda(evt);
              repaint(); 
           }
        });*/
        
        
        //añadimos el escuchador del tecaldo
       addKeyListener(new java.awt.event.KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
              laberinto.chequearTecla(e); //antes laberinto
              repaint();
        } });
       
       Celda aux= laberinto.fichaa1; //aux para las fichas azules
       Celda aux2 = laberinto.fichav1; //aux para las fichas verdes
       Celda aux3 = laberinto.fichar1; //aux para las fichas rojas
       	
       for(int i = 0 ; i < ordenbusqueda.length() ; i++){
       
    	   
       switch(ordenbusqueda.charAt(i)){
       
       	case 'A': jugador.inteligencia.destinos.add(new Estado(aux.x, aux.y,'L', null)); 
       				System.out.println(aux.x+" "+aux.y+"...A........");
       				if(aux.equals(laberinto.fichaa2))
       					aux=laberinto.fichaa3;
       				else
       				aux=laberinto.fichaa2;
       				break;
       	case 'V': jugador.inteligencia.destinos.add(new Estado( aux2.x,aux2.y,'K', null));
       				System.out.println(aux2.x+" "+aux2.y+"......V....");
       				if(aux2.equals(laberinto.fichav2))
						aux2=laberinto.fichav3;
       				else
					aux2=laberinto.fichav2;
       				break;
       	case 'R': jugador.inteligencia.destinos.add(new Estado( aux3.x,aux3.y ,'G', null));  
       				System.out.println(aux3.x+" "+aux3.y+".....R.....");			
       				if(aux3.equals(laberinto.fichar2))
       					aux3=laberinto.fichar3;
       				else
       				aux3=laberinto.fichar2;
       				break;
       }
      }  
       /*
       jugador.inteligencia.destinos.add(new Estado(5,5,'N',null));
       jugador.inteligencia.destinos.add(new Estado(14,4,'N',null));
       jugador.inteligencia.destinos.add(new Estado(5,5,'N',null));
       jugador.inteligencia.destinos.add(new Estado(0,0,'N',null));
       jugador.inteligencia.destinos.add(new Estado(5,5,'N',null));*/
       
      // jugador.inteligencia.destinos.add(new Estado(anchuraMundoVirtual-1,alturaMundoVirtual-1,'N', null));
       lanzadorTareas=new Timer();
      // jugador.inteligencia.run();
     
       lanzadorTareas.scheduleAtFixedRate(jugador.inteligencia,0,1);
            // adversario.inteligencia.destinos.add(new Estado(8,10,'N', null));
       //lanzadorTareas.scheduleAtFixedRate(adversario.inteligencia,0,500);
       
      
       
       
    }//fin constructor
    
   

   /* private void activarCelda(MouseEvent evt) {
      for(int i=0; i < anchuraMundoVirtual; i++)
          for ( int j=0 ; j <  alturaMundoVirtual ; j++)
             laberinto.celdas[i][j].celdaSeleccionada(evt.getX(),evt.getY());
    }*/
    
  //Codigo de pintado de la clase Lienzo.java
    @Override
    public void update(Graphics g) {
    	 
        //laberinto.paintComponent(g);
    	//inicialización del buffer gráfico mediante la imagen
         if(graficoBuffer==null){
            imagenBuffer=createImage(this.getWidth(),this.getHeight());
            graficoBuffer=imagenBuffer.getGraphics();
         }
         
         
         //volcamos color de fondo e imagen en el nuevo buffer grafico
         graficoBuffer.setColor(getBackground());
         graficoBuffer.fillRect(0,0,this.getWidth(),this.getHeight());
         graficoBuffer.drawImage(fondo, 0, 0, null);
         laberinto.update(graficoBuffer);
         //pintamos la imagen previa
         g.drawImage(imagenBuffer, 0, 0, null);
         g.setFont(fuente);
         g.drawString("Goles jugador:"+adversario.golesa, 100, 200);
         g.drawString("Goles goles adversario:"+jugador.golesj, 500, 200);
         
         //g.drawString("tiempo de partida:"+tiempo.getSegundos(), 350, 100);
         
         if(laberinto.celdas[1][10].tipo == 'P' ){
        	 adversario.golesa++;
          
          //   g.setFont(fuente);
            // g.drawString("Goles:"+adversario.golesa, 100, 200);
             laberinto.celdas[1][10].tipo='V';
             laberinto.celdas[15][15].tipo='P';
         }
         if(laberinto.celdas[anchuraMundoVirtual-2][10].tipo == 'P'){
        	 jugador.golesj++;
        
           //  g.setFont(fuente);
            // g.drawString("Goles:"+jugador.golesj, 400, 200);
             laberinto.celdas[anchuraMundoVirtual-2][10].tipo='V';
             laberinto.celdas[15][15].tipo='P';
         }
         
         
    }

  
    //metodo llamada la primera vez que se pinta
    @Override
    public void paint(Graphics g) {
    update(g); }

}

	