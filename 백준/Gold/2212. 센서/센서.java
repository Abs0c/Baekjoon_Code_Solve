import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        //센서간의 거리를 내림차순 우선순위큐에 저장함
        PriorityQueue<Integer> distanceArr = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //정렬을 통해서 일직선상에 존재한다는 상황을 표현함
        Arrays.sort(arr);
        for (int i = 0; i < n-1; i++){
            int temp = arr[i+1] - arr[i];
            //예시 : 1 6 9 3 6 7 -> 1 3 6 6 7 9, 기지국 2개
            //예시에서처럼 만일 기지국이 2개라고 하고, 각각의 센서간의 거리가 2 3 0 1 2 일때 
            //이 중 가장 큰 거릿값을 가지는 거리 3을 지우고, 거리 2를 커버하는 기지국 하나, 0 1 2의 거리를 커버하는 기지국 하나
            //이렇게 하면 기지국이 2개이면서 거리가 최소가 되는데
            //이 때 그냥 저 거리의 집합에서 기지국의 개수 - 1 개 만큼의 거리를 지워버리면? 문제가 원하는 답을 가지고 오게 된다
            //이 때 센서간의 거리의 개수 - (기지국의 개수 - 1) = n - k와 같다
            //단, 새로 확인한 거릿값보다 더 먼 거릿값이 큐에 들어있다면 그 값을 빼고 새로 확인한 거리를 넣어서 문제의 조건을 계속 만족하도록 한다
            if (distanceArr.size() < n - k){
                distanceArr.add(temp);
            }
            else if (distanceArr.size() == n - k){
                distanceArr.add(temp);
                distanceArr.poll();
            }
        }
        
        int sum = 0;
        while(!distanceArr.isEmpty()){
            sum += distanceArr.poll();
        }
        System.out.println(sum);
        br.close();
    }
}
