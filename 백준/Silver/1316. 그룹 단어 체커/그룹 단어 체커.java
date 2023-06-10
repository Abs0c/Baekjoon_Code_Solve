import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++){
            String temp = br.readLine();
            if (check(temp)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean check(String input){
        boolean[] checkArr = new boolean[26];
        int prev = 0;

        for (int i = 0; i < input.length(); i++){
            int temp = input.charAt(i);

            if (prev != temp){
                if (!checkArr[temp-'a']){
                    checkArr[temp-'a'] = true;
                    prev = temp;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
