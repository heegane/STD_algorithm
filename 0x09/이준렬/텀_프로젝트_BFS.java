// 텀프로젝트 9466 BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int n;
  static boolean[] vis;
  static int[] students;
  static int inssaStudent;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    for (int t = 0; t < tc; t++) {
      n = Integer.parseInt(br.readLine());
      String[] inputLine = br.readLine().split(" ");
      vis = new boolean[n + 1];
      students = new int[n + 1]; // 0은 아무것도 아니다잉
      inssaStudent = 0;

      // node 초기화
      for (int j = 1; j <= n; j++) {
        students[j] = Integer.parseInt(inputLine[j - 1]); // 1-> 3 2 -> 1 3-> 3...
        vis[j] = false;
      }

      for (int i = 1; i <= n; i++) {
        if (vis[i] == false) {
          BFS(i);
        }
      }

      System.out.println(n - inssaStudent);

    }
    br.close();
  }

  private static void BFS(int index) {
    Queue<Integer> que = new LinkedList<>();
    vis[index] = true; //  //1. 우선 BFS 알고리즘이 시작되면 첫 노드에 해당하는 곳에 방문했다는 표시를 남기고 해당 노드를 큐에 넣는다.
    que.offer(index); // 시작점인 index 삽입

    while (!que.isEmpty()) {//2. 큐가 빌때까지 원소를 꺼내고 해당 좌표의 다음값을(?) 확인하면서 3번 실행
      int cur = que.poll(); // 큐에서 현재값 추출
      int next = students[cur]; // 다음 값 방문
      if (vis[next]
          == false) { //3. 해당 칸을 이전에 방문했다면 아무것도 하지 않고 처음으로 방문했다면 방문했다는 표시를 남기고 해당 칸을 큐에 삽입. + loop가 완성됐다면(index == next
        vis[next] = true;
        que.offer(next);
      }
      if (index == next) {
        inssaStudent++;
        break;
      }
    }

  }


}
