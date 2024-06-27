package test08;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;


public class OxO8_Q3 {

    // 백준 9012 S4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i<n; i++) {
            boolean confirm = false;
            String line = br.readLine();
            char [] lineC = line.toCharArray();
            switch(line.length()%2) {
                case 0:
                    confirm = checkBracket.checkBracket(lineC); break;
                // 만약 입력받은 단어의 길이가 홀수 -> 무조건 불가능
                case 1: break;
            }
            // 해당 단어의 confirm 여부에 따른 temp 값 변경
            String temp = (confirm==true)? "YES\n":"NO\n";
            sb.append(temp);
        } // for fin
        bw.append(sb.toString().trim());
        br.close();
        bw.close();
    }
}

class checkBracket {
    public static boolean checkBracket(char[] lineC) {
        boolean check = true;
        Deque<Character> deq = new ArrayDeque<Character>();
        for(int i = 0; i<lineC.length; i++) {
            char temp = lineC[i];
            // deq가 비어있지 않고, 입력 받은 값이 ")"인 경우
            if(!deq.isEmpty()&&temp==')') {
                //기존 꼭대기가 '('면 삭제 아니면 그냥 입력 받은 값 추가
                switch(deq.peekLast()) {
                    case '(':
                        deq.pollLast(); break;
                    case ')':
                        deq.add(temp); break;
                }
            }
            // deq이 비어있는 경우 or 입력받은 값이 '('인경우
            else {deq.add(temp);}
        }
        // deq가 비어있지 않으면 false
        if(!deq.isEmpty()) {check = false;}
        return check;
    }
}
