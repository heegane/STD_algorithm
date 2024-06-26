import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int result = 0;
        int lineCount = 0;

        char prevCh = 's';
        for(char currCh : str.toCharArray()){
            if(currCh =='('){
                lineCount++;
            }
            else if(currCh ==')'&&prevCh=='('){
                lineCount--;
                result+=lineCount;
            }
            else{
                result++;
                lineCount--;
            }

            prevCh = currCh;
        }

        System.out.println(result);

        br.close();
    }
}
