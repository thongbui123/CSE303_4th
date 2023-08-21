import java.io.*;
import java.util.*;;

public class EIUGAME2 {

	public static void main(String[] args) {
		int n = ni(), m = ni();
		long[][] arr = new long[n + 1][m + 1];
		long[][] count = new long[n + 1][m + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				arr[i][j] = nl();
			}
		}
		count[0][1] = 1;
		count[1][0] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (i == 1) {
					arr[i][j] = arr[i][j - 1] + arr[i][j];
					count[i][j] = 1;
					continue;
				}
				if (j == 1) {
					arr[i][j] = arr[i - 1][j] + arr[i][j];
					count[i][j] = 1;
					continue;
				}
				arr[i][j] += Math.max(arr[i - 1][j], arr[i][j - 1]);
				if (arr[i - 1][j] > arr[i][j - 1]) {
					count[i][j] = count[i - 1][j];
				} else if (arr[i - 1][j] == arr[i][j - 1]) {
					count[i][j] = (count[i - 1][j] + count[i][j - 1]) % 10000000;
				} else {
					count[i][j] = count[i][j - 1];
				}

			}
		}
		System.out.println(arr[n][m] + " " + count[n][m]);
	}

	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}