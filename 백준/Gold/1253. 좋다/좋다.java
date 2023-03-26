import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            int left = 0;
            int right = n-1;
            while(true){
                if(left == i) left++;
                else if(right == i) right--;

                if(left >= right) break;

                if(numbers[left] + numbers[right] > numbers[i]) right--;
                else if(numbers[left] + numbers[right] < numbers[i]) left++;
                else{
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}