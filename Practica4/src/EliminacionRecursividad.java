
public class EliminacionRecursividad {
	//ALGORITMO DE MEMORIZACIÓN
	public static int mem(int m, int n){
		int resultado[][] = new int [m][n+1];
		for (int i = 0; i<m ; i++){
			for (int j = 0; j<=n;j++){
				resultado[i][j] = -1;
			}
		}
		//Se llama a un metodo auxiliar que se va a encargar de almacenar los valores en las tablas
		memAux(m,n,resultado);
		return resultado[m-1][n];
	}
	private static void memAux(int m,int n, int [][] resultado){
		/*Estas dos primeras comprobaciones sirven para rellenar las posiciones de la tabla 
		 que se corresponden con los casos base
		 */
		if (m<=2 && n>0){
			resultado[m-1][n] = m*n;
		}else if (n==0){
			resultado[m-1][n] = 5;
		}else{
			
			/*Este ultimo apartado calcula los casos recursivos*/
			
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
			/*Los dos primeros bucles se encargan de rellenar las posiciones de la tabla que se corresponderian
			 * con los anteriores casos base.
			 */
			for (int i = 0; i<m; i++){
					resultado[i][0]= 5;
			}
			for(int i = 1; i<=n; i++){	
				resultado[0][i] = 1*i;
				resultado[1][i] = 2*i;
			}
			/*
			 * Este bucle rellena las posiciones que serian las llamadas recursivas.
			 * Como se puede observar, en este metodo se ha eliminado la recursividad por completo.
			 */
			for (int i=2;i<m;i++){
				for(int j=1;j<=n;j++){
					resultado[i][j] = resultado[i-1][j] + resultado[i][j-1] + resultado[i-1][j-1] + resultado[i-2][j-1];
				}	
			}
		
		return resultado[m-1][n];
		
	}
	//ALGORITMO DE TABULACION OPTIMIZADA
	public static int tabOpt(int m, int n){
		/*
		 * En este metodo la principal diferencia con el anterior, es la reduccion de una matriz a un vector.
		 * que junto con algunas variables auxiliares, es suficiente para realizar cada uno de los calculos.
		 * Las diferentes comprobaciones que hay, son para saber en que posicion de la tabla estamos, y asi poder
		 * almacenar aquellos datos que nos sean relevantes.
		 */
		int resultado[] = new int [m];
		int aux1= 0;
		int aux2= 0;
		for(int i = 0; i<m; i++){
			resultado[i] = 5;
		}
		for(int j=1;j<=n;j++)
			for (int i =0; i<m;i++){
				if(i==0){
					aux2 = resultado[i];
					resultado[i] = (i+1) * j;
				}
				else if(i==1){
					aux1 = resultado[i];
					resultado[i] = (i+1) * j;
				}	
				else if ((i<m-1) && (i>1)){
						int a = aux1+aux2+resultado[i-1];
						aux2 = aux1;
						aux1 =resultado[i];
						resultado[i] = resultado[i]+a;
				}else if (i==m-1){
						resultado[i] = resultado[i]+aux2+aux1+resultado[i-1];
				}
			}
		return resultado[m-1];
	}
	
}
