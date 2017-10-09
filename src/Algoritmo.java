
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
            
        	
            if ((f[i]<= c[j])|| (f[j]<= c[i])){ 
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
		return sol;
	}
}
