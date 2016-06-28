package juego3;

import java.util.TimerTask;


public class Adversario extends TimerTask implements Constantes {
	
	public Laberinto laberinto;
    public Celda adversario; //esta ya no se esta usando. se usa celdaAdversario
    public int direccion;
    public int contador;
    public int golesa; //goles de adversario(?) xd
    
    
    public Celda celdaAdversario;
    public BusquedaProfundidad inteligencia;
    
    public Adversario(Laberinto laberinto) {
        this.laberinto=laberinto;
        celdaAdversario=new Celda(anchuraMundoVirtual-1,alturaMundoVirtual-1,'A');
        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
        inteligencia=new BusquedaProfundidad(laberinto,this);
        
    }




    
    // MOvimientos del Adversario
      public void moverAdversarioDerecha(){
      	
      	if(celdaAdversario.x < anchuraMundoVirtual-1){
      		if(laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y].tipo != 'J'){
      			if(laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y].tipo != 'O'){
      				if(laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y].tipo == 'P'){
      					if(celdaAdversario.x+1 < anchuraMundoVirtual-1){
      						
      						if(celdaAdversario.x+1 == anchuraMundoVirtual-1 || laberinto.celdas[celdaAdversario.x+2][celdaAdversario.y].tipo == 'O'){
      							laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='P'; //antes V
      							celdaAdversario.x=celdaAdversario.x+1;
      							laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
      							//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=1;
      						}else{//si no es pelota
      							laberinto.celdas[celdaAdversario.x+2][celdaAdversario.y].tipo='P';
      							laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y].tipo='V';
      						}
      					}
      				}else{ //si no es pelota xd
      					laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='V'; //antes V
      					celdaAdversario.x=celdaAdversario.x+1;
      					laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
      					//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=3;
      				}	    
      			}
      		}else{
      			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'V';
      			celdaAdversario.x = celdaAdversario.x-1;
      			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
      		}
      	}
      	
      }
      		
       
      public void moverAdversarioIzquierda(){	
      	if(celdaAdversario.x > 0){
      		if(laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y].tipo != 'J'){
      			if(laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y].tipo != 'O'){
      				if(laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y].tipo == 'P'){
      					if(celdaAdversario.x-1 >0){
      						
      					if(celdaAdversario.x-1 == 0 || laberinto.celdas[celdaAdversario.x-2][celdaAdversario.y].tipo == 'O'){
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='P'; //antes V
      						celdaAdversario.x=celdaAdversario.x-1;
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
      					//	laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=3;
      					}else{
      						laberinto.celdas[celdaAdversario.x-2][celdaAdversario.y].tipo='P';
      						laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y].tipo='V';
      					}
      					}
      				}else{ //si no es pelota xd
      					laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='V'; //antes V
      					celdaAdversario.x=celdaAdversario.x-1;
      					laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
      				//	laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=1;
      				}
      			    
      			}
      		}else{
      			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'V';
      			celdaAdversario.x = celdaAdversario.x+1;
      			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
      		}
      	}
      }
      		
      
      
      public void moverAdversarioArriba(){
      	 if (celdaAdversario.y > 0 ) {
      		 if(laberinto.celdas[celdaAdversario.x][celdaAdversario.y-1].tipo != 'J'){
      		 	if ( laberinto.celdas[celdaAdversario.x][celdaAdversario.y-1].tipo != 'O'){
      		 		if ( laberinto.celdas[celdaAdversario.x][celdaAdversario.y-1].tipo == 'P'){
      		 			if ( celdaAdversario.y-1 >=0 ) {
      		 				
      		 			if(celdaAdversario.y-1 == 0 || laberinto.celdas[celdaAdversario.x][celdaAdversario.y-2].tipo == 'O'){
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='P'; //antes V
      						celdaAdversario.y=celdaAdversario.y-1;
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
      					//	laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=2;
      					}else{
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y-2].tipo='P';
      		 				laberinto.celdas[celdaAdversario.x][celdaAdversario.y-1].tipo='V';
      		 			}
      					}
      		 		}else{ // si no es pelota
      		 			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='V';
      		 			celdaAdversario.y=celdaAdversario.y-1;
      		 			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
      		 			//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=0;
      		 		}
      		 	}
      		 }else{
      		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'V';
      		 		celdaAdversario.y = celdaAdversario.y+1;
      		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
      		 }
      	 }
      }
      
      public void moverAdversarioAbajo(){
      	if (celdaAdversario.y >= 0 && celdaAdversario.y < alturaMundoVirtual-1 ) {
      		if(laberinto.celdas[celdaAdversario.x][celdaAdversario.y+1].tipo !='J'){
      			if ( laberinto.celdas[celdaAdversario.x][celdaAdversario.y+1].tipo != 'O') {
      				if ( laberinto.celdas[celdaAdversario.x][celdaAdversario.y+1].tipo == 'P') {
      					if ( celdaAdversario.y+1 < alturaMundoVirtual ){
      						
      					if(celdaAdversario.y+1 == 0 || laberinto.celdas[celdaAdversario.x][celdaAdversario.y+2].tipo == 'O'){
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='P'; //antes V
      						celdaAdversario.y=celdaAdversario.y+1;
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
      						//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=0;
      					}else{
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y+2].tipo='P';
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y+1].tipo='V';
      					}
      					}
      	        	}else { //si no es pelota
      	        		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='V';
      	        		celdaAdversario.y=celdaAdversario.y+1;
      	        		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
      	        		//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=2;
      	        	} 
      	        }
      		}else{
  		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'V';
  		 		celdaAdversario.y = celdaAdversario.y-1;
  		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
      		}
      	}
      }
      
      public void moverAdversarioAD(){//arriba derecha (diagonal superior derecha)
      	if(celdaAdversario.y > 0 && celdaAdversario.x < anchuraMundoVirtual-1){
         		 if(laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y-1].tipo != 'J'){
         		 	if ( laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y-1].tipo != 'O'){
         		 		if ( laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y-1].tipo == 'P'){
         		 			if ( celdaAdversario.y-2 >=0 && celdaAdversario.x+2 < anchuraMundoVirtual-1) {
         		 				
         		 			if((celdaAdversario.y-2 == 0 && celdaAdversario.x+2 == anchuraMundoVirtual-1) || laberinto.celdas[celdaAdversario.x+2][celdaAdversario.y-2].tipo == 'O'){
         						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='P'; //antes V
         						celdaAdversario.y=celdaAdversario.y-1;
         						celdaAdversario.x=celdaAdversario.x+1;
         						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
         						//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=5;
         					}else{
         						laberinto.celdas[celdaAdversario.x+2][celdaAdversario.y-2].tipo='P';
         		 				laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y-1].tipo='A';
         		 			}
         					}
         		 		}else{ // si no es pelota
         		 			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='V';
         		 			celdaAdversario.y=celdaAdversario.y-1;
         		 			celdaAdversario.x=celdaAdversario.x+1;
         		 			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
         		 			//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=7;
         		 		}
         		 	}
         		 }else{
         		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'V';
         		 		celdaAdversario.y = celdaAdversario.y+1;
         		 		celdaAdversario.x= celdaAdversario.x-1;
         		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
         		 }
      	}
      }
      
      public void moverAdversarioAI(){//arriba izquierda
      	if(celdaAdversario.y > 0 && celdaAdversario.x > 0){
        		 if(laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y-1].tipo != 'J'){
          		 	if ( laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y-1].tipo != 'O'){
          		 		if ( laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y-1].tipo == 'P'){
          		 			if ( celdaAdversario.y-2 >=0 && celdaAdversario.x-2 < anchuraMundoVirtual-1) {
          		 				
          		 			if((celdaAdversario.y-2 == 0 && celdaAdversario.x+2 == anchuraMundoVirtual-1) || laberinto.celdas[celdaAdversario.x-2][celdaAdversario.y-2].tipo == 'O'){
          						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='P'; //antes V
          						celdaAdversario.y=celdaAdversario.y-1;
          						celdaAdversario.x=celdaAdversario.x-1;
          						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
          						//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=7;
          					}else{
          						laberinto.celdas[celdaAdversario.x-2][celdaAdversario.y-2].tipo='P';
          		 				laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y-1].tipo='V';
          					}
          					}
          		 		}else{ // si no es pelota
          		 			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='V';
          		 			celdaAdversario.y=celdaAdversario.y-1;
          		 			celdaAdversario.x=celdaAdversario.x-1;
          		 			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
          		 			//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=5;
          		 		}
          		 	}
          		 }else{
          		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'V';
          		 		celdaAdversario.y = celdaAdversario.y+1;
          		 		celdaAdversario.x= celdaAdversario.x+1;
          		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
          		 }
       	}
       }
      	
      public void moverAdversarioABAI(){ //abajo Izquierda
      	if(celdaAdversario.y < alturaMundoVirtual-1 && celdaAdversario.x > 0 ){
      		if(laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y+1].tipo != 'J'){
      		 	if ( laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y+1].tipo != 'O'){
      		 		if ( laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y+1].tipo == 'P'){
      		 			if ( celdaAdversario.y+2 >=0 && celdaAdversario.x-2 < anchuraMundoVirtual-1) {
      		 				
      		 			if((celdaAdversario.y+2 == 0 && celdaAdversario.x+2 == anchuraMundoVirtual-1) || laberinto.celdas[celdaAdversario.x-2][celdaAdversario.y+2].tipo == 'O'){
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='P'; //antes V
      						celdaAdversario.y=celdaAdversario.y+1;
      						celdaAdversario.x=celdaAdversario.x-1;
      						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
      					//	laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=7;
      					}else{
      						laberinto.celdas[celdaAdversario.x-2][celdaAdversario.y+2].tipo='P';
      		 				laberinto.celdas[celdaAdversario.x-1][celdaAdversario.y+1].tipo='V';
      		 			}
      					}
      		 		}else{ // si no es pelota
      		 			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='V';
      		 			celdaAdversario.y=celdaAdversario.y+1;
      		 			celdaAdversario.x=celdaAdversario.x-1;
      		 			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
      		 			//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=5;
      		 		}
      		 	}	
      		 }else{
      		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'V';
      		 		
      		 		celdaAdversario.y = celdaAdversario.y-1;
      		 		celdaAdversario.x= celdaAdversario.x+1;
      		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
      		 }
      	}
       }
      
      public void moverAdversarioABAD(){//abajo derecha
      	if( celdaAdversario.x < anchuraMundoVirtual-1 && celdaAdversario.y < alturaMundoVirtual-1){
      		
      		 if(laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y+1].tipo != 'J'){
          		 	if ( laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y+1].tipo != 'O'){
          		 		if ( laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y+1].tipo == 'P'){
          		 			if ( celdaAdversario.y+2 >=0 && celdaAdversario.x+2 < anchuraMundoVirtual-1) {
          		 				
          		 			if((celdaAdversario.y+2 == 0 && celdaAdversario.x+2 == anchuraMundoVirtual-1) || laberinto.celdas[celdaAdversario.x+2][celdaAdversario.y+2].tipo == 'O'){
          						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='P'; //antes V
          						celdaAdversario.y=celdaAdversario.y+1;
          						celdaAdversario.x=celdaAdversario.x+1;
          						laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
          						//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=1;
          					}else{
          						laberinto.celdas[celdaAdversario.x+2][celdaAdversario.y+2].tipo='P';
          		 				laberinto.celdas[celdaAdversario.x+1][celdaAdversario.y+1].tipo='V';
          		 			}
          					}
          		 		}else{ // si no es pelota
          		 			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='V';
          		 			celdaAdversario.y=celdaAdversario.y+1;
          		 			celdaAdversario.x=celdaAdversario.x+1;
          		 			laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo='A';
          		 			//laberinto.celdas[celdaAdversario.x][celdaAdversario.y].indexSprite=3;
          		 		}
          		 	}
          		 }else{
          		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'V';
          		 		celdaAdversario.y = celdaAdversario.y-1;
          		 		celdaAdversario.x= celdaAdversario.x-1;
          		 		laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
          		 }
      	}
      }





	@Override
	public void run() {
		// TODO Auto-generated method stub
		laberinto.lienzoPadre.repaint();
	}
    	
	
	

}
