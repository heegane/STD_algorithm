import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int result = 0;
        int start = 0;
        int end = N-1;
        while(start < end){
            if(arr[start] + arr[end] == x){
                result += 1;
                start += 1;
                end -= 1;
            }else if(arr[start] + arr[end] > x){
                end -= 1;
            }else{
                start += 1;
            }
        }
        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }
}
