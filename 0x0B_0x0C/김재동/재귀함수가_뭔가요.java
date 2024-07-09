package test11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ox11_Q2_1 {
  static StringBuilder sb;
  static int count = 0;
  static String space = "";
  // 백준 17478 S5 재귀함수가_뭔가요?
  public static void main(String [] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    br.close();
    sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
    // 증가하는 부분 재귀함수 실행
    returnPlus(n);

    // 중간 멘트 두 개 추가
    String sentence5 = '"' + "재귀함수가 뭔가요?" + '"' + "\n";
    String sentence6 = '"' +"재귀함수는 자기 자신을 호출하는 함수라네"+ '"' + "\n";
    sb.append(space + sentence5);
    sb.append(space + sentence6);

    String sentence7 = "라고 답변하였지.\n";
    for(int i =n; i>-1; i--) {
      sb.append(space + sentence7);

      // 출력할 때마다 언더바('_') 4개씩 줄어들게끔
      if(space.length()>3) {
        space = space.substring(0, space.length()-4);
      }
    }

    System.out.println(sb);

  }
  public static void returnPlus(int n) {
    while(true) {
      if(count==n) {
        break;
      }
      // 증가하는 문장
      String sentence1 = '"' + "재귀함수가 뭔가요?" + '"' + "\n";
      String sentence2 = '"' +"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
      String sentence3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
      String sentence4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어." + '"' + "\n";

      sb.append(space + sentence1);
      sb.append(space + sentence2);
      sb.append(space + sentence3);
      sb.append(space + sentence4);

      // 언더바 4개
      space += "____";
      count++;
      returnPlus(n);
    } // while fin
  }
}
