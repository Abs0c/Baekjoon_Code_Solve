import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer sk;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++){
            sk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sk.nextToken());
            int b = Integer.parseInt(sk.nextToken());
            int answer = 0;
            int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr2);
            for (int j = 0; j < a; j++){
                int start = 0;
                int end = b - 1;
                int index = 0;

                while (start <= end){
                    int mid = (start + end) / 2;
                    if (arr2[mid] < arr1[j]){
                        start = mid + 1;
                        index = mid + 1;
                    }
                    else{
                        end = mid - 1;
                    }
                }
                answer += index;
            }
            System.out.println(answer);
        }
        br.close();
    }
}