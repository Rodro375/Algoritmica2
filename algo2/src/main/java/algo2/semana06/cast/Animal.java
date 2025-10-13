package algo2.semana06.cast;

public abstract class Animal {
	String tipo = "Animal";
	public Animal() {
		System.out.println("Tipo es " + getTipo());
	}
	@Override
	public String toString() {
		return "Es animal";
	}
	abstract protected void hacerSonido();
	protected void m1() {
		
	}
	void m2() {
		
	}
	private void m3() {
		
	}
	static void m4() {
		
	}
	public String getTipo() {
		System.out.println("En getTipo de Animal");
		return tipo;
	}
	Animal hacerAlgo(Animal a) {
		return a;
	}
}
