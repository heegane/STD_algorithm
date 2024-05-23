import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] first = new char[26];
		char[] second = new char[26];
		int result = 0;

		for (char c : br.readLine().toCharArray()) {
			int index = c - 'a';
			first[index] += 1;
		}

		for (char c : br.readLine().toCharArray()) {
			int index = c - 'a';
			second[index] += 1;
		}

		for (int i = 0; i < 26; i++) {
			if (first[i] != second[i]) {
				result += Math.abs(first[i] - second[i]);
			}
		}
		System.out.println(result);
		br.close();
	}
}
