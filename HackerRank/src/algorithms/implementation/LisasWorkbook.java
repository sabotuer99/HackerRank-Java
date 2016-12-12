package algorithms.implementation;

import java.util.Scanner;

public class LisasWorkbook {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int chapters = in.nextInt();
        int pageCap = in.nextInt();
        int page = 1;
        int special = 0;
        
        for(int i = 0; i < chapters; i++){
            int problems = in.nextInt();
            for(int j = 1; j <= problems; j++){
                if(j == page){
                    special++;
                }
                if(j%pageCap == 0){
                    page++;
                }
            }
            if(problems%pageCap != 0){
                page++;
            }
        }
        
        System.out.println(special);       
        in.close();
    }
}
