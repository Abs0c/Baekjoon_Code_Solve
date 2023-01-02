import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String string = br.readLine();
            if (string.charAt(0) == ".".charAt(0)){
                break;
            }
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < string.length() - 1; i++){
                if (string.charAt(i) == "(".charAt(0) || string.charAt(i) == "[".charAt(0)){
                    stack.push(Character.toString(string.charAt(i)));
                }
                else if (string.charAt(i) == ")".charAt(0)){
                    if (!stack.isEmpty() && stack.peek().equals("(")){
                        stack.pop();
                    }
                    else{
                        System.out.println("no");
                        break;
                    }
                }
                else if (string.charAt(i) == "]".charAt(0)){
                    if (!stack.isEmpty() && stack.peek().equals("[")){
                        stack.pop();
                    }
                    else{
                        System.out.println("no");
                        break;
                    }
                }
                if (stack.isEmpty() && i == string.length() - 2){
                    System.out.println("yes");
                }
                else if (!stack.isEmpty() && i == string.length() - 2){
                    System.out.println("no");
                }
            }
        }
    }
}
