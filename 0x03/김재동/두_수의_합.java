import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    // 백준 3273 S3
    public static void main(String[] args) throws IOException {
        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 받기
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열 저장
        int arr[] = new int [n];
        for(int i = 0; i<n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        int x = Integer.parseInt(br.readLine());
        // 쌍의 개수 체크
        int cnt = 0;
        for(int i = 0; i<n; i++) {
            if(set.contains(x-arr[i])) {
                cnt++;
            }
        }
        //출력
        System.out.println(cnt/2);
    }
}