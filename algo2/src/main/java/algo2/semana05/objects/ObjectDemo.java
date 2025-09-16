package algo2.semana05.objects;

import java.util.Objects;

class Persona {
	private String nombre;
	private String apellido;
	
	@Override
	public String toString() {
		return "-Nombre: " + nombre + " -Apellido: " + apellido;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre);
	}



	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
}

public class ObjectDemo {
	public static void main(String[] args) {
		ObjectDemo obj = new ObjectDemo();
		System.out.println("obj=" + obj);
		System.out.println("obj.toString=" + obj.toString());
		System.out.printf("obj.hashCode= %d, obj.hashCode(hexadecimal)= %1$h%n", obj.hashCode());
		ObjectDemo obj2 = new ObjectDemo();
		System.out.println("obj.equals(obj2)" + obj.equals(obj2));
		
		Persona p = new Persona("Juan", "Perez");
		System.out.println(p);
		Persona p2 = new Persona("Juan", "Perez");
		System.out.println(p.equals(p2));
		Persona p3 = new Persona("Carlos", "Perez");
		System.out.println(p.equals(p3));
	}
}
