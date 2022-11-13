import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        boolean[] isused = new boolean[x.length()];
        ArrayList<Integer> intarr = new ArrayList<>();
        for (int i = 0; i < x.length(); i++){
            isused[i] = true;
            backtracking(x, Character.toString(x.charAt(i)), isused, intarr);
            isused[i] = false;
        }
        Collections.sort(intarr);
        int index = intarr.indexOf(Integer.parseInt(x));
        if (index + 1 >= intarr.size()){
            System.out.println(0);
        }
        else{
            System.out.println(intarr.get(index+1));
        }

    }
    public static void backtracking(String x, String tempx, boolean[] isused, ArrayList<Integer> intarr){
        if (tempx.length() == x.length()){
            if (!intarr.contains(Integer.parseInt(tempx))){
                intarr.add(Integer.parseInt(tempx));
            }
            return;
        }
        for(int i = 0; i < x.length(); i++){
            if (isused[i] == false){
                isused[i] = true;
                backtracking(x, String.join("", tempx, Character.toString(x.charAt(i))), isused, intarr);
                isused[i] = false;
            }
        }
    }
}
