import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
    static boolean[] isUsed1 = new boolean[40];
    static boolean[] isUsed2 = new boolean[40];
    static boolean[] isUsed3 = new boolean[40];

    static int count = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        backTracking(0);

        System.out.println(count);
    }

    public static void backTracking(int cur)
    {
        if(cur==n){
            count++;
            return;
        }

        for(int i=0; i<n; i++){
            if(isUsed1[i]||isUsed2[i+cur]||isUsed3[cur-i+n-1])
                continue;

            isUsed1[i] = true;
            isUsed2[i+cur] = true;
            isUsed3[cur-i+n-1] = true;

            backTracking(cur+1);
            isUsed1[i] = false;
            isUsed2[i+cur] = false;
            isUsed3[cur-i+n-1] = false;
        }
    }
}
