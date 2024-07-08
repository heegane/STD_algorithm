package test11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ox11_Q1_1 {
  static int cnt = 0;
  // 백준 1074 S1 Z
  public static void main(String [] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // n : 2의 n제곱만큼 보트 판크기
    // r : r행 (가로)
    // c : c행 (세료)
    int n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    // 기본적 보드판 생성
    int boardLen = (int) Math.pow(2, n);
    returnFunc(r,c,boardLen);
    System.out.println(cnt);

  }


  public static void returnFunc(int r,int c, int boardLen) {


    // boardLen ==1 -> 재귀 종료
    if(boardLen ==1 ) {
      return;
    }

    int temp = boardLen/2;
    //해당 좌표가 왼쪽 위
    if(r<temp && c<temp) {
      returnFunc(r,c,temp);
    }

    // 해당 좌표가 오른쪽 위
    else if(r<temp && temp<=c) {
      cnt+= (int)Math.pow(temp,2);
      returnFunc(r,c-temp,temp);
    }

    // 해당 좌표가 왼쪽 아래
    else if(r>=temp && c < temp) {
      cnt += (int)Math.pow(temp,2) * 2 ;
      returnFunc(r-temp,c,temp);
    }

    // 해당 좌표가 오른쪽 아래
    else {
      cnt += (int)Math.pow(temp,2) * 3;
      returnFunc(r-temp,c-temp,temp);

    }
  }

}
