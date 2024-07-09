package test11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ox11_Q3_1 {
  static int cnt = 0; // 경우의 수
  static int n;
  static boolean issued1 [] = new boolean [30]; // 세로 열 체크
  static boolean issued2 [] = new boolean [30]; // 오른쪽 위 대각선 체크
  static boolean issued3 [] = new boolean [30]; // 오른쪽 아래 대각선 체크
  // 백준 9663 G4 N-Queen
  public static void main(String args []) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    checkFunc(0);
    System.out.println(cnt);

  }

  public static void checkFunc(int cur) {
    // 체스 놓은 말 개수가 n이랑 같으면 return
    if (cur == n) {
      cnt++;
      return;
    }
    for (int i = 0; i < n; i++) {
      // Q가 있는 열, 오른쪽 대각선, 왼쪽 대각선에 값이 있는 경우 continue;
      if (issued1[i] || issued2[i + cur] || issued3[cur - i + n - 1]) {
        continue;
      }
      // 세 곳 값 세팅
      issued1[i] = true;
      issued2[i + cur] = true;
      issued3[cur - i + n - 1] = true;
      // 재귀
      checkFunc(cur + 1);
      // 다 놓아본 후 새로 복원
      issued1[i] = false;
      issued2[i + cur] = false;
      issued3[cur - i + n - 1] = false;
    } // for fin
  }// checkFunc fin
}
