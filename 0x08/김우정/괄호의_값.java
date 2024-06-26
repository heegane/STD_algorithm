import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int result = 0;
        int combo = 1;
        char prevCh = 's';

        Deque<Character> stack = new ArrayDeque<>();
        boolean isError = false;

        for(char currCh : str.toCharArray()){
            switch (currCh){
                case '(' :
                    combo*=2;
                    stack.push(currCh);
                    break;
                case '[' :
                    combo*=3;
                    stack.push(currCh);
                    break;
                case ')':
                    if(stack.isEmpty()||stack.peek()!='('){
                        isError = true;
                        break;
                    }

                    stack.pop();
                    if(prevCh=='('){
                        result+=combo;
                    }
                    combo/=2;

                    break;
                case ']':
                    if(stack.isEmpty()||stack.peek()!='['){
                        isError = true;
                        break;
                    }

                    stack.pop();
                    if(prevCh=='['){
                        result+=combo;
                    }
                    combo/=3;

                    break;
            }

            prevCh = currCh;
            if(isError==true) break;
        }

        if(!stack.isEmpty())
            isError = true;

        System.out.println(isError? 0 : result);

        br.close();
    }
}
