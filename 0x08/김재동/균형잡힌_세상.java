package test08;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class OxO8_Q1_2 {

    // 백준 4949 S3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            // "." 만 입력 받은 경우
            if(line.equals(".")) {
                break;
            }
            // 검색하는 구문

            char [] chArr =  line.toCharArray();
            String check = CheckLine.checkChar(chArr);
            sb.append(check + "\n");
        }
        System.out.println(sb.toString().trim());
    }
}
class CheckLine{
    public static String checkChar(char[] chArr) {
        Stack<Character> charStack = new Stack<Character>();
        String checkYN = "";
        // 값 하나씩 읽음
        for(char c : chArr) {
            // 받은 값이 '('나 '['인 경우
            if(c=='('||c=='[') {charStack.push(c);}
            // 받은 값이 ')'나 ']'인 경우
            else if(c==')'||c==']') {
                // 스택이 안비어있음 => 기존에 '('나 '['가 추가된 경우
                if(!charStack.isEmpty()) {
                    switch(c) {
                        case ')':
                            // 꼭대기가 '('인경우 - 한 쌍 완성
                            if(charStack.peek() =='(') {charStack.pop();}
                            // 꼭대기가 '['인경우 - 오류 발생
                            else if(charStack.peek() =='[') {checkYN = "no";break;}
                            // ')', ']'인 경우 일단 저장
                            else{charStack.push(c);}
                            break;
                        case ']':
                            // 꼭대기가 '['인경우 - 한 쌍 완성
                            if(charStack.peek() =='[') {charStack.pop();}
                            // 꼭대기가 '('인경우 - 오류 발생
                            else if(charStack.peek() =='(') {checkYN = "no";break;}
                            // ')', ']'인 경우 일단 저장
                            else{charStack.push(c);}
                            break;
                    }
                }
                // 스택이 비어있음 => 기존에 (나 [가 추가되지 않음 -> 무조건 false
                else {
                    checkYN = "no";
                    break;
                }
            }
            // .인경우 문장 종료
            else if (c=='.') {
                break;
            }
        }
        // 스택 비어있고. check여부에 별다른 문제 없음
        if(charStack.isEmpty()&&checkYN==""){checkYN = "yes";}
        // 스택에 값이 있거나, check여부가 no인 경우
        else{checkYN ="no";}

        return checkYN;
    }

}