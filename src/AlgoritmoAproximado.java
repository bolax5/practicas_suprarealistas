import java.util.Random;

public class AlgoritmoAproximado {
	
	/**
	 * 
	 * @param c : Un array de valores de comienzo sin orden
	 * @param f	: Un array de valores de fin sin orden
	 * @param b : Un array de beneficios sin ordenar
	 * @return El beneficio obtenido.Además, imprime por pantalla, el array de soluciones y el beneficio
	 */
	public int seleccionActividadesPonderadoVoraz (int [] c, int [] f, int [] b){
		
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [f.length]; 

		/*Este array de indices contiene el número de orden que le corresponde a cada actividad
		 con respecto a su beneficio.*/
		
		indices = shell(b);
		int i = 0;
		sol[indices[i]] = true;
		int ben = b[indices[i]];
		
		for (int j = 1 ;j<b.length; j++){
			
			/*En este apartado como las actividades no están ordenadas de ninguna forma hay que tener en
        	  cuenta el correspondiente índice de cada actividad, bien sea para comparar o para marcarla como
        	  válida o no.Además en este algoritmo al haberse incluido la maximizacion de beneficio, es necesario
        	  comprobar cada actividad con el resto, puesto que hay que saber si es compatible no solo con respecto
        	  a la anterior si no con todas.
        	 */
			
            	sol[indices[j]] = esCompatible(c,f,sol,indices[j]);
            	if (sol[indices[j]])
            		ben += b[indices[j]];
        }

		ImprimirSolucion("La solución para el algoritmo voraz con función de selección de coger el mayor beneficio es:", sol);
		System.out.println("El beneficio es : " + ben);
		return ben;
	}
	
	/**
	 * 
	 * @param c : Un array de valores de comienzo sin orden
	 * @param f	: Un array de valores de fin sin orden
	 * @param b : Un array de beneficios sin ordenar
	 * @return El beneficio obtenido.Además, imprime por pantalla, el array de soluciones y el beneficio
	 */
	public int seleccionActividadesPonderadoVoraz2 (int []c, int [] f, int [] b){
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [f.length];
		double [] tasas = new double [b.length];
		
		for (int i = 0; i<tasas.length; i++){
			tasas[i] = (double) b[i]/ (double)(f[i]-c[i]);
		}
		
		/*Este array de indices contiene el número de orden que le corresponde a cada actividad*/
		
		indices = shell(tasas);
		int i = 0;
		sol[indices[i]] = true;
		int ben = b[indices[i]];
		for (int j = 1; j<b.length; j++){
			
			/*En este apartado como las actividades no están ordenadas de ninguna forma hay que tener en
        	  cuenta el correspondiente índice de cada actividad, bien sea para comparar o para marcarla como
        	  válida o no.
        	 */
			
            	sol[indices[j]] = esCompatible(c,f,sol,indices[j]);
            	if(sol[indices[j]])
                ben += b[indices[j]];
            }
		ImprimirSolucion("\nLa solución para el algoritmo voraz con función de selección de coger la mayor tasa beneficio/duracion es:", sol);
		System.out.println("El beneficio es : " +ben);
		return ben;
	}
	
	/**
	 * 
	 * @param c : Un array de valores de comienzo sin orden
	 * @param f	: Un array de valores de fin sin orden
	 * @param b : Un array de beneficios sin ordenar
	 * @return El beneficio obtenido.Además, imprime por pantalla, el array de soluciones y el beneficio
	 */
	public int seleccionActividadesPonderada(int [] c, int [] f, int [] b){
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [c.length];
		indices = shell(b);
		
		int beneficio = 0;
		int i = 0;
		beneficio += b[indices[i]];
		sol[indices[i]] = true;
		for (int j= 1; j<f.length; j++){
			
			/*Esta condicion es la que cambia con respecto al correspondiente voraz. Solo se escogen aquellas
			que empiecen despues de que haya acabado la anterior seleccionada.*/
			
			if(c[indices[j]]>=f[indices[i]]){
				beneficio += b[indices[j]];
				sol[indices[j]] = true;
				i=j;
			}
			
			
		}
		ImprimirSolucion("\nLa solución para el algoritmo aproximado con la primera funcion de aproximacion es: ", sol);
		System.out.println("El beneficio es "+ beneficio);
		return beneficio;
	}
	
