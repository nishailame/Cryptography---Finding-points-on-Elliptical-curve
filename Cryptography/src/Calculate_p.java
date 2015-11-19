import java.math.BigInteger;
import java.util.*;

public class Calculate_p {

	// Line 1-> function modular_pow(base, exponent, modulus)
	public static BigInteger modular_pow(BigInteger base, BigInteger exponent,
			BigInteger modulus) {

		// Line 2-> Assert :: (modulus - 1) * (modulus - 1) does not overflow
		// base
		// termAbove = (modulus - 1) * (modulus - 1)
		int termAbove = (modulus.intValue() - 1) * (modulus.intValue() - 1); 
		// Convert to String to fit in BigInteger Constructor
		String termAboveString = "" + termAbove;

		// (modulus - 1) * (modulus - 1) does not overflow base : means should
		// be less than base
		// if compareTo return 1 than its greater than base which we dont want
		// So we are asserting(assuming) that it will always be less than base
		assert (new BigInteger(termAboveString).compareTo(base) < 0);

		// Line 3-> result := 1
		BigInteger result = BigInteger.ONE;

		// Line 4-> base := base mod modulus
		base = base.remainder(modulus);

		// Line 5-> while exponent > 0
		while (exponent.intValue() > 0) {

			// Line 6-> if (exponent mod 2 == 1):
			if (exponent.intValue() % 2 == 1) {

				// Line 7-> result := (result * base) mod modulus
				result = (result.multiply(base)).remainder(modulus);
			}// End If

			// Line 8-> exponent := exponent >> 1
			// exponent := exponent >> 1
			// this line means to shift bit right by 1 bit.

			exponent = exponent.shiftRight(1);

			// Line 9-> base := (base * base) mod modulus
			base = (base.multiply(base)).remainder(modulus);

		}// End While

		// Line 10-> return result
		return result;

	}// End Function

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Calcp p = new Calcp();
		BigInteger x, y, a, mod, g, alpha, f, f1, f2, f3;
		BigInteger x2, x2p, y2, y2p;

		BigInteger h = BigInteger.ONE;
		System.out.println("Enter the value of x");
		x = input.nextBigInteger();

		System.out.println("Enter the  value of y");
		y = input.nextBigInteger();

		System.out.println("Enter the  value of a");
		a = input.nextBigInteger();

		System.out.println("Enter the modulus value");
		mod = input.nextBigInteger();

		// Calculating value of alpha (3x^2+a)/2y
		g = (x.multiply(x).add(x.multiply(x)).add(x.multiply(x)).add(a));
		
		
		f = y.add(y);

		f1 = f.modInverse(mod);
		f2 = g.multiply(f1);
		alpha = f2.modPow(h, mod);

		System.out.println("Alpha = " + alpha);

		// Calculating value of x2p
		x2 = (alpha.multiply(alpha)).subtract(x).subtract(x);

		x2p = x2.modPow( h, mod);

		System.out.println("x2p = " + x2p);

		// Calculating Value of y2p
		y2 = (alpha.multiply(x.subtract(x2p)).subtract(y));

		y2p = y2.modPow( h, mod);

		System.out.println("y2p = " + y2p);
		
			
		System.out.println("Enter the value of x");
		int r=input.nextInt();
		
		BigInteger a1,a2,a3,a4,a5,a6,a7,  alpha2;
		
		for (int i=3;i<=r;i++)
		{
			try{
			a1= y2p.subtract(y);
			a2= x2p.subtract(x);
			
		//	System.out.println("a1 "+a1);
		//	System.out.println("a2 "+a2);	
			
			a3= a2.modInverse(mod);
		//	System.out.println("a3 "+a3);
			
			
			a4 = a1.multiply(a3);
		//	System.out.println("a4 "+a4);
			
			
			alpha2= a4.modPow(h, mod);
		//	System.out.println(alpha2);
			 
			 a5=((alpha2.multiply(alpha2)).subtract(x2p).subtract(x)).modPow(h,mod);
			 		 
			 a6 =(alpha2.multiply(x.subtract(a5)).subtract(y)).modPow(h,mod);
			 
			 System.out.println("x"+i+"P = "+ a5 +" y"+i+"P = "+a6);
			 
			BigInteger po= BigInteger.ZERO;
			
		//	System.out.println("Before if loop");
			
			 
		//   System.out.println("after if loop");
			 y2p=a6;
			 x2p=a5;
			 
			}
			catch(Exception e){
				
				
				System.exit(0);
			}
			 
		
		}
		

	}

}
