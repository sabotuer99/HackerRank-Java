package algorithms.strings;

import java.util.Scanner;

public class Anagram {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t  = Integer.parseInt(in.nextLine());
        for(; t > 0; t--){
            int[] alphacount = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            char[] line = in.nextLine().toCharArray();
            if((line.length & 1) == 1){
                System.out.println(-1);
            } else {
                for(int i = 0; i < line.length / 2; i++){
                    int index = (int)(line[i] - 'a');
                    alphacount[index] += 1;
                }
                int changecount = 0;
                for(int i = line.length / 2; i < line.length; i++){
                    int index = (int)(line[i] - 'a');
                    if(alphacount[index] > 0){
                        alphacount[index] -= 1;
                    } else {
                        changecount += 1;
                    }
                }
                System.out.println(changecount);
            }
        }
    }
}
