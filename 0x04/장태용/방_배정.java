package week3;

import java.io.*;
import java.util.StringTokenizer;

public class boj13300{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [][]arr = new int[6][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b-1][a] += 1;
        }
        for(int i = 0; i<6; i++){
            for(int j= 0; j<2; j++){
                int temp = arr[i][j];
                if(temp%K != 0){
                    answer += temp/K + 1;
                }
                else{
                    answer += temp/K;
                }
            }
        }
        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }
}
