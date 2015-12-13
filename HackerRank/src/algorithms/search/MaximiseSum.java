package algorithms.search;

import java.util.Scanner;
import java.util.TreeSet;

public class MaximiseSum {

    public static void log(Object message){
        System.out.println(message);
    }

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(; t > 0; t--){
            // With heavy assistance from: 
            // quora:          https://goo.gl/lRNvSo
            // stackoverflow:  http://goo.gl/UHQhT4
            
            int N = in.nextInt();
            long M = in.nextLong();
            long[] A = new long[N];
            for(int i = 0; i < N; i++)
                A[i] = in.nextLong();
            
            long[] prefix = new long[N];
            long curr = 0;
            long ret = 0;
            TreeSet<Long> T = new TreeSet<Long>();
            
            for(int i = 0; i < N; i ++) {
                curr = (A[i] % M + curr) % M;
                prefix[i] = curr;
                T.add(new Long(prefix[i]));
                
                Long j = T.higher(prefix[i]);
                if(j != null){
                    ret = Math.max(ret, (prefix[i] - j + M) % M);
                }
                
                ret = Math.max(ret, prefix[i]);
            }    
            
            System.out.println(ret);
        }
    }
}
