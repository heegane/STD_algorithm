import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        int resultCount = 0;

        for(int i=0; i<testcase; i++){
            Deque<Character> stack = new ArrayDeque<>();

            String sentence = br.readLine();
            for(char ch : sentence.toCharArray()){
                if(!stack.isEmpty()&&ch== stack.peek())
                    stack.pop();
                else
                    stack.push(ch);
            }

            if(stack.isEmpty())
                resultCount++;
        }

        System.out.println(resultCount);

        br.close();
    }
}
