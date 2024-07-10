package week9;
//z 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1074 {
    public static int recursiveFunc(int N, int r, int c){
        if(N==0){
            return 0;
        }
        int half = 1<<(N-1);
        if(r<half && c<half) return recursiveFunc(N-1,r,c); // 1사분면
        else if(r<half && c>=half) return half*half + recursiveFunc(N-1,r,c-half); //2사분면
        else if(r>=half && c<half) return half*half*2 + recursiveFunc(N-1,r-half,c); //3사분면
        else return half*half*3 + recursiveFunc(N-1,r-half,c-half); //4사분면
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(recursiveFunc(N,r,c));

    }
}
