package teoinfo.practico1;

public class Main {
	
	public static void main(String args[]) {
		
		Ejercicio1 e1 = new Ejercicio1();
		Ejercicio2 e2 = new Ejercicio2();
		Ejercicio4 e4 = new Ejercicio4();
		Ejercicio9 e9 = new Ejercicio9();
		Ejercicio11 e11 = new Ejercicio11();
		/*System.out.println("Casos con reposicion (independencia): ");
		System.out.println();
		System.out.println("La probabilidad de que al menos saque un sobre fácil en dos extracciones es:"+ e1.ejercicio1A());
		System.out.println("La probabilidad de que saque un sobre fácil en dos extracciones es:"+ e1.ejercicio1B());
		System.out.println("La probabilidad de que saque un sobre fácil en una extracción es:"+ e1.ejercicio1C());
		System.out.println();
		
		System.out.println("Casos sin reposición: ");
		System.out.println();
		System.out.println("La probabilidad de que al menos saque un sobre fácil en dos extracciones es:"+ e2.ejercicio2A());
		System.out.println("La probabilidad de que saque un sobre fácil en dos extracciones es:"+ e2.ejercicio2B());
		System.out.println("La probabilidad de que saque un sobre fácil dado que el primero fue fácil:"+ e2.ejercicio2C());
		System.out.println();
		
		System.out.println("Ejercicio 4 ");
		System.out.println();
		System.out.println("La probabilidad de que de negativo si la persona está sana:"+ e4.ejercicio4A());
		System.out.println("La probabilidad de que de positivo si la persona está enferma:"+ e4.ejercicio4B());
		
		System.out.println("La media muestral del Ejercicio 1 es: " + e9.mediaEjercicio1A());
		
		float probabilidadA [] = e11.probA();
		float probabilidadB [] = e11.probB();
		for(int i = 0; i< probabilidadA.length;i++)
			System.out.println("A = " +(i+2) + " tiene una probabilidad de: "+ probabilidadA[i]);
		for(int i = 0; i< probabilidadB.length;i++)
			System.out.println("B = " +(i+1) + " tiene una probabilidad de: "+ probabilidadB[i]);
		
		float probabilidadAB [][]= e11.probConjuntaAB();
		for(int i = 0; i< 3;i++) {
			for(int j = 0; j<5; j++)
				System.out.println("Con A= "+ (j+2) + " , y B= "+ (i+1) + " la probabilidad es: " + probabilidadAB[i][j] );
			System.out.println();
			
		}
		
		float probabilidadCondicionalBA [][] = e11.probCondicionalBA();
		for(int i = 0; i< 3;i++) {
			for(int j = 0; j<5; j++)
				System.out.println("La probabilidad de B = "+ (i+1) + " dado A = " + (j+2) + " es de: " + probabilidadCondicionalBA[i][j] );
			System.out.println();
			
		}
		
		float probabilidadCondicionalAB [][] = e11.probCondicionalAB();
		for(int i = 0; i< 3;i++) {
			for(int j = 0; j<5; j++)
				System.out.println("La probabilidad de A = "+ (j+2) + " dado B = " + (i+1) + " es de: " + probabilidadCondicionalAB[i][j] );
			System.out.println();
			
		}
		
		System.out.println("La media muestral de A es: "+  e11.mediaA());
		System.out.println("La media muestral de B es: "+  e11.mediaB());
		
		System.out.println("El desvio muestral de A es: "+ e11.desvioA());
		System.out.println("El desvio muestral de B es: "+ e11.desvioB());
		
		
		System.out.println("La covarianza de A y B es : "+ e11.covAB());*/
		
		float [] estimacionBdadoA = e11.estimacionBA();
		
		System.out.println("La estimación de B dado A da como resultado: ");
		for(int i = 0; i < 5; i++)
			System.out.println("A = " + (i+2) + " es: " + estimacionBdadoA[i]);
		
	
	
	}
	
}
