
package ag; 

public class HammingWeight {
	public static int hammingWeight(int n) {
		int ones = 0;
		while (n > 0) {
			ones += (n & 1);
			n >>= 1;
		}
		return ones;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 2001; i++)
			System.out.print(i + ":" + hammingWeight(i) + "\n");

	}
}
