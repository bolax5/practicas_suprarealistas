
public class main {

	public static void main(String[] args) {
		int [][] N = {{0,1,2,0},{1,0,0,2},{2,0,0,1},{0,2,1,0}};
		int [][] D = {{0,2,1,4},{2,0,4,1},{1,4,0,2},{4,1,2,0}};
		PracticaBT pbt = new PracticaBT();
		int a [] = pbt.algoritmoBT(N, D);
		
	}

}
