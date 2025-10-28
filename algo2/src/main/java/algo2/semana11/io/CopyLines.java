package algo2.semana11.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class CopyLines {
	public static void copy(String fromFile, String toFile) throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		
		in = new BufferedReader(new FileReader(fromFile));
		out = new BufferedWriter(new FileWriter(toFile));
		String c;
		
		while ((c = in.readLine()) != null) {
			out.write(c);
			out.newLine();
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
