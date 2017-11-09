import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		int [][] N = {{0,0,2,2},{0,0,1,1},{2,1,0,0},{2,1,0,0}};
		int [][] D = {{0,3,3,4},{3,0,2,1},{3,2,0,1},{4,1,1,0}};
		PracticaBT pbt = new PracticaBT();
		int a [] = pbt.algoritmoBT(N, D);
		for (int i = 0; i < a.length; i++) {
			if (i==0){
				System.out.print("{"+ a[i] + ", ");
			}else if ((i>0) && (i<a.length-1)){
				System.out.print(a[i] +", ");
			}else{
				System.out.print(a[i] + "}");
			}
			
		}
	}

}
