import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] tmp = str.split(" ");

        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);

        int[] lengthArray = new int[N];
        for(int i=0; i<N; i++){
            String nameString = br.readLine();
            lengthArray[i] = nameString.length();
        }

        //시간 복잡도 O(N*K)이기 때문에 1초 안에 해결 할 수 없습니다.
        //여기서 디벨롭 해보려고 했지만.. 슬라이딩 윈도우..? 가 뭔지 잘 모르겠어요..ㅎㅎ
        int count = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=1; j<=K && i+j<N; j++){
                if(lengthArray[i]==lengthArray[i+j])
                    count++;
            }

        }

        bw.write(Integer.toString(count));

        bw.close();
        br.close();
    }
}
