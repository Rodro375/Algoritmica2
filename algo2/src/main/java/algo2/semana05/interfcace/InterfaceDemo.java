package algo2.semana05.interfcace;

interface Movilizable {
	int VELOCIDAD_MAXIMA = 500; //public static final son por defecto para los campos en una interface
	public static final int VELOCIDAD_MINIMA = 0;
	
	void acelerar(); //los metodos por defecto son public abstract
	public abstract void desacelerar();
}

interface Conducible extends Movilizable {}

class Vehiculo implements Movilizable, Comparable<Movilizable> {

	@Override
	public void acelerar() {
		System.out.println("Vehiculo.acelerar()");
	}

	@Override
	public void desacelerar() {
		System.out.println("Vehículo.desacelerar()");
	}

	@Override
	public int compareTo(Movilizable o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class InterfaceDemo {
	public static void main(String[] args) {
		//Movilizable m = new Movilizable(); //ERROR
		Movilizable m = new Vehiculo(); //OK
		System.out.printf("La velocidad maxima de un Movilizable es: %d y la minima es: %d%n",
				Movilizable.VELOCIDAD_MAXIMA,
				Movilizable.VELOCIDAD_MINIMA);
		System.out.println(m instanceof algo2.semana05.polimorfismo.Animal);
		System.out.println(m instanceof Vehiculo);
		System.out.println(m instanceof Conducible);
		System.out.println(m instanceof Movilizable);
		System.out.println(m instanceof Comparable);
		System.out.println(m instanceof Object);
	}
}
