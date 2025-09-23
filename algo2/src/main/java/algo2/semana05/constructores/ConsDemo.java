package algo2.semana05.constructores;

class A{}
class B{ 
	B(){}
	B(int n){}
}
class C1 extends B{ } //Error en compilacion
class C2 extends B{ C2() {super(0);} } //Ok.

public class ConsDemo {
	private void demo() {
		A a1 = new A();
		B b1 = new B(); // Error en compilacion
		B b2 = new B(10); //Ok		
	}
}