package algo2.semana11.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanXan {
	static List<String> readTokenFrom(String file, String tokenDelimiter) throws FileNotFoundException {
		
		List<String> result = new ArrayList<>();
		Scanner s = null;
		
		s = new Scanner(new BufferedReader(new FileReader(file)));
		s.useDelimiter(tokenDelimiter);
		while (s.hasNext()) {
			result.add(s.next());
		}
		if (s != null) {
			s.close();
		}
		
		return result;
	}
	
	static void multipleRead() {
		Scanner scan = new Scanner(System.in);
		PrintStream out = System.out;
		out.print("Ingrese un entero: ");
		int intNum = scan.nextInt();
		
		out.print("Ingrese un double: ");
		double douNum = scan.nextDouble();
		
		out.print("true o false: ");
		boolean bool = scan.nextBoolean();
		
		out.format("int=%d, dou=%f, bool=%s", intNum, douNum, bool);
		scan.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//multipleRead();
		String inEncodedPath = ClassLoader.getSystemResource("sample.txt").getFile();
		String inDecodedPath = URLDecoder.decode(inEncodedPath, StandardCharsets.UTF_8);
		List<String> tokens = readTokenFrom(inDecodedPath, "-"); // \\r\\n
		int line = 1;
		for (String t : tokens) {
			System.out.println("Linea" + line + ": " + t);
			line++;
		}
		System.out.println(tokens);
	}
}
