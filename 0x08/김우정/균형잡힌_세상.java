import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while(!str.equals(".")){
            Deque<Character> brackets = new ArrayDeque<>();
            boolean isError=false;

            for(char ch : str.toCharArray()){
                if(ch=='('||ch=='['){
                    brackets.push(ch);
                }
                else if(ch==')'||ch==']'){
                    if (brackets.isEmpty() || (ch == ')' && brackets.peek() != '(') || (ch == ']' && brackets.peek() != '[')) {
                        isError = true;
                        break;
                    }
                    brackets.pop();
                }
            }

            if(!brackets.isEmpty())
                isError=true;

            System.out.println(isError?"no":"yes");

            str = br.readLine();
        }

        br.close();
    }
}
