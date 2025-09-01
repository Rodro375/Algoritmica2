package algo2.semana01.intro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algo2.semana02.lab.CalculadorBinario;

class BinaryCalculatorTest {
	CalculadorBinario Prueba;
	
	@Test
	void testGetResultadoConOperadorBasico() {
		Prueba = new CalculadorBinario(8, 5, "*"); assertEquals(40, Prueba.getResultado());
		Prueba = new CalculadorBinario(112,7,"/"); assertEquals(16, Prueba.getResultado());
		Prueba = new CalculadorBinario(60,3,"-"); assertEquals(57, Prueba.getResultado());
		Prueba = new CalculadorBinario(265,326,"+"); assertEquals(591, Prueba.getResultado());		
	}
	
	@Test
	void testGetResultadoConOperadorNoValido() {
		Prueba = new CalculadorBinario(8, 5, "$"); assertThrows(RuntimeException.class, () -> Prueba.getResultado());
		Prueba = new CalculadorBinario(112,7,"#"); assertThrows(RuntimeException.class, () -> Prueba.getResultado());
		Prueba = new CalculadorBinario(265,326,")"); assertThrows(RuntimeException.class, () -> Prueba.getResultado());
	}
	
	@Test
	void testGetResultadoConDivisionConCero() {
		Prueba = new CalculadorBinario(1,0,"/"); assertThrows(RuntimeException.class, () -> Prueba.getResultado());
	}
}
