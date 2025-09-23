package algo2.semana05.lab;

import java.util.ArrayList;
import java.util.List;

public class BasicLibDemo extends ConsolaApp {	
	BasicLibDemo() {
		super(new String[]{"Circulo", "Rectangulo", "Cadena(String)", "Fechas", "Lista(Nuevo elemento)", "Lista(Mostrar contenido)"});
	}
	
	@Override
	protected void procesarOpcion(int opcion) {
		List<String> lista = new ArrayList<>();
		switch(opcion){
		case 1:
			String radioStr = System.console().readLine("Ingrese el radio: ");
			double radio = Double.parseDouble(radioStr);
			final double PI = Math.PI;
			double area = PI * radio * radio;
			System.out.format("El area del circulo con radio (%.3f) es %.3f (%.3f * %1$.3f * %1$.3f).%n", radio, area, PI);
			System.out.println("Resumen de datos:");
			System.out.format("radio: %.3f %n", radio);
			System.out.format("área: %.3f", area); 
			break;
		case 2:
			System.out.println("???(Por desarrollar.)");
			break;
		case 3:
			String cad1 = System.console().readLine("Ingrese un string: ");
			String cad2 = System.console().readLine("Ingrese otro string: ");
			String cad3 = System.console().readLine("Escoja un caracter especial(*#.-/): ");
			int pos = cad1.indexOf(cad2);
			if (pos >= 0) {
				System.out.format("La cadena '%s' es parte de '%s', y se encuentra en la posicion %d%n", cad2, cad1, pos);
				System.out.format("Con la subcadena('%s') eliminada seria '%s'%n", cad2, "???(Por desarrollar)");
				System.out.format("Con la subcadena('%s') remplazada por '%s' seria '%s'%n", cad2, cad3, "???");
			}else{
				System.out.format("La cadena '%s' NO es parte de '%s'", cad2, cad1);				
			}
			break;
		case 4:
			System.out.println("???(Por desarrollar.)");
			break;
	
		case 5:
			String cad = System.console().readLine("Ingrese elemento: ");
			lista.add(cad);
			break;
		case 6:
			System.out.println("Contenido de la lista es:");
			for (String elem : lista) {
				System.out.println(elem);
			} 
			break;
	
		default:
			System.exit(0);
			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		ConsolaApp app = new BasicLibDemo();
		app.ejecutar();
	}
}
