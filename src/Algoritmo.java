
public class Algoritmo {
	
	/**
	 * 
	 * @param c Un array de comienzos
	 * @param f Un array de tiempos de fin ordenados de menor a mayor
	 * @return Un array de booleanos. La actividad i es TRUE si ha sido seleccionada, FALSE en caso contrario.
	 */
	
	/*En este caso, se espera un array de tiempos finales ordenados de menor a mayor,
	 puesto que el criterio de selecci�n va a ser orden creciente de fin.
	 */
	public boolean[] seleccionActividades(int[] c, int [] f){
		boolean [] sol = new boolean [c.length];
        sol[0] = true;
        int i = 0;
        for (int j = 1; j<c.length; j++){
        	
        	/*Las actividades i y j son compatibles si la i es anterior a la j o viceversa.
        	 Es decir, el tiempo de finalizaci�n de la actividad i es menor o igual que el de comienzo de la j,
        	 o el tiempo de finalizaci�n de la actividad j es menor o igual que el de comienzo de la i.*/
        	
            if (c[i]>=f[j] || c[j]>= f[i]){ 
            	sol[j] = true;
                i=j;
            }
            else{
                sol[j] = false;
            }    
        }
       
        //Se imprime la soluci�n en forma de array de booleanos.
        
        ImprimirSolucion("La soluci�n para el primer ejercicio es: ", sol);
        return sol;
    }

	/**
	 * 
	 * @param c Un array de tiempos de comienzo
	 * @param f Un array de tiempos de fin
	 * @return  Un array de booleanos. La actividad i es TRUE si ha sido seleccionada, FALSE en caso contrario.
	 */
	public boolean[] seleccionActividadesMejorado (int []c, int [] f){
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [f.length];
		
		/*Este array de indices contiene el n�mero de orden que le corresponde a cada actividad*/
		
		indices = shell(f);
		sol[indices[0]] = true;
		int i=0;
		for (int j = 1; j<c.length; j++){
        	
			
			/*En este apartado como las actividades no est�n ordenadas de ninguna forma hay que tener en
        	  cuenta el correspondiente �ndice de cada actividad, bien sea para comparar o para marcarla como
        	  v�lida o no.
        	 */
            if (c[indices[i]]>= f[indices[j]] || c[indices[j]]>= f[indices[i]]){ 
            	sol[indices[j]] = true;
                i=j;
            }
            else{
                sol[indices[j]]= false;
            }    
        }
		
		ImprimirSolucion("\nLa soluci�n para el segundo ejercicio es:", sol);
		return sol;
		
	}
	public boolean[] seleccionActividadesSinOrden(int [] c, int [] f){
		boolean sol [] = new boolean [c.length];
		int tiempoMenor = f[0];
		int tiempoMaximo = f[0];
		int indice = 0;
		for (int i = 1; i < c.length; i++){
			if (f[i]<tiempoMenor){
				tiempoMenor = f[i];
				indice = i;
			}
			if (f[i]>tiempoMaximo){
				tiempoMaximo = f[i];
			}	
		}
		sol[indice] = true;
		int tiempoAnterior;
		int cont = 0;
		tiempoAnterior=tiempoMenor;
		tiempoMenor=tiempoMaximo;
		int indiceNuevo = 0;
		while(cont<c.length){
		for (int i = 0; i<c.length; i++){
			if (sol[i]==true){
				continue;
			}
			if ((f[i]>tiempoAnterior) && (f[i]<= tiempoMenor)){
				tiempoMenor = f[i];
				indiceNuevo = i;
			}
			
		}
		if((c[indice] >= f[indiceNuevo])||(c[indiceNuevo]>=f[indice])){
			sol[indiceNuevo] = true;
			indice= indiceNuevo;
		}
		
		tiempoAnterior= tiempoMenor;
		tiempoMenor = tiempoMaximo;
		cont++;
		}
		
		ImprimirSolucion("Tercera solucion" ,sol);
		return sol;
		
	}
	
	/** En este m�todo 
	 * @params: Un array de valores
	 * @return : Un array de �ndices ordenados con respecto al array introducido */
    
	private  int [] shell (int valores[]){
        int salto, aux, i, z;
        int indices[] = new int [valores.length];
        for (z=0;z<indices.length;z++){
            indices[z]=z;
        }
        boolean cambios;
        for(salto=indices.length/2; salto!=0; salto/=2){
            cambios=true;
            while(cambios){ // Mientras se intercambie alg�n elemento
                cambios=false;
                for(i=salto; i< indices.length; i++) // se da una pasada
                    if(valores[indices[i-salto]]>valores[indices[i]]){ // y si est�n desordenados
                            aux=indices[i]; // se reordenan
                            indices[i]=indices[i-salto];
                            indices[i-salto]=aux;
                            cambios=true; // y se marca como cambio.
                    }
                
            }
        }
        return indices;
    }
    
	/* M�todo privado para imprimir por pantalla la soluci�n */
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
	// Este es el mio, dale un chance a ver que tal se comporta, si funciona tambien, tenemos mas variantes para el informe
	public boolean[] seleccionActividadesmejora2(int[] c, int [] f){
		boolean [] sol = new boolean [c.length];
        
		int i;
		int min = 0;
		for (i = 0;i<c.length; i++){
			if (f[min]>f[i])
				min = i;
		}
		sol[min] = true;
		boolean solucion = true;

		while (solucion){
			solucion = false;
			for ( i = 0; i<c.length; i++){
				if ((f[i]>f[min]) && c[i]>= f[min]){ 
					sol[i] = true;
					min = i;
					solucion = true;
				} 
			}
		}
        
       
        //Se imprime la soluci�n en forma de array de booleanos.
        
        ImprimirSolucion("La soluci�n para el primer ejercicio es: ", sol);
        return sol;
    }
	
}
    
