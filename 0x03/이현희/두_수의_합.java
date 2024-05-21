import static java.util.Arrays.*;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] nums =
			Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		Arrays.sort(nums);
		int x = Integer.parseInt(br.readLine());

		HashMap<Integer, Boolean> hashMap = new HashMap<>();
		int result = 0;

		for (int i = 0; i < n; i++) {
			int find = x - nums[i];
			if (hashMap.containsKey(find)) {
				result += 1;
			} else {
				hashMap.put(nums[i], true);
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
