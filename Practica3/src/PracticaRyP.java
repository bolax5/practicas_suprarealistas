
public class PracticaRyP {
	int[] sol;
	int longitud;
	public int [] algoritmoRyP(int[][] N,int [][] D){
		sol = new int[N.length];
		for(int i=0;i<N.length;i++){
			sol[i] = i;
		}
		longitud = calcularCable (sol,N,D);
		int sol_parcial[] = new int[N.length];
		boolean [] escogidos = new boolean[N.length];
		
		//  Seteamos las soluciones a -1 //
		for (int i = 0; i < escogidos.length; i++) {
			sol_parcial[i] = -1;
		}
		
		for (int i = 0; i < escogidos.length; i++) {
			
			escogidos[i] = true;
			algoritmoRyPRecur(sol_parcial,escogidos,0,i,N,D);
			escogidos[i] = false;
		}
		
		
		imprimirMejorSolucion(sol);
		System.out.println("La longitud minima es: " +longitud);
		return sol;
	}
	
	
	private void algoritmoRyPRecur(int [] sol_parcial, boolean [] escogidos, int etapa,int componente, int [][] N, int [][] D){
		sol_parcial[etapa] = componente;
		int cota = calcularCable(sol_parcial, N, D);
		if(etapa==sol_parcial.length-1){
			//Soy una hoja
			if(cota<longitud){
				for (int i = 0; i < D.length; i++) {
					sol[i]=sol_parcial[i];
				}
				longitud = cota;
				
			}
			sol_parcial[etapa] = -1;
		}
		else{
			cota += calcularCota(D,etapa);
			if (cota<longitud){
				for (int i = 0; i < escogidos.length; i++) {
					if(!escogidos[i]){
						escogidos[i] = true;
						algoritmoRyPRecur(sol_parcial,escogidos,etapa+1,i,N,D);
						escogidos[i] = false;
						
					}
				}
			}
			sol_parcial[etapa] = -1;
		}
		
	}
	public int calcularCable (int[] sol_parcial, int [][]N, int [][]D){
		int cable = 0;
		for (int i = 0; i < sol_parcial.length; i++) {
			for (int j = i+1; j < sol_parcial.length; j++) {
				if(sol_parcial[i]!=-1 && sol_parcial[j]!=-1)
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
	private int calcularCota (int [][] D,int etapa){
		int minimo = 0;
		int aux = 0;
			for (int i = etapa; i<D.length; i++){
				aux = Integer.MAX_VALUE;
				for(int j=i+1;j<D.length; j++){
					if (D[i][j]<aux){
						aux =D[i][j];
					}
				}
				if (aux != Integer.MAX_VALUE){
					minimo += aux;
				}
			}
		return minimo;
	}
	
}
