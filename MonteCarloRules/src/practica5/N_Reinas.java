/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

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
            Random rand = new Random();
            int r=0;
            infactible=true;
            
            r =rand.nextInt(n);
            infactible= false;
            for (int k = 0; k < n && !infactible; k++) {
                if((tablero[k][r]||((r+i-k)>=0 && (r+i-k)<n && tablero[k][r+i-k])||((r+k-i)<n && (r+k-i)>=0 && tablero[k][r+k-i]))){
                    infactible = true;
                } 
            }


            if (!infactible){
                    tablero[i][r]=true;
                    solucion[i]=r;
                    nodos++;
            }
            if (i==n-1 &&!infactible)
                exito =true;
                else if(!infactible){
                    exito = buscarReinas(n,i+1,solucion,tablero, random);
                    
                }
            
            
        }
               	   
	return exito;
   }
}
