package algo2.semana10.excep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.hamcrest.collection.ArrayAsIterableMatcher;

public class CheckedAndUnCheckedExcepcion {
	private void uncheckedExcep() {
		throw new RuntimeException("");
	}
	private void checkedExcep() throws IOException{
		throw new IOException("");
	}
	
	private void useUncheckedExcepNoNecesitoNiPropagarNiTratar() {
		uncheckedExcep();
	}
	
	private void useCheckedExcep1Propagar() throws IOException {
		checkedExcep();
	}
	private void useCheckedExcep2Tratar() {
		try {
			checkedExcep();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//BufferedWriter writer = new BufferedWriter(new FileWriter(""));
		}
	}
	
	private static void nullPointer() {
		List<Integer> lista = null;
		lista.clear();
	}
	private static void divideByZero() {
		int result = 100/0;
	}
	private static void useDivideByZero() {
		divideByZero();
	}
	
	public static void main(String[] args) {
		try {
			useDivideByZero();
		} catch (ArithmeticException e) {
			System.out.println("Division por cero");
		}
		
		try {
			nullPointer();
		} catch (NullPointerException e) {
			System.out.println("Puntero nulo");
		}
		System.out.println("Programa terminado ok");
	}
}

class PersonalizedException extends Exception {
	public PersonalizedException(String mensaje) {
		super(mensaje);
	}
}