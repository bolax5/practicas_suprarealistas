public class Main {

	public static void main(String[] args) {
		/*int [][] N = {	{0,0,2,2},
							{0,0,1,1},
							{2,1,0,0},
							{2,1,0,0}};
			
			int [][] D = {	{0,3,3,4},
							{3,0,2,1},
							{3,2,0,1},
							{4,1,1,0}}; // 1 2 3 0
		
			/*int [][] N = {	{0,1,2,0},
		  					{1,0,0,2},
		  					{2,0,0,1},
		  					{0,2,1,0}};
		
		int [][] D = {		{0,2,1,4},
							{2,0,4,1},
							{1,4,0,2},
							{4,1,2,0}}; *///0 1 2 3
		
		/*int [][] N = {	{0,2,2,2,2},
						{2,0,0,1,1},
						{2,0,0,1,1},
						{2,1,1,0,0},
						{2,1,1,0,0}};
		
		
		int [][] D = {	{0,2,1,2,3},
						{2,0,1,3,2},
						{1,1,0,1,1},
						{2,3,1,0,2},
						{3,2,1,2,0}};*/
		
		/*int [][] N = {	{0,2,2,0,0,1},
						{2,0,0,2,1,0},
						{2,0,0,0,0,2},
						{0,2,0,0,2,0},
						{0,1,0,2,0,2},
						{1,0,2,0,2,0}};


		int [][] D = {	{0,1,1,3,3,4},
						{1,0,2,1,4,3},
						{1,2,0,4,1,3},
						{3,1,4,0,2,1},
						{3,4,1,2,0,1},
						{4,3,3,1,1,0}};
		/*int[][]N = {	{0,1,3},
						{1,0,3},
						{3,3,0}};
		int[][]D = {	{0,4,2},
						{4,0,1},
						{2,1,0}};*/
		int [][] N = {	{0,0,0,1},
						{0,0,1,0},
						{0,1,0,0},
						{1,0,0,0}};

		int [][] D = {	{0,3,1,4},
						{3,0,4,1},
						{1,4,0,3},
						{4,1,3,0}};
								
		PracticaBT pbt = new PracticaBT();
		PracticaRyP pryp = new PracticaRyP();
		
		long tini;
		long tfin;
		long time;
		tini =System.nanoTime();
		pbt.algoritmoBT(N, D);
		tfin = System.nanoTime();
		time = tfin-tini;
		System.out.println(time/1000000.0);
		 
		tini = System.nanoTime();
		pryp.algoritmoRyP(N, D);
		//pbt.algoritmoBT(N, D);
		tfin = System.nanoTime();
		time = tfin-tini;
		System.out.println(time/1000000.0);
		
		
	}
}
