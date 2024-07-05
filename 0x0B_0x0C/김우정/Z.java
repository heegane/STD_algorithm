import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = z(r, c, n);

        System.out.println(result);

        br.close();
    }

    public static int z(int r, int c, int n){
        if(n==0)
            return 0;

        int half = 1<<n-1;

        if(r<half &&  c<half)
            return z(r, c, n-1);
        else if(r<half && c>=half)
            return half*half + z(r, c-half, n-1);
        else if(r>=half && c<half)
            return 2*half*half +z(r-half, c, n-1);
        else
            return 3*half*half +z(r-half, c-half, n-1);
    }
}
