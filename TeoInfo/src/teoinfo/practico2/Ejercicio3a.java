package teoinfo.practico2;

public class Ejercicio3a {
	
	private final double ERROR = 0.0001;
	private final int T_MIN = 100;
	private final int T_FINAL = 3;
	
	public Ejercicio3a() {}
	
	boolean converge(float A[], float B[]) {
		
		for(int i = 0; i<=2; i++)
			if(Math.abs(A[i]-B[i]) > ERROR)
				return false;
		return true;
		
	}
	
	int primerSimbolo() {
		
		float r = (float) Math.random();
		float vInicial[] = {1,1,1};
		
		for (int i = 0; i <= 2 ; i++)
			if(r < vInicial[i])
				return i;
		
		return -1;
	}
	
	int sigEstado(int sAnt) {
		
		float r = (float) Math.random();
		float mAcum [][] = { {1/4f,3/4f,0} , {3/4f,1,1/2f} , {1, 1, 1} };
		for( int i = 0; i<=2; i++)
			if(r < mAcum[i][sAnt])
				return i;
		return -1;
	}
	
	
	float [] probSalga0 () {
		
		int [] emisiones = {0,0,0};
		float [] estAnt = {0,0,0};
		float [] estAct = {0,0,0};
		int mensajes = 0;
		
		do {
			
			int s = this.primerSimbolo();
			for(int i = 0; i < T_FINAL; i++) {		
				s = this.sigEstado(s);
				if(s==0)
					emisiones[i]++;
			}
			mensajes++;	
			for(int i = 0; i<=2; i++) {
				estAnt[i] = estAct[i];
				estAct[i] = (float) emisiones[i] / (float) mensajes;
			}
					
		} while((!this.converge(estAnt, estAct)) || (mensajes < T_MIN));
		
		return estAct;
	}
	

}
