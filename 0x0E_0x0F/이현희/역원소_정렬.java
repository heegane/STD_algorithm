import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        long[] nums = new long[n];
        int index = 0;

        while (index < n) {
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                StringBuilder reverseStr = new StringBuilder();
                // 역정렬
                for (int i = str.length() - 1; i >= 0; i--) {
                    reverseStr.append(str.charAt(i));
                }
                nums[index] = Long.parseLong(reverseStr.toString());
                index++;
            }
            if (index < n) {
                st = new StringTokenizer(br.readLine());
            }
        }

        Arrays.sort(nums);
        for (long num : nums) {
            sb.append(num + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}