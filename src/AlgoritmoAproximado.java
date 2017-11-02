import java.util.Arrays;

public class AlgoritmoAproximado {
	public int seleccionActividadesPonderadoVoraz (int [] c, int [] f, int [] b){
		
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [f.length];
		
		int numActividades = 1;
		
		/*Este array de indices contiene el número de orden que le corresponde a cada actividad*/
		
		indices = shell(b);
		int i = b.length-1;
		sol[indices[i]] = true;
		for (int j = b.length-2; j>=0; j--){
			
			/*En este apartado como las actividades no están ordenadas de ninguna forma hay que tener en
        	  cuenta el correspondiente índice de cada actividad, bien sea para comparar o para marcarla como
        	  válida o no.
        	 */
            if ((c[indices[i]]>= f[indices[j]] || c[indices[j]]>= f[indices[i]])&&f[indices[j]] != -1){
            	
            	sol[indices[j]] = true;
                numActividades++;
            }
            else{
                sol[indices[j]]= false;
                f[indices[j]] = -1;
            }    
        }
		
		ImprimirSolucion("\nLa solución para el primer método es:", sol);
		return numActividades;
	}
	public int seleccionActividadesPonderadoVoraz2 (int []c, int [] f, int [] b){
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [f.length];
		double [] tasas = new double [b.length];
		
		for (int i = 0; i<tasas.length; i++){
			tasas[i] = (double) b[i]/ (double)(f[i]-c[i]);
		}
		int numActividades = 1;
		
		/*Este array de indices contiene el número de orden que le corresponde a cada actividad*/
		
		indices = shell(tasas);
		int i = b.length-1;
		sol[indices[i]] = true;
		for (int j = b.length-2; j>=0; j--){
			
			/*En este apartado como las actividades no están ordenadas de ninguna forma hay que tener en
        	  cuenta el correspondiente índice de cada actividad, bien sea para comparar o para marcarla como
        	  válida o no.
        	 */
            if ((c[indices[i]]>= f[indices[j]] || c[indices[j]]>= f[indices[i]])&&(f[indices[j]]!=-1)){ 
            	i=j;
            	sol[indices[j]] = true;
                numActividades++;
            }
            else{
            	f[indices[j]] = -1;
                sol[indices[j]]= false;
               
             }    
        }
		
		
		ImprimirSolucion("\nLa solución para el segundo método es:", sol);
		return numActividades;
	}

	public int seleccionActividadesPonderada(int [] c, int [] f, int [] b){
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [c.length];
		indices = shell(b);
		
		int beneficio = 0;
		for (int i= b.length-1; i>=b.length/2; i--){
			beneficio += b[indices[i]];
		}
		return beneficio;
	}
	
	
	
	public int seleccionActividadesPonderada2(int [] c, int [] f , int [] b){
		boolean [] sol = new boolean [c.length];
		int media = 0;
		for (int i = 0; i<b.length; i++){
			media = media + b[i];
		}
		media = media/b.length;
		System.out.println(media);
		int beneficio = 0;
		for (int i = 0; i<b.length; i++){
			if (beneficio + b[i]<= media){
				beneficio += b[i];
				sol[i] = true;
			}
		
		}
		ImprimirSolucion("Hola:",sol);
		return beneficio;
	}
	
	
	
	/** En este método 
	 * @params: Un array de valores
	 * @return : Un array de índices ordenados con respecto al array introducido */
    
	public  int [] shell (double valores[]){
        int salto, aux, i, z;
        int indices[] = new int [valores.length];
        for (z=0;z<indices.length;z++){
            indices[z]=z;
        }
        boolean cambios;
        for(salto=indices.length/2; salto!=0; salto/=2){
            cambios=true;
            while(cambios){ // Mientras se intercambie algún elemento
                cambios=false;
                for(i=salto; i< indices.length; i++) // se da una pasada
                    if(valores[indices[i-salto]]>valores[indices[i]]){ // y si están desordenados
                            aux=indices[i]; // se reordenan
                            indices[i]=indices[i-salto];
                            indices[i-salto]=aux;
                            cambios=true; // y se marca como cambio.
                    }
                
            }
        }
        return indices;
    }
	public  int [] shell (int valores[]){
        int salto, aux, i, z;
        int indices[] = new int [valores.length];
        for (z=0;z<indices.length;z++){
            indices[z]=z;
        }
        boolean cambios;
        for(salto=indices.length/2; salto!=0; salto/=2){
            cambios=true;
            while(cambios){ // Mientras se intercambie algún elemento
                cambios=false;
                for(i=salto; i< indices.length; i++) // se da una pasada
                    if(valores[indices[i-salto]]>valores[indices[i]]){ // y si están desordenados
                            aux=indices[i]; // se reordenan
                            indices[i]=indices[i-salto];
                            indices[i-salto]=aux;
                            cambios=true; // y se marca como cambio.
                    }
                
            }
        }
        return indices; 
	}
	/* Método privado para imprimir por pantalla la solución */
    private void ImprimirSolucion (String s, boolean [] sol){
    	System.out.println(s);
    	System.out.print("{");
        for (int k = 0; k<sol.length; k++){
        	if(k == sol.length-1){
            System.out.println(sol[k]+ "}");
        	}
        	else{
        		System.out.print(sol[k] + ",");
        	}
        }	
	}
}
