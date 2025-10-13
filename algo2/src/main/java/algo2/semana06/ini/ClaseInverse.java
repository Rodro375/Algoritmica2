package algo2.semana06.ini;

public class ClaseInverse {
	
	public ClaseInverse(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	{  //No usaran x ni y
		System.out.println("No podre usar las variable (campos) ante de ser declarados.");
	}
	private int x, y;
	{  //Se podría usar x e y
		System.out.println("Ahora si puedo acceder a los campos declarados: x =" + x);
	}
}
