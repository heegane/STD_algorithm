// 두 수의 합 3273
// 시간 제한이 1초이고 배열의 개수가 1_000_000개 -> 시간복잡도가 O(NlogN) 보다 빨라야함.
// 이중 for문으로 모든 경우의 수를 따지면 O(N^2) 으로 통과 못함.
// 1. 자연수 x가 주어지면 a_i 를 빼서 a_j가 있는지 체크 -> HashSet 을 사용하면 시간복잡도가 O(1)
// 2. 투포인터 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // n
    //    number arr
    String[] strArr = br.readLine().split(" ");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(strArr[i]);
    }
    int x = Integer.parseInt(br.readLine()); // x
    br.close();

    // 투포인터 사용.
    Arrays.sort(arr); // 투포인터는 sorting 필수.
    int l = 0;
    int r = n - 1;
    int count = 0;
    while (l < r) {
      int sum = arr[l] + arr[r];
      if (sum == x) {
        count++;
        l++;
        r--;
      } else if (sum < x) {
        l++;
      } else {
        r--;
      }
    }

    // Output
    System.out.println(count);
  }
}