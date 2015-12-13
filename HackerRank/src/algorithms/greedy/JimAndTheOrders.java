package algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class JimAndTheOrders {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        TreeMap<Integer, ArrayList<Integer>> data = new TreeMap<Integer, ArrayList<Integer>>();
        
        for(Integer i = 1; i <= N; i++){
            Integer start = in.nextInt();
            Integer duration = in.nextInt();
            Integer finish = start + duration;
            
            ArrayList<Integer> customers = data.get(finish);
            customers = customers == null ? new ArrayList<Integer>() : customers;
            
            customers.add(i);
            data.put(finish, customers);       
        }
        
        StringBuilder sb = new StringBuilder();
        for(Integer finish : data.keySet()){
            ArrayList<Integer> customers = data.get(finish);
            
            if(customers.size() == 1){
                sb.append(customers.get(0) + " ");
            } else {
                Collections.sort(customers);
                for(Integer customer : customers){
                    sb.append(customer + " ");
                }
            }                        
        }
        
        System.out.println(sb.toString());
    }
}
