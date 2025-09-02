package algo2.semana03.lab;

import algo2.semana01.intro.DemoFami;

enum DiaDeLaSemana{
	Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo;
}

public class EnumDemo {

	public static final int LUNES = 1;
	public static final int MARTES = 2;
	public static final int MIERCOLES = 3;
	public static final int JUEVES = 4;
	public static final int VIERNES = 5;
	public static final int SABADO = 6;
	public static final int DOMINGO = 7;
	
	public static void demoUsandoFinals(int diaDeLaSemana) {
		System.out.printf("El día de la semana es %d%n", diaDeLaSemana);
	}
	
	public static void demoUsandoEnum(DiaDeLaSemana dia) {
		System.out.printf("El día de la semana es %d, o sea %s(%s)%n", dia.ordinal()+1, dia, dia.name());
	}
	
	public static void main(String[] args) {
		demoUsandoFinals(1);
		demoUsandoFinals(9);
		demoUsandoEnum(DiaDeLaSemana.Lunes);
	}

}
