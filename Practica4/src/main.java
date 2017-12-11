
public class main {

	public static void main(String[] args) {
		
		int c = EliminacionRecursividad.mem(4, 2);
		System.out.println("El resultado para el algoritmo de memorizacion es : " + c);
		c = EliminacionRecursividad.tab(4, 2);
		System.out.println("El resultado para el algoritmo de tabulacion es : " + c);
		c = EliminacionRecursividad.tabOpt(4, 2);
		System.out.println("El resultado para el algoritmo de tabulacion optimizada es : " + c);
		
		
		int GCD[] = {200,50,100,75,100,50,80};
		double RCD[] = {1.01,1.02,1.1,1.03,1.1,1.2,1.06};
		int GBT[] = {75,100,200,50,200,50,75};
		double RBT[] = {1.03,1.5,1.3,1.2,1.02,1.2,1.05};
		
		ProgramacionDinamica pd = new ProgramacionDinamica();
		double d = pd.beneficio(4000, GCD, RCD, GBT, RBT);
		int [] arr = pd.beneficioSolucion(4000, GCD, RCD, GBT, RBT);
		System.out.println("El beneficio obtenido es : " + d);
		
		System.out.print("La solucion es : {");
		for (int i = 0;i<arr.length;i++){
			if(i==arr.length-1){
			System.out.print(arr[i]+ "}");
			}else{
				System.out.print(arr[i] +", ");
			}
		}
	}

}
