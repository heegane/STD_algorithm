package test07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class OxO7_Q3 {

    public static StringBuilder sb = new StringBuilder();
    // 백준 5430 G5
    public static void main(String[] args) throws IOException {
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); 	// t: 총 개수
        for(int i = 0; i<t; i++) {
            String funcR = br.readLine();	// fucR : 행동할 함수
            String [] funcRarr = funcR.split(""); // 함수 배열화
            int n = Integer.parseInt(br.readLine());// 배열에 들어 있는 수

            // 배열 체크
            String s = br.readLine();
            String subStr = s.substring(1,s.length()-1);
            String [] tempSarr = new String[subStr.length()];
            if(subStr.length()>0) {
                tempSarr = subStr.split(",");
            }

            // 받은 배열 deq에 저장
            Deque<Integer> deq = new ArrayDeque<Integer>();
            for(int j = 0; j<tempSarr.length; j++) {
                deq.add(Integer.parseInt(tempSarr[j]));
            }

            String direct = ""; 		// direct : 방향
            String temp = "";

            // 함수에 따른 결과 값 계산
            for(int j = 0; j<funcRarr.length; j++) {
                // 방향 체크, R인경우 reverse or "", ""는 정방향
                if(funcRarr[j].equals("R")) {
                    if(direct == "") {
                        direct  = "reverse";
                    }else {
                        direct = "";
                    }
                }else {
                    // deq가 비어있지 않은 경우
                    if(!deq.isEmpty()) {
                        if(direct=="") { // 정방향
                            deq.pollFirst();
                        }else {	// 역방향
                            deq.pollLast();
                        }
                    }else {// deq 비어있는 경우
                        temp = "error\n";
                        sb.append(temp);
                        break;
                    }
                }
            } // 받은 함수 반복문 fin
            if(temp != "error\n") { // error가 아닌 경우 -> 정상적으로 함수 진행
                checkDeq(deq,direct);
            }
        }// t 횟수 반복분 fin
        System.out.println(sb.toString());
    }

    // deq값 출력하는 함수
    public static void checkDeq(Deque<Integer> deq, String direct) {
        sb.append("[");
        // deq가 비어있지 않은 경우
        if(!deq.isEmpty()){
            if(direct == "") { 	// 정방향
                sb.append(deq.pollFirst());
                while(!deq.isEmpty()) {
                    sb.append(",").append(deq.pollFirst());
                }
            }else { // 역방향
                sb.append(deq.pollLast());
                while(!deq.isEmpty()) {
                    sb.append(",").append(deq.pollLast());
                }
            }
        }
        sb.append("]\n");
    }
}



