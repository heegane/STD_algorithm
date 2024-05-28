import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int roomCnt = 0;

		int[] girls = new int[7];
		int[] boys = new int[7];

		for (int i = 0; i < n; i++) {
			String data = br.readLine();
			StringTokenizer st2 = new StringTokenizer(data);
			int sex = Integer.parseInt(st2.nextToken());
			int grade = Integer.parseInt(st2.nextToken());

			if (sex == 0) {
				girls[grade] += 1;
			} else {
				boys[grade] += 1;
			}
		}

		for (int i = 1; i <= 6; i++) {
			if (girls[i] != 0) {
				if (girls[i] > k) {
					roomCnt += girls[i] / k;
					if (girls[i] % k != 0) {
						roomCnt += 1;
					}
				} else {
					roomCnt += 1;
				}
			}

			if (boys[i] != 0) {
				if (boys[i] > k) {
					roomCnt += boys[i] / k;
					if (boys[i] % k != 0) {
						roomCnt += 1;
					}
				} else {
					roomCnt += 1;
				}
			}
		}

		System.out.println(roomCnt);
		br.close();
	}
}
