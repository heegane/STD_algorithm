import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException{
        //입력
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str=reader.readLine();
        int count=Integer.parseInt(reader.readLine());

        //연산
        LinkedList<Character> list = new LinkedList<>();
        for(char ch:str.toCharArray()){
            list.add(ch);
        }

        ListIterator<Character> listIterator=list.listIterator(list.size());

        for(int i=0; i<count; i++){
            String command = reader.readLine();
            switch (command.charAt(0)){
                case 'L':
                    if(listIterator.hasPrevious()){
                        listIterator.previous();
                    }
                    break;
                case 'D' :
                    if(listIterator.hasNext()) {
                        listIterator.next();
                    }
                    break;
                case 'B' :
                    if(listIterator.hasPrevious()){
                        listIterator.previous();
                        list.remove();
                    }
                    break;
                case 'P' :
                    char ch = command.charAt(2);
                    list.add(ch);
                    break;
            }
        }

        //출력
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for(char c:list){
            writer.write(c);
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
