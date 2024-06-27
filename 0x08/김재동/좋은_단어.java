package test08;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class OxO8_Q2_1 {

    // 백준 3986 S4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 올바른 단어 개수
        int correct = 0;

        for (int i = 0; i < n; i++) {
            boolean confirm = false;
            String word = br.readLine();
            char [] wordC = word.toCharArray();
            switch(word.length()%2) {
                case 0:
                    confirm = checkC.checkChar(wordC); break;
                case 1: // 만약 입력받은 단어의 길이가 홀수 -> 무조건 불가능
                    continue;
            }
            // 해당 단어가 좋은 단어면 1 증가
            if(confirm == true) {correct++;}
        } // for fin
        System.out.println(correct);
        br.close();
    }
}

class checkC {
    public static boolean checkChar(char[] wordc) {
        boolean check = true;
        Deque<Character> deq = new ArrayDeque<Character>();
        for(int i = 0; i<wordc.length; i++) {
            char temp = wordc[i];
            // deq가 비어있지 않은 경우
            if(!deq.isEmpty()) {
                // 입력 받은 값과 deq의 꼭대기가 같은 경우, 기존 꼭대기 삭제 아니면 그냥 입력 받은 값 추가
                if(deq.peekLast().equals(temp)) { deq.pollLast();}
                else {deq.add(temp);}
            }
            else {deq.add(temp);}
        }// for fin
        // deq가 비어있지 않으면 쌍 완성x 의미 -> false
        if(!deq.isEmpty()) {check = false;}
        return check;
    }


}
