package week6;
//AC
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N;i++){
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String str = br.readLine();
            String[] strArray = str.substring(1,str.length()-1).split(",");
            for(int j =0 ; j<n; j++){
                deque.addLast(Integer.parseInt(strArray[j]));
            }
            int currentDirection = 1;
            boolean condition = true; //컨디션을 통해 for문 탈출
            for(int j = 0; j<command.length(); j++){
                if(!condition){
                     break;
                }
                switch (command.charAt(j)){
                    case 'R':
                        currentDirection *=-1;
                        break;
                    case 'D':
                        if(deque.isEmpty()){
                            System.out.println("error");
                            condition =false;
                            break;
                        }
                        if(currentDirection==1){
                            deque.removeFirst();
                        }else{
                            deque.removeLast();
                        }
                        break;
                }
            }
            if(!condition){
                continue; //error 일시 for문 빠져나옴
            }
            StringBuilder sb = new StringBuilder();
            while(!deque.isEmpty()){
                if(currentDirection==1){
                    sb.append(deque.pollFirst());
                }
                else{
                    sb.append(deque.pollLast());
                }
                if(!deque.isEmpty()) sb.append(',');
            }
            System.out.println("["+sb+"]");
        }
        br.close();
    }
}
