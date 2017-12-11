
public class ProgramacionDinamica {
	public double beneficio (int c_inicial, int[]GCD, double[] RCD, int [] GBT, double [] RBT ){
	//Dado que necesitamos obtener el array de beneficios, para calcular el beneficio total, invocamos a la funcion que devuelve el array completo
	//y accedemos a la última pósicion
		return generarTabla(c_inicial,GCD, RCD, GBT,RBT )[GCD.length];  
	} 
	public int[] beneficioSolucion (int c_inicial, int[]GCD, double[] RCD, int [] GBT, double [] RBT ){
		double beneficios[] = new double [GCD.length+1];
		int solucion[] = new int[GCD.length +1];
		int i = 0;
		beneficios = generarTabla(c_inicial,GCD, RCD, GBT,RBT );
		solucion[0] = 0; //La posicion 0 de la solucion devuelta es un 0 puesto que es nuestro caso inicial.
		for(i = 1; i<= Math.min(5,GCD.length-1); i++){
			if(beneficios[i] == beneficios[i-1]){
				solucion[i] = 1;
			}else{
				solucion[i] = 2;
			}
		}
		for(i=6;i<=GCD.length;i++){
			if(beneficios[i] == beneficios[i-1]){
				solucion[i] = 1;
			}else if(beneficios[i]==(beneficios[i-1]-GCD[i-1])*RCD[i-1]){
				solucion[i] = 2;
			}else{
				solucion[i] = 3;
			}
		}
		return solucion;
	}
	private double[] generarTabla(int c_inicial, int[]GCD, double[] RCD, int [] GBT, double [] RBT ){
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

