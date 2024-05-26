import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    // 백준 5397 S2
    public static void main(String[] args) throws IOException {
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder ();

		/*
		 	변수 소개
		 	n : 명령어 개수
		 	str : 기본 문자열 받기
		 	leftSt : 커서 기준 왼쪽 문자값들 저장
		 	rightSt : 커서 기준 오른쪽 문자값들 저장
		 */

        // 변수 선언 및 값 받기
        int n = Integer.parseInt(br.readLine());
        Stack<Character> leftSt = new Stack<>();
        Stack<Character> rightSt = new Stack<>();

        for(int i =0; i<n; i++) {
            String str = br.readLine();
            // 단어별 반복문 시작
            for(int j = 0; j<str.length(); j++) {
                // 제어문 시작
                if(str.charAt(j)=='<') {
                    if(!leftSt.empty()) {
                        rightSt.push(leftSt.pop());
                    }
                }else if(str.charAt(j)=='>') {
                    if(!rightSt.empty()) {
                        leftSt.push(rightSt.pop());
                    }
                }else if(str.charAt(j)=='-') {
                    if(!leftSt.empty()) {
                        leftSt.pop();
                    }
                }else {
                    leftSt.push(str.charAt(j));
                }
                // 제어문 끝
            }// 단어별 반복문 끝
            // 왼쪽 스택의 값들을 오른쪽 스택에 다 쌓은 후 다시 하나씩 빼서 출력
            while(!leftSt.empty()) {
                rightSt.push(leftSt.pop());
            }
            while(!rightSt.empty()) {
                sb.append(rightSt.pop());
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}