package test08;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class OxO8_Q4 {

    // 백준 10799 S2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        char [] lineC = line.toCharArray(); // 받은 문자열 배열화
        int cnt = carcBracket.carcBracket(lineC);
        System.out.println(cnt);
        br.close();
    }
}
class carcBracket{
    public static int carcBracket(char [] lineC) {
        int cnt = 0;
        // line의 모든 값 저장할 deq
        Deque<Character> totalDeq = new  ArrayDeque<Character>();
        // 왼쪽 괄호의 인덱스를 담는 deq
        Deque<Integer> LeftBracket = new ArrayDeque<Integer>();
        for(int i = 0; i<lineC.length; i++) {
            char temp = lineC[i];
            // deq가 비어있지 않고, 입력 받은 값이 ")"인 경우
            if(!totalDeq.isEmpty()&&temp==')') {
                //기존 꼭대기가 '('면 삭제 아니면 그냥 입력 받은 값 추가
                switch(totalDeq.peekLast()) {
                    case '(':
                        // 레이저인 경우
                        if(LeftBracket.peekLast()== (i-1)) {
                            LeftBracket.pollLast();
                            totalDeq.pollLast();
                            cnt += totalDeq.size();
                        }else {
                            // 쇠막대인 경우, 전체에서 삭제 + 쇠막대 인덱스도 삭제 + 남은 쪼가리 +1
                            totalDeq.pollLast();
                            LeftBracket.pollLast();
                            cnt+=1;
                        }
                        break;
                    case ')':
                        totalDeq.add(temp); break;
                }
            }
            // deq이 비어있는 경우 or 입력받은 값이 '('인경우
            else {
                totalDeq.add(temp);
                LeftBracket.add(i);
            }
        }

        return cnt;
    }
}


