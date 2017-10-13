import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		 int [] fin = {3,8,11,18,20,21,24,24,25,29};
		 int [] com = {0,7,5,2,16,11,23,15,12,24};
		 Algoritmo alg = new Algoritmo();
		 alg.seleccionActividades(com, fin);
		 
		int [] a = {8,29,21,11,3,25,24,18,20,24};
	
		boolean [] b = alg.seleccionActividadesMejorado(com, a);
		System.out.println();
		for (int i = 0; i< b.length; i++){
			System.out.println(b[i]+ ", ");
		}
	}

}
