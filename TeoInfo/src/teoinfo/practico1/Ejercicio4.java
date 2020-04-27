package teoinfo.practico1;

public class Ejercicio4 {
	
	public Ejercicio4() {}
	
	private final double ERROR = 0.001;
	private final int MIN_MUESTRAS = 1000;
	
	public char estaEnferma() {
		
		float p = (float) Math.random();
		if (p < 0.005)
			return 'E';
		return 'S';}
	
	public char daPositivo(int esEnferma) {
		
		double probAcum[][] = { {0.95 , 1} , {0.04 , 1} };
		float p =(float) Math.random();
		if (p < probAcum[esEnferma][0])
			return 'P';
		return 'N';
	}
	
	public boolean converge(float pAnt, float pAct) {
		
		return(Math.abs(pAnt-pAct) < ERROR);
		
	}
////////////////////////////////////////////I N C I S O   A ///////////////////////////////////////////////////////
	
	public float ejercicio4A () {
		
		int exitos = 0; 
		int muestras = 0;
		float pAnt = 0;
		float pAct = 0;
		char  e1 = ' ';
		char e2 = ' ';
		
		do {
			
			e1 = this.estaEnferma();
			if(e1 == 'E')
				e2 = this.daPositivo(0);
			else
				e2 = this.daPositivo(1);
			
			if(e2 == 'N') {
				if(e1 == 'S')
					exitos++;
			muestras++;
			}
			
			pAnt = pAct;
			pAct = (float)exitos /(float) muestras;
		} while((!this.converge(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
		
		return pAct;
		
	} 
///////////////////////////////////////// I N C I S O   B  ///////////////////////////////////////////////////////////////
	
public float ejercicio4B () {
		
		int exitos = 0; 
		int muestras = 0;
		float pAnt = 0;
		float pAct = 0;
		char  e1 = ' ';
		char e2 = ' ';
		
		do {
			
			e1 = this.estaEnferma();
			if(e1 == 'E')
				e2 = this.daPositivo(0);
			else
				e2 = this.daPositivo(1);
			
			if(e2 == 'P') {
				if(e1 == 'E')
					exitos++;
			muestras++;
			}
			
			pAnt = pAct;
			pAct = (float)exitos /(float) muestras;
		} while((!this.converge(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
		
		return pAct;
		
	} 
}
