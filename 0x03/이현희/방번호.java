import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int[] arr = new int[10];

		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - '0';
			arr[index] += 1;
		}
		int mid = (arr[6] + arr[9] + 1) / 2;
		arr[6] = mid;
		arr[9] = mid;

		int result = Arrays.stream(arr).max().orElse(0);
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
