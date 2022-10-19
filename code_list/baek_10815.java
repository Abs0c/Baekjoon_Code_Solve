package code_list;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_10815 {
    public static void quickSort(int A[], int p, int r){
        if (p < r){
            int q = partition(A, p ,r);
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
    public static int divFind(int arr[], int target, int start, int end){
        if (start > end){
            return 0;
        }
        int mid = (start + end) / 2;

        if (arr[mid] == target){
            return 1;
        }
        else if (arr[mid] > target){
            return divFind(arr, target, start, mid-1);
        }
        else{
            return divFind(arr, target, mid+1, end);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk;
        int[] hasarr; int[] checkarr; int[] countarr;
        sk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sk.nextToken());
        hasarr = new int[n];
        sk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            hasarr[i] = Integer.parseInt(sk.nextToken());
        }
        
        sk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(sk.nextToken());
        checkarr = new int[m];
        countarr = new int[m];
        sk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            checkarr[i] = Integer.parseInt(sk.nextToken());
        }

        quickSort(hasarr, 0, n-1);

        for (int i = 0; i < m; i++){
            int temp = divFind(hasarr, checkarr[i], 0, n-1);
            countarr[i] += temp;
        }
        
        for (int i = 0; i < m-1; i++){
            System.out.print(countarr[i] + " ");
        }
        System.out.print(countarr[countarr.length-1]);
    }
}
