package algo2.semana04.acceso;

public class BaseMismaClase {
	public int publicNum;
	protected int protectedNum;
	int packNum;
	private int privateNum;
	
	void accessMismaClase() {
		publicNum = 20;
		protectedNum =20;
		packNum = 20;
		privateNum = 20;
	}
}