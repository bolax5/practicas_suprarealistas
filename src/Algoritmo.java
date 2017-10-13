
public class Algoritmo {
	
	
	/*En este caso, se espera un array de tiempos finales ordenados de menor a mayor,
	 puesto que el criterio de selección va a ser orden creciente de fin.
	 */
	public boolean[] seleccionActividades(int[] c, int [] f)
    
    {
boolean [] sol = new boolean [c.length];
       
        sol[0] = true;
        int i = 0;
        for (int j = 1; j<c.length; j++){
        	
        	/*Las actividades i y j son compatibles si la i es anterior a la j o viceversa.
        	 Es decir, el tiempo de finalización de la actividad i es menor o igual que el de comienzo de la j,
        	 o el tiempo de finalización de la actividad j es menor o igual que el de comienzo de la i.*/
        	
            if (c[i]>=f[j] || c[j]>= f[i]){ 
            	sol[j] = true;
                i=j;
            }
            else{
                sol[j] = false;
            }    
        }
        
        //Se imprime la solución en forma de array de booleanos.
        
        System.out.print("{");
        for (int k = 0; k<c.length; k++){
        	if(k == c.length-1){
            System.out.print(sol[k]+ "}");
        	}
        	else{
        		System.out.print(sol[k] + ",");
        	}
        }
        return sol;
    }


	public boolean[] seleccionActividadesMejorado (int []c, int [] f){
		boolean [] sol = new boolean [c.length];
		int [] indices = new int [f.length];
		indices = shell(f);
		sol[0] = true;
		int i=0;
		for (int j = 1; j<c.length; j++){
        	
            if ((c[indices[i]]>= f[indices[j]])|| (c[indices[j]]>= f[indices[i]])){ 
            	sol[j] = true;
                i=j;
            }
            else{
                sol[j] = false;
            }    
        }
		return sol;
	}
	/** En este método 
	 * @params: Un array de valores
	 * @return : Un array de índices ordenados con respecto al array introducido */
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
 
}
    
