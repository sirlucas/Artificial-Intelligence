package juego3;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TimerTask;

public class BusquedaAnchura extends TimerTask implements Constantes {


	public Laberinto laberinto;
    public Queue<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    public int index_pasos;
    public Estado inicial;
    public Estado objetivo;
    public Estado temp;
    public boolean exito;

    public int flag;

    public int x, tiempo = 500;
    
    //para tener un busqueda anchura multiobjetivo
   public Jugador jugador;
   public ArrayList<Estado> destinos;
   public boolean parar;
    
    public BusquedaAnchura(Laberinto laberinto, Jugador jugador) {
        
    	this.laberinto=laberinto;
        colaEstados=new PriorityQueue<>();
        historial=new ArrayList<>();
        pasos=new ArrayList<>();
        destinos=new ArrayList<>();
        index_pasos=0;
        exito=false;
        this.jugador=jugador;
        parar=false;
    }
    
    public boolean buscar(Estado inicial,Estado objetivo) {
        
    	this.inicial=inicial;
        this.objetivo=objetivo;
        inicial.prioridad=distancia(inicial.x,inicial.y,objetivo.x, objetivo.y);
        index_pasos=0;
        colaEstados.add(inicial);
        historial.add(inicial);
        exito=false;
        if ( inicial.equals(objetivo)) exito=true;
        
        while ( !colaEstados.isEmpty() && !exito ){
          
        	
        	temp=colaEstados.poll();
        //	System.out.println("temp........."+temp);
        	if(!destinos.contains(temp)){
        	
        		 moverArriba(temp);
        		 moverAD(temp);  //arriba derecha
        		 moverAI(temp); //arriba izquierda
        		 moverAbajo(temp);
        		 moverABAD(temp); //abajo derecha
        		 moverABAI(temp); //abajo izquierda  	
        		 moverIzquierda(temp);
        		 moverDerecha(temp); 
        		 
           }
        	
        }
        if ( exito ) {
            System.out.println("Ruta calculada");
            this.calcularRuta();
            return true;
        }
        else {
            System.out.println("La ruta no pudo calcularse");
            return false;
        }
}
    
    private void moverArriba(Estado e) {
    	   if ( e.y > 0 ) {
    	      if ( laberinto.celdas[e.x][e.y-1].tipo != 'O' ) {
    	         Estado arriba=new Estado(e.x,e.y-1,'U',e);
    	         arriba.prioridad=distancia(arriba.x,arriba.y, objetivo.x,objetivo.y);
    	         if ( !historial.contains(arriba)) {
    	            colaEstados.add(arriba);
    	            historial.add(arriba);
    	            if ( arriba.equals(objetivo)) {
    	               objetivo=arriba;
    	               exito=true;
    	            }
    	         }
    	      }
    	 }
    	}//fin del metodo moverArriba
   
    private void moverAD(Estado e){
    	if((e.y > 0) && (e.x < anchuraMundoVirtual-1) ){
    		if(laberinto.celdas[e.x+1][e.y-1].tipo !='O'){
    			Estado arribaDerecha = new Estado(e.x+1,e.y-1,'E',e);
    			arribaDerecha.prioridad=distancia(arribaDerecha.x,arribaDerecha.y,objetivo.x,objetivo.y);	
    			if(!historial.contains(arribaDerecha)){
    				colaEstados.add(arribaDerecha);
    				historial.add(arribaDerecha);
    				if(arribaDerecha.equals(objetivo)){
    					objetivo=arribaDerecha;
    					exito=true;
    				}
    			}
    		}
    	}
    }
    
    private void moverAI(Estado e){
    	if((e.y > 0) && (e.x > 0) ){
    		if(laberinto.celdas[e.x-1][e.y-1].tipo !='O'){
    			Estado arribaIzquierda = new Estado(e.x-1,e.y-1,'Q',e);
    			arribaIzquierda.prioridad=distancia(arribaIzquierda.x,arribaIzquierda.y,objetivo.x,objetivo.y);	
    			if(!historial.contains(arribaIzquierda)){
    				colaEstados.add(arribaIzquierda);
    				historial.add(arribaIzquierda);
    				if(arribaIzquierda.equals(objetivo)){
    					objetivo=arribaIzquierda;
    					exito=true;
    				}
    			}
    		}
    	}
    }
    
    
    private void moverAbajo(Estado e) {
    	   if ( e.y < alturaMundoVirtual-1 ) {
    	      if ( laberinto.celdas[e.x][e.y+1].tipo != 'O') {
    	         Estado abajo=new Estado(e.x,e.y+1,'D',e);
    	         abajo.prioridad=distancia(abajo.x,abajo.y, objetivo.x,objetivo.y);
    	         if ( !historial.contains(abajo)) {
    	            colaEstados.add(abajo);
    	            historial.add(abajo);
    	            if ( abajo.equals(objetivo)) {
    	               objetivo=abajo;
    	               exito=true;
    	            }
    	        }
    	    }
    	 }
   }
    
    private void moverABAD(Estado e){
    	if((e.y < alturaMundoVirtual-1) && (e.x < anchuraMundoVirtual-1) ){
    		if(laberinto.celdas[e.x+1][e.y+1].tipo !='O'){
    			Estado abajoDerecha = new Estado(e.x+1,e.y+1,'C',e);
    			abajoDerecha.prioridad=distancia(abajoDerecha.x,abajoDerecha.y,objetivo.x,objetivo.y);	
    			if(!historial.contains(abajoDerecha)){
    				colaEstados.add(abajoDerecha);
    				historial.add(abajoDerecha);
    				if(abajoDerecha.equals(objetivo)){
    					objetivo=abajoDerecha;
    					exito=true;
    				}
    			}
    		}
    	}
    }
    
