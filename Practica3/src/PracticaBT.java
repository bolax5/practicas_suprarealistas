import java.util.Arrays;

public class PracticaBT {
	int longitud=Integer.MAX_VALUE;
	int sol[];
	public int[] algoritmoBT (int [][] N, int [][] D){
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
		
		return sol;
	}
	public void algoritmoBTRecur(int [] sol_parcial, boolean [] escogidos, int etapa, int componente, int [][] N, int [][] D){
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
}
