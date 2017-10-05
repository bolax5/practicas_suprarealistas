
public class Algoritmo {
	public boolean[] seleccionActividades(int[] c, int [] f)
    
    {
        boolean [] sol = new boolean [c.length];
        sol[0] = true;
        int i = 0;
        for (int j = 1; j<c.length; j++){
            if ((f[i]<= c[j])||(c[i]>=f[j])){
                sol[j] = true;
                i=j;
            }else{
                sol[j] = false;
            }    
        }
        for (int k = 0; k<c.length; k++){
            System.out.println(sol[k]);
        }
        return sol;
    }


}
