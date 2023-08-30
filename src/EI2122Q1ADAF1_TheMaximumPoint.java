import java.io.*;
import java.util.*;

class Test {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuffer outBf = new StringBuffer();
		int n = reader.nextInt();
		long[] values = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			values[i] = reader.nextLong();
		}
		long[] maxValue = new long[n + 1];
		maxValue[0] = 0;
		maxValue[1] = values[1];
		for (int i = 2; i <= n; i++) {
			maxValue[i] = Math.max(values[i - 1] * 2 + values[i] + maxValue[i - 2], maxValue[i - 1] + values[i]);
		}
		maxValue[n] = Math.max(maxValue[n], maxValue[n - 1] + values[n] * 2);
		System.out.println(maxValue[n]);
	}

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