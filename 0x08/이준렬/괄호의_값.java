// 균형잡힌 세상 2504

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine().trim();

    if (!isBalanced(input.toCharArray())) {
      System.out.println(0);
    } else {
      System.out.println(calculate(input));
    }
  }

  public static int calculate(String line) {
    String previous;
    do {
      previous = line;
      line = line.replace("()", "2 ")
          .replace("[]", "3 ")
          .replace("(2 ", "4 ")
          .replace("(3 ", "6 ")
          .replace("[2 ", "6 ")
          .replace("[3 ", "9 ");
    } while (!line.equals(previous));

    int result = 0;
    line = line.replaceAll("[()\\[\\]]", ""); // 괄호 제거

    String[] numbers = line.split("\\s+"); // 공백으로 분리
    for (String number : numbers) {
      if (!number.isEmpty()) {
        result += Integer.parseInt(number);
      }
    }
    return result;
  }

  private static boolean isBalanced(char[] line) {
    Stack<Character> bracketStack = new Stack<>();
    for (char c : line) {
      if (c == '[' || c == '(') {
        bracketStack.push(c);
      } else if (c == ']' || c == ')') {
        if (bracketStack.isEmpty()) {
          return false;
        }
        char openBracket = bracketStack.pop();
        if ((openBracket == '(' && c != ')') || (openBracket == '[' && c != ']')) {
          return false;
        }
      }
    }
    return bracketStack.isEmpty();
  }
}
