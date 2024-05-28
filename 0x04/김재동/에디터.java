import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    // 백준 1406 S2
    public static void main(String[] args) throws IOException {
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/*
		 	변수 소개
		 	str : 기본 문자열 받기
		 	leftSt : 커서 기준 왼쪽 문자값들 저장
		 	rightSt : 커서 기준 오른쪽 문자값들 저장
		 	n : 명령어 개수
		 	ord : 명령어
		 	ordC : 명령어 단어
		 	ordStr : 명령어 문자
		 */

        // 변수 선언 및 값 받기
        String str = br.readLine();
        Stack<Character> leftSt = new Stack<>();
        Stack<Character> rightSt = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        // 받은 문자열 단어로 변환해서 왼쪽 스택에 저장
        for(int i = 0; i<str.length(); i++) {
            leftSt.push(str.charAt(i));
        }

        // n 개수 만큼 명령어 실행
        for(int i = 0; i<n; i++) {	// 반복문 시작
            String ord = br.readLine();
            char ordC = ord.charAt(0);

            if(ordC=='L') {
                if(!leftSt.empty()) {
                    rightSt.push(leftSt.pop());
                }
            }else if(ordC=='D') {
                if(!rightSt.empty()) {
                    leftSt.push(rightSt.pop());
                }
            }else if(ordC=='B') {
                if(!leftSt.empty()) {
                    leftSt.pop();
                }
            }else if(ordC=='P'){
                char ordStr = ord.charAt(2);
                leftSt.push(ordStr);
            }
        }// 반복문 끝

        // 왼쪽 스택의 값들을 오른쪽 스택에 다 쌓은 후 다시 하나씩 빼서 출력
        while(!leftSt.empty()) {
            rightSt.push(leftSt.pop());
        }
        while(!rightSt.empty()) {
            bw.write(rightSt.pop());
        }
        bw.flush();
        bw.close();
    }
}