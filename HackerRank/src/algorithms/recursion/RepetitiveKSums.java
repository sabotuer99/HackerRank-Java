package algorithms.recursion;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepetitiveKSums {

    public static class Counter{
        Map<Long, Integer> counts = new HashMap<>();
        long min = Long.MAX_VALUE;
        
        
        public void inc(long val){
            min = Math.min(min, val);
            int count = get(val);
            count++;
            counts.put(val, count);
        }
        
        public void dec(long val){
            int count = get(val);
            count--;
            if(count > 0){
                counts.put(val, count);
            } else {
                counts.remove(val);
                if(min == val){
                    if(counts.size() > 0)
                        min = Collections.min(counts.keySet());
                    else
                        min = Long.MAX_VALUE;
                }
            }
        }
        
        public int get(long val){
            return counts.containsKey(val) ? counts.get(val) : 0;
        }
        
        public long first(){
            return min;
        }
    }
    
    //https://github.com/fernandoBRS/HackerRank/blob/master/repetitive_k_sums.cpp
    public static void dfs(int now, long num, int les, long[] DP, Counter sums) {
        if (now == 0) {
            num += les * DP[0];
        }

        if (les == 0 || now == 0) {
            sums.dec(num);
            return;
        }

        for (int i = 0; i <= les;i++)
            dfs(now-1, num + i*DP[now], les-i, DP, sums);
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        long[] DP = new long[100007];
        
        for(; T > 0; T--){
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();
            String[] nums = in.nextLine().split(" ");

            Counter sumSeq = new Counter();
            for(String num : nums){
                long parsed = Long.parseLong(num);
                sumSeq.inc(parsed);
            }
            
            //fernandoBRS
            for (int i = 0; i < n; i++) {
                long now = sumSeq.first();
                if (i == 0) {
                    DP[i] = now / k;
                    sumSeq.dec(now);
                } else {
                    DP[i] = now - DP[0]*(k-1);

                    for (int j = 1; j <= k; j++)
                        dfs(i-1, DP[i]*j, k-j, DP, sumSeq);
                }
            }            
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                sb.append(DP[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        
        in.close();
    }
}
