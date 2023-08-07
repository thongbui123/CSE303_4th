import java.io.*;
import java.util.*;;

public class EIULOGGING3 {

	public static void main(String[] args) {
		int t = ni();
		long[] arr = new long[t + 1];
		long[] max = new long[t + 1];
		long[] way = new long[t + 1];
		for (int i = 1; i < t + 1; i++) {
			arr[i] = nl();
		}
		max[1] = Math.max(max[0], arr[1]);
		way[0] = 1;
		way[1] = 1;
		for (int i = 2; i < t + 1; i++) {
			// max[i] = Math.max(max[i - 2] + arr[i], max[i - 1]);
			if (max[i - 2] + arr[i] > max[i - 1]) {
				max[i] = max[i - 2] + arr[i];
				way[i] = way[i - 2];
			} else if (max[i - 2] + arr[i] == max[i - 1]) {
				max[i] = max[i - 2] + arr[i];
				way[i] = (way[i - 2] + way[i - 1]) % 1000000007;
			} else {
				max[i] = max[i - 1];
				way[i] = way[i - 1];
			}

		}
		System.out.println(max[t] + " " + way[t]);
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