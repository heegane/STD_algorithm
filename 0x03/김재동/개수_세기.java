import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 백준 10807 B5
    public static void main(String[] args) throws IOException {
        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 받기
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 수열 저장
        int arr[] = new int [n];
        for(int i = 0; i<n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }
        int v = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        // 쌍의 개수 체크
        int cnt = 0;
        for(int i = 0; i<n; i++) {
            if(arr[i]==v) {
                cnt++;
            }else if(arr[i]>v) {
                break;
            }
        }
        //출력
        System.out.println(cnt);
    }

}