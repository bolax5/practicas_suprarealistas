/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.ArrayList;
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
                
                for (int k = 0; k < i && !infactible; k++) {
                    
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
                    exito = buscarReinas(n,i+1,solucion,tablero, random);
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
            ArrayList<Integer> posibles = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                posibles.add(j);
            }
            
            //r =rand.nextInt(n);
            infactible= false;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < i ; k++) {
                    if((tablero[k][j]||((j+i-k)>=0 && (j+i-k)<n && tablero[k][j+i-k])||((j+k-i)<n && (j+k-i)>=0 && tablero[k][j+k-i]))){
                        posibles.remove((Integer)j);
                        
                    } 
                }
            }
            if (!posibles.isEmpty()){
                r =rand.nextInt(posibles.size());
                r=posibles.get(r);
                tablero[i][r]=true;
                solucion[i]=r;
                nodos++;
            }
            if (i==n-1 &&!posibles.isEmpty())
                exito =true;
                else if(!posibles.isEmpty()){
                    exito = buscarReinas(n,i+1,solucion,tablero, random);
                    
                }
            
            
        }
               	   
	return exito;
   }
}
