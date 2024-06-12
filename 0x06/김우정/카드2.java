import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> cards = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            cards.add(i);
        }

        while(cards.size()>1)
        {
            cards.poll();
            cards.add(cards.poll());
        }

        bw.write(Integer.toString(cards.poll()));

        bw.close();
        br.close();
    }
}
