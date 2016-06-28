package juego3;


import java.awt.event.KeyEvent;
import java.util.TimerTask;


public class Jugador extends TimerTask implements Constantes {
	
	public Laberinto laberinto;
    public Celda jugador;
    
    public int direccion, contador=2; //para saber hacia donde se mueve
    public int tiempodormido;
    
    public int aux;
    public int golesj;
    
    public BusquedaAnchura inteligencia;
        
    
    public Jugador(Laberinto laberinto, int velocidad, int tiempodormido) {
        
    	this.tiempodormido=tiempodormido;
    	
    	//jugador=new Celda(0, numeroAleatorio(0,alturaMundoVirtual-1),'J');
        //laberinto.celdas[jugador.x][jugador.y].tipo='J';
       
        
        this.laberinto=laberinto;
        jugador=new Celda(0,0,'J');
        laberinto.celdas[0][0].tipo='J';
        inteligencia=new BusquedaAnchura(laberinto,this);
    } //-->Fin del Constructor

  //Eventos de teclado para movimiento del jugador
    

 
 
  // MOvimientos del jugador  
    public void moverJugadorDerecha(){
    	
    	if(jugador.x < anchuraMundoVirtual-1){
    		if(laberinto.celdas[jugador.x+1][jugador.y].tipo != 'A'){
    			if(laberinto.celdas[jugador.x+1][jugador.y].tipo != 'O'){
    				if(laberinto.celdas[jugador.x+1][jugador.y].tipo == 'P'){
    					if(jugador.x+1 <= anchuraMundoVirtual-1){
    	
    					if(jugador.x+1 == anchuraMundoVirtual-1 || laberinto.celdas[jugador.x+2][jugador.y].tipo == 'O'){
    						laberinto.celdas[jugador.x][jugador.y].tipo='P'; //antes V
    						jugador.x=jugador.x+1;
    						laberinto.celdas[jugador.x][jugador.y].tipo='J';
    						laberinto.celdas[jugador.x][jugador.y].indexSprite=1;
    						
    					}else{
    						
    					laberinto.celdas[jugador.x+2][jugador.y].tipo='P';
						laberinto.celdas[jugador.x+1][jugador.y].tipo='V';}
    					}
    					
    				}else{ //si no es pelota xd
    					laberinto.celdas[jugador.x][jugador.y].tipo='V'; //antes V
    					jugador.x=jugador.x+1;
    					laberinto.celdas[jugador.x][jugador.y].tipo='J';
    					laberinto.celdas[jugador.x][jugador.y].indexSprite=3;
    				}	    
    			}
    		}else{
    			laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
    			jugador.x = jugador.x-1;
    			laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
    		}
    	}
    	
    }
    		
   
     
    public void moverJugadorIzquierda(){	
    	if(jugador.x > 0){
    		if(laberinto.celdas[jugador.x-1][jugador.y].tipo != 'A'){
    			if(laberinto.celdas[jugador.x-1][jugador.y].tipo != 'O'){
    				if(laberinto.celdas[jugador.x-1][jugador.y].tipo == 'P'){
    					if(jugador.x-1 >=0){
    						
    					if(jugador.x-1 == 0 || laberinto.celdas[jugador.x-2][jugador.y].tipo == 'O'){
    						laberinto.celdas[jugador.x][jugador.y].tipo='P'; //antes V
    						jugador.x=jugador.x-1;
    						laberinto.celdas[jugador.x][jugador.y].tipo='J';
    						laberinto.celdas[jugador.x][jugador.y].indexSprite=3;
    					}
    					else{
    						laberinto.celdas[jugador.x-2][jugador.y].tipo='P';
    						laberinto.celdas[jugador.x-1][jugador.y].tipo='V';
    					}
					}
    				}else{ //si no es pelota xd
    					laberinto.celdas[jugador.x][jugador.y].tipo='V'; //antes V
    					jugador.x=jugador.x-1;
    					laberinto.celdas[jugador.x][jugador.y].tipo='J';
    					laberinto.celdas[jugador.x][jugador.y].indexSprite=1;
    				}
    			    
    			}
    		}else{
    			laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
    			jugador.x = jugador.x+1;
    			laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
    		}
    	}
    }
    		
    
    
    public void moverJugadorArriba(){
    	 if (jugador.y > 0 ) {
    		 if(laberinto.celdas[jugador.x][jugador.y-1].tipo != 'A'){
    		 	if ( laberinto.celdas[jugador.x][jugador.y-1].tipo != 'O'){
    		 		if ( laberinto.celdas[jugador.x][jugador.y-1].tipo == 'P'){
    		 			if ( jugador.y-1 >=0 ) {
    		 				
    		 			if(jugador.y-1 == 0 || laberinto.celdas[jugador.x][jugador.y-2].tipo == 'O'){
    						laberinto.celdas[jugador.x][jugador.y].tipo='P'; //antes V
    						jugador.y=jugador.y-1;
    						laberinto.celdas[jugador.x][jugador.y].tipo='J';
    						laberinto.celdas[jugador.x][jugador.y].indexSprite=2;
    					}else{
    						laberinto.celdas[jugador.x][jugador.y-2].tipo='P';
    		 				laberinto.celdas[jugador.x][jugador.y-1].tipo='V';
    		 				
    					}
    					}
    		 		}else{ // si no es pelota
    		 			laberinto.celdas[jugador.x][jugador.y].tipo='V';
    		 			jugador.y=jugador.y-1;
    		 			laberinto.celdas[jugador.x][jugador.y].tipo='J';
    		 			laberinto.celdas[jugador.x][jugador.y].indexSprite=0;
    		 		}
    		 	}
    		 }else{
    		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
    		 		jugador.y = jugador.y+1;
    		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
    		 }
    	 }
    }
    
