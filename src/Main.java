import java.util.Random;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AlgoritmoAproximado alg = new AlgoritmoAproximado();

		
		int [] com = {0,2,4,1,7,6};
		int [] fin = {3,7,6,5,9,8};
		int [] ben = {2,7,4,4,2,2};
		
	
		
		alg.seleccionActividadesPonderadoVoraz(com,fin,ben);	 	
		alg.seleccionActividadesPonderadoVoraz2(com, fin, ben);
		alg.seleccionActividadesPonderada(com, fin, ben);
		alg.seleccionActividadesPonderada2(com, fin, ben);
		alg.seleccionActividadesPonderada3(com, fin, ben);
		alg.seleccionActividadesPonderada4(com, fin, ben);
	}

}
