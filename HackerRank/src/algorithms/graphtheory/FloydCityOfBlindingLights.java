package algorithms.graphtheory;

import java.util.Scanner;

public class FloydCityOfBlindingLights {

    /*
    1 let dist be a |V| × |V| array of minimum distances initialized to ∞ (infinity)
    2 for each vertex v
    3    dist[v][v] ← 0
    4 for each edge (u,v)
    5    dist[u][v] ← w(u,v)  // the weight of the edge (u,v)
    6 for k from 1 to |V|
    7    for i from 1 to |V|
    8       for j from 1 to |V|
    9          if dist[i][j] > dist[i][k] + dist[k][j] 
    10             dist[i][j] ← dist[i][k] + dist[k][j]
    11         end if
    */
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //vertices
        int M = in.nextInt(); //edges
        
        long[][] dist = new long[N][N];  //initialize weights to "infinity"
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i != j)
                    dist[i][j] = Integer.MAX_VALUE;         
            }
        }
                
        for(int i = 0; i < M; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int r = in.nextInt();
            dist[y - 1][x - 1] = r;
        }    
        
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        
        print(dist);
        
        int t = in.nextInt();
        for(; t > 0; t--){
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            long distance = dist[v][u] == Integer.MAX_VALUE ? -1 : dist[v][u];
            System.out.println(distance);
        }
        
    }
    
    
    public static void print(long[][] dist){
        //for(int i = 0; i < dist.length; i++)
            //System.out.println(Arrays.toString(dist[i]));
    }
}
