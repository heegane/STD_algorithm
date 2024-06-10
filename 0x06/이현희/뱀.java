import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int time = 0;

        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            graph[x - 1][y - 1] = 1; // 사과 위치
        }

        int l = Integer.parseInt(br.readLine());
        // nextMoveTime, nextDirection
        Queue<Map.Entry<Integer, Character>> commands = new LinkedList<>();
        // 명령어 입력 받기
        for (int i = 0; i < l; i++) {
            String[] input = br.readLine().split(" ");
            commands.add(new AbstractMap.SimpleEntry<>(Integer.parseInt(input[0]), input[1].charAt(0)));
        }

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});

        // 오른쪽, 아래, 왼쪽, 위
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int index = 0;

        // 명령어를 수행하는 부분
        Map.Entry<Integer, Character> nextCommand = commands.poll();
        int nextMoveTime = nextCommand.getKey();
        char nextDirection = nextCommand.getValue();

        while (true) {
            time++;

            int[] head = snake.peekLast();
            int nx = head[0] + dx[index];
            int ny = head[1] + dy[index];

            // 벽에 부딪히는 경우 처리
            if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
                break;
            }

            // 자신의 몸에 부딪히는 경우 처리
            boolean isBlocked = false;
            for (int[] part : snake) {
                if (part[0] == nx && part[1] == ny) {
                    isBlocked = true;
                    break;
                }
            }
            if (isBlocked) {
                break;
            }

            // 사과 있는지 체크
            if (graph[nx][ny] == 1) { // 뱀 길이 확장
                graph[nx][ny] = 0; // 사과 제거
            } else {
                snake.pollFirst(); // 뱀 길이 유지
            }

            snake.addLast(new int[]{nx, ny});

            // 명령어 수행 시간에 도달했을 때 방향 전환
            if (time == nextMoveTime) {
                if (nextDirection == 'L') {
                    index = (index + 3) % 4;  // 왼쪽으로 90도 회전 (반시계 방향)
                } else {
                    index = (index + 1) % 4;  // 오른쪽으로 90도 회전 (시계 방향)
                }

                if (!commands.isEmpty()) {
                    nextCommand = commands.poll();
                    nextMoveTime = nextCommand.getKey();
                    nextDirection = nextCommand.getValue();
                }
            }
        }

        bw.write(String.valueOf(time));
        br.close();
        bw.close();
    }
}
