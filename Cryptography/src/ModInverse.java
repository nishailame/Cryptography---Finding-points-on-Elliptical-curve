import java.lang.*;
import java.util.*;
import java.math.BigInteger;

public class ModInverse {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		BigInteger base, modof, a;
		BigInteger result, result2, finalResult;
		
		System.out.println("Enter the base value of which inverse is to be find");
		base = input.nextBigInteger();
		
		System.out.println("Enter the modulus value");
		modof = input.nextBigInteger();
		
		System.out.println("Enter the multiplier value");
		a = input.nextBigInteger();

		result = base.modInverse(modof);
		result2 = a.multiply(result);
		finalResult = result2.mod(modof);
		System.out.println(finalResult);

	}
}


