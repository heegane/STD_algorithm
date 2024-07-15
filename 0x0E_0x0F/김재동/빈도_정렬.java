package test12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Ox12_Q4_2 {
  // 백준 2910 S3 빈도 정렬
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // n , c 세팅
    StringTokenizer st= new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    long c = Long.parseLong(st.nextToken());

    // n개의 개수 세팅
    Map <String,Integer>cArrMap = new LinkedHashMap<>();
    st = new StringTokenizer(br.readLine());

    // 입력받은 문자 별 중복 개수 체크
    for(int i = 0; i<n; i++) {
      String temp = st.nextToken();
      cArrMap.put(temp, cArrMap.getOrDefault(temp, 0)+1);
    }
    List<String> keySet = new ArrayList<>(cArrMap.keySet());
    // Value 값으로 내림차순 정렬
    // 위 comparator 람다 표현식으로
    keySet.sort((o1, o2) -> {
      int precompare = cArrMap.get(o2).compareTo(cArrMap.get(o1));
      // 만약 value 차이가 같다면, 입력 순서 유지
      if(precompare == 0) {
        return 0; // LinkedHashmap 특성, 입력 순서대로 key 유지
      }
      return precompare;
    }); // sort fin

    // sb에 hashmap 값들 추가
    for(String key : keySet) {
      int value = cArrMap.get(key);
      for(int i = 0; i<value; i++) {
        sb.append(key + " ");
      }
    }// for fin

    System.out.println(sb.toString().trim());
  }
}

