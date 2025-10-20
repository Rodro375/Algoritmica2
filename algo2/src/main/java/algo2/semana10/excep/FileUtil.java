package algo2.semana10.excep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	private static final int MAX_LINES = 5;
	
	private static void m1() {
		try {
			m2();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void m2() throws IOException, FileNotFoundException {
		m3();
		//proseguir();
	}
	
	private static void m3() throws IOException, FileNotFoundException {
		fromTo("C:\\algo2\\2025-2\\workspace\\tmp\\file1.txt", "C:\\algo2\\2025-2\\workspace\\tmp\\file2.txt");
		//proseguir();
	}

	public static void fromTo(String from, String to) throws IOException, FileNotFoundException {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(from));
			writer = new BufferedWriter(new FileWriter(to));
			String line = reader.readLine();
			while (line != null) {
				writer.write(line);
				line = reader.readLine();
				if (line != null) {
					writer.write(System.lineSeparator());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
			reader.close();
		}
	}
	
	/*public static void fromTo2(String from, String to) {
		try (BufferedReader reader = new BufferedReader(new FileReader(from));
				BufferedWriter writer = new BufferedWriter(new FileWriter(to));) {
			
			String line = reader.readLine();
			while (line != null) {
				writer.write(line + System.lineSeparator());
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	public static void fromTo3(String from, String to) throws FileNotFoundException, IOException, LimitException
	{
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(to));) {
			BufferedReader reader = new BufferedReader(new FileReader(from));
			long numLinea = reader.lines().count();
			
			if (numLinea > MAX_LINES) {
				reader.close();
				throw new LimitException("Numero de lineas " + numLinea + " es mayor que " + MAX_LINES);
			}
			reader = new BufferedReader(new FileReader(from));
			String line = reader.readLine();
			while (line != null) {
				writer.write(line + System.lineSeparator());
				line = reader.readLine();
			}
		}
	}
	/*
	public void FileReader(String fileName) throws FileNotFoundException {
		super(new FileInputStream(fileName));
	}
	
	public String readLine() throws IOException {
		return readLine(false);
	}*/
	
	public static void main(String[] args) {
		//m1();
		try {
			fromTo3("C:\\algo2\\2025-2\\workspace\\tmp\\file1.txt", "C:\\algo2\\2025-2\\workspace\\tmp\\file2.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LimitException e) {
			e.printStackTrace();
		}
	}
}

class LimitException extends Exception {
	public LimitException(String mensaje) {
		super(mensaje);
	}
}
