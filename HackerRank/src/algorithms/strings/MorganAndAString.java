package algorithms.strings;

import java.util.ArrayList;
import java.util.Scanner;

public class MorganAndAString {
	
	//Adapted from:
	//https://github.com/AlexAtNet/galgo/blob/master/solutions/hackerrank/morgan-and-a-string/morgan-and-a-string.go
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        
        for(; t > 0; t--){
            String word1 = in.nextLine();
            String word2 = in.nextLine();
            System.out.println(morgan(word1, word2));
        }
        in.close();
    }

	public static String morgan(String word1, String word2) {
		StringBuilder answer = new StringBuilder();
		
		String[] a = new String[word1.length()];
		for(int i = 0; i < word1.length(); i++){
			a[i] = word1.substring(i, i+1);
		}
			
		String[] b = new String[word2.length()];
		for(int i = 0; i < word2.length(); i++){
			b[i] = word2.substring(i, i+1);
		}
		
		int[] i = new int[1];
		int[] j = new int[1];
		
		while(toToken("", a, b, i, j, answer)){
			
			String ntk = a[i[0]];
			String[] sa = getTokens(ntk, a, i);
			String[] sb = getTokens(ntk, b, j);
			
			if(sa.length == 0 && sb.length == 0){
				for(; i[0] < a.length && a[i[0]] == ntk; i[0]++){
					answer.append(a[i[0]]);
				}
				for(; j[0] < b.length && b[j[0]] == ntk; j[0]++){
					answer.append(b[i[0]]);
				}
			}
			mergetokens(ntk, sa, sb, answer);
		}
		return answer.toString();
	}

	private static void mergetokens(String tk, String[] a, String[] b, StringBuilder answer) {
		//wrap i and j in arrays so they can be mutated by function
		int[] i = new int[1];
		int[] j = new int[1];
		while(toToken(tk, a, b, i, j, answer)){
			if(i[0] == a.length - 1 && j[0] == b.length - 1){
				answer.append(a[i[0]]);
				answer.append(b[j[0]]);
				break;
			}
			
			String ntk = a[i[0]];
			String[] sa = getTokens(ntk, a, i);
			String[] sb = getTokens(ntk, b, j);
			
			if(sa.length == 0 && sb.length == 0){
				for(; i[0] < a.length && a[i[0]] == ntk; i[0]++){
					answer.append(a[i[0]]);
				}
				for(; j[0] < b.length && b[j[0]] == ntk; j[0]++){
					answer.append(b[i[0]]);
				}
			}
			
			mergetokens(ntk, sa, sb, answer);
		}
	}

	private static String[] getTokens(String v, String[] s, int[] i) {
		ArrayList<String> result = new ArrayList<String>();
		String[] st = {""};
		while(getToken(v, s, i, st)){
			result.add(st[0]);
		}
		
		return result.toArray(new String[result.size()]);
	}

	private static boolean getToken(String v, String[] s, int[] i, String[] st) {
		int j = i[0];
		while(j < s.length && s[j].equals(v)){
			j++;
		}
		while(j < s.length && lt(s[j], v)){
			j++;
		}
		
		if(j - i[0] < 2){
			st[0] = "";
			return false;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int ix = i[0]; ix < j; ix++){
			sb.append(s[ix]);
		}
		
		st[0] = sb.toString();
		i[0] = j;
		return true;
	}

	private static boolean lt(String a, String b){
		return (a + b).compareTo(b + b) < 0;
	}
	
	private static boolean toToken(String token, String[] a, String[] b, int[] i, int[] j, StringBuilder answer) {
		while(true){
			if (i[0] < a.length && j[0] < b.length) {
				if (lt(a[i[0]], b[j[0]])) {
					answer.append(a[i[0]]);
					i[0]++;
				} else if (lt(b[j[0]], a[i[0]])) {
					answer.append(b[j[0]]);
					j[0]++;
				} else {
					return true;
				}
			} else {
				for(int ix = i[0]; ix < a.length; ix++){
					answer.append(a[ix]);
				}
				for(int jx = j[0]; jx < b.length; jx++){
					answer.append(b[jx]);
				}				
				i[0] = a.length;
				j[0] = b.length;
				return false;
			}
		}
	}
}
