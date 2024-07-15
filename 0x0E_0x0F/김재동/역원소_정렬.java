package test12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Ox12_Q2_2 {
  static String [] strArr;
  // 백준 5648 S5 역원소 정렬
  public static void main(String [] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    // 첫 줄 먼저 체크
    strArr = br.readLine().split(" ");
    int n = Integer.parseInt(strArr[0]);

    PriorityQueue<Long> priQue = new PriorityQueue<Long>();
    int start ; // 반복문 시작할 인덱스 번호
    int linecnt = 0;
    while(priQue.size()<n) {
      // 첫 줄인 경우
      if(priQue.isEmpty()&& linecnt == 0) {
        start = 1;
      }
      // 값이 있다는 것은 무조건 첫 줄이 아니므로, 반복문 시작 인덱스 0으로 지정
      else {
        start = 0;
        strArr = br.readLine().split(" ");
      }
      for(int i = start; i<strArr.length; i++) {
        if(strArr[i].equals("")) {
          continue;
        }
        // 우선순위que에 reverse된 숫자 추가
        String temp = strArr[i];
        priQue.add(returnLong(temp));
      }// for fin
      linecnt++;
    } // while fin
    // priQue 안의 값들 sb에 추가
    while(!priQue.isEmpty()) {
      sb.append(priQue.poll()).append("\n");
    }
// 		이렇게 poll 안하고 그냥 추가할 때는 똑바로 정렬되지 않음
//		for (int i : priQue) {
//			sb.append(i).append("\n");
//		}
    br.close();
    System.out.println(sb.toString().trim());
  }
  // String으로 된 숫자인자 받아서, 역순으로 변경
  public static long returnLong(String strInt) {
    // string은 reverse()가 없기에, StringBuilder를 활용함
    StringBuilder tempSb = new StringBuilder();
    String reverseStr = tempSb.append(strInt).reverse().toString();
    long reverseInt = Long.parseLong(reverseStr);
    return reverseInt;
  }
}

