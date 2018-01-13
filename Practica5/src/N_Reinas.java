/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

/**
 *
 * @author josevicentebanulsgarcia
 */
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
                
                for (int k = 0; k < n && !infactible; k++) {
                    
                    if((tablero[k][j]||((j+i-k)>=0 && (j+i-k)<n && tablero[k][j+i-k])||((j+k-i)<n && (j+k-i)>=0 && tablero[k][j+k-i]))){
                        infactible = true;
                    } 
                }
                if (!infactible){
                    tablero[i][j]=true;
                    solucion[i]=j;
                    nodos++;
                }   
                if (i==n-1 &&!infactible)
                    exito =true;
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
            infactible=true;
            
            r =rand.nextInt(n);
            infactible= false;
            
            //Comprobación de factibilidad de las reinas
            for (int k = 0; k < n && !infactible; k++) {
                if((tablero[k][r]||((r+i-k)>=0 && (r+i-k)<n && tablero[k][r+i-k])||((r+k-i)<n && (r+k-i)>=0 && tablero[k][r+k-i]))){
                    infactible = true;
                } 
            }

            //Si es factible se marca y se suma el numero de nodos visitados.
            if (!infactible){
                    tablero[i][r]=true;
                    solucion[i]=r;
                    nodos++;
            }
            //Si es la última reina colocada y es factible se ha encontrado una solución. Si no se vuelve a llamar recursivamente.
            if (i==n-1 &&!infactible)
                exito =true;
                else if(!infactible){
                    exito = buscarReinas(n,i+1,solucion,tablero, random);
                    
                }
            
            
        }
               	   
	return exito;
   }
}
