import java.io.*;
import java.util.StringTokenizer;

public class boj10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < N; i++) {
            if (arr[i] == x) {
                count += 1;
            }
        }
        bw.write(Integer.toString(count));
        bw.close();
        br.close();
    }
}
