import java.io.*;
import java.util.*;;

public class EIQUEENS {

	public static void main(String[] args) {
		List<int[]> queens = new ArrayList<int[]>();
		boolean res = true;
		for (int i = 0; i < 8; i++) {
			String s = ns();
			for (int j = 0; j < 8; j++) {
				if (s.charAt(j) == '*') {
					int[] arr = new int[] { i, j };
					queens.add(arr);
				}
			}
		}
		if (queens.size() == 8) {
			for (int i = 0; i < queens.size() - 1; i++) {
				for (int j = i + 1; j < queens.size(); j++) {
					if (queens.get(i)[0] == queens.get(j)[0])
						res = false;
					if (queens.get(i)[1] == queens.get(j)[1])
						res = false;
					if (Math.abs(queens.get(i)[0] - queens.get(j)[0]) == Math.abs(queens.get(i)[1] - queens.get(j)[1]))
						res = false;
				}
			}
		} else
			res = false;
		System.out.println(res ? "valid" : "invalid");
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