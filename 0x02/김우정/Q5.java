import java.util.Scanner;
class Pair{
    private final int maxValue;
    private final int maxIndex;

    public Pair(int maxValue, int maxIndex){
        this.maxValue=maxValue;
        this.maxIndex=maxIndex;
    }

    public int getMaxValue(){
        return maxValue;
    }

    public int getMaxIndex(){
        return maxIndex;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[9];

        for(int i=0; i<9; i++)
        {
            array[i]=scanner.nextInt();
        }
        scanner.close();

        Pair result = findMaxandLocation(array);

        System.out.println(result.getMaxValue());
        System.out.println(result.getMaxIndex());
    }

    private static Pair findMaxandLocation(int[] array){
        int max = array[0];
        int index = 0;

        for(int i=1; i<array.length;i++){
            if(array[i]>max){
                max=array[i];
                index = i;
            }
        }

        return new Pair(max, index+1);
    }
}
