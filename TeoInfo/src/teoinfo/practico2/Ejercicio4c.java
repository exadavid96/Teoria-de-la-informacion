package teoinfo.practico2;

public class Ejercicio4c {
	
	public Ejercicio4c() {}
	
	private final double ERROR = 0.0001;
	private final int T_MIN = 100;
	
	
	boolean converge(float A[], float B[]) {
		
		for(int i = 0; i<=2; i++)
			if(Math.abs(A[i]-B[i]) > ERROR)
				return false;
		return true;
		
	}
	
	
	int primerSimbolo() {
		
		float r = (float) Math.random();
		float vInicial[] = {0,1,1};
		
		for (int i = 0; i <= 2 ; i++)
			if(r < vInicial[i])
				return i;
		
		return -1;
	}
	
	int sigEstado(int sAnt) {
		
		float r = (float) Math.random();
		float mAcum [][] = { {1/2f,1/3f,0} , {1,2/3f,1} , {1, 1, 1} };
		for( int i = 0; i<=2; i++)
			if(r < mAcum[i][sAnt])
				return i;
		return -1;
	}
	
	float [] probSalgan2simb() {
		
		int emisiones = 0;
		int [] exitos = {0,0,0};
		float [] probAnt = {0,0,0};
		float [] probAct = {0,0,0};		
		int simAnt = this.primerSimbolo();
		
		do {
			
			int simAct = this.sigEstado(simAnt);
			
			if(simAnt == simAct)
				exitos[simAct]++;
			
			emisiones++;
			simAnt = simAct;
			for(int i = 0; i <= 2;i++) {
				
				probAnt [i] = probAct[i];
				probAct [i] = (float) exitos[i] / (float) emisiones; 
				
				}
			
			} while ((!this.converge(probAnt, probAct)) || (emisiones < T_MIN));
		
		return probAct;
	}
	
}
