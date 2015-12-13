package algorithms.strings;

import java.util.Scanner;

public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(; t > 0; t--){
            
            char[] line = in.nextLine().toCharArray();
            int index = -1;
            for(int i = 0; i <= line.length / 2; i++){
                int j = line.length - 1 - i;
                if(line[i] != line[j]){
                    int skip = 0; 
                    while(line[i + skip + 1] == line[j - skip] && line[i + skip] == line[j - skip - 1]){
                        skip += 1;
                    }
                    if(line[i + 1 + skip] == line[j - skip]){
                        index = i;
                    } else {
                        index = j;
                    }
                    break;
                }
            }
            System.out.println(index);
        }
    }
}
