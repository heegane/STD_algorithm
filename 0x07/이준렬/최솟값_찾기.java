//최솟값 찾기 11003

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // input
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int L = Integer.parseInt(input[1]);

    String[] inputA = br.readLine().split(" ");
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(inputA[i]);
    }
    // 덱 초기화
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      if (!deque.isEmpty() && deque.peekFirst() < i - L + 1) {
        deque.removeFirst();
      }
      while (!deque.isEmpty() && A[deque.peekLast()] > A[i]) {
        deque.removeLast();
      }
      deque.addLast(i);
      sb.append(A[deque.peekFirst()]).append(" ");


//      System.out.print("Deque 상태 (index): ");
//      for (int idx : deque) {
//        System.out.print(idx + " ");
//      }
//      System.out.println();
    }
    System.out.println(sb.toString());
    br.close();
  }
}