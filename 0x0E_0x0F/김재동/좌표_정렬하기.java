package test12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ox12_Q1_1 {
  // 백준 11650 S5 좌표 정렬하기
  public static void main(String [] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    // 우선순위 큐 선언
    PriorityQueue<Dot> dotPrQ= new PriorityQueue<>(1, new dotComparator());
    for(int i = 0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      int dot1 = Integer.parseInt(st.nextToken());
      int dot2 = Integer.parseInt(st.nextToken());
      dotPrQ.offer(new Dot(dot1,dot2));
    }
    br.close();

    while(!dotPrQ.isEmpty()) {
      Dot d = dotPrQ.poll();
      sb.append(d.dot1).append(" ").append(d.dot2).append("\n");
    }
    System.out.println(sb.toString());

  }

}

class Dot{
  int dot1;
  int dot2;
  public Dot(int dot1, int dot2) {
    this.dot1 = dot1;
    this.dot2 = dot2;
  }
}

//클래스 객체의 우선순위를 위한 클래스
class dotComparator implements Comparator<Dot>{
  @Override
  public int compare(Dot d1, Dot d2) {
    if(d1.dot1 == d2.dot1) {
      return d1.dot2 - d2.dot2;
    }else {
      return d1.dot1 - d2.dot1;
    }
  }
}

