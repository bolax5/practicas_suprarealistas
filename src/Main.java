import java.util.Arrays;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x,y,z;
		Algoritmo algo = new Algoritmo();
		AlgoritmoAproximado alg = new AlgoritmoAproximado();

		
		int [] com2 = {7,2,4,1,7,6};
		int [] fin2 = {10,7,6,5,9,8};
		int [] ben2 = {2,2,4,7,4,2};
		
		double [] tasas = new double [com2.length];
		
		for (int i = 0; i<tasas.length; i++){
			tasas[i] = (double)ben2[i]/ (double)(fin2[i]-com2[i]);
		}
		
		int [] a = alg.shell(ben2);
		for (int i = 0; i<tasas.length; i++){
			System.out.println(a[i]);	
		}
		
		x = alg.seleccionActividadesPonderada2(com2, fin2, ben2);
		System.out.println(x);
		alg.seleccionActividadesPonderadoVoraz2(com2, fin2, ben2);
	}

}
