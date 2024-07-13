import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        isUsed = new boolean[n+1];

        backTracking(0);
    }

    public static void backTracking(int k){
        if(k == m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=(k>0?arr[k-1]+1:1); i<=n; i++)
        {
            if(isUsed[i]) continue;

            arr[k]=i;
            isUsed[i]=true;

            backTracking(k+1);
            isUsed[i] = false;
        }
    }
}
