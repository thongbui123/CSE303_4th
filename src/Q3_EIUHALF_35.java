import java.util.*;
import java.io.*;

public class Q3_EIUHALF_35 {

	public static void main(String[] args) {
		var N = reader.nextInt();
		long[] arr = new long[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.nextLong();
		}
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				min = Math.min(min, arr[j] - arr[i]);
			}
		}
		if (arr.length == 1) {
			System.out.println(arr[0]);
		} else if (arr.length == 2) {
			System.out.println(arr[1] - arr[0]);
		} else {
			System.out.println(min);
		}
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
