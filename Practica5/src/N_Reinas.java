import java.util.ArrayList;
import java.util.Random;

public class N_Reinas {
    static float nodos = 0;

    public float getNodos() {
        return nodos;
    }
    public void reset(){
        nodos=0.0f;
    }
    public static boolean buscarReinas (int n,int i,int[]solucion,boolean[][]tablero,int random) {
        boolean exito = false;
        boolean infactible = false;
        //Ejecución del algoritmo de backtracking.
        if(random<=i){
            for (int j = 0; j < n &&!exito; j++) {
                infactible= false;
                
                //Comprobación de factibilidad de la reina
                for (int k = 0; k < i && !infactible; k++) {
                    if((tablero[k][j]||((j+i-k)>=0 && (j+i-k)<n && tablero[k][j+i-k])||((j+k-i)<n && (j+k-i)>=0 && tablero[k][j+k-i]))){
                        infactible = true;
                    } 
                }
                //Si es factible se marca como solución y se aumenta el número de nodos visitados.
                if (!infactible){
                    tablero[i][j]=true;
                    solucion[i]=j;
                    nodos++;
                } 
                //Si es la última reina y es factible se ha encontrado solución.
                if (i==n-1 &&!infactible)
                    exito =true;
                //Si no es la última reina se llama recursivamente de nuevo.
                else if(!infactible){
                    exito = buscarReinas(n,i+1,solucion,tablero, 0);
                    if (!exito){
                        solucion[i]=-1;
                        tablero[i][j]=false;
                    }
                }
            }
        }else{
        	//Parte del algoritmo que coloca las random primeras reinas, siendo random el último parámetro.
            Random rand = new Random();
            int r=0;
            infactible=false;
            ArrayList<Integer> posibles = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                posibles.add(j);
            }
            
            
            //Comprobación de factibilidad de las reinas
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < i ; k++) {
                    if((tablero[k][j]||((j+i-k)>=0 && (j+i-k)<n && tablero[k][j+i-k])||((j+k-i)<n && (j+k-i)>=0 && tablero[k][j+k-i]))){
                        posibles.remove((Integer)j);
                        
                    } 
                }
            }

            //Si es factible se marca y se suma el numero de nodos visitados.
            if (!posibles.isEmpty()){
                r =rand.nextInt(posibles.size());
                r=posibles.get(r);
                tablero[i][r]=true;
                solucion[i]=r;
                nodos++;
            }
            //Si es la última reina colocada y es factible se ha encontrado una solución. Si no se vuelve a llamar recursivamente.
            if (i==n-1 &&!posibles.isEmpty())
            exito =true;
            else if(!posibles.isEmpty()){
                exito = buscarReinas(n,i+1,solucion,tablero, random);
                
            }
            
            
        }
               	   
	return exito;
   }
}
