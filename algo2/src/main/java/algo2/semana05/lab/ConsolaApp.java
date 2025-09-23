package algo2.semana05.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class ConsolaApp {
	private String[] opciones;
	
	public ConsolaApp(String[] opciones) {
		this.opciones = opciones;
	}

	protected void mostrarMenu() {
		int n=1;
		for (String opc : opciones) {
			 System.out.format("%d.- %s%n", n++, opc);
		}
	}

	protected int leerOpcionValida() {
		int opc;
			try {
				opc= leerOpcion();
				return opc;
			} catch (Exception e) {
				return leerOpcionValida();
			}
	}

	int leerOpcion() throws Exception {
		//String opc = System.console().readLine("Seleccione una opcion: ");
		System.out.print("Seleccione una opcion: ");
		String opc = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int op = Integer.parseInt(opc);
		if (esOpcionValida(op))
			return op;
		else throw new Exception("La opcion seleccionada no es valida");
		
	}

	private boolean esOpcionValida(int dia) {
		return dia >0 && dia <= opciones.length;
	}

	protected abstract void procesarOpcion(int opcion);

	protected void ejecutar() {
		mostrarMenu();
		int opcion = leerOpcionValida();
		procesarOpcion(opcion);
	}
}