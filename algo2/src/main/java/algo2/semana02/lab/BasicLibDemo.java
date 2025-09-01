package algo2.semana02.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicLibDemo {
	private String[] opciones = { "Circulo", "Rectangulo", "Cadena(String)", "Fechas", "Lista(Nuevo elemento)",
			"Lista(Mostrar contenido)", "Salir" };
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		BasicLibDemo m = new BasicLibDemo();
		m.mostrarMenu();
		int opcion = m.leerOpcionValida();
		m.procesarOpcion(opcion);
	}

	void mostrarMenu() {
		int n = 1;
		for (String opc : opciones) {
			System.out.format("%d.- %s%n", n++, opc);
		}
	}
	
	int leerOpcionValida() {
		int opc;
		try {
			opc = leerOpcion();
			return opc;
		} catch (Exception e) {
			return leerOpcionValida();
		}
	}

	int leerOpcion() throws Exception {
		System.out.print("Seleccione una opcion: ");
		String opc = entrada.readLine();
		int op = Integer.parseInt(opc);
		if (esOpcionValida(op))
			return op;
		else
			throw new Exception("La opcion seleccionada no es valida");

	}

	private boolean esOpcionValida(int dia) {
		return dia > 0 && dia <= opciones.length;
	}

	void procesarOpcion(int opcion) throws NumberFormatException, IOException {
		List<String> lista = new ArrayList<>();
		switch (opcion) {
		case 1:
			procesarCirculo();

			break;
		case 2:
			procesarRectangulo();
			break;
		case 3:
			procesarCadena();
			break;
		case 4:
			procesarRectangulo();
			break;

		case 5:
			procesarListaNuevo(lista);
			break;
		case 6:
			procesarListaMostrar(lista);
			break;
		case 7:
		    System.out.println("Se ha salido del programa");
		    System.exit(0);
		    break;

		default:
			System.exit(0);
			break;
		}
	}

	private void procesarListaMostrar(List<String> lista) {
		System.out.println("Contenido de la lista es:");
		for (String elem : lista) {
			System.out.println(elem);
		}
	}

	private void procesarListaNuevo(List<String> lista) throws IOException {
		System.out.println("Ingrese elemento: ");
		String cad = entrada.readLine();
		lista.add(cad);
	}

	private void procesarCadena() throws IOException {
		System.out.print("Ingrese un string: ");
		String cad1 = entrada.readLine();
		System.out.print("Ingrese otro string: ");
		String cad2 = entrada.readLine();
		System.out.println("Escoja un caracter especial(*#.-/): ");
		String cad3 = entrada.readLine();
		int pos = cad1.indexOf(cad2);
		if (pos >= 0) {
			System.out.format("La cadena '%s' es parte de '%s', y se encuentra en la posicion %d%n", cad2, cad1,
					pos); 
			String eliminada = cad1.replace(cad2, "");
		    System.out.format("Con la subcadena('%s') eliminada seria '%s'%n", cad2, eliminada);
		    String reemplazada = cad1.replace(cad2, cad3);
		    System.out.format("Con la subcadena('%s') reemplazada por '%s' seria '%s'%n", cad2, cad3, reemplazada);
		    String eliminadaPrimera = cad1.replaceFirst(Pattern.quote(cad2), "");
		    System.out.format("Eliminando SOLO la primera ocurrencia: '%s'%n", eliminadaPrimera);
		    String reemplazadaPrimera = cad1.replaceFirst(Pattern.quote(cad2), Matcher.quoteReplacement(cad3));
		    System.out.format("Reemplazando SOLO la primera ocurrencia por '%s': '%s'%n", cad3, reemplazadaPrimera);
		} else {
			System.out.format("La cadena '%s' NO es parte de '%s'", cad2, cad1);
		}
	}

	private void procesarRectangulo() {
		System.out.println("???(Por desarrollar.)");
	}

	private void procesarCirculo() throws IOException {
		System.out.print("Ingrese el radio: ");
		double radio = Double.parseDouble(entrada.readLine());
		double circunferencia = 2 * Math.PI * radio;
		System.out.format("El area del circulo con radio %f es %f%nY la circunferencia es %f%n", radio,
				Math.PI * Math.pow(radio, 2), circunferencia);
	}
}