    private void moverABAI(Estado e){
    	  if ( e.x > 0 && e.y < alturaMundoVirtual-1 ) {
    	      if ( laberinto.celdas[e.x-1][e.y+1].tipo != 'O' ) {
    	         Estado abajoIzquierda=new Estado(e.x-1,e.y+1,'Z',e);
    	         abajoIzquierda.prioridad=distancia(abajoIzquierda.x,abajoIzquierda.y,objetivo.x,objetivo.y);
    	         if ( !historial.contains(abajoIzquierda)) {
    	            colaEstados.add(abajoIzquierda);
    	            historial.add(abajoIzquierda);
 
    	            if ( abajoIzquierda.equals(objetivo)) {
    	               objetivo=abajoIzquierda;
    	               exito=true;
    	            } 
    	         }	
    	      }
    	   }
    }
    private void moverIzquierda(Estado e) {
    	   if ( e.x > 0 ) {
    		   
    	      if ( laberinto.celdas[e.x-1][e.y].tipo != 'O' ) {
    	         Estado izquierda=new Estado(e.x-1,e.y,'L',e);
    	        izquierda.prioridad=distancia(izquierda.x,izquierda.y,objetivo.x,objetivo.y);
    	         if ( !historial.contains(izquierda)) {
    	            colaEstados.add(izquierda);
    	            historial.add(izquierda);
    	            
    	            if ( izquierda.equals(objetivo)) {
    	               objetivo=izquierda;
    	               exito=true;
    	            } 
    	         }	
    	      }
    	   }
    }// fin del metodo izquierda
    
    private void moverDerecha(Estado e) {
    	   if ( e.x < anchuraMundoVirtual-1 ) {
    		  
    	      if ( laberinto.celdas[e.x+1][e.y].tipo != 'O' ) {
    	         Estado derecha=new Estado(e.x+1,e.y,'R',e);
    	         derecha.prioridad=distancia(derecha.x,derecha.y,objetivo.x,objetivo.y);
    	         if ( !historial.contains(derecha)){
    	            colaEstados.add(derecha);
    	            historial.add(derecha);
    	            if ( derecha.equals(objetivo)) {
    	               objetivo=derecha;
    	               exito=true;
    	            } 
    	         }
    	      }
    	   }
    }

    

    public double distancia(int x1, int y1, int x2, int y2){
      
    	double valor;
        double parte1=Math.pow(Math.abs(x1-x2),2);
        double parte2=Math.pow(Math.abs(y1-y2),2);
        parte1+=parte2;
        valor=Math.sqrt(parte1);
        return valor;
    }
    
    public void calcularRuta() {
    	
    	Estado predecesor=objetivo;
    	
    	do{
    		pasos.add(0,predecesor.oper);
    		
    		predecesor=predecesor.predecesor;
    	}while ( predecesor != null);
    	index_pasos=pasos.size()-1;
    }

    

@Override
public void run() {
   
	//solo cuando quedan destinos donde ir
   if ( !parar ) {
      
	   //inicializacion de la busqueda
      colaEstados.clear();
      historial.clear();
      pasos.clear();

      Estado subinicial,subobjetivo;	
      boolean resultado;
   	//System.out.println("Destinos"+destinos.toString());

      do{
   		
    	  //el estado inicial es donde estoy
   		subinicial=new Estado(jugador.jugador.x,
                         jugador.jugador.y,'N',null);
   		
   		//el estado final es a donde quiero ir
   		subobjetivo=destinos.get(0);
   		
   		
   		
   		
   		
   		
   		//busco ruta
   		resultado=this.buscar(subinicial,subobjetivo);
   		
   		System.out.println("Subinicial:"+subinicial+" "+subobjetivo+"  "+resultado+" "+subobjetivo.oper+"  Destinos:"+destinos.toString());
    		
   		
   		if ( subinicial.equals(subobjetivo)){
   			//aqui asignamos el pause al hilo
	   		destinos.remove(subobjetivo);
	  /*	 switch(subobjetivo.oper){
   		 case 'G' : try {
   			 	
				Thread.sleep(3000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  break;// rojo
   		 case 'K' :try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} break;//verde
   		 case 'L' : try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} break; //azul
   		 case 'N' :try {
   			 	
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}break;
	 	}
	   		*/
	   		
	   	switch(subobjetivo.oper){
	   	case 'G' : tiempo = 2000; break;
	   	case 'K' : tiempo = 4000; break;
	   	case 'L' : tiempo = 80000; break;
	   	}	

  	 
	   		
   		}	
  		else {
 		   if ( !resultado) {
 			   colaEstados.clear();
 			   historial.clear();
 			   pasos.clear();
 			   destinos.remove(subobjetivo);
 		   } 
 		}
   		if ( destinos.isEmpty() ) {
   			System.out.println("Se acabo a donde ir");
   			
   			this.cancel();
   		}
   		
   
   	}while(!resultado && !destinos.isEmpty());
      
      
      
      if ( pasos.size() > 1 ) {
  		
    	  try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  
    	  
   		switch(pasos.get(1)) {
   			
   			case 'D': jugador.moverJugadorAbajo();break;
   			case 'U': jugador.moverJugadorArriba(); break;
   			case 'R': jugador.moverJugadorDerecha();break;
   			case 'L': jugador.moverJugadorIzquierda();break;
   			case 'E': jugador.moverJugadorAD();break;
   			case 'Q': jugador.moverJugadorAI();break;
   			case 'Z': jugador.moverJugadorABAI();break;
   			case 'C': jugador.moverJugadorABAD();break;
   			
   		}
   		
   		laberinto.lienzoPadre.repaint();
   	}
	
   }
}
}
