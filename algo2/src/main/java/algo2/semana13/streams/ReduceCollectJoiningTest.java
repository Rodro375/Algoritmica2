package algo2.semana13.streams;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceCollectJoiningTest {
	@Test
	void joining() {
		
		String delimiter = " ";
		String s = Stream.of("Hola", "Mundo", "!!")
		.collect(Collectors.joining(delimiter));
		String esperado = "Hola Mundo !!";
		assertEquals(esperado, s);
		
		s = Stream.of("Hola", "Mundo", "!!")
		.reduce("", (rp, e) -> {if(rp.isEmpty()) return e; else return rp + delimiter + e; });
		esperado = "Hola Mundo !!";
		assertEquals(esperado, s);

		//Imposible, porque String es Inmutable!!
		s = Stream.of("Hola", "Mundo", "!!")
		.collect(()-> new String(""),  
				(rp, e) -> {if(rp.isEmpty()) rp = e; else rp += delimiter + e; }, //rp.concat(e),
				(rp1, rp2) -> {if(rp1.isEmpty()) rp1 = rp2; else rp1 += delimiter + rp2; }
				);
		String supuestamente = "Hola Mundo !!";
		assertNotEquals(supuestamente, s);
		assertEquals("", s);
		
		s = Stream.of("Hola", "Mundo", "!!")
		.collect(()-> new StringBuilder(),  
				(rp1, e) -> { if (rp1.length()<1) rp1.append(e);  else rp1.append(delimiter+e);},
				(rp1, rp2) -> { if (rp1.length()<1) rp1.append(rp2);  else rp1.append(delimiter+rp2);}
				)
		.toString();

		esperado = "Hola Mundo !!";
		assertEquals(esperado, s);

	}
	
	class StringAcuCom{
		private StringBuilder s;
		private String delimiter;
		StringAcuCom(String inicial, String delimiter){
			s = new StringBuilder(inicial);
			this.delimiter = delimiter;
		}
		StringAcuCom(){
			this("", "");
		}
		void accu(String e) {
			if  (s.length()<1) s.append(e); else s.append(delimiter+e);
		}
		void comb(StringAcuCom otro) {
			if (s.length()<1) s.append(otro.s);  
			else s.append(delimiter+otro.s);	
		}
		@Override
		public String toString() {
			return s.toString();
		}
	}

	@Test
	void joining2() {
		
		String delimiter = " ";
		
		String s = Stream.of("Hola", "Mundo", "!!")
		.collect(()-> new StringAcuCom("",delimiter),  
				StringAcuCom::accu,
				StringAcuCom::comb
				)
		.toString();

		String esperado = "Hola Mundo !!";
		assertEquals(esperado, s);
	}
}
