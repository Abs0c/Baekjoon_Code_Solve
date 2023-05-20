import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0){
                if (queue.size() == 0){
                    System.out.println(0);
                }
                else{
                    System.out.println(queue.poll());
                }
            }
            else{
                queue.add(temp);
            }
        }
    }
}
