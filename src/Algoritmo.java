
public class Algoritmo {
	
	/**
	 * 
	 * @param c Un array de comienzos
	 * @param f Un array de tiempos de fin ordenados de menor a mayor
	 * @return Un array de booleanos. La actividad i es TRUE si ha sido seleccionada, FALSE en caso contrario.
	 */
	
	/*En este caso, se espera un array de tiempos finales ordenados de menor a mayor,
	 puesto que el criterio de selección va a ser orden creciente de fin.
	 */
	public int seleccionActividades(int[] c, int [] f){
		boolean [] sol = new boolean [c.length];
        sol[0] = true;
        int numActividades = 1;
        int i = 0;
        for (int j = 1; j<c.length; j++){
        	
        	/*Las actividades i y j son compatibles si la i es anterior a la j o viceversa.
        	 Es decir, el tiempo de finalización de la actividad i es menor o igual que el de comienzo de la j,
        	 o el tiempo de finalización de la actividad j es menor o igual que el de comienzo de la i.*/
        	
            if ( c[j]>= f[i]||c[i]>=f[j]){ 
            	sol[j] = true;
                i=j;
                numActividades++;
            }
            else{
                sol[j] = false;
            }    
        }
       
        //Se imprime la solución en forma de array de booleanos.
        
        ImprimirSolucion("La solución para el primer método es: ", sol);
        return numActividades;
    }

	/**
	 * 
	 * @param c Un array de tiempos de comienzo
	 * @param f Un array de tiempos de fin
	 * @return  Un array de booleanos. La actividad i es TRUE si ha sido seleccionada, FALSE en caso contrario.
	 */
	public int seleccionActividadesMejorado (int []c, int [] f){
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [f.length];
		int numActividades = 1;
		
		/*Este array de indices contiene el número de orden que le corresponde a cada actividad*/
		
		indices = shell(f);
		sol[indices[0]] = true;
		int i=0;
		for (int j = 1; j<c.length; j++){
        	
			
			/*En este apartado como las actividades no están ordenadas de ninguna forma hay que tener en
        	  cuenta el correspondiente índice de cada actividad, bien sea para comparar o para marcarla como
        	  válida o no.
        	 */
            if (c[indices[i]]>= f[indices[j]] || c[indices[j]]>= f[indices[i]]){ 
            	sol[indices[j]] = true;
                i=j;
                numActividades++;
            }
            else{
                sol[indices[j]]= false;
            }    
        }
		
		ImprimirSolucion("\nLa solución para el segundo método es:", sol);
		return numActividades;
		
	}

	
	/** En este método 
	 * @params: Un array de valores
	 * @return : Un array de índices ordenados con respecto al array introducido */
    
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
	/**
	 * 
	 * @param c : Un array de valores de comienzo sin orden
	 * @param f	: Un array de valores de fin sin orden
	 * @return 
	 */
	public int seleccionActividadesSinOrden(int[] c, int [] f){
		boolean [] sol = new boolean [c.length];
        int numActividades =1;
		int i;
		int min = 0;
		for (i = 0;i<c.length; i++){
			if (f[min]>f[i])
				min = i;
		}
		sol[min] = true;
		boolean solucion = true;
		int minAux = min;
		while (solucion){
			solucion = false;
			for (i = 0; i<c.length; i++){
				
				/*Se comprueba si es el siguiente fin, si lo es, se comprueba que sea compatible.
				Si no, hay que buscar un nuevo mínimo y empezar de nuevo el bucle*/
				if (esMinimo(f[minAux],f[i],f)){ 
					if(c[i]>= f[min]){
						sol[i] = true;
						min = i;
						solucion = true;
						numActividades++;
						break;
						
					}	
					else{
						minAux = i;
						i=-1;
					}
				}
			}
		}
        
       
        //Se imprime la solución en forma de array de booleanos.
        
        ImprimirSolucion("La solución para el tercer método es: ", sol);
        return numActividades;
    }
	/*Este método devuelve TRUE si candidato es justo el tiempo siguiente más pequeño en orden
	 * del array, FALSE en otro caso */
	 
	private boolean esMinimo (int antiguoMenor, int candidato, int [] array){
		int menor = Integer.MAX_VALUE;
		for (int i = 0; i<array.length; i++){
			if ((array[i]>antiguoMenor) && (array[i]<=menor )){
				menor = array[i];
			}
		}
		return menor == candidato;
	}
}
    
