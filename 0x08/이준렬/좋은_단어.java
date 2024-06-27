// 좋은 단어 3986

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // input
    int tc = Integer.parseInt(br.readLine());
    int count = 0;

    for (int i = 0; i < tc; i++) {
      String word = br.readLine();
      if (checkGoodWords(word)) {
        count += 1;
      }
    }
    System.out.println(count);

    br.close();
  }

  private static Boolean checkGoodWords(String word) {
    Stack<Character> stack = new Stack<>();
    for (char c : word.toCharArray()) {
      if (!stack.isEmpty() && stack.peek() == c) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
