package algorithms.implementation;

import java.util.Scanner;

public class DesignerPDFViewer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int max = 0;
        for(int i = 0; i < word.length(); i++){
            int hindex = word.charAt(i) - 'a';
            int height = h[hindex];
            max = Math.max(height, max);
        }
        System.out.println(max * word.length());
        in.close();
    }
}
