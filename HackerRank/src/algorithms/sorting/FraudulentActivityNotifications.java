package algorithms.sorting;

import java.util.Scanner;

public class FraudulentActivityNotifications {

    public static class Median{
        int[] counts = new int[201];
        int size = 0;
        
        public Median add(int n){
            counts[n]++;
            size++;
            return this;
        }
        
        public Median drop(int n){
            counts[n]--;
            size--;
            return this;
        }
        
        public int size(){
            return size;
        }
        
        public double median(){
            int[] left = new int[201];
            int[] right = new int[201];
            left[0] = counts[0];
            right[200] = counts[200];
            
            for(int i = 1; i < 201; i++){
                left[i] = left[i-1] + counts[i];
                right[200-i] = right[201-i] + counts[200-i];
            }
            
            int L = 0;
            int R = 200;
            int half = size/2 + size%2;
            while(L < R){
                
                
                
                if(left[L] == half && right[R] == half){
                    return (R + L)/2.0;
                }
                
                if(left[L] > size/2){
                    return L;
                }
                if(right[R] > size/2){
                    return R;
                }
                
                if(left[L] < right[R]){
                    L++;
                } else {
                    R--;
                }
            }
            
            return (R + L)/2.0;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();   
        }
        in.close();
        
        int notifications = 0;
        Median med = new Median();
        for(int i = 1; i < n; i++){
            med.add(arr[i-1]);
            if(med.size > d){
                med.drop(arr[i-d-1]);
            }
            
            if(med.size == d){         
                double median = med.median();
                if(arr[i] >= median * 2){
                    notifications++;
                }
            }            
        }
        
        System.out.println(notifications);   
    }
}
