package algo2.semana06.cast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class CastDemo {
	public void demo() {
		List<String> lista = new LinkedList<>();
		System.out.println(lista);
		ArrayList<String> lista2 = (ArrayList<String>) lista;
		System.out.println(lista2);
	}
	/*
	public void demo2() {
		LinkedList<String> lista = new LinkedList<String>();
		ArrayList<String> lista2 = (ArrayList<String>) lista;
	}
	
	private void castQueFallaEnCompilacion() {
		HashSet<String> hs = new HashSet<String>();
		TreeSet<String> ts = (TreeSet<String>) hs;
	}
	*/
	public static void main(String[] args) {
		new CastDemo().demo();
	}
}
