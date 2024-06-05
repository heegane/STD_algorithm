import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 위
		for (int i = 1; i < n; i++) {
			// 빈칸
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			// 별
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 가운데
		for (int i = 0; i < 2 * n - 1; i++) {
			System.out.print("*");
		}
		System.out.println();

		// 아래
		for (int i = n - 1; i > 0; i--) {
			// 빈칸
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			// 별
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
