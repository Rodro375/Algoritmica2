package algo2.semana13.streams;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;

class StreamConcept {

	List<Estudiante> estudiantes;
	EstudiantesFactoryMock EstFact;
	@BeforeEach
	public void init() {
		estudiantes = EstFact.getEstudiantes();
	}	
	
	@Test
	void test() {
		long cantidadSistAprobado = 
				estudiantes.stream()
					.filter(e->e.getEscuela()==Escuela.Sistemas)
					.filter(e->e.getPromedio() > 10.5)
					.count();
		
		assertEquals(2, cantidadSistAprobado);
		
		double sumaProm10Primeros = estudiantes.stream()
			.filter(e->e.getEscuela()==Escuela.Sistemas)
			.filter(e->e.getPromedio() > 10.5)
			.sorted((e1, e2) -> (int)(e2.getPromedio() - e1.getPromedio()))
			.limit(10)
			.mapToDouble(Estudiante::getPromedio)
			.sum();
		assertEquals(12+18,sumaProm10Primeros); 
				
		IntStream istream = IntStream.range(1, 100);
		int[] numeros = istream.skip(90).toArray();
		assertArrayEquals(new int[] {91, 92, 93, 94, 95, 96, 97, 98, 99}, numeros);
		
		Estudiante[] arrayEstudiantes = estudiantes.toArray(new Estudiante[0]);
		double promedioEsperado = promedioMedio(arrayEstudiantes);
		double promedioCalculado = estudiantes.stream().mapToDouble(e->e.getPromedio()).average().getAsDouble();
		assertEquals(promedioEsperado, promedioCalculado);
	}
	
	private double promedioSum(Estudiante...estudiantes) {
		double result = 0;
		for (Estudiante estudiante : estudiantes) {
			result+=estudiante.getPromedio();
		} 
		return result;
	}
	private double promedioMedio(Estudiante...estudiantes) {
		double result = promedioSum(estudiantes);
		return result/estudiantes.length;
	}	
}
