  

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AlgoritmoAproximado alg = new AlgoritmoAproximado();
		
		int [] com2 = {0,0,1,2,3,4};
		int [] fin2 = {4,1,2,3,4,5};
		int [] ben2 = {60,50,50,50,50,50};
		
		
		/*int [] com2 = {0,2,4,1,7,6};
		int [] fin2 = {3,7,6,5,9,8};
		int [] ben2 = {2,7,4,4,2,2};
		/*int [] com2 = {3,7,1,5,4,8};
		int [] fin2 = {5,8,4,7,8,10};
		int [] ben2 = {4,3,5,1,6,3};*/
		
		
	 	alg.seleccionActividadesPonderadoVoraz(com2, fin2, ben2);
	 	alg.seleccionActividadesPonderadoVoraz2(com2, fin2, ben2);
		alg.seleccionActividadesPonderada(com2, fin2, ben2);
		alg.seleccionActividadesPonderada2(com2, fin2, ben2);
		alg.seleccionActividadesPonderada3(com2, fin2, ben2);
		alg.seleccionActividadesPonderada4(com2, fin2, ben2);
	}

}
