public class PracticaBT {
	int longitud;
	int sol[];
	
	/**
	 * Este metodo es un algoritmo de backtracking que calcula la mejor solucion para el problema de colocacion de n componentes en una placa con n huecos.
	 * 
	 * 
	 * @param N : Matriz de numero de conexiones entre componentes.
	 * @param D : Matriz de distancias entre huecos.
	 * @return : Un array con la mejor solucion.
	 */
	
	public int[] algoritmoBT (int [][] N, int [][] D){
		longitud=Integer.MAX_VALUE;
		sol = new int[N.length];
		int sol_parcial[] = new int[N.length];
		boolean [] escogidos = new boolean[N.length];
		
			for (int i = 0; i < escogidos.length; i++) {
				if(!escogidos[i]){
					escogidos[i] = true;
					algoritmoBTRecur(sol_parcial,escogidos,0,i,N,D);
					escogidos[i] = false;
				}
			}
		imprimirMejorSolucion(sol);
		System.out.println("La longitud minima es: " +longitud);
		return sol;
	}
	
	private void algoritmoBTRecur(int [] sol_parcial, boolean [] escogidos, int etapa, int componente, int [][] N, int [][] D){
		sol_parcial[etapa] = componente;
		if(etapa==sol_parcial.length-1){
			//Soy una hoja
			int x = calcularCable(sol_parcial, N, D);
			
			
			if(x < longitud){
				
				for (int i = 0; i < D.length; i++) {
					sol[i]=sol_parcial[i];
				};
				
				longitud = x;
			}
		}
		else{
			for (int i = 0; i < escogidos.length; i++) {
				if(!escogidos[i]){
					escogidos[i] = true;
					algoritmoBTRecur(sol_parcial,escogidos,etapa+1,i,N,D);
					escogidos[i] = false;
				}
			}
		}
		
	}
	public int calcularCable (int[] sol_parcial, int [][]N, int [][]D){
		int cable = 0;
		for (int i = 0; i < sol_parcial.length; i++) {
			for (int j = i+1; j < sol_parcial.length; j++) {
				cable += D[i][j]*N[sol_parcial[i]][sol_parcial[j]];
				
			}
		}
		return cable;
	}
	private void imprimirMejorSolucion(int [] a){
		System.out.print("La mejor solucion es:" );
		for (int i = 0; i < a.length; i++) {
			if (i==0){
				System.out.print("{"+ a[i] + ", ");
			}else if ((i>0) && (i<a.length-1)){
				System.out.print(a[i] +", ");
			}else{
				System.out.println(a[i] + "}");
			}
		}
	}	
}
