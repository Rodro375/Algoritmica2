package algo2.semana13.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;
import algo2.semana13.streams.ReduceCollectPromedioTest.EstudianteDirty;


public class ReduceCollectPromedioTest {
	final Escuela sist = Escuela.Sistemas; // new Escuela("Sistemas");
	final Escuela soft = Escuela.Software; // new Escuela("Software");
	final Estudiante e1 = new Estudiante("12345678", "Angel Ungenio", 8, sist);
	final Estudiante e2 = new Estudiante("22345678", "Beto Dosantos", 9, soft);
	final Estudiante e3 = new Estudiante("32345678", "Carlos Trelles", 10, sist);
	final Estudiante e4 = new Estudiante("42345678", "David Cuadros", 11, soft);
	final Estudiante e5 = new Estudiante("52345678", "Efain Quinto", 12, sist);
	final Estudiante e6 = new Estudiante("62345678", "Felipe Sexto", 16, soft);
	final Estudiante e7 = new Estudiante("72345678", "Guzman Septimo", 18, sist);

	List<Estudiante> estudiantes;
	@BeforeEach
	public void init() {
		estudiantes = Arrays.asList(
				e1, e2, e3, e4, e5, e6, e7
				);
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
	void promedioConAverage() {
		double prom = estudiantes.stream()
		.filter(e -> e.getEscuela() == sist)
		.mapToDouble(e->e.getPromedio())
		.average()
		.getAsDouble();
		
		 double expected = promedioMedio(e1, e3, e5, e7);
		 assertEquals(expected, prom);
	}

	class AveragerForReduce 
	{
	    private double total = 0;
	    private int count = 0;
	        
	    public double average() {
	        return count > 0 ? ((double) total)/count : 0;
	    }
	        
	    public AveragerForReduce accu(Estudiante e) { 
	    	total += e.getPromedio(); count++;
	    	return this;
	    }

		public AveragerForReduce combine(AveragerForReduce other) {
	        total += other.total;
	        count += other.count;
			return this;
		}
	}

	/*
	 * Nota que la sintaxis reduce(id, accu, comb) 
	 * aplica a Stream, mas no a DoubleStrem, por lo que no
	 * podemos decir:
	 * .filter(e -> e.getEscuela() == sist)
	 * .mapToDouble(...)
	 * .reduce(id, accu, comb)
	 */
	@Test
	void promedioConReduce() {
		
		double prom = estudiantes.stream()
		.filter(e -> e.getEscuela() == sist)
		.reduce(new AveragerForReduce(),
				AveragerForReduce::accu,
				AveragerForReduce::combine
				)
		.average();
		
		 double expected = promedioMedio(e1, e3, e5, e7);
		 assertEquals(expected, prom);
	}
	
	class EstudianteDirty extends Estudiante{
		double total = 0;
		int count = 0;
		EstudianteDirty(){
			super(null, null, 0, null);
		}
		public EstudianteDirty accu(Estudiante e) {
			total += e.getPromedio();
			count++;
			return this;
		}
		public double average() {
			return total / count;
		}
	}
	@Test
	void promedioConReduceDirty() {
		
		double prom = ((EstudianteDirty)estudiantes.stream()
		.filter(e -> e.getEscuela() == sist)
		.reduce(new EstudianteDirty(),
				(a, e) -> ((EstudianteDirty)a).accu(e)
				//EstudianteDirty::accu
				)
		)
		.average();
		
		 double expected = promedioMedio(e1, e3, e5, e7);
		 assertEquals(expected, prom);
	}

	class Averager implements DoubleConsumer
	{
	    private double total = 0;
	    private int count = 0;
	        
	    public double average() {
	        return count > 0 ? ((double) total)/count : 0;
	    }
	        
	    public void accept(double i) { total += i; count++; }
	    public void acceptWithEstudiante(Estudiante e) { total += e.getPromedio(); count++; }

	    public void combine(Averager other) {
	        total += other.total;
	        count += other.count;
	    }
	}
	
	@Test
	void promedioConCollect() {
		double prom = estudiantes.stream()
		.filter(e -> e.getEscuela() == sist)
		.mapToDouble(e -> e.getPromedio())
		.collect(Averager::new,
				Averager::accept,
				Averager::combine
				)
		.average();
		
		 double expected = promedioMedio(e1, e3, e5, e7);
		 assertEquals(expected, prom);
	}

	@Test
	void promedioConCollect2() {
		double prom = estudiantes.stream()
		.filter(e -> e.getEscuela() == sist)
		//.mapToDouble(e -> e.getPromedio())
		.collect(Averager::new,
				Averager::acceptWithEstudiante,
				Averager::combine
				)
		.average();
		
		 double expected = promedioMedio(e1, e3, e5, e7);
		 assertEquals(expected, prom);
	}

}
