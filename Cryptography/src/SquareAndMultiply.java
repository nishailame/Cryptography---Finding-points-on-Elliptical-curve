
import java.lang.*;
import java.util.*;
import java.math.BigInteger;

public class SquareAndMultiply {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		BigInteger base, modular, expo;
		BigInteger result;
		System.out.println("Enter the base value");
		base = input.nextBigInteger();
		
		System.out.println("Enter the value");
		expo = input.nextBigInteger();
		
		System.out.println("Enter the modulus value");
		modular = input.nextBigInteger();
		result = base.modPow(expo, modular);
		System.out.println(result);
	
	}
}

