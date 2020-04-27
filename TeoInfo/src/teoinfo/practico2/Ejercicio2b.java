package teoinfo.practico2;

public class Ejercicio2b {
	
	private final double ERROR = 0.0001;
	private final int T_MIN = 100;
	
	public Ejercicio2b() {};
	
	
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
		float mAcum [][] = { {0,1/4f,1/4f} , {1/2f,3/4f,1/2f} , {1, 1, 1} };
		for( int i = 0; i<=2; i++)
			if(r < mAcum[i][sAnt])
				return i;
		return -1;
	}
	
	
	float[] vectorEstacionario() {
		
		int [] emisiones = {0,0,0};
		float [] v_est_ant = {0,0,0};
		float [] v_est_act = {0,0,0};
		int transiciones = 0;
		int s = this.primerSimbolo();
		
		do {
			
			s = this.sigEstado(s);
			emisiones[s]++;
			transiciones++;
			for(int i = 0; i <=2; i++) {
				
				v_est_ant[i] = v_est_act[i];
				v_est_act[i] = (float) emisiones[i] / (float) transiciones;}
			
			} while((!this.converge(v_est_ant, v_est_act)) || (transiciones < T_MIN));
			
		return v_est_act;
			
		}
		
		
		
	
	
	
	
	
	
}
