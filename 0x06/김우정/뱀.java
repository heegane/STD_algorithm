import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class GameObject{
    public int x=0;
    public int y=0;

    public GameObject(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int boardSize = Integer.parseInt(br.readLine());
        int[][] game = new int[boardSize][boardSize];

        int appleSize = Integer.parseInt(br.readLine());
        for(int i=0; i<appleSize; i++){
            String input = br.readLine();
            String[] tmp = input.split(" ");
            int x = Integer.parseInt(tmp[0])-1;
            int y = Integer.parseInt(tmp[1])-1;
            game[x][y]=2;
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> directionChanges = new HashMap<>();
        for(int i=0; i<L; i++){
            String input = br.readLine();
            String[] tmp = input.split(" ");
            int X = Integer.parseInt(tmp[0]);
            char C = tmp[1].charAt(0);
            directionChanges.put(X,C);
        }

        Queue<GameObject> snake = new ArrayDeque<>();
        GameObject head = new GameObject(0,0);
        snake.add(head);
        game[0][0]=1;

        int[] dx = { 0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int direction = 0;

        int time = 0;

        while(true){
            time++;

            int newX = head.x + dx[direction];
            int newY = head.y + dy[direction];

            if(newX < 0 || newY <0 || newX>=boardSize|| newY>=boardSize||game[newX][newY]==1)
            {
                break;
            }

            if(game[newX][newY]==2)
            {
                head = new GameObject(newX, newY);
                snake.add(head);
                game[newX][newY]=1;
            }
            else
            {
                head = new GameObject(newX, newY);
                snake.add(head);
                game[newX][newY]=1;
                GameObject tail = snake.poll();
                game[tail.x][tail.y]=0;
            }

            if(directionChanges.containsKey(time)){
                char turn = directionChanges.get(time);
                if(turn =='L'){
                    direction = (direction + 3)%4;
                }
                else if(turn =='D')
                {
                    direction = (direction +1)%4;
                }
            }
        }

        bw.write(Integer.toString(time));
        bw.close();
        br.close();
    }
}
