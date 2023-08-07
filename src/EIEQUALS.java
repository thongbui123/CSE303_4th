import java.io.*;
import java.util.*;;

public class EIEQUALS {

	public static void main(String[] args) {
		int n = ni(), k = ni();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = ni();
		}
		for (int i = 0; i < n; i++) {
			arr2[i] = ni();
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		boolean[] check1 = new boolean[n];
		boolean[] check2 = new boolean[n];
		int index1 = 0, index2 = 0, count = 0;
		boolean res = false;
		while (index1 < arr1.length && index2 < arr2.length) {
			int x = arr1[index1] - arr2[index2];
			if (x == 0) {
				check1[index1] = true;
				check2[index2] = true;
				index1++;
				index2++;
				count++;
			} else {
				if (x > 0) {
					index2++;
				} else {
					index1++;
				}
			}
		}
		if (count == n) {
			res = true;
		} else if (count == n - 1) {
			for (int i = 0; i < check1.length; i++) {
				if (check1[i] == false) {
					for (int j = 0; j < check2.length; j++) {
						if (check2[j] == false) {
							if (Math.abs(arr1[i] - arr2[j]) <= k) {
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