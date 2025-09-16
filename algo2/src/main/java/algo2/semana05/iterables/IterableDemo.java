package algo2.semana05.iterables;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IterableDemo {
	
	public <T> void list1(Iterable<T> ite) {
		System.out.println("IterableDemo.list1()");
		for (Iterator<T> iterator = ite.iterator(); iterator.hasNext();) {
			T s = iterator.next();
			System.out.println(s);
		}
	}
	
	public void list2(Iterable<String> ite) {
		System.out.println("IterableDemo.list2()");
		for (String s : ite) {
			System.out.println(s);
		}
	}
	
	public void demos() {
		List<String> lista1 = List.of("abc", "def", "jdk");
		list1(lista1);
		list2(lista1);
		Set<String> set1 = Set.of("abc", "def", "jdk");
		list1(set1);
		list2(set1);
		List<Integer> lista2 = List.of(1, 2, 3);
		list1(lista2); //OK, generalizado
		//list2(lista2); //Error, solamente Iterable de String	
	}
	
	public static void main(String[] args) {
		IterableDemo demo = new IterableDemo();
		demo.demos();
	}
	
}
