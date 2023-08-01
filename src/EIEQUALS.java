import java.io.*;
import java.util.*;;

public class EIEQUALS {

	public static void main(String[] args) {
		int t = ni(), k = ni();
		int[] arr1 = new int[t];
		int[] arr2 = new int[t];
		for (int i = 0; i < t; i++) {
			arr1[i] = ni();
		}
		for (int i = 0; i < t; i++) {
			arr2[i] = ni();
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		boolean[] check1 = new boolean[t];
		boolean[] check2 = new boolean[t];
		int i = 0, j = 0, count = 0;
		boolean res = false;
		while (i < arr1.length && j < arr2.length) {
			int x = arr1[i] - arr2[j];
			if (x == 0) {
				check1[i] = true;
				check2[j] = true;
				i++;
				j++;
				count++;
			} else {
				if (x > 0) {
					j++;
				} else {
					i++;
				}
			}
		}
		if (count == t) {
			res = true;
		} else if (count == t - 1) {
			for (int l = 0; l < check1.length; l++) {
				if (check1[l] == false) {
					for (int l2 = 0; l2 < check2.length; l2++) {
						if (check2[l2] == false) {
							if (Math.abs(arr1[l] - arr2[l2]) <=k) {
								res = true;
							}
						}
					}
				}
			}
		}
		System.out.println(res ? "YES" : "NO");
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