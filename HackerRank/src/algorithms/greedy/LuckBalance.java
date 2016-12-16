package algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LuckBalance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int luck = 0;
        List<Integer> imp = new ArrayList<>();
        for(; n > 0; n--){
            int L = in.nextInt();
            int bit = in.nextInt();
            if(bit == 0){
                luck += L;
            } else {
                imp.add(L);
            }
        }
        in.close();
        Collections.sort(imp, Collections.reverseOrder());
        
        for(int i = 0; i < imp.size(); i++){
            int L = imp.get(i);
            if(i < k){
                luck += L;
            } else {
                luck -= L;
            }
        }
        System.out.println(luck);
        
    }
}
