import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    // 백준 1919 B2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받음
        String str1 = br.readLine();
        String str2 = br.readLine();

        // 문자 개수 체크할 방 생성
        int [] c1 = new int[26];
        int [] c2 = new int[26];

        // 각 문자별 단어 개수 체크
        for(int i =0; i<str1.length(); i++) {
            c1[str1.charAt(i)-'a']++;
        }
        for(int i =0; i<str2.length(); i++) {
            c2[str2.charAt(i)-'a']++;
        }

        int cnt = 0;
        // 단어 개수 비교
        for(int i = 0; i<26; i++) {
            int temp = Math.abs(c1[i]-c2[i]);
            cnt+=temp;
        }
        System.out.println(cnt);

    }


}