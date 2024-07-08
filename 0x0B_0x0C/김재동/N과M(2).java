package test11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ox11_Q4_2 {
  static StringBuilder sb;
  static int n,m;
  static int cnt;
  static boolean [] issued ; // 해당 공간에 값 있는지 여부 체크
  static int [ ] put; // 수열

  // 백준 15650 S3 ( N과 M(2) )
  public static void main(String args []) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    // 둘다 편의상 1부터 진행하므로, 공간 n+1
    issued = new boolean[n+1];
    put = new int[m+1];
    br.close();

    checkN(0,1);
    System.out.println(sb.toString());
  }

  public static void checkN(int cur, int start) {
    // 현재 값(cur)과 원하는 개수(m)가 같으면 출력
    if (cur == m) {
      for (int i = 0; i < m; i++) {
        sb.append(put[i] + " ");
      }
      sb.append("\n");
      return;
    } // if fin

    // i가 start부터 시작하므로, 이후에 추가될 값은 오름차순임.
    for (int i = start; i <= n; i++) {
      if (!issued[i]) {
        put[cur] = i;
        issued[i] = true;
        // 재귀해서 체크
        checkN(cur + 1, i+1);
        // 초기화
        issued[i] = false;
      }// if fin
    } // for fin
  }// checkN fin

}
