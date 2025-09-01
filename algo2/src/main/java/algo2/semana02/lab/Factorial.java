package algo2.semana02.lab;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese un valor: ");
		int num = scan.nextInt();
		long fact = factorial(num);
		System.out.printf("El factorial de %d es %d.", num, fact);
		scan.close();
	}

	public static long factorial(int num) {
		if (num > 20 || num < 0) {
			throw new RuntimeException("El numero está fuera de límites");
		}
		
		long result = 1;
		for(int i = 1; i<=num; i++) {
			result *= i;
		}
		return result;
	}
}
