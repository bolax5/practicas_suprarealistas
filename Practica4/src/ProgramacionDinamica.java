
public class ProgramacionDinamica {

	public int beneficio (int c_inicial, int[]GCD, int[] RCD, int [] GBT, int [] RBT ){
		int inversiones[] = new int [GCD.length];
		inversiones[0] = c_inicial;
		for (int i = 1; i<=Math.min(5,GCD.length-1);i++){
			inversiones[i] = Math.max(inversiones[i-1],(inversiones[i-1]-GCD[i-1])*RCD[i-1]);
		}
		for(int i = 6; i< GCD.length;i++){
			inversiones[i] = Math.max(inversiones[i-1],Math.max((inversiones[i-1]-GCD[i-1])*RCD[i-1],(inversiones[i-6]-GBT[i-6])*RBT[i-6]));
		}
		return inversiones[GCD.length-1];
	}
}