	/**
	 * 
	 * @param c : Un array de valores de comienzo sin orden
	 * @param f	: Un array de valores de fin sin orden
	 * @param b : Un array de beneficios sin ordenar
	 * @return El beneficio obtenido.Además, imprime por pantalla, el array de soluciones y el beneficio
	 */
	public int seleccionActividadesPonderada2(int []c, int [] f, int [] b){
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [f.length];
		double [] tasas = new double [b.length];
		
		for (int i = 0; i<tasas.length; i++){
			tasas[i] = (double) b[i]/ (double)(f[i]-c[i]);
		}
		
		
		
		indices = shell(tasas);
		int i = 0;
		sol[indices[i]] = true;
		int beneficio = b[indices[i]];
		for (int j = 1; j<f.length; j++){
			
			/*Esta condicion es la que cambia con respecto al correspondiente voraz. Solo se escogen aquellas
			que empiecen despues de que haya acabado la anterior seleccionada.*/
			if(c[indices[j]]>=f[indices[i]]){
				beneficio += b[indices[j]];
				sol[indices[j]] = true;
				i=j;
			}
		}
		ImprimirSolucion("\nLa solución para el algoritmo aproximado con la segunda funcion de aproximacion es:",sol);
		System.out.println("El beneficio es : "+ beneficio);
		return beneficio;
	}
	
	/**
	 * 
	 * @param c : Un array de valores de comienzo sin orden
	 * @param f	: Un array de valores de fin sin orden
	 * @param b : Un array de beneficios sin ordenar
	 * @return El beneficio obtenido.Además, imprime por pantalla, el array de soluciones y el beneficio
	 */
	public int seleccionActividadesPonderada3(int [] c, int [] f , int [] b){
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [f.length];
		int media = 0;
		for (int i = 0; i<b.length; i++){
			media = media + b[i];
		}
		media = media/b.length;
		indices = shell(b);
		int beneficio = 0;
		for (int i = 0; i<b.length; i++){
			
			/* En este caso se comprueba que el beneficio de la actividad candidata, sumado al acumulado
			  no supere la media de beneficios. Si es así se marca como solución*/
			 
			if (beneficio + b[indices[i]]<= media){
				beneficio += b[indices[i]];
				sol[indices[i]] = true;
			}
		
		}
		ImprimirSolucion("\nLa solución para el algoritmo aproximado con la tercera funcion de aproximacion es:",sol);
		System.out.println("El beneficio es : "+ beneficio);
		return beneficio;
	}
	
	/**
	 * 
	 * @param c : Un array de valores de comienzo sin orden
	 * @param f	: Un array de valores de fin sin orden
	 * @param b: Un array de beneficios sin ordenar
	 * @return El beneficio obtenido.Además, imprime por pantalla, el array de soluciones y el beneficio
	 */
	
	public int seleccionActividadesPonderada4(int [] c,int [] f, int [] b){
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [f.length];
		double [] tasas = new double [b.length];
		
		for (int i = 0; i<tasas.length; i++){
			tasas[i] = (double) b[i]/ (double)(f[i]-c[i]);
		}
		indices = shell(tasas);
		int media = 0;
		for (int i = 0; i<b.length; i++){
			media = media + b[i];
		}
		media = media/b.length;
		int beneficio = 0;
		for (int i = 0; i<b.length; i++){
			
			/* En este caso se comprueba que el beneficio de la actividad candidata, sumado al acumulado
			  no supere la media de beneficios. Si es así se marca como solución*/
			
			if (beneficio + b[indices[i]]<= media){
				beneficio += b[indices[i]];
				sol[indices[i]] = true;
			}
		}
ImprimirSolucion("\nLa solución para el algoritmo aproximado con la tercera funcion de aproximacion es:",sol);
		System.out.println("El beneficio es : " + beneficio);
		return beneficio;
	}
	//Se implementa este método para que admita un array de double.
	
	/** En este método 
	 * @params: Un array de valores
	 * @return : Un array de índices ordenados con respecto al array introducido */
    
	
	private  int [] shell (double valores[]){
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
                    if(valores[indices[i-salto]]<valores[indices[i]]){ // y si están desordenados
                            aux=indices[i]; // se reordenan
                            indices[i]=indices[i-salto];
                            indices[i-salto]=aux;
                            cambios=true; // y se marca como cambio.
                    }
                
            }
        }
        return indices;
    }
	private  int [] shell (int valores[]){
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
                    if(valores[indices[i-salto]]<valores[indices[i]]){ // y si están desordenados
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
     * Este método compara una actividad candidata con el resto de actividades seleccionadas,
     * para comprobar si es compatible con todas.
     * @param c .Array de tiempos de comienzo.
     * @param f	.Array de tiempos de fin.
     * @param sol .Array de solucion.
     * @param act .Actividad a comparar.
     * @return
     */
    private boolean esCompatible(int [] c, int [] f, boolean[] sol, int act){
    	for (int i = 0; i<sol.length;i++){
    		if(sol[i]==true){
    			if (!(c[act]>= f[i])&& !(c[i]>=f[act])){
    				return false;
    			}
    		}
    	}
    	return true;
    }

	
}
