import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for(int i=0; i<testcase; i++){
            Deque<Character> stack = new ArrayDeque<>();
            boolean isError = false;

            String sentence = br.readLine();
            for(char ch : sentence.toCharArray()){
                if(ch=='(')
                    stack.push(ch);
                else if(!stack.isEmpty()&&ch==')'&&stack.peek()=='(')
                    stack.pop();
                else
                    isError=true;
            }

            if(!stack.isEmpty()) isError = true;

            System.out.println(isError?"NO":"YES");
        }

        br.close();
    }
}
