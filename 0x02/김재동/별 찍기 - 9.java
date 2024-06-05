import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    // 백준 2446 B3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		// 입력 받음
        int n = Integer.parseInt(br.readLine());										// 정수 개수
        StringBuilder sb = new StringBuilder();											// 제한 없는 문자열

        for (int i = 0; i <n; i++) {				// 윗 삼각형
            for (int j = 0; j < i; j++) {			// 공백
                sb.append(" ");
            }
            for (int j = 1; j <= 2*(n-i)-1; j++) {	// 별
                sb.append("*");
            }
            sb.append("\n");					// 줄 바꿈
        }

        for(int i = 1; i<=n-1; i++) {			// 밑 삼각형
            for (int j = n-i-1; j >0; j--) {	// 공백
                sb.append(" ");
            }
            for (int j = 1; j <= 2*i+1; j++) {	// 별
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}