import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		 int [] fin = {3,8,11,18,20,21,24,24,25,29};
		 int [] com = {0,7,5,2,16,11,23,15,12,24};
		 Algoritmo alg = new Algoritmo();
		 alg.seleccionActividades(com, fin);
		 
		int [] a = {8,29,21,11,7,25,24,18,20,24};
		int [] com2 = {7,24,11,5,0,12,23,2,16,15};
		alg.seleccionActividadesMejorado(com2, a);
		alg.seleccionActividadesSinOrden(com2,a );
	}

}
