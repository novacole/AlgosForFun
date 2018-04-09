package ag;

public class digits {
	public static int addDigits(int num) {
		while (Integer.toString(num).length() > 1) {
			int len = Integer.toString(num).length();
			int temp = 0;
			for (int i = 0; i < len; i++) {
				temp += Integer.parseInt(Integer.toString(num).split("")[i]);
			}
			num = temp;
		}
		return num;
	}

	public static void main(String[] args) {
		// Given a non-negative integer num, repeatedly add all its digits until the
		// result has only one digit.
		// For example:
		// Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
		// one digit, return it.
		System.out.print(addDigits(0));
		System.out.print(addDigits(38));
		System.out.print(addDigits(192));
		System.out.print(addDigits(92));
	}
}
