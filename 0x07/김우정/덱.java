import java.io.*;
import java.util.StringTokenizer;

class Node
{
    int value;
    Node next;
    Node prev;

    Node(int value)
    {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class MyDeque{
    private Node head;
    private Node tail;
    private int size;

    public MyDeque(){
        head = null;
        tail = null;
        size = 0;
    }

    public void pushFront(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void pushBack(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public int popFront(){
        if(head == null)
            return -1;
        else{
            int value = head.value;
            head = head.next;

            if(head == null)
                tail = null;
            else{
                head.prev = null;
            }
            size--;

            return value;
        }
    }

    public int popBack(){
        if(tail == null)
            return -1;
        else{
            int value = tail.value;
            tail = tail.prev;

            if(tail == null)
                head = null;
            else{
                tail.next = null;
            }
            size --;

            return value;
        }
    }

    public int size(){
        return size;
    }

    public int empty(){
        if(size==0)
            return 1;
        else
            return 0;
    }

    public int front(){
        if(head == null)
            return -1;
        else
            return head.value;
    }

    public int back(){
        if(tail==null)
            return -1;
        else
            return tail.value;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque();

        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push_back":
                    int value = Integer.parseInt(st.nextToken());
                    deque.pushBack(value);
                    break;
                case "push_front":
                    value = Integer.parseInt(st.nextToken());
                    deque.pushFront(value);
                    break;
                case "pop_front":
                    value = deque.popFront();
                    bw.write(Integer.toString(value)+'\n');
                    break;
                case "pop_back":
                    value = deque.popBack();
                    bw.write(Integer.toString(value)+'\n');
                    break;
                case "size":
                    value = deque.size();
                    bw.write(Integer.toString(value)+'\n');
                    break;
                case "empty":
                    value = deque.empty();
                    bw.write(Integer.toString(value)+'\n');
                    break;
                case "front":
                    value = deque.front();
                    bw.write(Integer.toString(value)+'\n');
                    break;
                case "back":
                    value = deque.back();
                    bw.write(Integer.toString(value)+'\n');
                    break;
                default:
                    bw.write("ERROR : WRONG COMMAND!\n");

            }
        }

        br.close();
        bw.close();
    }
}
