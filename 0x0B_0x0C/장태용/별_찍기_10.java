package week9;
//별 찍기_10
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2447 {

    public static boolean recursiveFunc(int N, int r, int c){
        if(N==3){
            if(r==1 && c ==1){
                return false;
            }else{
                return true;
            }
        }
        int x = N/3;
        if(r<x && c<x) return recursiveFunc(x, r, c);
        else if(r>=x && r<2*x && c<x) return recursiveFunc(x, r-x,c);
        else if(r>=2*x && c<x) return recursiveFunc(x, r-2*x,c);
        else if(r<x && c>=x && c<2*x) return recursiveFunc(x, r, c-x);
        else if(r>=x && r<2*x && c>=x && c<2*x) return false;
        else if(r>=2*x && c>=x && c<2*x) return recursiveFunc(x, r-2*x, c-x);
        else if(r<x && c>=2*x) return recursiveFunc(x, r, c-2*x);
        else if(r>=x && r<2*x && c>=2*x) return recursiveFunc(x, r-x, c-2*x);
        else return recursiveFunc(x, r-2*x, c-2*x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        for(int i = 0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<N; j++){
                if(recursiveFunc(N,i,j)) sb.append("*");
                else sb.append(" ");
            }
            System.out.println(sb);
        }

    }
}
