package teoinfo.practico1;

public class Ejercicio2 {
	
   private final double ERROR = 0.001;
   private final int MIN_MUESTRAS = 10000;
   
   public Ejercicio2(){ }
   
   public char primeraExtraccion() {
	   
	 float p = (float) Math.random();
	 if(p < 0.6)
		 return 'F';
	 return 'C';
   }
   
   public char segundaExtraccion(int pExtraccion) {
	   
	   double probAcum[][] = {{0.5 , 1}, {0.75, 1}};
	   float p =(float) Math.random();
	   if(p < (float) probAcum[pExtraccion] [0])
		   return 'F';
	   return 'C';
   }
   
   public boolean converge(float pAnt, float pAct) {
		
		return(Math.abs(pAnt-pAct) < ERROR);
		
	}
 //////////////////////////////////////////// I N C I S O   A ///////////////////////////////////////////////////////
   
   public float ejercicio2A() {
	   
	   int exitos=0; 
	   int muestras=0;
	   float pAnt = 0;
	   float pAct = 0;
	   char e1 = ' ';
	   char e2 = ' ';
	  
	   do {
		   e1 = this.primeraExtraccion();
		   if(e1 == 'F')
			   e2 = this.segundaExtraccion(0);
		   else
			   e2 = this.segundaExtraccion(1);
		   
		   if((e1 == 'F')||(e2 == 'F'))
			   exitos++;
		   muestras++;
		   pAnt = pAct;
		   pAct = (float) exitos / (float) muestras;
		      
	   } while((!this.converge(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
	   
	   return pAct;
   } 
   
   ////////////////////////////////////////////I N C I S O   B ///////////////////////////////////////////////////////
   
   public float ejercicio2B() {
	   
	   int exitos=0; 
	   int muestras=0;
	   float pAnt = 0;
	   float pAct = 0;
	   char e1 = ' ';
	   char e2 = ' ';
	  
	   do {
		   e1 = this.primeraExtraccion();
		   if(e1 == 'F')
			   e2 = this.segundaExtraccion(0);
		   else
			   e2 = this.segundaExtraccion(1);
		   
		   if(((e1=='F') && (e2=='C')) || ((e1=='C') && (e2=='F')))
			   exitos++;
		   muestras++;
		   pAnt = pAct;
		   pAct = (float) exitos / (float) muestras;
		      
	   } while((!this.converge(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
	   
	   return pAct;
   } 
   
   ////////////////////////////////////////////I N C I S O   C ///////////////////////////////////////////////////////
   
public float ejercicio2C() {
	   
	   int exitos=0; 
	   int muestras=0;
	   float pAnt = 0;
	   float pAct = 0;
	   char e1 = ' ';
	   char e2 = ' ';
	  
	   do {
		   e1 = this.primeraExtraccion();
		   if(e1 == 'F')
			   e2 = this.segundaExtraccion(0);
		   else
			   e2 = this.segundaExtraccion(1);
		   
		   if(e1=='F') {
			   if(e2=='F')
				   exitos++;
			   muestras++; /// Se actualiza SOLO si el primero salió F
		   } 
		   pAnt = pAct;
		   pAct = (float) exitos / (float) muestras;
		   
	   } while((!this.converge(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
	   
	   return pAct;
   } 
   
}
