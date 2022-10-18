import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_16506 {
    static String op2(int temp, int size){
        String binaryString = Integer.toBinaryString(temp);

        while (binaryString.length() < size){
            binaryString = "0" + binaryString;
        }
        return binaryString;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk;
        int n = Integer.parseInt(br.readLine());
        String[][] st = new String[n][4];
        String opcode;
        String[] tempst;

        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++){
                st[i][j] = sk.nextToken();
            }
        }
        for (int i = 0; i < n; i++){
            opcode = new String();
            tempst = st[i][0].split("");
            if (tempst[0].compareTo("A") == 0){
                if (tempst[1].compareTo("D") == 0){
                    if (tempst.length > 3){
                        opcode = "00001";
                    }
                    else{
                        opcode = "00000";
                    }
                }
                else if (tempst[1].compareTo("N") == 0){
                    if (tempst.length > 3){
                        opcode = "00111";
                    }
                    else{
                        opcode = "00110";
                    }
                }
                else if (tempst[1].compareTo("S") == 0){
                    if (tempst.length > 5){
                        opcode = "10011";
                    }
                    else{
                        opcode = "10010";
                    }
                }
            }
            else if (tempst[0].compareTo("S") == 0){
                if (tempst.length > 3){
                    opcode = "00011";
                }
                else{
                    opcode = "00010";
                }
            }
            else if (tempst[0].compareTo("M") == 0){
                if (tempst[1].compareTo("O") == 0){
                    if (tempst.length > 3){
                        opcode = "00101";
                    }
                    else{
                        opcode = "00100";
                    }
                }
                else if (tempst[1].compareTo("U") == 0){
                    if (tempst.length > 4){
                        opcode = "01101";
                    }
                    else{
                        opcode = "01100";
                    }
                }
            }
            else if (tempst[0].compareTo("O") == 0){
                if (tempst.length > 2){
                    opcode = "01001";
                }
                else{
                    opcode = "01000";
                }
            }
            else if (tempst[0].compareTo("N") == 0){
                opcode = "01010";
            }
            else if (tempst[0].compareTo("L") == 0){
                if (tempst[4].compareTo("L") == 0){
                    if (tempst.length > 5){
                        opcode = "01111";
                    }
                    else{
                        opcode = "01110";
                    }
                }
                else if (tempst[4].compareTo("R") == 0){
                    if (tempst.length > 5){
                        opcode = "10001";
                    }
                    else{
                        opcode = "10000";
                    }
                }
            }
            else if (tempst[0].compareTo("R") == 0){
                if (tempst[1].compareTo("L") == 0){
                    if (tempst.length > 2){
                        opcode = "10101";
                    }
                    else{
                        opcode = "10100";
                    }
                }
                else if (tempst[1].compareTo("R") == 0){
                    if (tempst.length > 2){
                        opcode = "10111";
                    }
                    else{
                        opcode = "10110";
                    }
                }
            }
            opcode = opcode + "0";
            opcode = opcode + op2(Integer.parseInt(st[i][1]), 3);
            opcode = opcode + op2(Integer.parseInt(st[i][2]), 3);
            String[] temp_opcode = opcode.split("");
            if (temp_opcode[4].compareTo("1") == 0){
                opcode = opcode + op2(Integer.parseInt(st[i][3]), 4);
            }
            else{
                opcode = opcode + op2(Integer.parseInt(st[i][3]), 3) + "0";
            }
        System.out.println(opcode);
        }
        br.close();
    }
}