    public void moverJugadorAbajo(){
    	if (jugador.y >= 0 && jugador.y < alturaMundoVirtual-1 ) {
    		if(laberinto.celdas[jugador.x][jugador.y+1].tipo !='A'){
    			if ( laberinto.celdas[jugador.x][jugador.y+1].tipo != 'O') {
    				if ( laberinto.celdas[jugador.x][jugador.y+1].tipo == 'P') {
    					if ( jugador.y+1 < alturaMundoVirtual ){
    						
    					if(jugador.y+1 == alturaMundoVirtual-1 || laberinto.celdas[jugador.x][jugador.y+2].tipo == 'O'){
    						laberinto.celdas[jugador.x][jugador.y].tipo='P'; //antes V
    						jugador.y=jugador.y+1;
    						laberinto.celdas[jugador.x][jugador.y].tipo='J';
    						laberinto.celdas[jugador.x][jugador.y].indexSprite=0;
    					}else{
    						laberinto.celdas[jugador.x][jugador.y+2].tipo='P';
    						laberinto.celdas[jugador.x][jugador.y+1].tipo='V';
    						
    					}
    					}
    	        	}else { //si no es pelota
    	        		laberinto.celdas[jugador.x][jugador.y].tipo='V';
    	        		jugador.y=jugador.y+1;
    	        		laberinto.celdas[jugador.x][jugador.y].tipo='J';
    	        		laberinto.celdas[jugador.x][jugador.y].indexSprite=2;
    	        	} 
    	        }
    		}else{
		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
		 		jugador.y = jugador.y-1;
		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
    		}
    	}
    }
    
    public void moverJugadorAD(){//arriba derecha (diagonal superior derecha)
    	if(jugador.y > 0 && jugador.x < anchuraMundoVirtual-1){
       		 if(laberinto.celdas[jugador.x+1][jugador.y-1].tipo != 'A'){
       		 	if ( laberinto.celdas[jugador.x+1][jugador.y-1].tipo != 'O'){
       		 		if ( laberinto.celdas[jugador.x+1][jugador.y-1].tipo == 'P'){
       		 			if ( jugador.y-2 >=0 && jugador.x+2 < anchuraMundoVirtual-1) {
       		 				       		 			
       		 			if((jugador.y-1 == 0 && jugador.x+2 == anchuraMundoVirtual-1) || laberinto.celdas[jugador.x+2][jugador.y-2].tipo == 'O'){
       						laberinto.celdas[jugador.x][jugador.y].tipo='P'; //antes V
       						jugador.y=jugador.y-1;
       						jugador.x=jugador.x+1;
       						laberinto.celdas[jugador.x][jugador.y].tipo='J';
       						laberinto.celdas[jugador.x][jugador.y].indexSprite=5;
       					}else{
       						laberinto.celdas[jugador.x+2][jugador.y-2].tipo='P';
       		 				laberinto.celdas[jugador.x+1][jugador.y-1].tipo='V';
	
       					}
       					}
       		 		}else{ // si no es pelota
       		 			laberinto.celdas[jugador.x][jugador.y].tipo='V';
       		 			jugador.y=jugador.y-1;
       		 			jugador.x=jugador.x+1;
       		 			laberinto.celdas[jugador.x][jugador.y].tipo='J';
       		 			laberinto.celdas[jugador.x][jugador.y].indexSprite=7;
       		 		}
       		 	}
       		 }else{
       		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
       		 		jugador.y = jugador.y+1;
       		 		jugador.x= jugador.x-1;
       		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
       		 }
    	}
    }
    
