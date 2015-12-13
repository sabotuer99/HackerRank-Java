package algorithms.implementation;

import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] line = in.nextLine().toCharArray();
        int rows = (int)Math.round(Math.sqrt(line.length));
        int cols = (int)Math.ceil((line.length * 1.0) / rows);
        
        //System.out.println(rows + ", " + cols);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                
                int index = (j * cols) + i;
                if(index < line.length){
                    sb.append(line[index]);
                    //System.out.print(index + ":");
                }
                    
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
