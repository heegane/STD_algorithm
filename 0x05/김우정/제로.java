import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> moneyList = new Stack<>();

        for(int i=0; i<n; i++)
        {
            int money = Integer.parseInt(br.readLine());

            if(money==0 && !moneyList.empty())
            {
                moneyList.pop();
                continue;
            }
            else
            {
                moneyList.push(money);
            }
        }

        int sum = 0;
        while(!moneyList.isEmpty())
        {
            sum += moneyList.pop();
        }

        bw.write(sum + "\n");

        br.close();
        bw.close();
    }
}
