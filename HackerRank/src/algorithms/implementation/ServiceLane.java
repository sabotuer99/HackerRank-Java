package algorithms.implementation;

import java.util.Scanner;

public class ServiceLane {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        int T = in.nextInt();
        int[][] last_possible_entry = new int[N][2];
        
        //read input and preprocess
        //implementation of code found here:
        //http://www.martinkysel.com/hackerrank-service-lane-solution/
        for(int i = 0; i < N; i++){
            int width = in.nextInt();
            int last_car_entry = -1;
            int last_truck_entry = -1;
            
            if(width > 1){
                last_car_entry = i;
                if(i > 0 && last_possible_entry[i - 1][0] >= 0)
                    last_car_entry = last_possible_entry[i - 1][0];
            }
            
            if(width > 2){
                last_truck_entry = i;
                if(i > 0 && last_possible_entry[i - 1][1] >= 0)
                    last_truck_entry = last_possible_entry[i - 1][1];
            }
            
            last_possible_entry[i][0] = last_car_entry;
            last_possible_entry[i][1] = last_truck_entry;
        }
       
        for(; T > 0; T--){
            int i = in.nextInt();
            int j = in.nextInt();
            
            int[] access_pattern = last_possible_entry[j];
            if (access_pattern[1] != -1 && access_pattern[1] <= i){
                System.out.println(3);
            } else if(access_pattern[0] != -1 && access_pattern[0] <= i){          
                System.out.println(2);  
            } else {
                System.out.println(1);
            }
        }
        
    }
}
