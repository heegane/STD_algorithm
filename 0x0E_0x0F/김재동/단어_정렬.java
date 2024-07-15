package test12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Ox12_Q3_1 {
  // 백준 1181 S5 단어 정렬
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    String [] str = new String[n];
    Set<String> set = new HashSet<>(); // 중복 단어 제거용 Set
    PriorityQueue<word> prique = new PriorityQueue<>(1, new wordComparator());

    // 값 입력 부분
    for(int i = 0 ; i<n; i++) {
      String temp = br.readLine();
      // 값이 중복이 아니라서 정상적으로 들어가는 경우
      if(set.add(temp)) {
        prique.offer(new word(temp,temp.length()));
      }
    }// for fin
    br.close();

    // 출력 부분
    while(!prique.isEmpty()) {
      word w = prique.poll();
      sb.append(w.word).append("\n");
    }// while fin
    System.out.println(sb.toString().trim());

  }

}

class word{
  String word;
  int wordLen;

  word(String word, int wordLen){
    this.word = word;
    this.wordLen = wordLen;
  }
}

class wordComparator implements Comparator<word>{
  @Override
  public int compare(word w1, word w2) {
    // 길이가 같은 경우 -> 사전 순 정렬
    if (w1.wordLen == w2.wordLen) {
      return w1.word.compareTo(w2.word);
    }
    // 기존 -> 문자열 길이 정렬
    else {
      return w1.wordLen - w2.wordLen;
    }
  }
}
