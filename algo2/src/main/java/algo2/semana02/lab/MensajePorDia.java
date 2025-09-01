package algo2.semana02.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MensajePorDia {
	private String[] nombreDia = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
	private String[] mensajeDia = {"Algo2", "GPS", "MAE", "...", "MAE", "...", "..."};
	
	public static void main(String[] args) throws Exception {
		MensajePorDia m = new MensajePorDia();
		m.mostrarMenu();
		int dia = m.leerDia();
		m.mostrarMensaje(dia);
	}

	void mostrarMenu(){
		for (String dia : nombreDia) {
			 System.out.println(dia);
		}
	}
	int leerDiaValido(){
		int dia;
			try {
				dia = leerDia();
				return dia;
			} catch (Exception e) {
				return leerDiaValido();
			}
	}
	
	int leerDia() throws Exception{
		boolean diaNoHabil = false;
		System.out.print("Seleccione un dia: ");
		String diaOpt;
		do {
			diaOpt = new BufferedReader(new InputStreamReader(System.in)).readLine();
			int dia = Integer.parseInt(diaOpt);
			if (diaValido(dia)) {
				diaNoHabil = true;
				return dia;
			}
			else System.out.print("El día seleccionado no es válido, vuelva a escoger otro: ");			
		} while (!diaNoHabil);
		return 0;
	}
	private boolean diaValido(int dia) {
		return dia >0 && dia <= nombreDia.length;
	}
	
	void mostrarMensaje(int dia){
		System.out.format("El dia seleccionado es %d, %s%n", dia, mensajeDia[dia-1]);
	}
	
}