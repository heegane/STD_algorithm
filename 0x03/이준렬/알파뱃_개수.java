// 알파뱃 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str = br.readLine();
    br.close();

    // 계수 행렬로 초기화
    int[] countArr = new int[26];
    //  stream 사용.
    str.chars()
        .forEach(c -> countArr[Character.valueOf((char) c) - 97]++);

    // Output
    for (int s : countArr) {
      sb.append(s);
      sb.append(" ");
    }

    System.out.println(sb.toString());
  }
}