package algo2.semana05.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class MensajePorDia extends ConsolaApp {
	private String[] mensajeDia = {"Algo2", "GPS", "MAE", "...", "MAE", "...", "..."};
	
	MensajePorDia(){
		super(new String[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"});
	}
	
	@Override
	protected void procesarOpcion(int dia){
		DayOfWeek diaSemana = DayOfWeek.of(dia);
		System.out.format("El día seleccionado es %d, %s", dia, diaSemana);
	}
	
	public static void main(String[] args) throws Exception {
		ConsolaApp app = new MensajePorDia();
		app.ejecutar();
	}
}
