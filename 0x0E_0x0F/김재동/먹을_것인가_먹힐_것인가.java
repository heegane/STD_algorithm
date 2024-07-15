package test12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ox12_Q5_3 {
  // 백준 7795 S3 먹을 것인가 먹힐 것인가
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());
    // 테스트 케이스 수 만큼 입력받음
    for(int i = 0 ; i<t; i++) {
      int cnt = 0;
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      // 데이터 배열에 저장
      int [] aArr = new int[n];
      int [] bArr = new int[m];


      st = new StringTokenizer(br.readLine());
      for(int j = 0; j<n; j++) {
        aArr[j] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j<m; j++) {
        bArr[j] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(bArr);
      // A가 B보다 큰 쌍의 개수 체크
      for(int j = 0; j<aArr.length; j++) {
        int temp = aArr[j];
        cnt += compareAB(temp,bArr);
      }
      sb.append(cnt).append("\n");
    }// for fin
    System.out.println(sb.toString().trim());
    br.close();
  }
  // 이진 탐색으로 값 비교
  public static int compareAB(int temp, int bArr[]) {
    int left = 0;
    int right = bArr.length;
    // 왼쪽이 오른쪽보다 큰경우 fin
    while(left<right) {
      int middle = (left+right)/2;
      // 현재 값이 중앙 값보다 큰 경우
      if(temp>bArr[middle]) {
        left = middle + 1;
      }
      // 현재 값이 중앙 값보다 작은 경우
      else {
        right = middle;
      }
    }
    return left;
  }
}
