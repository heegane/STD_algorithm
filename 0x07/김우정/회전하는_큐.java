import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=1; i<=n; i++){
            deque.addLast(i);
        }

        int count = 0;


        StringTokenizer commandToken = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int value = Integer.parseInt(commandToken.nextToken());

            int tempCount = 0;
            while(deque.getFirst()!=value){
                deque.addLast(deque.pollFirst());
                tempCount++;
            }

            if(tempCount>deque.size()/2){
                tempCount = deque.size()-tempCount;
            }

            count = count+tempCount;

            deque.pollFirst();
        }

        bw.write(Integer.toString(count));

        br.close();
        bw.close();
    }
}