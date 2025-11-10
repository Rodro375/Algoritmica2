package algo2.semana13.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;

class Reducing {

	List<Estudiante> estudiantes;
	EstudiantesFactoryMock EstFact;
	@BeforeEach
	public void init() {
		estudiantes = EstFact.getEstudiantes();
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
	
	@Test
	void average() {
		double prom = estudiantes
				.stream()
				.filter(e->e.getEscuela()==Escuela.Sistemas)
				.mapToDouble(Estudiante::getPromedio)
				.average()
				.getAsDouble();

		double esperado = promedioMedio(EstFact.e1, EstFact.e3, EstFact.e5, EstFact.e7);
		assertEquals(esperado, prom);
		
		prom = estudiantes
				.stream()
				.filter(e->e.getEscuela()==Escuela.Sistemas)
				.collect(Collectors.averagingDouble(e->e.getPromedio()));
		assertEquals(esperado, prom);
	}

	@Test
	void sum() {
		double sum = estudiantes
				.stream()
				.filter(e->e.getEscuela()==Escuela.Sistemas)
				.mapToDouble(Estudiante::getPromedio)
				.sum();
		double esperado = promedioSum(EstFact.e1, EstFact.e3, EstFact.e5, EstFact.e7);
		assertEquals(esperado, sum);
		
		sum = estudiantes
				.stream()
				.filter(e->e.getEscuela()==Escuela.Sistemas)
				.collect(Collectors.summarizingDouble(e->e.getPromedio()))
				.getSum();

		assertEquals(esperado, sum);
	}
	
}
