// N과 M 15649

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15649 {

  static int n; // 1~n 까지의 자연수
  static int m; // 길이가 m 인 수열의 길이
  static int[] arr;
  static boolean[] isUsed;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    arr = new int[10];
    isUsed = new boolean[10];

    // input
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    recur(0);

    br.close();
  }

  public static void recur(int k) {
    // 만약 k == m 이면 여태까지 넣은 배열 요소 출력.
    if (k == m) {
      for (int i = 0; i < m; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
    // 배열에 들어갈 숫자가 1~n 까지니까 범위는 1 <= i <= n
    for (int i = 1; i <= n; i++) {
      if (!isUsed[i]) { // 만약 flag가 false면
        arr[k] = i; // arr 에 값 할당
        isUsed[i] = true; // true 로 바꿔주기
        recur(k + 1); // k에 1을 더한 후 재귀 호출
        isUsed[i] = false; // 조건에 맞는 수를 출력했다는 뜻이므로 해당 i는 false로 다시 바꿔줌.
      }
    }
  }
}
