import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.getX() != o2.getX()){
                    return Integer.compare((int)o1.getX(), (int)o2.getX());
                } else {
                    return Integer.compare((int)o1.getY(), (int)o2.getY());
                }
            }
        });

        for(int i=0; i<n; i++){
            System.out.println((int)points[i].getX() + " " + (int)points[i].getY());
        }
    }
}
