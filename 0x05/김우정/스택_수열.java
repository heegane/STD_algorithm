import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] goal = new int[n];
        for(int i=0;i<n;i++){
            goal[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> upperStack = new Stack<>();
        Stack<Integer> lowerStack = new Stack<>();

        for(int i=n; i>=1; i--)
        {
            upperStack.push(i);
        }
        int i=0;

        while(!upperStack.empty() || !lowerStack.empty()) {
            if (!upperStack.empty() && goal[i] >= upperStack.peek()) {
                lowerStack.push(upperStack.pop());
                sb.append("+\n");
                continue;
            }

            if(!lowerStack.empty() && goal[i]==lowerStack.peek())
            {
                lowerStack.pop();
                sb.append("-\n");
                i++;
            }
            else
            {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
