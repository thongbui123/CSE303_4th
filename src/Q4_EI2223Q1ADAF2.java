import java.util.*;
import java.io.*;

public class Q4_EI2223Q1ADAF2 {

	public static void main(String[] args) {
		String s = reader.next();
		String p = reader.next();
		int i = 0, j = 0, count = 0;
		while (i < s.length() && j < p.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				if (j == p.length()) {
					count++;
					j = 0;
				}
			} else {
				i++;
			}
		}
		System.out.println(count);
	}

	static InputReader reader = new InputReader(System.in);

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
