package test08;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class OxO8_Q5_2 {

    // 백준 2504 G5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char [] lineC = line.toCharArray();
        int result = Bracket.BracketSum(lineC);

        System.out.println(result);


    }
}


class Bracket{
    public static int BracketSum(char [] lineC) {
        // lineDeq : (,[인경우  lineDeq에 저장
        // result : 합계
        // value : result에 합하기 전 임시의 계산 값들
        Deque<Character> lineDeq = new ArrayDeque<Character>();
        int result = 0;
        int value = 1;

        for(int i = 0; i<lineC.length; i++) {
            switch(lineC[i]) {
                case '(':
                    lineDeq.add(lineC[i]);
                    value *=2;
                    break;
                case '[':
                    lineDeq.add(lineC[i]);
                    value *=3;
                    break;
                case ')':
                    // deque가 비어있거나, 바로 앞 값이 (가 아닌 경우 -> 오류 발생
                    if(lineDeq.isEmpty() || lineDeq.peekLast() != '(') {
                        lineDeq.add(lineC[i]); // 오류 방지용
                        result = 0;
                        break;
                    }
                    // 바로 앞 값이 (인 경우, 현재까지의 value 최종 값에 저장
                    if(lineC[i-1]=='(') {result += value;}
                    // 바로 앞 값이 '('가 아닌 경우 이미 안의 값은 계산하였으므로 별다른 추가 없이 덱에서 제거
                    lineDeq.pollLast();
                    value /=2;                     // 2로 나누기
                    break;
                case ']':
                    // deque가 비어있거나, 바로 앞 값이 [가 아닌 경우 -> 오류 발생
                    if(lineDeq.isEmpty() || lineDeq.peekLast() != '[') {
                        lineDeq.add(lineC[i]); // 오류 방지용
                        result = 0;
                        break;
                    }
                    // 바로 앞 값이 [인 경우, 현재까지의 value 최종 값에 저장
                    if(lineC[i-1]=='[') {result += value;}
                    // 바로 앞 값이 '['가 아닌 경우 이미 안의 값은 계산하였으므로 별다른 추가 없이 덱에서 제거
                    lineDeq.pollLast();
                    value /=3;                    // 3로 나누기
                    break;
            }//switch fin
        }// for fin
        if(!lineDeq.isEmpty()) {result = 0;}

        return result;
    }

}
