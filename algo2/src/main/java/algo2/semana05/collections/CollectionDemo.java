package algo2.semana05.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CollectionDemo {
	<T> void procesar(List<T> lista) {
		
	}
	
	private void demo1() {
		List<String> lista = new LinkedList<String>(List.of("abc", "def"));
		procesar(lista);
	}
	
	private void demo2() {
		List<Integer> lista = new LinkedList<Integer>(List.of(10, 20));
		procesar(lista);		
	}
	
	private void demo3() {
		List<Integer> lista = List.of(10, 20);
		procesar(lista);		
	}
	
	public void listCreation() {
		List<Integer> lista1 = new LinkedList<Integer>();
		List<Integer> lista2 = new LinkedList<Integer>(lista1);
		
		
		List<String> lista3 = new ArrayList<String>();
		List<String> lista4 = new ArrayList<String>(Set.of("a", "b", "c"));
	}
	
	public void queueCreation() {
		Queue<Integer> lista5 = new LinkedList<Integer>();
		
	}
	
	public void setCreation() {
		
	}
	
	public void listDemo() {
		List<String> lista = new ArrayList<String>();
		lista.add("Perez");
		lista.add("Chavez");
		lista.add("Vega");
		assertEquals("Chavez", lista.get(1));;
	}
}
