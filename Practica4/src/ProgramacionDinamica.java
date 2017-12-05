
public class ProgramacionDinamica {

	public double beneficio (int c_inicial, int[]GCD, double[] RCD, int [] GBT, double [] RBT ){
		double inversiones[] = new double [GCD.length];
		inversiones[0] = c_inicial;
		for (int i = 1; i<=Math.min(5,GCD.length-1);i++){
			inversiones[i] = Math.max(inversiones[i-1],(inversiones[i-1]-GCD[i-1])*RCD[i-1]);
			System.out.println("En el mes " + i + " : " + inversiones[i]);
		}
		for(int i = 6; i< GCD.length;i++){
			inversiones[i] = Math.max(inversiones[i-1],Math.max((inversiones[i-1]-GCD[i-1])*RCD[i-1],(inversiones[i-6]-GBT[i-6])*RBT[i-6]));
			System.out.println("En el mes " +i+ " : " + inversiones[i]);
		}
		return inversiones[GCD.length-1];
	}
}
