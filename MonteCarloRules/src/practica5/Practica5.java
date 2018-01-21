/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Arrays;

/**
 *
 * @author josevicentebanulsgarcia
 */
public class Practica5 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = {{3,1,4},{1,5,9},{2,6,5}};
        int[][] c = {{11,29,37},{29,65,91},{47,99,45}};
        //System.out.println(new MatrixMultiplicity().MonteCarloMatrix(a, b, c, 3,10));
        int n = 16;
        boolean[][] tablero =   new boolean[n][n];
        int[] solucion = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        N_Reinas reina; new N_Reinas();
        int bucles = 1000;
        float nodosKOTemp = 0;
        float[] nodosOK = new float[n+1];
        float[] nodosKO = new float[n+1];
        double[] probabilidad = new double[n+1];
        float[] exitos = new float[n+1];
        float[] fallos = new float[n+1];
        double[] t = new double[n+1];
        float fallosTemp = 0.0f;
        boolean success = false;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < bucles; j++) {
                do{
                    tablero = new boolean[n][n];
                    reina= new N_Reinas();
                    if(reina.buscarReinas (n, 0,solucion, tablero,i)){
                        exitos[i]++;
                        nodosOK[i] += reina.getNodos();
                        success= true;
                        
                    }else{
                        fallos[i]++;
                        fallosTemp++;
                        nodosKOTemp+= reina.getNodos();
                        success= false;
                    }
                    reina.reset();
                }while(!success);
                if(fallosTemp!=0){
                    nodosKO[i]+=nodosKOTemp/fallosTemp;
                }
                probabilidad[i]+= 1.0/(1.0+fallosTemp);
                nodosKOTemp = 0;
                fallosTemp=0.0f;
                
                //System.out.println(Arrays.toString(solucion))   
            }
            //fallos[i]=fallos[i]/bucles;
            //probabilidad[i]= 1.0/(1.0+fallos[i]);
            probabilidad[i]=probabilidad[i]/bucles;
            nodosOK[i]=nodosOK[i]/bucles +1;
            
            if(fallos[i]!=0)
                nodosKO[i]=nodosKO[i]/bucles +1;
            t[i]=nodosOK[i]+nodosKO[i]*(1-probabilidad[i])/probabilidad[i];
        }
        
        
        
        System.out.println("Exitos: "+Arrays.toString(exitos));
        System.out.println("Fracasos: "+Arrays.toString(fallos));
        System.out.println("Nodos en el exito: "+Arrays.toString(nodosOK));
        System.out.println("Nodos en el fracaso: "+Arrays.toString(nodosKO));
        System.out.println("Probabilidad: "+Arrays.toString(probabilidad));
        System.out.println("Esperados: "+Arrays.toString(t));
        

        
    }
    
        
}
