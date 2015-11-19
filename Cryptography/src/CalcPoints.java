import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class CalcPoints {

	public static List<Order> order = new ArrayList<Order>();

	public static void main(String[] args) throws IOException {

		
		Scanner input = new Scanner(System.in);

		Calcp p = new Calcp();
		int x, y, a, b, mod;
		BigInteger y1, f;
		BigInteger y2, y3, y4;
		BigInteger f2 = BigInteger.ONE;

		// Inputs from user for equation y^2=x^3 + 2a + b mod p
		System.out.println("Enter the  value of a");
		a = input.nextInt();

		System.out.println("Enter the  value of b");
		b = input.nextInt();

		System.out.println("Enter the modulus value p");
		mod = input.nextInt();

		// for (BigInteger h = BigInteger.ONE ; h. p1.subtract(g) )
		// y1= (a.multiply(a))

		int two = 2;
		// while verification we need to square the roots and then find mod,
		// hence constant two
		BigInteger two_big = new BigInteger(String.valueOf(two));

		// Finding exponential value (p+1)/4, later use it for calculating roots
		int expo = (mod + 1) / 4;

		BigInteger expo1 = new BigInteger(String.valueOf(expo));
		BigInteger modulus = new BigInteger(String.valueOf(mod));

		// Loop for getting points for x=0 .... p-1
		for (int i = 0; i <= (mod - 1);) {
			x = i;

			// Calculating value of y putting values in equation
			y = (x * x * x) + (a * x) + b;

			// int to BigInteger conversion
			BigInteger big_y = new BigInteger(String.valueOf(y));

			// calculating value of y with mod value (if value of y is greater
			// than modulus value)
			f = big_y.modPow(f2, modulus);

			// System.out.println(f);

			// Creating String equation for comparison y^2=f mod p
			String equation = f + " mod " + mod;

			// System.out.println(equation);

			// int to BigInteger conversion
			BigInteger calc_y = new BigInteger(String.valueOf(f));

			// Calculating first root
			y1 = calc_y.modPow(expo1, modulus);
			// System.out.println(y1);

			// Calculating first root
			y2 = modulus.subtract(y1);
			// System.out.println(y2);

			// Verification of first root r=y1^2 mod p must be equal to f mod p
			y3 = y1.modPow(two_big, modulus);
			// System.out.println(y3);

			// Verification of first root r=y2^2 mod p must be equal to f mod p
			y4 = y2.modPow(two_big, modulus);
			// System.out.println(y4);

			// creating equations with roots for comparison
			String first_root = y3 + " mod " + mod;
			String second_root = y4 + " mod " + mod;

			// System.out.println(first_root);
			// System.out.println(second_root);

			// Comparing if roots equations and first equation are same
			if (first_root.equalsIgnoreCase(equation)
					&& second_root.equalsIgnoreCase(equation)) {

				order.add(new Order(x, y1));
				order.add(new Order(x, y2));

				System.out.println("( " + x + " , " + y1 + ")");
				System.out.println("( " + x + " , " + y2 + ")");

			}

			i++;
		}
		Calcp cp = new Calcp();
		cp.myMethod(order);

	}
}