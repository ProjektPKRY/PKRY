package extra;

import java.math.BigInteger;
import java.util.Random;

public class HelpingMethods {
	
	//dupa dupa tralala
	/**
	 * This method generate a probably prime big number.
	 * @param bit_length
	 * length of number in bits
	 * @return
	 * probably prime BigInteger
	 */
	public static BigInteger generatePrimeNumber(int bit_length) {
		
		Random random = new Random();
		BigInteger big_int = BigInteger.probablePrime(bit_length, random);		
		
		return big_int;
	}
}