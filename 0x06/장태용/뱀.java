package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class boj3190 {
    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) throws IOException {
        // 뱀의 방향을 나타내는 방향 배열
        String[] direction = {"right", "down", "left", "up"};
        int answer =0;
        int currentDir = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Pair> snakeSet = new HashSet<>(); // 뱀 몸을 구성한 좌표 집합
        HashSet<Pair> appleSet = new HashSet<>(); // 사과의 위치 좌표 집합
        Queue<Pair> snakeQueue = new LinkedList<>();
        snakeQueue.add(new Pair(0,0));
        int currentX = 0;
        int currentY = 0;
        int appleN = Integer.parseInt(br.readLine());
        for (int i = 0; i < appleN; i++) {
            String[] line = br.readLine().split(" ");
            appleSet.add(new Pair(Integer.parseInt(line[0])-1, Integer.parseInt(line[1])-1));
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i <= L; i++) {
            String[] line;
            int time = 0;
            boolean last = true;
            String nextDirection = "initial";
            if (i!=L){
                line = br.readLine().split(" ");
                time = Integer.parseInt(line[0]);
                 nextDirection= line[1];
                 last = false;
            }

            while (answer < time || last) {
                answer++;
                switch(direction[currentDir]){
                    case "right":
                        currentX++;
                        break;
                    case "down":
                        currentY++;
                        break;
                    case "left":
                        currentX--;
                        break;
                    case "up":
                        currentY--;
                        break;
                }
                if (currentX < 0 || currentY < 0 || currentX >= N || currentY >= N){
                    System.out.println(answer);
                    return;
                }
                if (snakeSet.contains(new Pair(currentX, currentY))) {
                    System.out.println(answer);
                    return;
                }
                if (appleSet.contains(new Pair(currentX, currentY))) {
                    appleSet.remove(new Pair(currentX, currentY));
                    snakeSet.add(new Pair(currentX, currentY));
                    snakeQueue.add(new Pair(currentX, currentY));
                }else{
                    Pair temp = snakeQueue.poll();
                    snakeSet.remove(temp);
                    snakeSet.add(new Pair(currentX, currentY));
                    snakeQueue.add(new Pair(currentX, currentY));
                }
            }
            if (nextDirection.equals("D")) {
                currentDir = (currentDir + 1) % 4;
            } else {
                currentDir = (currentDir + 3) % 4;
            }
        }
    }
}
