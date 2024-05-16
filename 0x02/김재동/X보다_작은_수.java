import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    // 백준 10871 B5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		// 입력 받음

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");					// 문자열 쪼갬

        int n = Integer.parseInt(st.nextToken());										// 정수 개수
        int x = Integer.parseInt(st.nextToken());										// 비교 정수

        StringBuilder sb = new StringBuilder();											// 제한 없는 문자열

        st = new StringTokenizer(br.readLine(), " ");									// 문자열 쪼갬

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());									// 값 받기
            if (val < x)
                sb.append(val).append(' ');												// if 걸러진 값들 문자열 저장
        }
        System.out.println(sb);
    }
}