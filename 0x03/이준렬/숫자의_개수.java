// 숫자의_개수_3577
// 숫자 -> 문자 유형 캐스팅 유의할 것.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());// A
    N *= Integer.parseInt(br.readLine());   // B
    N *= Integer.parseInt(br.readLine());   // C
    br.close();

    // 숫자 -> 문자 배열.
    char[] str_N = String.valueOf(N).toCharArray();

    // 계수 행렬로 초기화
    int[] countArr = new int[10];
    for (char c : str_N) {
      // 문자 -> 숫자

      //  getNumericValue() 사용
      countArr[Character.getNumericValue(c)] += 1;

      //  ParseInt() 사용
      //countArr[Integer.parseInt(String.valueOf(c))] += 1;
    }

    // Output
    for (int i : countArr) {
      sb.append(i);
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }
}