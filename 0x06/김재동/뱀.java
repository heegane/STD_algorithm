package test06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class OxO6_Q4 {
    /*
    dx : 방향에 따른 x좌표
    dy : 방향에 따른 y좌표
    */
    private static int[] dx = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
    private static int[] dy = { 0, 1, 0, -1 }; // 상, 우, 하, 좌
    // 백준 13300 G4
    public static void main(String[] args) throws IOException {
		/*
		n*n 보드위, 뱀이 보드위 지나가는데 벽 or 자기 자신과 부딫히면 게임 종료 게임이 끝나는 시간 구하기 2<=n<=100,
		0<=k<=100, 1<=l<=100, 1<=x<=10000 벽 = 0,  보드판 1, 사과위치 2, 뱀 = 3 으로 지정하고 이동하면서 값 체크
		*/
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		/*
		변수 소개
		n : 보드 크기
		board : 보드 판
		*/
        // 변수 선언
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 2][n + 2];
        // 보드판 생성 n*n의 최대가 10000이므로, 그냥 이중 반복문 진행
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = 1;
            }
        }
        // k : 사과
        // 사과 받기 + 보드 판에 사과 위치 지정
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            board[temp1][temp2] = 2;
        }
		/*
		l : 방향 변환 횟수
		direction : 반복횟수, 방향 저장, hashmap
		 */
        // 방향 변경 수 받기
        int l = Integer.parseInt(br.readLine());
        Map<Integer, String> direction = new HashMap<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            String temp2 = st.nextToken();
            direction.put(temp1, temp2);
        }
		/*
		dindex : 좌표 인덱스
		time : 시간
		 */
        int dindex = 1; // 초기 방향은 오른쪽
        int time = 0;
		/*
		뱀 좌표 deque선언, 입출력 잦으므로 LinkedList로 구현
		1,1 처음 좌표 지정
		*/
        Deque<Location> snake = new LinkedList<>();
        snake.add(new Location(1, 1));
        board[1][1] = 3;
		/*
		snake : 뱀 좌표 저장, 출력 deque
		head : 뱀 머리 좌표
		tail : 뱀 꼬리 좌표
		*/
        while (true) {
            time++;
            Location head = snake.peekFirst();
            int tempx = head.x + dx[dindex];
            int tempy = head.y + dy[dindex];
            // 이동한 곳이 0이거나, 뱀인 경우
            if (tempx <= 0 || tempy <= 0 || tempx > n || tempy > n || board[tempx][tempy] == 3) {
                break;
            }
            // 이동한 곳이 사과가 아닌 경우, 꼬리 제거
            if (board[tempx][tempy] != 2) {
                Location tail = snake.pollLast();
                board[tail.x][tail.y] = 1;
            }
            // 보드판과 deque에 뱀 머리 좌표 저장
            board[tempx][tempy] = 3;
            snake.addFirst(new Location(tempx, tempy));

            // 방향 체크
            if (direction.containsKey(time)) {
                // D인 경우
                if (direction.get(time).equals("D")) {
                    dindex = (dindex + 1) % 4;
                }
                // L인 경우
                else {
                    dindex = (dindex + 3) % 4;
                }
            }
        }

        System.out.println(time);
    }
    // 현재 x,y 좌표 this로 호출하기 위해 class 생성
    private static class Location {
        int x, y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}