
public class main {

	public static void main(String[] args) {
		EliminacionRecursividad er = new EliminacionRecursividad();
		int a = er.tabOpt(6, 2);
		System.out.println(a);
		int GCD[] = {200,50,100,75,100,50,80};
		double RCD[] = {1.01,1.02,1.1,1.03,1.1,1.2,1.06};
		int GBT[] = {75,100,200,50,200,50,75};
		double RBT[] = {1.03,1.03,1.3,1.2,1.02,1.2,1.05};
		ProgramacionDinamica pd = new ProgramacionDinamica();
		double d = pd.beneficio(4000, GCD, RCD, GBT, RBT);
		System.out.println(d);
	}

}
