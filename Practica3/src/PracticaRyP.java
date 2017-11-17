
public class PracticaRyP {
	int[] sol;
	int longitud;
	int top;
	int [] pS;
	public int [] algoritmoRyP(int[][] N,int [][] D){
		sol = new int[N.length];
		pS = new int[N.length];
		for(int i=0;i<N.length;i++){
			pS[i] = i;
			sol[i] = i;
		}
		top = calcularCable (pS,N,D);
		int sol_parcial[] = new int[N.length];
		boolean [] escogidos = new boolean[N.length];
		longitud=top;
		//  Seteamos las soluciones a -1 //
		for (int i = 0; i < escogidos.length; i++) {
			sol_parcial[i] = -1;
		}
		
		for (int i = 0; i < escogidos.length; i++) {
			
			escogidos[i] = true;
			algoritmoBTRecur(sol_parcial,escogidos,0,i,N,D);
			escogidos[i] = false;
		}
		
		
		imprimirMejorSolucion(sol);
		System.out.println("La longitud minima es: " +longitud);
		return sol;
	}
	
	
	private void algoritmoBTRecur(int [] sol_parcial, boolean [] escogidos, int etapa, int componente, int [][] N, int [][] D){
		sol_parcial[etapa] = componente;
		int cota = calcularCable(sol_parcial, N, D)+calcularCota(N,D,sol_parcial,escogidos,etapa);
		if(etapa==sol_parcial.length-1){
			//Soy una hoja
			
			if(cota<longitud){
				for (int i = 0; i < D.length; i++) {
					sol[i]=sol_parcial[i];
				}
				
				longitud = calcularCable(sol_parcial,N ,D);
				
			}
			sol_parcial[etapa] = -1;
		}
		else{
			
			if (cota<longitud){
				for (int i = 0; i < escogidos.length; i++) {
					if(!escogidos[i]){
						escogidos[i] = true;
						algoritmoBTRecur(sol_parcial,escogidos,etapa+1,i,N,D);
						escogidos[i] = false;
						
					}
				}
			}else{
				for (int i = 0; i < D.length; i++) {
					System.out.print(sol_parcial[i]);
				}
				System.out.print(" => cable= "+cota);
				System.out.println();
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
	private int calcularCota (int [][] N, int [][] D, int [] sol_parcial, boolean []escogidos,int etapa){
		int minimo = 0;
		int aux = 0;
			for (int i = etapa; i<D.length; i++){
				aux = Integer.MAX_VALUE;
				for(int j=i+1;j<D.length; j++){
					if (D[i][j]<aux){
						aux =D[i][j];
					}
				}
				if (aux != Integer.MAX_VALUE)
					minimo += aux;
			}
				
			
		
		//System.out.println(minimo);
		return minimo;
	}
	
}
