public class MyByte {
	
	static String toBinaryString(byte bajt) {
		
		int power2 = 64;
		String binary = "";
		
		if (bajt < 0) {
			int bajt_tmp = -128;
			binary = binary + "1";
			for(int i = 0; i < 7; i++) {
				
				if (bajt >= (bajt_tmp + power2)) {					
					binary = binary + "1";
					bajt_tmp = bajt_tmp + power2;
				}
				else {
					binary = binary + "0";
			//		bajt = (byte)(bajt + power2);
				}
				power2 = power2/2;
			}
		}
		else {
			binary = binary + "0";
			for(int i = 0; i < 7; i++) {
				
				if (bajt <= (power2 - 1)) {
					binary = binary + "0";
				}
				else {
					binary = binary + "1";
					bajt = (byte)(bajt - power2);
				}
				power2 = power2 / 2;
			}
		}	
		return binary;
	}
}