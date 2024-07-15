import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long[] array = new long[n];

        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            StringBuffer sb = new StringBuffer(st.nextToken());
            array[i] = Long.parseLong(sb.reverse().toString());
        }

        Arrays.sort(array);

        for(int i=0; i<n; i++){
            System.out.println(array[i]);
        }
    }
}
