import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] height = new int[num];

        for(int i=0; i<num;i++)
        {
            height[i]=Integer.parseInt(br.readLine());
        }

        /*
        가장 먼저 떠올랐던 풀이는 두개의 배열을 사용하는 법.
        하지만, 입력값을 확인 했을 때 O(N^2)으로는 해결할 수 없는 문제.
        스택이라는 주제의 문제로 풀이하지 않았다면, 스택과 연관된 문제라는 것도 몰랐을 문제이다.

        한 주 동안 문제를 풀기위해 그림도 그려보고
        스트레스와 함께 많은 고민을 했지만.. 결국 풀지 못했다.

        이 문제에서 다음의 내용에 대하여 코드리뷰를 통해 학습하고 싶다.
        1. 문제의 어느 Point에서 Stack과 관련된 문제임을 알 수 있는가.
        2. Stack을 이용한 문제 해결 방안
        3. 그 외 방법
        */
        

        bw.close();
        br.close();
    }
}
