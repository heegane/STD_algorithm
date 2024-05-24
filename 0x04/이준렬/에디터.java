import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class arrTest {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder initStr = new StringBuilder(br.readLine());
    int m = Integer.parseInt(br.readLine()); // 입력할 정수의 개수
    String[] cmdList = new String[m];

    for (int i = 0; i < m; i++) {
      cmdList[i] = br.readLine();
    }
    br.close();

    int cursor = initStr.length();

    for (String command : cmdList) {
      char cmd = command.charAt(0);
      switch (cmd) {
        case 'L':
          if (cursor > 0) {
            cursor--;
          }
          break;
        case 'D':
          if (cursor < initStr.length()) {
            cursor++;
          }
          break;
        case 'B':
          if (cursor > 0) {
            initStr.deleteCharAt(cursor - 1);
            cursor--;
          }
          break;
        case 'P':
          char argument = command.charAt(2); // P 명령어 뒤에 오는 첫 번째 문자
          initStr.insert(cursor, argument);
          cursor++;
          break;
      }
    }

    // Output
    System.out.println(initStr.toString());
  }
}