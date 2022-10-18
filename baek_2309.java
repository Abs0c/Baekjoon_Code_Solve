import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2309 {
    public static int aindex = 0;
    public static int bindex = 0;
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
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0; int a; int b;
        for (int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        quickSort(arr, 0, 8);

        int breakp = 0;
        for (int i = 0; i < 9-1; i++){
            if (breakp == 1) break;
            a = arr[i];
            for (int j = i+1; j < 9; j++){
                b = arr[j];
                if (sum - (a+b) == 100){
                    aindex = i;
                    bindex = j;
                    breakp = 1;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++){
            if ((i != aindex) && (i != bindex)){
                System.out.println(arr[i]);
            }
        }
    }
}
