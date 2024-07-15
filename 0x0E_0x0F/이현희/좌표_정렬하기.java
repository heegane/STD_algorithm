import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            nums[i][0] = Integer.parseInt(input[0]);
            nums[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(nums, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(nums[i][0] + " " + nums[i][1] + "\n");
        }
        System.out.println(sb);
    }
}