package algorithms.implementation;

import java.util.Scanner;

public class TheTimeInWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hours = in.nextInt();
        int mins = in.nextInt();
        String[] nums = {"twelve","one", "two", "three", "four", "five", "six", "seven", 
                         "eight", "nine", "ten", "eleven", "twelve", "thirteen",
                         "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", 
                         "nineteen", "twenty"};
        String[] quarters = {"", "quarter", "half"};
        
        String modifier = mins > 30 ? "to" : "past";
        hours = mins > 30 ? (hours + 1) % 12 : hours;
        mins = mins > 30 ? 60 - mins : mins;
        
        String result = "";
        
        if(mins == 0){
            result = nums[hours] + " o' clock";
        } else {
            result = mins % 15 == 0 ? quarters[mins / 15] : 
                     (mins > 20 ? nums[20] + " " + nums[mins % 20] : nums[mins]) + " minutes";
            result += " " + modifier + " " + nums[hours];        
        }
        
        System.out.println(result);
    }
}
