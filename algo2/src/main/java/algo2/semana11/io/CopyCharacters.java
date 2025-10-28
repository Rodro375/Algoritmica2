package algo2.semana11.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class CopyCharacters {
	public static void copy(String fromFile, String toFile) throws IOException {
		FileReader in = null;
		FileWriter out = null;
		
		in = new FileReader(fromFile);
		out = new FileWriter(toFile);
		int c;
		
		while ((c = in.read()) != -1) {
			out.write(c);
		}
		if (in != null) {
			in.close();
		}
		if (out != null) {
			out.close();
		}
	}

	public static void main(String[] args) throws IOException {
		String inPath = ClassLoader.getSystemResource("sample.txt").getFile();
		String outPath = ClassLoader.getSystemResource(".").getPath() + "copia.txt";
		System.out.println(inPath);
		System.out.println(outPath);
		inPath = URLDecoder.decode(inPath, StandardCharsets.UTF_8);
		outPath = URLDecoder.decode(outPath, StandardCharsets.UTF_8);
		System.out.println(inPath);
		System.out.println(outPath);
		
		copy(inPath, outPath);
	}
}
