import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			arr.add(Integer.valueOf(sc.nextInt()));
		}

		int max = Collections.max(arr);
		int index = arr.indexOf(max);

		System.out.println(max);
		System.out.println(index + 1);
	}
}
