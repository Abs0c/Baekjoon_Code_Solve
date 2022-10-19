package code_list;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class important {
    public static void main(String[] args) throws IOException {
        //스트림 관련 정보는 pdf참조
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk; //
        //sk = new StringTokenizer(br.readLine());
        //int a = Integer.parseInt(sk.nextToken());
        br.close(); // throws IOException
        
        //2차원 배열을 담은 우선순위큐에서 첫 번째 값을 기준으로 오름차순하고, 값이 같을 경우 두 번째 값을 기준으로 정렬한다
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int arr1[], int arr2[]){
                if(arr1[0] == arr2[0]){
                    return Integer.compare(arr2[1], arr1[1]);
                }
                return Integer.compare(arr1[0], arr2[0]);
            }
        });

        //우선순위큐를 힙으로 사용할 수 있다.
        //최소힙 : min 요소를 항상 맨 위에 유지하므로..
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        //최대힙 : max 요소를 항상 맨 위에 유지할 수 있도록
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Integer o1, Integer o2) -> (-Integer.compare(o1, o2)));

        //문자열 비교시 ==이 아닌  equls, compareTo를 쓰는 이유는 ==은 주소값을 비교하고
        //equals, compareTo는 값을 비교한다
        //https://hyunjungchoi.tistory.com/15
        String testStringA = "abcd";
        String testStringB = new String("abcd");
        System.out.println("testA " + testStringA + " testB " + testStringB);
        System.out.println("==으로 비교할 경우 " + (testStringA == testStringB));
        System.out.println("equals()로 비교할 경우 " + (testStringA.equals(testStringB)));
        System.out.println("compareTo로 비교할 경우 " + (testStringA.compareTo(testStringB)));
    }

    //재귀할때 return 안쓰고 호출? (어디서였는지 기억안나는데 재귀함수에서 자기 자신을 호출할때 return으로 썼던 기억이..)
    public static void quickSort(int A[], int p, int r){
        if (p < r){
            int q = partition(A, p ,r);
            System.out.println("현재 배열 상태 : " + Arrays.toString(A));
            quickSort(A, p, q-1);
            quickSort(A, q+1, r);
        }
    }
    public static int partition(int A[], int p, int r){
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (A[j] <= x){
                ++i;
                swap(A, i, j);
            }
        }
        swap(A, r, i+1);
        
        return i+1;
    }
    public static void swap(int A[], int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    //위임? //캠으로 책?
}

