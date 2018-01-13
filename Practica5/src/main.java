
public class main {

	public static void main(String[] args) {
		AlgoritmoNumerico an = new AlgoritmoNumerico();
		
		double [] mediasEspera = new double [100];
		double [] tCerrado = new double [100];
		
		//EJECUTAR 100 VECES ALGORITMO
		
		for(int i = 0; i<100; i++){
			an.fun_colas();
			
			/*Se almacena en distintos array los tiempos medios de espera y el tiempo de cierre
			para cada ejecucion*/
			
			tCerrado[i] = an.tiempoCierre;
			mediasEspera[i] = an.media_espera();
		}
		
		/*Diferentes operaciones para calcular las medias*/
		double mEsperas = 0;
		double mediaCerrado = 0;
		double minE= Integer.MAX_VALUE;
		double maxE = Integer.MIN_VALUE;
		double minC= Integer.MAX_VALUE;
		double maxC = Integer.MIN_VALUE;
		for (int i = 0; i<100; i++){
			mediaCerrado += tCerrado[i];
			mEsperas += mediasEspera[i];
			if (tCerrado[i]<minC){
				minC = tCerrado[i];
			}else if(tCerrado[i]>maxC){
				maxC = tCerrado[i];
			}
			if(mediasEspera[i]<minE){
				minE = mediasEspera[i];
			}else if (mediasEspera[i]>maxE){
				maxE = mediasEspera[i];
			}
		}
		
		mediaCerrado /=100;
		mEsperas/=100;
		double precisionE = Math.max(Math.abs(mEsperas-minE), Math.abs(mEsperas-maxE));
		double precisionC = Math.max(Math.abs(mediaCerrado-minC), Math.abs(mediaCerrado-maxC));
		double infC = mediaCerrado-precisionC;
		double supC = mediaCerrado+precisionC;
		double infE = mEsperas-precisionE;
		double supE = mEsperas+precisionE;
		
		//Impresion de los intervalos de confianza
		
		System.out.println("El intervalo de confianza del tiempo de espera es :  ["+ infE + "," +supE + "]"); 
		System.out.println("El intervalo de confianza que el aeropuerto pasa cerrado es :  ["+ infC + "," +supC + "]"); 
		
		
		}
}
