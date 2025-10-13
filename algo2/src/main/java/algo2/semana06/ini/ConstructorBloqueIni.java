package algo2.semana06.ini;

class Super {
	{
		System.out.println("En bloque de ini de Super.0");
	}
	{
		System.out.println("En bloque de ini de Super.1");
	}
	Super(){
		System.out.println("En Super. Primero.");
	}
	{
		System.out.println("En bloque de ini de Super.2");
	}
}

class Sub extends Super{
	String s = "A";
	{
		System.out.println("En bloque de ini de Sub. Segundo.1. s=" + s);
	}
	Sub() {
		System.out.println("En constructor de Sub. Tercero.");
		System.out.printf("Valor de s es: %s, s2 es: %s%n", s, s2);
	}
	String s2 = "B";
	{
		System.out.println("En bloque de ini de Sub. Segundo.2. s2= " + s2);
	}
	public static void main(String[] args) {
		new Sub();
	}
}