    public void moverJugadorAI(){//arriba izquierda
    	if(jugador.y > 0 && jugador.x > 0){
      		 if(laberinto.celdas[jugador.x-1][jugador.y-1].tipo != 'A'){
        		 	if ( laberinto.celdas[jugador.x-1][jugador.y-1].tipo != 'O'){
        		 		if ( laberinto.celdas[jugador.x-1][jugador.y-1].tipo == 'P'){
        		 			if ( jugador.y-2 >=0 && jugador.x-2 < anchuraMundoVirtual-1) {
        		 				
        		 			if((jugador.y-2 == 0 && jugador.x+2 == anchuraMundoVirtual-1) || laberinto.celdas[jugador.x-2][jugador.y-2].tipo == 'O'){
        						laberinto.celdas[jugador.x][jugador.y].tipo='P'; //antes V
        						jugador.y=jugador.y-1;
        						jugador.x=jugador.x-1;
        						laberinto.celdas[jugador.x][jugador.y].tipo='J';
        						laberinto.celdas[jugador.x][jugador.y].indexSprite=7;
        					}else{
        						laberinto.celdas[jugador.x-2][jugador.y-2].tipo='P';
        		 				laberinto.celdas[jugador.x-1][jugador.y-1].tipo='V';
        		 			}
        					}
        		 		}else{ // si no es pelota
        		 			laberinto.celdas[jugador.x][jugador.y].tipo='V';
        		 			jugador.y=jugador.y-1;
        		 			jugador.x=jugador.x-1;
        		 			laberinto.celdas[jugador.x][jugador.y].tipo='J';
        		 			laberinto.celdas[jugador.x][jugador.y].indexSprite=5;
        		 		}
        		 	}
        		 }else{
        		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
        		 		jugador.y = jugador.y+1;
        		 		jugador.x= jugador.x+1;
        		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
        		 }
     	}
     }
    	
    public void moverJugadorABAI(){ //abajo Izquierda
    	if(jugador.y < alturaMundoVirtual-1 && jugador.x > 0 ){
    		if(laberinto.celdas[jugador.x-1][jugador.y+1].tipo != 'A'){
    		 	if ( laberinto.celdas[jugador.x-1][jugador.y+1].tipo != 'O'){
    		 		if ( laberinto.celdas[jugador.x-1][jugador.y+1].tipo == 'P'){
    		 			if ( jugador.y+2 >=0 && jugador.x-2 < anchuraMundoVirtual-1) {
    		 				
    		 			if((jugador.y+2 == 0 && jugador.x+2 == anchuraMundoVirtual-1) || laberinto.celdas[jugador.x-2][jugador.y+2].tipo == 'O'){
    						laberinto.celdas[jugador.x][jugador.y].tipo='P'; //antes V
    						jugador.y=jugador.y+1;
    						jugador.x=jugador.x-1;
    						laberinto.celdas[jugador.x][jugador.y].tipo='J';
    						laberinto.celdas[jugador.x][jugador.y].indexSprite=7;
    					}else{
    						laberinto.celdas[jugador.x-2][jugador.y+2].tipo='P';
    		 				laberinto.celdas[jugador.x-1][jugador.y+1].tipo='V';
    		 			}
    					}
    		 		}else{ // si no es pelota
    		 			laberinto.celdas[jugador.x][jugador.y].tipo='V';
    		 			jugador.y=jugador.y+1;
    		 			jugador.x=jugador.x-1;
    		 			laberinto.celdas[jugador.x][jugador.y].tipo='J';
    		 			laberinto.celdas[jugador.x][jugador.y].indexSprite=5;
    		 		}
    		 	}	
    		 }else{
    		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
    		 		
    		 		jugador.y = jugador.y-11;
    		 		jugador.x= jugador.x+1;
    		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
    		 }
    	}
     }
    
    public void moverJugadorABAD(){//abajo derecha
    	if( jugador.x < anchuraMundoVirtual-1 && jugador.y < alturaMundoVirtual-1){
    		
    		 if(laberinto.celdas[jugador.x+1][jugador.y+1].tipo != 'A'){
        		 	if ( laberinto.celdas[jugador.x+1][jugador.y+1].tipo != 'O'){
        		 		if ( laberinto.celdas[jugador.x+1][jugador.y+1].tipo == 'P'){
        		 			if ( jugador.y+2 >=0 && jugador.x+2 < anchuraMundoVirtual-1) {
        		 				
        		 			if((jugador.y+2 == 0 && jugador.x+2 == anchuraMundoVirtual-1) || laberinto.celdas[jugador.x+2][jugador.y+2].tipo == 'O'){
        						laberinto.celdas[jugador.x][jugador.y].tipo='P'; //antes V
        						jugador.y=jugador.y+1;
        						jugador.x=jugador.x+1;
        						laberinto.celdas[jugador.x][jugador.y].tipo='J';
        						laberinto.celdas[jugador.x][jugador.y].indexSprite=1;
        					}else{
        						laberinto.celdas[jugador.x+2][jugador.y+2].tipo='P';
        		 				laberinto.celdas[jugador.x+1][jugador.y+1].tipo='V';
        		 			}
        					}
        		 		}else{ // si no es pelota
        		 			laberinto.celdas[jugador.x][jugador.y].tipo='V';
        		 			jugador.y=jugador.y+1;
        		 			jugador.x=jugador.x+1;
        		 			laberinto.celdas[jugador.x][jugador.y].tipo='J';
        		 			laberinto.celdas[jugador.x][jugador.y].indexSprite=3;
        		 		}
        		 	}
        		 }else{
        		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
        		 		jugador.y = jugador.y-1;
        		 		jugador.x= jugador.x-1;
        		 		laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
        		 }
    	}
    }
    
   
    


	@Override
	public void run() {
		
		
		
		
		laberinto.lienzoPadre.repaint();
	}
    
	

}
