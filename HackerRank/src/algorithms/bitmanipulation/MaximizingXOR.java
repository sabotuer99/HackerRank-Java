package algorithms.bitmanipulation;

import java.util.Scanner;

public class MaximizingXOR {
	/*
	 * Complete the function below.
	 */

	    static int maxXor(int l, int r) {
	        
	        return onemask(l ^ r);
	        /*
	        int result = l;
	        int mask = onemask(r);
	        int nilresult = niland(result,result+1,mask);
	        
	        for(int i = l + 1; i <= r; i++){
	            result &= i;
	            int temp = niland(result,i,mask);
	            nilresult &= temp;
	        }
	        
	        /*
	        for(int i = l; i <= r; i++){
	            printbits(i, topbit(r));
	        }*/
	        /*
	        nilresult ^= mask;
	        
	        return nilresult;
	        */
	    }

	    public static int niland(int a, int b, int mask){
	        if((a == 0 || b == 0) && a != b)
	            return 0;
	        //printbits(a, 16);
	        //printbits(b, 16);
	        int result = ((~(a | b)) & mask) | (a & b);
	        //printbits(result, 16);
	        //System.out.println();
	        return result;
	    }
	    
	    public static int topbit( int bits ){
	        if(bits == 0)
	            return 0;
	        
	        return binlog(bits) + 1;
	    }
	    
	    public static int binlog( int bits ) // returns 0 for bits=0
	    {
	        int log = 0;
	        if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
	        if( bits >= 256 ) { bits >>>= 8; log += 8; }
	        if( bits >= 16  ) { bits >>>= 4; log += 4; }
	        if( bits >= 4   ) { bits >>>= 2; log += 2; }
	        return log + ( bits >>> 1 );
	    }
	    
	    public static int onemask( int bits ){
	        int r = 0;
	        for(int i = 0; i < topbit(bits); i++){
	            r = r << 1 | 1;
	        }
	        return r;
	    }
	    
	    public static int roundup( int v ){
	        v--;
	        v |= v >> 1;
	        v |= v >> 2;
	        v |= v >> 4;
	        v |= v >> 8;
	        v |= v >> 16;
	        v++;
	        return v;
	    }
	    
	    public static void printbits( int bits, int digits ){
	        System.out.print(bits + ": ");
	        for (int i = digits - 1; i >= 0; i--){
	            int bit = (bits & (int)Math.pow(2,i)) >> i;
	            System.out.print( bit + " " );
	            //bits >>= 1;
	        }
	        System.out.println();
	    }
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int res;
	        int _l;
	        _l = Integer.parseInt(in.nextLine());
	        
	        int _r;
	        _r = Integer.parseInt(in.nextLine());
	        
	        res = maxXor(_l, _r);
	        System.out.println(res);
	        
	    }
}
