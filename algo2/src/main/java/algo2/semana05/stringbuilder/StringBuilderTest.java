package algo2.semana05.stringbuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringBuilderTest {
	@Test
	public void testAppendDeUnStringNoNulo() {
		StringBuilder inicial = new StringBuilder("uno");
		assertEquals("unodostres", inicial.append("dos").append("tres").toString());
	}
	
	@Test
	public void testAppendConAlgunosStringsNulos() {
		StringBuilder inicial = new StringBuilder("uno");
		String s = null;
		assertEquals("unonulltres", inicial.append(s).append("tres").toString());
	}
	
	@Test
	public void testStringBuilderEsFluent() {
		StringBuilder sb = new StringBuilder("uno");
		sb.append("dos")
		  .append("tres")
		  .reverse()  //sertsodonu
		  .replace(0,  4, "otrocad");
		String result = sb.toString();
		assertEquals("otrocadsodonu", result);
	}
	
}