import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int x,y,z;
		
		int [] com = {0,7,5,2,16,11,23,15,12,24}; 
		int [] fin = {3,8,11,18,20,21,24,24,25,29};
		Algoritmo alg = new Algoritmo();
		x = alg.seleccionActividades(com, fin);
		 
		int [] fin2 = {8,29,21,11,3,25,24,18,20,24};
		int [] com2 = {7,24,11,5,0,12,23,2,16,15};
		y =alg.seleccionActividadesMejorado(com2, fin2);
		z = alg.seleccionActividadesSinOrden(com2,fin2 );
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}

}
