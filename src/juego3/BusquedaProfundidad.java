package juego3;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TimerTask;

public class BusquedaProfundidad extends TimerTask implements Constantes {


    public Laberinto laberinto;
    public Queue<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    public int index_pasos;
    public Estado inicial;
    public Estado objetivo;
    public Estado temp;
    public boolean exito;

    //para tener un busqueda anchura multiobjetivo
   public Adversario adversario;
   public ArrayList<Estado> destinos;
   public boolean parar;
    
    public BusquedaProfundidad(Laberinto laberinto, Adversario adversario) {
        
    	this.laberinto=laberinto;
        colaEstados=new PriorityQueue<>(); //cola de prioridad
        historial=new ArrayList<>();
        pasos=new ArrayList<>();
        index_pasos=0;
        exito=false;
        this.adversario=adversario;
        destinos=new ArrayList<>();
        parar=false;
    }
    
    public boolean buscar(Estado inicial,Estado objetivo) {
        
    	this.inicial=inicial;
        inicial.prioridad=distancia(inicial.x,inicial.y,laberinto.lienzoPadre.adversario.celdaAdversario.x,laberinto.lienzoPadre.adversario.celdaAdversario.y);
    	index_pasos=0;
        colaEstados.add(inicial);
        historial.add(inicial);
        this.objetivo=objetivo;
        exito=false;
        
        if ( inicial.equals(objetivo)) exito=true;
        
        while ( !colaEstados.isEmpty() && !exito ){
           
        	temp=colaEstados.poll();
        	 
          
          //  System.out.println("asdfasfdafas");
        
        	moverArriba(temp);
            moverAbajo(temp);
            moverIzquierda(temp);
            moverDerecha(temp);
            moverAD(temp); //arriba derecha
            moverAI(temp); //arriba izquierda
            moverABAD(temp); //abajo derecha
            moverABAI(temp); //abajo izquierda
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
    	         arriba.prioridad=distancia(inicial.x,inicial.y,laberinto.lienzoPadre.adversario.adversario.x,laberinto.lienzoPadre.adversario.adversario.y);
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
    			arribaDerecha.prioridad=distancia(inicial.x,inicial.y,laberinto.lienzoPadre.adversario.adversario.x,laberinto.lienzoPadre.adversario.adversario.y);	
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
    			arribaIzquierda.prioridad=distancia(inicial.x,inicial.y,laberinto.lienzoPadre.adversario.adversario.x,laberinto.lienzoPadre.adversario.adversario.y);	
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
    	   if ( e.y+1 < alturaMundoVirtual ) {
    	      if ( laberinto.celdas[e.x][e.y+1].tipo != 'O') {
    	         Estado abajo=new Estado(e.x,e.y+1,'D',e);
    	         if ( !historial.contains(abajo)) {
    	            colaEstados.add(abajo);
    	            historial.add(abajo);
    	            if ( abajo.equals(objetivo)) {
    	               objetivo=abajo;
    	               exito=true;
    	} }}}
    	}
    
    private void moverABAD(Estado e){
    	if((e.y < alturaMundoVirtual-1) && (e.x < anchuraMundoVirtual-1) ){
    		if(laberinto.celdas[e.x+1][e.y+1].tipo !='O'){
    			Estado abajoDerecha = new Estado(e.x+1,e.y+1,'C',e);
    			abajoDerecha.prioridad=distancia(inicial.x,inicial.y,laberinto.lienzoPadre.adversario.adversario.x,laberinto.lienzoPadre.adversario.adversario.y);	
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
    	         if ( !historial.contains(derecha)){
    	            colaEstados.add(derecha);
    	            historial.add(derecha);
    	            if ( derecha.equals(objetivo)) {
    	               objetivo=derecha;
    	               exito=true;
    	} }}}}

    

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
    		//pasos.add(predecesor.oper);
    		pasos.add(0,predecesor.oper);
    		predecesor=predecesor.predecesor;
    	}while ( predecesor != null);
    	index_pasos=pasos.size()-1;
    }


    @Override
    public void run() {
    if ( ! parar ) {
          colaEstados.clear();
          historial.clear();
          pasos.clear();
          Estado subinicial,subobjetivo;
          boolean resultado;
          subinicial=new Estado(adversario.celdaAdversario.x,
          adversario.celdaAdversario.y,'N',null);
          
          subobjetivo=new Estado(
          adversario.laberinto.lienzoPadre.adversario.celdaAdversario.x,
          adversario.laberinto.lienzoPadre.adversario.celdaAdversario.y,'N',null);
          resultado=this.buscar(subinicial,subobjetivo);
          if ( pasos.size() > 1 ) {
             switch(pasos.get(1)) {
             	case 'D': adversario.moverAdversarioAbajo();break;
    			case 'U': adversario.moverAdversarioArriba(); break;
    			case 'R': adversario.moverAdversarioDerecha();break;
    			case 'L': adversario.moverAdversarioIzquierda();break;
    			case 'E': adversario.moverAdversarioAD();break;
    			case 'Q': adversario.moverAdversarioAI();break;
    			case 'Z': adversario.moverAdversarioABAI();break;
    			case 'C': adversario.moverAdversarioABAD();break;
             }
             laberinto.lienzoPadre.repaint();
           }
    	}
    }
}

