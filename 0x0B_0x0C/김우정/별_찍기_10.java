import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {
    static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        result = new char[input][input];

        backTracking(0,0, input, false);

        printResult(input);
    }

    public static void backTracking(int x, int y, int n, boolean blank){
        if(blank){
            for(int i=x; i<x+n; i++){
                for(int j=y; j<y+n; j++){
                    result[i][j]=' ';
                }
            }
            return;
        }

        if(n==1) {
            result[x][y] = '*';
            return;
        }

        int area=0;
        for(int i=x; i<x+n; i+=n/3){
            for(int j=y; j<y+n; j+=n/3){
                area++;
                if(area==5){
                    backTracking(i,j,n/3,true);
                }
                else {
                    backTracking(i, j, n / 3, false);
                }
            }
        }
    }

    public static void printResult(int n){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
