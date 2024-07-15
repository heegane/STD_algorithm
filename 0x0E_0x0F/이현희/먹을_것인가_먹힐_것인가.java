import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Integer[] a = new Integer[n];
            Integer[] b = new Integer[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a, Collections.reverseOrder());
            Arrays.sort(b, Collections.reverseOrder());
            int temp = 0;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < m; j++) {
                    if (a[i] > b[j]) {
                        temp += (m - cnt);
                        break;
                    } else cnt++;
                }
            }
            answer.append(temp + "\n");
        }

        System.out.println(answer);
        br.close();
    }
}

