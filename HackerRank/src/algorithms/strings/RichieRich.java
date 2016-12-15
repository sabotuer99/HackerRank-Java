package algorithms.strings;

import java.util.Scanner;

public class RichieRich {

    public static boolean isPal(char[] seq){
        for(int i = 0; i < seq.length/2; i++){
            if(seq[i] != seq[seq.length - 1 - i]){
                return false;
            }
        }
        return true;
    }
    
    public static int countMiss(char[] seq, int index){
        int miss = 0;
        for(int i = index; i < seq.length/2; i++){
            if(seq[i] != seq[seq.length - 1 - i]){
                miss++;
            }
        }
        return miss;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        @SuppressWarnings("unused")
		int n = in.nextInt();
        int k = in.nextInt();       
        char[] number = in.next().toCharArray();
        in.close();
        
        //handle length 1 corner case
        if(number.length == 1){
            if(k > 0){
                System.out.println(9);
            } else {
                System.out.println(number[0]);
            }
            return;
        }
        
        
        //main loop
        for(int i = 0; i <= number.length/2; i++){
            int j = number.length - 1 - i;
            int misses = countMiss(number, i);
            if(misses + 2 <= k || (misses + 1 == k && number[i] != number[j])){
                //we have surplus k, set 9s
                if(number[i] != '9'){
                    number[i] = '9';
                    k--;
                }  
                if(number[j] != '9'){
                    number[j] = '9';
                    k--;
                }
            } else if(misses == k){
                //we only have enough k to make things match
                if(number[i] != number[j]){
                    if(number[i] < number[j]){
                        number[i] = number[j];
                    } else {
                        number[j] = number[i];
                    }
                    k--;
                }
            }
        }
        
        //if we have 1 k left and legnth is odd, stick it in the middle
        if(k == 1 && number.length%2 == 1){
            number[number.length/2] = '9';
        }      
        
        if(isPal(number)){
            System.out.println(new String(number));
        } else {
            System.out.println(-1);
        }
        
    }
}
