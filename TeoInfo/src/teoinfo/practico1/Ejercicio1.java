package teoinfo.practico1;

public class Ejercicio1 {
	
	private final double ERROR = 0.00001;
	private final int MIN_MUESTRAS = 0;
	
	public Ejercicio1() {}
	
	
	public char extraerSobre() {
		
	float p = (float) Math.random();
	if(p<0.6)
		return 'F';
	return 'C';
	}
	
	public boolean converge(float pAnt, float pAct) {
		
		return(Math.abs(pAnt-pAct) < ERROR);
		
	}
	
	
	//////////////////////////////////////////////  I N C I S O  A   ///////////////////////////////////////////////////////////
	
	public float ejercicio1A() {
	
	int exitos = 0;
	int muestras = 0;
	float pAnt = 0;
	float pAct = 0;
	
	do {
		char e1 = this.extraerSobre();
		char e2 = this.extraerSobre();
		if((e1=='F') || (e2=='F'))
			exitos++;
		muestras++;
		pAnt = pAct;
		pAct =(float) exitos /(float) muestras;
		
		
	} while((!this.converge(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
	System.out.println("Iteraciones: " + muestras);
	return pAct;
	
}
    //////////////////////////////////////////   I N C I S O  B  ///////////////////////////////////////////////////////////////	
	
	public float ejercicio1B() {
			
		int exitos = 0;
		int muestras = 0;
		float pAnt = 0;
		float pAct = 0;
			
		do {
			char e1 = this.extraerSobre();
			char e2 = this.extraerSobre();
			if(((e1=='F') && (e2=='C')) || ((e1=='C') && (e2=='F')))
				exitos++;
			muestras++;
			pAnt = pAct;
			pAct =(float) exitos /(float) muestras;
				
		} while((!this.converge(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
		
		
		return pAct;
		
	}
    //////////////////////////////////////////  I N C I S O  C  ///////////////////////////////////////////////////////////////
	
	public float ejercicio1C() {
		
		int exitos = 0;
		int muestras = 0;
		float pAnt = 0;
		float pAct = 0;
		
		do {
			///char e1 = this.extraerSobre();  No es necesario, hay independencia
			char e2 = this.extraerSobre();
			if(e2=='F')
				exitos++;
			muestras++;
			pAnt = pAct;
			pAct =(float) exitos /(float) muestras;
			
		} while((!this.converge(pAnt, pAct)) || (muestras < MIN_MUESTRAS));
		
		
		return pAct;
		
	}
}
