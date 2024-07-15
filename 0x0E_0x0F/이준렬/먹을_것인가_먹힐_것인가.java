
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
// 먹을것인가 먹힐것인가 7795
public class boj_7795 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int tc = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for (int i = 0; i < tc; i++) {
      st = new StringTokenizer(br.readLine());

      // a, b 초기화
      int lengthOfA = Integer.parseInt(st.nextToken());
      int lengthOfB = Integer.parseInt(st.nextToken());

      List<Integer> a = new ArrayList<>();
      List<Integer> b = new ArrayList<>();

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < lengthOfA; j++) {
        a.add(Integer.parseInt(st.nextToken()));
      }

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < lengthOfB; j++) {
        b.add(Integer.parseInt(st.nextToken()));
      }

      Collections.sort(a, Collections.reverseOrder());
      Collections.sort(b, Collections.reverseOrder());

      int result = 0;
      int bIndex = 0;

      for (int j = 0; j < lengthOfA; j++) {
        while (bIndex < lengthOfB && a.get(j) <= b.get(bIndex)) { // 만약 A의 요소가 B의 요소보다 크다면 bIndex를 증가
          bIndex++;
        }
        if (bIndex < lengthOfB) { // 작다면 bIndex가 가리키는 인덱스까지의 B 배열의 요소 개수를 result에 더함.
          result += (lengthOfB - bIndex);
        }
      }

      sb.append(result).append('\n');
    }

    System.out.println(sb.toString());
    br.close();
  }
}
