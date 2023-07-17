import java.io.*;
import java.util.*;;

public class EI2122Q1ADAM2_Matching {

	public static void main(String[] args) {
		int n = ni(), m = ni(), x = ni();
		int[] males = new int[n];
		for (int i = 0; i < males.length; i++) {
			males[i] = ni();
		}
		Arrays.sort(males);
		int[] females = new int[m];
		for (int i = 0; i < females.length; i++) {
			females[i] = ni();
		}
		Arrays.sort(females);
		int temp = 0, left = 0, right = Integer.MAX_VALUE - 1;
		while(left <= right) {
			int h = (left + right) / 2;
			int count = count(males, females, h);
			if (count >= x) {
				temp = h;
				right = h - 1;
			} else {
				left = h + 1;
			}
		}
		System.out.println(temp);
	}
	
	static int count(int[] males, int[] females, int h) {
		int i = 0, j = 0, sum = 0;
		while(i < males.length && j < females.length) {
			if (males[i] > females[j]) {
				if (males[i] - females[j] <= h) {
					i++;
					j++;
					sum++;
				} else {
					j++;
				}
			} else if (males[i] == females[j]) {
				i++;
				j++;
				sum++;
			} else {
				if (females[j] - males[i] <= h) {
					i++;
					j++;
					sum++;
				} else {
					i++;
				}
			}
		}
		return sum;
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