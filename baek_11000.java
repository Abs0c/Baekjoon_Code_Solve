import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0]){
                    return Integer.compare(arr2[1], arr1[1]);
                }
                return Integer.compare(arr1[0], arr2[0]);
            }
        });
        
        boolean breakp = false;
        int cnt = 0;

        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sk.nextToken());
            int b = Integer.parseInt(sk.nextToken());
            pq.add(new int[] {a, b});
        }
        arr[0] = pq.poll()[1];
        cnt++;

        for (int i = 1; i < n; i++){
            //두 개의 값을 받아서 뒷값을 저장,
            int[] temp = pq.poll();
            int a = temp[0];
            int b = temp[1];
            for (int j = 0; j < cnt; j++){
                //현재 수업중인 강의실들의 수업이 끝나는 시간보다 새로 확인한 수업이 같은 시간 혹은 더 늦은 시간에 시작하면
                if (a >= arr[j]){
                    //저장값을 다음 값의 뒷 값으로 바꾸고 개수는 그대로
                    arr[j] = b;
                    //이미 적절한 위치를 찾았으니 break
                    breakp = true;
                    break;
                }
            }
            if (breakp == true){
                breakp = false;
                continue;
            }
            //현재 수업중인 강의실들의 수업이 끝나는 시간보다 새로 확인한 수업이 더 일찍 시작하면 추가 저장 및 개수 + 1
            else {
                arr[cnt++] = b;
            }    
            
        }
        System.out.println(cnt);
        br.close();
    }
}
