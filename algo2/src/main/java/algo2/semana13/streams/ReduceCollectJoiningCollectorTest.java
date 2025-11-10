package algo2.semana13.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class ReduceCollectJoiningCollectorTest {
	class StringAcuCom implements Collector<String, StringAcuCom, StringAcuCom>{
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
		StringAcuCom comb(StringAcuCom otro) {
			if (s.length()<1) s.append(otro.s);  
			else s.append(delimiter+otro.s);
			return this;
		}
		@Override
		public String toString() {
			return s.toString();
		}
		@Override
		public Supplier<StringAcuCom> supplier() {
			return () -> this;
		}
		@Override
		public BiConsumer<StringAcuCom, String> accumulator() {
			return StringAcuCom::accu;
		}
		@Override
		public BinaryOperator<StringAcuCom> combiner() {
			return StringAcuCom::comb;
		}
		@Override
		public Function<StringAcuCom, StringAcuCom> finisher() {
			// TODO Auto-generated method stub
			return (a1) -> a1;
		}
		@Override
		public Set<Characteristics> characteristics() {
			// TODO Auto-generated method stub
			return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
		}
	}

	@Test
	void joining() {
		
		String delimiter = " ";
		String s = Stream.of("Hola", "Mundo", "!!")
		.collect(new StringAcuCom("",delimiter))
		.toString();

		String esperado = "Hola Mundo !!";
		assertEquals(esperado, s);
		
		s = Stream.of("Hola", "Mundo", "!!")
		.collect(new StringAcuCom())
		.toString();

		esperado = "HolaMundo!!";
		assertEquals(esperado, s);

	}
}
