import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[10];
		int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
		String s = String.valueOf(val);

		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 48;
			arr[index] += 1;
		}

		for (int e : arr) {
			bw.write(String.valueOf(e));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
