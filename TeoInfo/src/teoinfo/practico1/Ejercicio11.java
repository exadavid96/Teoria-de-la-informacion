package teoinfo.practico1;

public class Ejercicio11 {
	
	private final float ERROR = 0.001f;
	private final int MIN_MUESTRAS = 10000;
	
	
/////////////////////////////////////////// C O N V E R G E N C I A S /////////////////////////////////////////////////	
	
	
	public boolean converge(float a , float b) {
		
		return (Math.abs(a-b) < ERROR);
	}
	
	public boolean convergeD(float pAnt[], float pAct[]) {
		
		for(int i = 0;i < pAnt.length; i++)
			if(Math.abs(pAnt[i] - pAct[i]) >= ERROR)
				return false;
		return true;
	}
	
	public boolean convergeConjunta(float pAnt[][] , float pAct[][]) {
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 5; j++)
				if(Math.abs(pAnt[i][j] - pAct[i][j]) >= ERROR)
					return false;
		return true;
		
	}
	
////////////////////////////////////// E V E N T O    A L E A T O R I O  /////////////////////////////////////////////////////////	
	public int extraerCubito() {
		
		float probAcum[] = {3f/13 , 9f/13, 1};
		float p = (float) Math.random();
		for(int i = 0; i< probAcum.length;i++)
			if(p < probAcum[i])
				return i;
		return -1;
	}
