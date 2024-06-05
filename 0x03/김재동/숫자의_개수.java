import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    // 백준 2577 B2
    public static void main(String[] args) throws IOException {
        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 합계 구하기
        int sum = 1;
        for (int i = 0; i<3; i++) {
            int k = Integer.parseInt(br.readLine());
            sum *= k;
        }

        // 합계 -> 문자열 -> 배열
        String sSum = Integer.toString(sum);
        char[] num = sSum.toCharArray();

        // 숫자 개수 만큼 배열 생성
        int cnt[] = new int[10];

        // 합계의 길이 만큼 반복
        for(int i = 0; i <num.length; i++) {
            // 숫자 체크
            for(int j =0; j<10; j++) {
                // 문자 -> int 변형하여 비교
                if(Character.getNumericValue(num[i]) == j ) {
                    cnt[j]++;
                    break;				// break 걸어서 빠르게 다음 숫자 체크하기
                }
            }
        }

        // 체크한 숫자 개수 출력
        for (int i = 0; i <cnt.length; i++) {
            System.out.println(cnt[i]);
        }
    }
}