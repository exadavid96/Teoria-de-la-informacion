package teoinfo.practico2;

public class Main {
	
	
	public static void main(String args[]) {
		
		
		Ejercicio2b e2b = new Ejercicio2b();
		Ejercicio3a e3a = new Ejercicio3a();
		Ejercicio4c e4c = new Ejercicio4c();
		
		/*float [] vectorEstacionario2b = e2b.vectorEstacionario();
		for(int i = 0; i <= 2; i++)
			System.out.print(vectorEstacionario2b[i] + ", ");
		
		float [] probabilidadSalga0 = e3a.probSalga0();
		for(int i = 0; i <= 2; i++)
			System.out.println("La probabilidad de que salga un 0 en el tiempo "+ (i+1) + " es: " + probabilidadSalga0[i]);*/
			
		float [] probabilidadSalgan2simbolos = e4c.probSalgan2simb();
		for(int i = 0; i <= 2; i++)
			System.out.println("La probabilidad de que salgan dos  "+ (i+1) + " seguidos es: " + probabilidadSalgan2simbolos[i]);
	}

}
