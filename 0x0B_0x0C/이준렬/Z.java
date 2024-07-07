// Z 1074

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    System.out.println(recursion(input[0], input[1], input[2]));
  }

  private static int recursion(int n, int row, int col) {
    // 기본 사례
    if (n == 0) {
      return 0;
    }

    int half = (int) Math.pow(2, n - 1);

    // 0사분면
    if (row < half && col < half) {
      //System.out.println("0사분면");
      return recursion(n - 1, row, col);
    }
    // 1사분면
    else if (row < half && col >= half) {
      //System.out.println("1사분면");
      return half * half + recursion(n - 1, row, col - half);
    }
    // 2사분면
    else if (row >= half && col < half) {
      //System.out.println("2사분면");
      return 2 * half * half + recursion(n - 1, row - half, col);
    }
    // 3사분면
    else {
      //System.out.println("3사분면");
      return 3 * half * half + recursion(n - 1, row - half, col - half);
    }
  }
}
