import java.io.*;
import java.util.StringTokenizer;

class Node
{
    int value;
    Node next;

    Node(int value)
    {
        this.value = value;
        this.next = null;
    }
}

class myQueue
{
    private Node front;
    private Node back;
    private int size;

    public myQueue()
    {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public int empty(){
        if(size==0) return 1;
        return 0;
    }

    public void push(int x)
    {
        Node newNode = new Node(x);

        if (size == 0) {
            front = newNode;
            back = newNode;
        } else {
            back.next = newNode;
            back = newNode;
        }
        size++;
    }

    public int size(){
        return this.size;
    }

    public int pop(){
        if(size==0) return -1;

        size--;
        int value = front.value;
        front = front.next;

        if(size==0) back = null;

        return value;

    }


    public int front(){
        if(size==0) return -1;
        return front.value;
    }

    public int back(){
        if(size==0) return -1;
        return back.value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        myQueue queue = new myQueue();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < num ; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    queue.push(value);
                    break;
                case "pop" :
                    bw.write(Integer.toString(queue.pop()));
                    bw.newLine();
                    break;
                case "size" :
                    bw.write(Integer.toString(queue.size()));
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(Integer.toString(queue.empty()));
                    bw.newLine();
                    break;
                case "front" :
                    bw.write(Integer.toString(queue.front()));
                    bw.newLine();
                    break;
                case "back" :
                    bw.write(Integer.toString(queue.back()));
                    bw.newLine();
                    break;
                default:
                    bw.write("Error!");
            }
        }

        bw.close();
        br.close();
    }
}
