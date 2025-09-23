package algo2.semana05.polimorfismo;

public class AnimalDemo {
	void diagnostica(Animal a) {
		a.hacerSonido();
	}
	
	void listar(Animal[] animals) {
		System.out.println("AnimalDemo.listar()");
		for (Animal a: animals) {
			a.hacerSonido();
		}
	}
	
	public static void main(String[] args) {
		AnimalDemo demo = new AnimalDemo();
		//demo.diagnostica(new Animal()); no puede instanciar una clase abstracta
		demo.diagnostica(new Cat());
		demo.diagnostica(new Dog());
		Animal[] as = {new Cat(), new Cat(), new Dog()};
		demo.listar(as);
	}
}
