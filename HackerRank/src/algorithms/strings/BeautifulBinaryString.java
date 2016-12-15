package algorithms.strings;

import java.util.Scanner;

public class BeautifulBinaryString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] B = in.next().toCharArray();
        in.close();
        
        int changes = 0;
        for(int i = 0; i < B.length - 2; i++){
            if(B[i] == '0' && B[i+1] == '1' && B[i+2] == '0'){
                B[i+2] = '1';
                changes++;
            }
        }
        
        System.out.println(changes);
    }
}
