
public class ProgramacionDinamica {
	public double beneficio (int c_inicial, int[]GCD, double[] RCD, int [] GBT, double [] RBT ){
	//Dado que necesitamos obtener el array de beneficios, invocamos a la funcion que devuelve el array completo
	//y accedemos a la última pósicion
		return beneficioSolucion(c_inicial,GCD, RCD, GBT,RBT )[GCD.length];  
	} 
	public double[] beneficioSolucion (int c_inicial, int[]GCD, double[] RCD, int [] GBT, double [] RBT ){
		double beneficios[] = new double [GCD.length+1];
		int i = 0;
		beneficios[0] = c_inicial;
		for (i = 1; i<=Math.min(5,GCD.length-1);i++){
			beneficios[i] = Math.max(beneficios[i-1],(beneficios[i-1]-GCD[i-1])*RCD[i-1]);
		}
		for(i = 6; i<= GCD.length;i++){
			beneficios[i] = Math.max(beneficios[i-1],Math.max((beneficios[i-1]-GCD[i-1])*RCD[i-1],(beneficios[i-6]-GBT[i-6])*RBT[i-6]));
		}
		return beneficios;
	}
}
