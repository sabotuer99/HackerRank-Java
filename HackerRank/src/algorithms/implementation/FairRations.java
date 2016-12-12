package algorithms.implementation;

import java.util.Scanner;

public class FairRations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        for(int B_i=0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
        }
        in.close();
        
        int bread = 0;
        boolean impossible = false;
        for(int i = 1; i < N; i++){
            
            //check impossible state
            if(i == N-1 && (B[i]%2 != B[i-1]%2)){
                impossible = true;
                break;
            }
            
            if(B[i-1]%2 == 1){
                B[i-1]++;
                B[i]++;
                bread += 2;
            }
        }
        
        //System.out.println(Arrays.toString(B));
        
        if(impossible){
            System.out.println("NO");
        } else {
            System.out.println(bread);
        }
        
    }
}
