package teoinfo.practico1;

public class Ejercicio9 {
	
	private final double ERROR = 0.00001;
	private final int MAX_MUESTRAS = 10;
	
	public boolean converge(float pAnt, float pAct) {
		
		return(Math.abs(pAnt-pAct) < ERROR);
		
	}
	
	public float mediaEjercicio1A() {
		
		Ejercicio1 e1 = new Ejercicio1();
		int muestras = 0;
		float mediaAnt = 0; float mediaAct = 0;
		float suma = 0;
		
		do {
			float p = e1.ejercicio1A(); //Solo me sirve para mostrar a p en la iteración (muestra) 
			suma+= p;
			muestras++;
			System.out.println("p en iteración "+ muestras + " es: " + p);
			mediaAnt = mediaAct;
			mediaAct = suma / (float) muestras;
			System.out.println("media en iteración "+ muestras + " es: " + mediaAct);
			System.out.println(".........................");
			
		} while((!this.converge(mediaAnt, mediaAct))&&(muestras < MAX_MUESTRAS));
		
		
		return mediaAct;
	}

}
