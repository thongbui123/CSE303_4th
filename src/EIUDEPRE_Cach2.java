import java.util.*;

public class EIUDEPRE_Cach2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		double before = sc.nextDouble();
		double after = sc.nextDouble();
		double res = binarySearch(0, 1, before, after, n);
		System.out.println(res);
	}

	static double binarySearch(double low, double high, double before, double after, int year) {
		while (high - low > 0.000001) {
			double mid = (high + low) / 2;
			double price = calPrice(before, year, mid);
			if (price > after) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return low;
	}
	
	static double calPrice(double before, int n, double x) {
		double price = before;
		for (int i = 0; i < n; i++) {
			double rate = x - x * i / n;
			price = (price * (1 - rate));
		}
		return price;
	}
}
