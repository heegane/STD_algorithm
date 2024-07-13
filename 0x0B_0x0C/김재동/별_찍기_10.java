package test11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ox11_Q5_1 {
  static int n;
  static char[][] board;

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    n = Integer.parseInt(br.readLine());
    br.close();
    // 보드판 세팅, 모든 공간을 공백으로 먼저 세팅
    board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = ' ';
      }
    }
    // 메서드 호출
    starFunc(0, 0, n);
    // 계산 된 보드판 출력세팅 , 행마다 "\n" 추가
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(board[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }

  public static void starFunc(int x, int y, int n) {
    if (n == 1) {
      board[x][y] = '*';
      return; // 재귀함수로 return
    }

    int newSize = n / 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
          continue; // 중앙은 비워둔다.
        }
        // 재귀함수 호출, 지금 검사한 메소드 x * 3, y *3 좌표
        starFunc(x + i * newSize, y + j * newSize, newSize);
      }
    }
  }
}
