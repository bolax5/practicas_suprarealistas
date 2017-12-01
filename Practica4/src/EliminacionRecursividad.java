
public class EliminacionRecursividad {
	//ALGORITMO DE MEMORIZACIÓN
	public static int mem(int m, int n){
		int resultado[][] = new int [m][n+1];
		for (int i = 0; i<m ; i++){
			for (int j = 0; j<=n;j++){
				resultado[i][j] = -1;
			}
		}
		memAux(m,n,resultado);
		return resultado[m-1][n];
	}
	private static void memAux(int m,int n, int [][] resultado){
		if (m<=2 && n>0){
			resultado[m-1][n] = m*n;
		}else if (n==0){
			resultado[m-1][n] = 5;
		}else{
			memAux(m-1,n,resultado);
			memAux(m,n-1,resultado);
			memAux(m-1,n-1,resultado);
			memAux(m-2,n-1,resultado);
			resultado[m-1][n] = resultado[m-2][n]+resultado [m-1][n-1]+resultado [m-2][n-1]+resultado [m-3][n-1];	
		}	
	}
	//ALGORTIMO DE TABULACION
	public static int tab (int m ,int n){
		int [][] resultado = new int [m][n+1];
			for (int i = 0; i<m; i++){
					resultado[i][0]= 5;
			}
			for(int i = 1; i<=n; i++){	
				resultado[0][i] = 1*i;
				resultado[1][i] = 2*i;
			}
			for (int i=2;i<m;i++){
				for(int j=1;j<=n;j++){
					resultado[i][j] = resultado[i-1][j] + resultado[i][j-1] + resultado[i-1][j-1] + resultado[i-2][j-1];
				}	
			}
		
		return resultado[m-1][n];
		
	}
	//ALGORITMO DE TABULACION OPTIMIZADA
	public static int tabOpt(int m, int n){
		int resultado[] = new int [m];
		int aux1= 0;
		int aux2= 0;
		for(int i = 0; i<m; i++){
			resultado[i] = 5;
		}
		for(int j=1;j<=n;j++)
			for (int i =0; i<m;i++){
				if(i==0){
					aux1 = resultado[i];
					resultado[i] = (i+1) * j;
				}
				else if(i==1){
					aux2 = resultado[i];
					resultado[i] = (i+1) * j;
				}	
				else if ((i<m-1) && (i>1)){
						int a = aux1+aux2+resultado[i-1];
						aux1 =resultado[i];
						resultado[i] = resultado[i]+a;
				}else if (i==m-1){
						resultado[i] = resultado[i]+aux2+aux1+resultado[i-1];
				}
			}
		return resultado[m-1];
	}
	
}
