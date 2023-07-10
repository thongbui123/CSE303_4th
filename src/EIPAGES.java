import java.io.*;
import java.util.*;;

public class EIPAGES {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		int n = ni(), flag = 1;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = ni();
		}
		if (arr.length == 1) {
			sb.append(arr[0]);
		} else {
			Arrays.sort(arr);
			sb.append(arr[0]);
			for (int i = 1; i < arr.length - 1; i++) {
				if (arr[i] - 1 != arr[i - 1]) {
					sb.append(" ").append(arr[i]);
					if (flag == 0)
						flag++;
				} else {
					if (arr[i] + 1 != arr[i + 1]) {
						if (flag > 1) 
							sb.append("-").append(arr[i]);						
						if (flag == 1) 
							sb.append(" ").append(arr[i]);		
						flag = 0;
					} else 
						flag++;					
				}
			}
		}
		int last = arr.length - 1;
		if (arr[last - 1] == arr[last] - 1 && flag > 1) 
			sb.append("-").append(arr[last]);
		 else 
			sb.append(" ").append(arr[last]);		
		System.out.println(sb);
	}

	static int getMin(List<Integer> list) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			min = Math.min(list.get(i), min);
		}
		return min;
	}

	static List<Integer> removeItem(List<Integer> list, int item) {
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i) == item) {
				list.remove(i);
			} else {
				list.set(i, list.get(i) - item);
			}
		}
		return list;
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