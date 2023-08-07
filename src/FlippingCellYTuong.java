import java.io.*;
import java.util.*;;

public class FlippingCellYTuong {

	public static void main(String[] args) {
		List<String> allSubset = new ArrayList<String>();
		List<String> subSubset = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			int num = i + 1;
			allSubset.add(Integer.toString(num));
			for (int j = 0; j < allSubset.size() - 1; j++) {
				subSubset.add(allSubset.get(j) + num);
			}
			allSubset.addAll(subSubset);
			subSubset.clear();
		}
		allSubset.sort((s1, s2) -> {
			return s1.length() - s2.length();
		});
		Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
		for (String subset : allSubset) {
			List<Integer> defaultList = new ArrayList<Integer>();
			for (int i = 1; i <= 9; i++) {
				defaultList.add(0);
			}
			defaultList = tab(defaultList, subset);
			if (!map.containsKey(defaultList)) {
				map.put(defaultList, subset.length());
			} else {
				if (map.get(defaultList) > subset.length()) {
					map.put(defaultList, subset.length());
				}
			}
		}
		int testcases = ni();
		StringBuffer sb = new StringBuffer();
		while (testcases-- > 0) {
			List<Integer> input = new ArrayList<Integer>();
			for (int i = 0; i < 3; i++) {
				String s = ns();
				for (Character c : s.toCharArray()) {
					if (c.toString().equalsIgnoreCase("*")) {
						input.add(1);
					} else {
						input.add(0);
					}
				}
			}
			if (map.get(input) == null) {
				sb.append(0).append("\n");
			} else {
				sb.append(map.get(input)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static List<Integer> tab(List<Integer> list, String s) {
		for (int i = 0; i < s.length(); i++) {
			int center = Integer.parseInt(String.valueOf(s.charAt(i)));
			list.set(center - 1, list.get(center - 1) == 0 ? 1 : 0);
			if (center > 1 && center % 3 != 1) {
				list.set(center - 2, list.get(center - 2) == 0 ? 1 : 0);
			}
			if (center < 9 && center % 3 != 0) {
				list.set(center, list.get(center) == 0 ? 1 : 0);
			}
			if (center > 3) {
				list.set(center - 4, list.get(center - 4) == 0 ? 1 : 0);
			}
			if (center < 7) {
				list.set(center + 2, list.get(center + 2) == 0 ? 1 : 0);
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