
public class ProgramacionDinamica {

	public double beneficio (int c_inicial, int[]GCD, double[] RCD, int [] GBT, double [] RBT ){
		double beneficios[] = new double [GCD.length+1];
		beneficios[0] = c_inicial;
		for (int i = 1; i<=Math.min(5,GCD.length-1);i++){
			beneficios[i] = Math.max(beneficios[i-1],(beneficios[i-1]-GCD[i-1])*RCD[i-1]);
		}
		for(int i = 6; i<= GCD.length;i++){
			beneficios[i] = Math.max(beneficios[i-1],Math.max((beneficios[i-1]-GCD[i-1])*RCD[i-1],(beneficios[i-6]-GBT[i-6])*RBT[i-6]));
		}
		return beneficios[GCD.length];
	} 
	public double[] beneficioSolucion (int c_inicial, int[]GCD, double[] RCD, int [] GBT, double [] RBT ){
		double beneficios[] = new double [GCD.length+1];
		beneficios[0] = c_inicial;
		for (int i = 1; i<=Math.min(5,GCD.length-1);i++){
			beneficios[i] = Math.max(beneficios[i-1],(beneficios[i-1]-GCD[i-1])*RCD[i-1]);
		}
		for(int i = 6; i<= GCD.length;i++){
			beneficios[i] = Math.max(beneficios[i-1],Math.max((beneficios[i-1]-GCD[i-1])*RCD[i-1],(beneficios[i-6]-GBT[i-6])*RBT[i-6]));
		}
		return beneficios;
	}
	
}
