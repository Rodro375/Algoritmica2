package algo2.semana11.persistencia;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class EsSerializable implements Serializable{
}
class Data implements Serializable{
	private String seraSerializado;
	private transient String noSeraSerializado1;
	private transient int noSeraSerializado2=2;
	private SerializableYNoSerializableTest seraSerializado2 = new SerializableYNoSerializableTest();
	
	public String getNoSeraSerializado1() {
		return noSeraSerializado1;
	}

	public int getNoSeraSerializado2() {
		return noSeraSerializado2;
	}
	public SerializableYNoSerializableTest getSeraSerializado2() {
		return seraSerializado2;
	}

	public Data(String seraSerializado, String noSeraSerializado) {
		this.seraSerializado = seraSerializado;
		this.noSeraSerializado1 = noSeraSerializado;
		this.noSeraSerializado2 = 10;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		Data otro = (Data)obj;
		return seraSerializado.equals(otro.seraSerializado);
	}
}

public class SerializableYNoSerializableTest {
	private File testFile = null;
	private final Data d1 = new Data("111", "AAA");

	@BeforeEach
	public void init() {
		try {
			testFile = File.createTempFile("abc", "txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void unSoloData() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile));
			out.writeObject(d1);
			out.close();

			ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile));
			Data d  = (Data)in.readObject();
			assertEquals(d1, d);
			assertNull(d.getNoSeraSerializado1());
			assertEquals(0, d.getNoSeraSerializado2());
			assertNotNull(d.getSeraSerializado2());
			
			in.close();
		} catch (FileNotFoundException e) {
			fail("Fallo con archivo");
			e.printStackTrace();
		} catch (IOException e) {
			fail("Fallo con archivo");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			fail("Fallo con casting");
			e.printStackTrace();
		}
	}

}