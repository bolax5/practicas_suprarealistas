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
public class MatrixMultiplicity {
    private boolean checkMultiplicity(int[][] a, int[][] b, int[][] c,int n){
        int[] x = new int[n];
        //int[] x = {1,1,0};
        int[] xa = new int[n];
        int[] xab = new int[n];
        int[] xc = new int[n];
        
        
        for(int i=0;i<n;i++){
            x[i] = new Random().nextInt(2);
        };
        
        for(int i=0;i<n;i++){
           for(int z=0;z<n;z++){
               xa[z]+= a[i][z]*x[i];
           }
        }
        
                
                
        for(int i=0;i<n;i++){
           for(int z=0;z<n;z++){
               xab[z]+= b[i][z]*xa[i];
           }
        }
        
        
        
        for(int i=0;i<n;i++){
           for(int z=0;z<n;z++){
               xc[z]+= c[i][z]*x[i];
           }
        }
        
        for(int i=0;i<n;i++){
            if(xc[i]!=xab[i])
               return false;
        }
        
        
        /*
        printMatrix(x);
        printMatrix(xa);
        printMatrix(xab);
        printMatrix(xc);
        */
        
               
        return true;
    }
    
    private void printMatrix(int[]m){
        System.out.print("{");
        for(int z : m){
            System.out.print(z+",");
        }
        System.out.println("}");
    }
    public boolean MonteCarloMatrix(int[][] a, int[][] b, int[][] c,int n, int k){
        for (int i=0; i<k;i++){
            if(!checkMultiplicity(a,b,c,n))
                return false;
        }
            
         return true;
    }
    
}
