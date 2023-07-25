import java.util.*;

public class StringPattern {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String text = sc.nextLine();
		String pattern = sc.nextLine();
		//do phuc tap O^N
		for (int i = 0; i < text.length() - pattern.length(); i++) {
			int j = 0;
			for (j = 0; j < pattern.length(); j++) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == pattern.length()) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);

	}

}
