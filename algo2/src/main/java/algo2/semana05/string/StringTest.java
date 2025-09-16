package algo2.semana05.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void testTestTrimBorraLosEspaciosDeLosExternos() {
		String s1 = "	Java is cool	";
		assertEquals("Java is cool", s1.trim());
	}

	@Test
	void testTestTrimNoBorraLosEspaciosIntermediosSinoSeConserva() {
		assertNotEquals("Java is cool", "Java is		cool".trim());
		assertEquals("Java is		cool", "Java is		cool".trim());
	}

	@Test
	void testTestTrimAcuerdeseQueStringEsInmutable() {
		String s1 = "	Java is cool	";
		String s2 = s1.trim();
		assertNotEquals("Java is cool", s1);
	}

	@Test
	void testStringJoinConDelimitadorDeUnCaracter() {
		String s1 = String.join("-", "Java", "is", "cool");
		assertEquals("Java-is-cool", s1);
	}
	
	@Test
	void testStringJoinConDelimitadorConMasDeUnCaracter() {
		String s1 = String.join("**", "Java", "is", "cool");
		assertEquals("Java**is**cool", s1);
	}
	
	@Test
	void TestStringJoinDelimitadorNulo() {
		String nulo = null;
		assertThrows(RuntimeException.class, () -> String.join(nulo, "a"));
	}
	
	@Test
	void TestStringJoinElementoNulo() {
		CharSequence[] nulo = null;
		assertThrows(RuntimeException.class, () -> String.join("a", nulo));
	}
	
}