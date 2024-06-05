import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] students = new int[6][2];

        for(int i = 0; i < N; i++){
            String[] studentInput = reader.readLine().split(" ");
            int gender = Integer.parseInt(studentInput[0]);
            int grade = Integer.parseInt(studentInput[1])-1;

            students[grade][gender]++;
        }

        int roomCounter = 0;
        for(int i=0; i<6;i++){
            for(int j=0; j<2; j++){
                roomCounter+=(students[i][j]+K-1)/K;
            }
        }

        writer.write(String.valueOf(roomCounter));
        writer.flush();
        reader.close();
        writer.close();
    }
}
