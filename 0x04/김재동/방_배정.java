import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    // 백준 13300 B2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		// 입력 받음

        // 값 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr [][] = new int[2][7];
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[s][y]++;
        }
        int cnt = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 6; j++) {
                if (arr[i][j] % k != 0) {
                    cnt++;
                }
                cnt += arr[i][j] / k;
            }
        }
        System.out.println(cnt);

    }
}