///////////////////////////////////   I N C I S O    A   /////////////////////////////////////////////////////////////////////////
	public float [] probA() {
		
		int exitos[] = {0,0,0,0,0};
		int muestras = 0;
		float pAnt[] = {0,0,0,0,0};
		float pAct[] = {0,0,0,0,0};
		
		do {
			
			int s = this.extraerCubito() + this.extraerCubito();
			exitos[s]++;
			muestras++;
			for(int i = 0; i< pAct.length;i++) {
				pAnt[i] = pAct[i];
				pAct[i] = (float) exitos[i] /(float) muestras;
			}
		} while((!this.convergeD(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
		
		return pAct;		
	
	}
	
	
	public float [] probB() {
		
		int exitos[] = {0,0,0};
		int muestras = 0;
		float pAnt[] = {0,0,0};
		float pAct[] = {0,0,0};
		
		do {
			
			int s = Math.max(this.extraerCubito(), this.extraerCubito());
			exitos[s]++;
			muestras++;
			for(int i = 0; i< pAct.length;i++) {
				pAnt[i] = pAct[i];
				pAct[i] = (float) exitos[i] /(float) muestras;
			}
		} while((!this.convergeD(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
		
		return pAct;		
	
	}
	
	
	
	public float[][] probConjuntaAB(){
		
		int exitos[][]= {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		int muestras = 0;
		float pAnt[][]= {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		float pAct[][]= {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		do {
			int aux1 = this.extraerCubito();
			int aux2 = this.extraerCubito();
			int s1 = Math.max(aux1, aux2);
			int s2 = aux1 + aux2;
			exitos[s1][s2]++;
			muestras++;
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 5; j++) {
					pAnt[i][j]= pAct[i][j];
					pAct[i][j]= (float) exitos[i][j] / (float) muestras;
				}
		} while((!this.convergeConjunta(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
		
		return pAct;
	}
	
	public boolean superaMinMuestras(int muestras[]) {
		
		for(int i = 0; i < muestras.length; i++)
			if(muestras[i] <= MIN_MUESTRAS)
				return false;
		return true;
		
		
	}
	
	public float [][] probCondicionalBA(){
		
		int exitos[][] = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		int muestras [] = {0,0,0,0,0}; // Para cada A
		float pAnt[][]= {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		float pAct[][]= {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		do {
			
			int aux1 = this.extraerCubito();
			int aux2 = this.extraerCubito();
			int a = aux1 + aux2;
			muestras[a]++;   //La muestra se actualiza en la posición del arreglo donde tocó el A
			int b = Math.max(aux1, aux2);
			exitos[b][a]++;	
			for(int i = 0; i< 3; i++)
				for(int j = 0; j < 5; j++) {
					
					pAnt[i][j] = pAct[i][j];
					pAct[i][j] = (float) exitos[i][j] / (float) muestras[j];
				}
		} while((!this.convergeConjunta(pAnt, pAct)) || (!this.superaMinMuestras(muestras)));
		
		
		return pAct;
		
			
	}
	
	public float [][] probCondicionalAB(){
		
		int exitos[][] = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		int muestras [] = {0,0,0}; 
		float pAnt[][]= {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		float pAct[][]= {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		do {
			
			int aux1 = this.extraerCubito();
			int aux2 = this.extraerCubito();
			int b = Math.max(aux1, aux2);
			muestras[b]++;//La muestra se actualiza en la posición del arreglo donde tocó el B
			int a = aux1 + aux2;
			exitos[b][a]++;	
			for(int i = 0; i< 3; i++)
				for(int j = 0; j < 5; j++) {
					
					pAnt[i][j] = pAct[i][j];
					pAct[i][j] = (float) exitos[i][j] / (float) muestras[i];
				}
		} while((!this.convergeConjunta(pAnt, pAct)) || (!this.superaMinMuestras(muestras)));
		
		return pAct;
		
			
	}
	
	
//////////////////////////////////////// I N C I S O   B  //////////////////////////////////////////////////////
	
	public float mediaA() {
		
		int muestras = 0;
		float mediaAnt = 0;
		float mediaAct = 0;
		int suma = 0;
		
		do {
			int a = this.extraerCubito() + this.extraerCubito() + 2; ///Esto porque extraer cubito devuelve del 0 al 4
			suma+=a;
			muestras++;
			mediaAnt = mediaAct;
			mediaAct =  suma / (float) muestras;
			
			} while((!this.converge(mediaAnt, mediaAct)) || (muestras < MIN_MUESTRAS));
		
		return mediaAct;
		
	}
	
	public float mediaB() {
		
		int muestras = 0;
		float mediaAnt = 0;
		float mediaAct = 0;
		int suma = 0;
		
		do {
			int b = Math.max(this.extraerCubito()+1, this.extraerCubito()+1) ; ///Esto porque extraer cubito devuelve del 0 al 2
			suma+=b;
			muestras++;
			mediaAnt = mediaAct;
			mediaAct =  suma / (float) muestras;
			
			} while((!this.converge(mediaAnt, mediaAct)) || (muestras < MIN_MUESTRAS));
		
		return mediaAct;
		
	}
	
	public float desvioA() {
		
		int muestras = 0;
		float desvioAnt = 0;
		float desvioAct = 0;
		int suma = 0;
		float sumaEMC = 0;
		
		do {
			
			int a = this.extraerCubito() + this.extraerCubito() + 2;
			suma+= a;
			muestras++;
			sumaEMC += Math.pow(a-((float) suma / (float) muestras), 2);
			desvioAnt = desvioAct;
			desvioAct = (float) Math.sqrt(sumaEMC / (float) muestras);
		} while((!this.converge(desvioAnt, desvioAct)) || (muestras < MIN_MUESTRAS));
		
		return desvioAct;
		
	}
	
	public float desvioB() {
		
		int muestras = 0;
		float desvioAnt = 0;
		float desvioAct = 0;
		int suma = 0;
		float sumaEMC = 0;
		
		do {
			
			int b = Math.max(this.extraerCubito()+1,this.extraerCubito()+1);
			suma+= b;
			muestras++;
			sumaEMC += Math.pow(b-((float) suma / (float) muestras), 2);
			desvioAnt = desvioAct;
			desvioAct = (float) Math.sqrt(sumaEMC / (float) muestras);
		} while((!this.converge(desvioAnt, desvioAct)) || (muestras < MIN_MUESTRAS));
		
		return desvioAct;
		
	}
	
	
	
   ///////////////////////////////////     E   X   T   R   A   /////////////////////////////////////////////////////////
	
	
	public float covAB() {
		
		int muestras = 0;
		float covAnterior = 0;
		float covActual = 0;
		int sumaA = 0;
		int sumaB = 0;
		int sumaAB = 0;
		
		do {
			
			int aux1 = this.extraerCubito()+1;
			int aux2 = this.extraerCubito()+1;
			
			int a = aux1 + aux2;
			int b = Math.max(aux1, aux2);
			sumaA+= a;
			sumaB+= b;
			sumaAB+= a * b;
			
			muestras++;
			covAnterior = covActual;
			covActual = ( (float) sumaAB / (float) muestras ) - ((float) (sumaA * sumaB) / (float) Math.pow(muestras, 2));	
			
		  } while ((!this.converge(covAnterior, covActual)) || (muestras < MIN_MUESTRAS));
		
		return covActual;
		
		
		
		
		
		
	}
	
	
	public float [] estimacionBA () {
		
		int [] muestras = {0,0,0,0,0}; //// Para cada A
		float [] estimacionAnt = {0,0,0,0,0};
		float [] estimacionAct = {0,0,0,0,0};
		float [] suma = {0,0,0,0,0};    /// Cada valor que salga de B asociado con el A condicionado
		
		do {
			
			int aux1 = this.extraerCubito();
			int aux2 = this.extraerCubito();
			
			int a = aux1 + aux2;
			muestras[a]++;
			
			int b = Math.max(aux1 + 1, aux2 + 1);
			suma[a]+=b;
			
			for(int i = 0; i < 5; i++) {
				
				estimacionAnt[i] = estimacionAct[i];
				estimacionAct[i] = suma[i] / (float) muestras[i];   ///// Media en la posición i	
				}
			
		} while ((!this.convergeD(estimacionAnt, estimacionAct)) || (!this.superaMinMuestras(muestras)));
		
		return estimacionAct;		
		
	}
	
	
	
	
	
	
	
	
	
		
}
	


