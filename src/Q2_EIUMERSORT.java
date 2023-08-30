import java.util.*;
import java.io.*;

public class Q2_EIUMERSORT {

	public static void main(String[] args) {
		var N = reader.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.nextInt();
		}
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(arr, 0, arr.length - 1);
		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	static class MergeSort {
		void mergeSort(int[] arr, int from, int to) {
			if (from < to) {
				// tìm điểm giữa
				int mid = (from + to) / 2;
				// đệ quy cho tiếp tục cho mảng
				mergeSort(arr, from, mid);
				mergeSort(arr, mid + 1, to);
				merge(arr, from, mid, to);
			}
		}

		static void merge(int[] arr, int from, int mid, int to) {
			// khai báo kích thước cho 2 mảng con tạm
			int left = mid - from + 1;
			int right = to - mid;
			// tạo mạng tạm L và R
			int[] leftArr = new int[left];
			int[] rightArr = new int[right];
			// copy dữ liệu từ mảng chính vào 2 mảng tạm
			for (int i = 0; i < leftArr.length; i++) {
				leftArr[i] = arr[from + i];
			}
			for (int i = 0; i < rightArr.length; i++) {
				rightArr[i] = arr[mid + 1 + i];
			}
			// sort các mảng tạm lại

			// vị trí ban đầu của 2 mạng tạm
			int left_idx = 0;
			int right_idx = 0;
			// vị trí ban đầu của mảng được hợp nhất
			int complete = from;
			while (left_idx < left && right_idx < right) {
				if (leftArr[left_idx] <= rightArr[right_idx]) {
					arr[complete] = leftArr[left_idx];
					left_idx++;
				} else {
					arr[complete] = rightArr[right_idx];
					right_idx++;
				}
				complete++;
			}
			// sao chép các phần tử còn lại của leftArr (nếu có)
			while (left_idx < left) {
				arr[complete] = leftArr[left_idx];
				left_idx++;
				complete++;
			}
			// tương tự
			while (right_idx < right) {
				arr[complete] = rightArr[right_idx];
				right_idx++;
				complete++;
			}
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
