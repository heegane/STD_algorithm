// 균형잡힌 세상 2504

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine().replace("()", "+2").replace("[]", "+3").replace("(", "+(").replace(")", ")*2").replace("[", "+(").replace("]", ")*3");
    System.out.println(input);
    if (!isBalanced(input)) {
      System.out.println(0); // 균형 잡힌 괄호가 아닌 경우 0 출력
    } else {
      System.out.println(evaluateExpression(convertToPostfix(input))); // 후위 표기법으로 변환 후 평가
    }
  }

  // 중위 표기법을 후위 표기법으로 변환하는 메서드
  private static String convertToPostfix(String infix) {
    StringBuilder postfix = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (char c : infix.toCharArray()) {
      if (Character.isDigit(c)) {
        postfix.append(c); // 숫자는 그대로 출력
      } else if (c == '(' || c == '[') {
        stack.push(c); // 여는 괄호는 스택에 push
      } else if (c == ')' || c == ']') {
        // 닫는 괄호를 만나면 스택에서 여는 괄호를 만날 때까지 pop하여 출력
        while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '[') {
          postfix.append(stack.pop());
        }
        stack.pop(); // 여는 괄호를 pop하여 버림
      } else { // 연산자인 경우
        // 스택의 top이 현재 연산자보다 우선순위가 높거나 같으면 pop하여 출력
        while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
          postfix.append(stack.pop());
        }
        stack.push(c); // 현재 연산자를 스택에 push
      }
    }

    // 스택에 남아 있는 연산자들을 모두 pop하여 출력
    while (!stack.isEmpty()) {
      postfix.append(stack.pop());
    }

    return postfix.toString();
  }

  // 후위 표기법을 평가하는 메서드
  private static int evaluateExpression(String postfix) {
    Stack<Integer> stack = new Stack<>();

    for (char c : postfix.toCharArray()) {
      if (Character.isDigit(c)) {
        stack.push(c - '0'); // 숫자는 스택에 push
      } else {
        // 연산자를 만나면 스택에서 피연산자를 pop하여 연산 후 결과를 스택에 push
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        int result = applyOperator(c, operand1, operand2);
        stack.push(result);
      }
    }

    // 최종 결과는 스택의 top에 남아 있는 값
    return stack.pop();
  }

  // 연산자의 우선순위를 반환하는 메서드
  private static int precedence(char operator) {
    switch (operator) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      default:
        return 0;
    }
  }

  // 연산자를 적용하는 메서드
  private static int applyOperator(char operator, int operand1, int operand2) {
    switch (operator) {
      case '+':
        return operand1 + operand2;
      case '-':
        return operand1 - operand2;
      case '*':
        return operand1 * operand2;
      case '/':
        return operand1 / operand2;
      default:
        return 0;
    }
  }

  // 괄호의 균형을 확인하는 메서드
  private static boolean isBalanced(String line) {
    Stack<Character> bracketStack = new Stack<>();
    for (char c : line.toCharArray()) {
      if (c == '(' || c == '[') {
        bracketStack.push(c);
      } else if (c == ')' || c == ']') {
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
