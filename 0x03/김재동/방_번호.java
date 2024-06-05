import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    // 백준 1475 S5
    public static void main(String[] args) throws IOException {
        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 받음
        String str = br.readLine();

        // 모든 문자의 6을 9로 변환
        str = str.replace('6','9');

        // 문자열 배열화
        String st[] = str.split("");

        // 숫자 개수 체크
        int cnt[] = new int[10];

        for(int i = 0; i<st.length; i++) {
            for(int j = 0; j<10; j++) {
                if(Integer.parseInt(st[i])==j) {
                    cnt[j] += 1;
                }
            }
        }
        int max = 0;
        // 0~8 까지의 max 구하기
        for(int i =0; i<9; i++) {
            max = Math.max(max, cnt[i]);
        }
        // 9번 구하기
        if(cnt[9]%2 ==1) {
            cnt[9] = cnt[9]/2+1;
        }else {
            cnt[9] = cnt[9]/2;
        }
        max = Math.max(max, cnt[9]);

        System.out.println(max);
    }
}