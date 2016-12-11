package algorithms.constructive;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bonetrousle {

    public static BigInteger sumToX(long x){
        
        BigInteger bx = BigInteger.valueOf(x);
        BigInteger ax = BigInteger.valueOf(x);
        
        bx = bx.multiply(bx);
        ax = ax.add(bx);
        ax = ax.divide(BigInteger.valueOf(2));
        
        return ax;
    }
    
    public static List<Long> boxes(long total_n, long inv_k, long boxes){
        
        //System.out.printf("%d   %d   %d\n",total_n, inv_k, boxes);
        
        
        long min = sumToX(boxes).longValue();
        BigInteger max = sumToX(inv_k).subtract(sumToX(inv_k - boxes));
        
        List<Long> boxList = new ArrayList<>();
        
        if(total_n < min || max.compareTo(BigInteger.valueOf(total_n)) < 0){
            return boxList;
        }
        
        long additional = (total_n - min)/boxes;
        long total = 0;
        for(long i = 1; i <= boxes; i++){
            boxList.add(i + additional);
            total += i + additional;
        }
        
        long remainder = total_n - total;
        
        if(remainder > 0){
            boxList.add(1+additional+boxes);
            boxList.remove(1+additional+boxes-remainder);
        }
        
        return boxList;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(;T > 0; T--){
            long n = in.nextLong();
            long k = in.nextLong();
            long b = in.nextLong();
            List<Long> boxes = boxes(n,k,b);
            if(boxes == null || boxes.size() == 0){
                System.out.println(-1);
            } else {
                StringBuilder sb = new StringBuilder();
                //long total = 0;
                for(Long box : boxes){
                    sb.append(box + " ");
                    //total += box;
                }
                //System.out.println(total);
                System.out.println(sb.toString().trim());
            }
        }
        in.close();
    }
}
