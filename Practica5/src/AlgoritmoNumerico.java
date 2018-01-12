import java.util.ArrayList;
import java.util.Random;

public class AlgoritmoNumerico {
	static double lambda;
	ArrayList <Double> S;
	ArrayList<Double> LL;
	int NLL;
	int NS;
	int n;
	double tiempoCierre;
	//Funcion que calcula el tiempo medio de espera de cada usuario en un dia.
	public double media_espera(){
		double media =0;
		for(int i=0;i<NS;i++){
			media +=S.get(i)-LL.get(i);
		}
		media = media /NS;
		return media;
	}
	
	//Funcion encargada de generar las llegadas
	private double genero_llegadas(double ts){
		double t = ts;
		double u = Math.random();
		t = t - (1/lambda) * Math.log(u);
		double u2 = Math.random();
		if(u2<=lambda(t)/lambda){
			ts =t;
		}
		return ts;
	}
	public void fun_colas(){
		lambda = 9;
		S = new ArrayList<>();
		LL = new ArrayList<>();
		NLL = 0;
		NS = 0;
		n = 0;
		tiempoCierre = 0;
		double t=0;
		double Tp = 0;
		double t0 = genero_llegadas(t);
		double tll = t0;
		double ts =Integer.MAX_VALUE;
		final int T = 14;
		while(t<T){
			
			//Si existe un tiempo de llegada menor que la anterior salida y ademas es menor de 14
			if (tll<=ts && tll<T){
				t = tll;
				NLL++;
				n++;
				LL.add(t);
				tll = genero_llegadas(t);
				if (n==1){
					ts = t+tiempo_atencion();		
				}
			}
			//Si el actual tiempo de salida es menor que el de llegada y ademas es menor de 14.
			if(ts<tll && ts<T){
				t=ts;				
				NS++;
				n--;
				S.add(t);
				if(n==0){
					ts = Integer.MAX_VALUE;
				}else{
					ts = t+tiempo_atencion();
				}
			}
			//Cuando el aeropuerto ha cerrado pero aun quedan clientes por salir
			if(Math.min(tll,ts)>T&&n!=0) {
				
				/*Se ha añadido este bucle para que salgan todos los clientes
				 * y no solo el primero.  */
				while(n>0){
					t = ts;
					S.add(t);
					NS++;
					n--;			
					if(n>0){
						ts = t+tiempo_atencion();
					}else{
						Tp = Math.max(t-T, 0);
					}
				}	
			}
			/*Esta condicion se cumple cuando el aeropuerto 
			 * esta cerrado y ya se han ido todos los clientes.
			 * Se actualiza t a T para que salga del bucle  */
			if(Math.min(tll,ts)>T && n==0){
				Tp = Math.max(t-T,0);
				tiempoCierre = Tp;
				t=T;
			}			
		}
	}
	//Funcion encargada de calcular el tiempo de atencion
	private static double tiempo_atencion(){
		Random r = new Random();
		double u = r.nextDouble();
		if(u<0){
			return 0;
		}
		return -(Math.log(u)/33);
	}
	//Funcion encargada de generar los clientes que llegan
	private static double lambda(double t) {
		if (0<=t && t<=3) {
			lambda=2+13*Math.floor(t);
			return 2+13*t;
			
		}
		else if (t<=7) {
			lambda=41;
			return 41;
		}
		else if (t<=10) {
			lambda=-(41/7)*(Math.ceil(t)-14);
			return -(41/7)*(t-14);
		}
		else {
			lambda=41*4/7;
			return 41*4/7;
		}
		
		
	}
}
