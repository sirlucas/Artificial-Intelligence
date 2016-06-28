package juego3;



/* paquetes que utilizaremos */
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/* clase Celda que era de JComponent e implementa Constantes */
public class Celda extends JComponent implements Constantes {
    
	//posicion x e y de la Celda
    public int x;
    public int y;
    public boolean celdaSeleccionada = false;
    public Rectangle rectangulo;
    public char tipo;
    public BufferedImage jugador,obstaculo,camino, adversario,fuego, sprites[], sprites1[], 
    	imagenSprites,imagenSpritesf,imagenSpritesa, sprites2[],ficharoja,fichaverde,fichaazul;
    public int indexSprite;
    
   
    //constructor
    public Celda(int x,int y, char tipo) {
    	this.x=x;
    	this.y=y; 
    	this.tipo=tipo;
    	this.indexSprite=2; //corresponde a usbimagen de frente
        try {
           jugador = ImageIO.read(new File("img/mario.png"));
           obstaculo = ImageIO.read(new File("img/brick.png"));
           camino = ImageIO.read(new File("img/camino.png"));
           adversario = ImageIO.read(new File("img/mega.png"));
           fuego = ImageIO.read(new File("img/fuego.gif"));
           ficharoja = ImageIO.read(new File("img/fr.png"));
           fichaverde = ImageIO.read(new File("img/fv.png"));
           fichaazul = ImageIO.read(new File("img/fa.png"));
           
         
           
           //gestion de sprites
           
           
           //cargo la imagen de grupo de imagenes
           imagenSprites = ImageIO.read(new File("img/spritesSoldier.png")); //para el jugador
        //   imagenSpritesa= ImageIO.read(new File("img/adversario.png")); //para el adv
        //   imagenSpritesf = ImageIO.read(new File("img/fuego.gif")); //para el fuego
           
           //creo una array de 4 x 9 para el jugador
           sprites = new BufferedImage[4 * 9];
           //creo un array de x * x para el adversario
        //   sprites1 = new BufferedImage[9 * 9];
           //cro un array de x * x para el fuego
        //   sprites2 = new BufferedImage[9 * 9];
           
           //lo recorro separando las imagenes
           for(int i = 0; i < 9; i++) {
              for(int j = 0; j < 4; j++) {
                 sprites[(i * 4) + j] = imagenSprites.getSubimage(i * anchuraCelda, j * alturaCelda, celda_size, celda_size);
              } 
           } 	
        } catch (IOException e) {
           System.out.println(e.toString());
        }
    	
    }
    
    //metodo para dibujar celda, hace uso de drawRect
    @Override
   public void update(Graphics g) {
    	
            switch(tipo) {
               case 'J': g.drawImage(sprites[indexSprite],x,y, null); break;
               case 'O': g.drawImage(obstaculo,x,y, this); break;
               case 'V': g.setColor(COLORFONDO);
             // g.fillRect(x, y,anchuraCelda,alturaCelda);
               	break;
               case 'A': g.drawImage(adversario,x,y, this); break;
               case 'P': g.drawImage(fuego,x,y, this);break;
               case 'G': g.drawImage(ficharoja, x, y, this); break;
               case 'K': g.drawImage(fichaverde, x, y, this); break;
               case 'L': g.drawImage(fichaazul, x, y, this); break;
               
            }
    	
            g.drawRect(x,y,anchuraCelda,alturaCelda);
    	
    	//si la celda esta seleccionada entonces doy color a la celda
    	   if ( celdaSeleccionada ) {
    	      g.drawRect(x,y,anchuraCelda,alturaCelda);
    	      g.fillRect(x,y,anchuraCelda,alturaCelda);
    	      //g.fillOval(x, y, anchuraCelda, alturaCelda);
    	   //si no entonces la pinta sin color
    	   }else {
    	    //  g.drawRect(x,y,anchuraCelda,alturaCelda);
    	   }
    }
    
    @Override
    public void paintComponent(Graphics g) {
    update(g); }
    
    
//si el click esta sobre la celda
  public boolean celdaSeleccionada(int xp,int yp) {
	  Rectangle r=new Rectangle(x,y,anchuraCelda,alturaCelda);
  	return  r.contains(new Point(xp,yp));
  }

}
