import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    // 백준 10808 B5
    public static void main(String[] args) throws IOException {
        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 받음
        String str = br.readLine();
        // 제한 없는 문자열
        StringBuilder sb = new StringBuilder();

        // 문자열 -> char 배열로 변환
        char[] ch = str.toCharArray();

        // 알파벳 개수 만큼 배열 생성
        int alpha[] = new int[26];


        // 문자열 길이 만큼 반복
        for(int i = 0; i<str.length(); i++) {
            // 알파벳 체크
            for(int j =0; j<26; j++) {
                int temp = 97+j;			// 알파벳 아스키 코드 97~122
                if(temp == (byte)ch[i]) {	// 알파벳 수 만큼 ++
                    alpha[j]++;
                    break;				// break 걸어서 빠르게 다음 알파벳 체크하기
                }
            }
        }

        // 체크한 알파벳 개수 문자열에 저장하기
        for (int i = 0; i <alpha.length; i++) {
            // if 걸러진 값들 문자열 저장
            sb.append(alpha[i]).append(' ');
        }
        System.out.println(sb);
    }
}