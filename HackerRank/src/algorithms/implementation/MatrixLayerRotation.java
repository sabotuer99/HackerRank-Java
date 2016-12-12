package algorithms.implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MatrixLayerRotation {

    public static int[] rotateLeft(int[] array, int shift){
        
        int n = array.length;
        int[] shifted = new int[n];
        shift = shift % n;
        
        for(int i = 0; i < n; i++){
            shifted[(n+i-shift)%n] = array[i];
        }           
        
        System.arraycopy(shifted, 0, array, 0, n);
        
        return shifted;
    } 
    
    
    public static int[][] matrixize (Map<Integer, int[]> vectors, int rows, int cols){
        int[][] matrix = new int[rows][cols];
        
        for(Integer layer : vectors.keySet()){
        
            int[] vector = vectors.get(layer);
            int layerRows = rows - 2 * layer;
            int layerCols = cols - 2 * layer;
            
            //copy top row
            for(int i = 0; i < layerCols; i++){
                matrix[layer][layer + i] = vector[i];
            }
            
            //copy right side
            for(int i = 1; i < layerRows; i++){
                matrix[i + layer][layerCols-1 + layer] = vector[layerCols - 1 + i];
            }
            
            //copy bottom row
            for(int i = 1; i < layerCols; i++){
                matrix[layerRows - 1 + layer][layerCols - 1 - i + layer] = vector[layerCols + layerRows - 2 + i];
            }
            
            //copy left side
            for(int i = 1; i < layerRows - 1; i++){
                matrix[layerRows - 1 - i + layer][layer] = vector[2 * layerCols + layerRows - 3 + i];
            }
            
        }
        
        return matrix;
    }
    
    
    public static Map<Integer, int[]> vectorize(int[][] matrix){
        //0 layer is exterior layer
        //min(rows, cols) / 2 is center layer
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        Map<Integer, int[]> vectors = new HashMap<>();
            
        for(int layer = 0; layer < Math.min(rows/2, cols/2); layer++){
            int layerRows = rows - 2 * layer;
            int layerCols = cols - 2 * layer;
            
            int[] vector = new int[2 * layerRows + 2 * layerCols - 4];
            
            //copy top row
            for(int i = 0; i < layerCols; i++){
                vector[i] = matrix[layer][layer + i];
            }
            
            //copy right side
            for(int i = 1; i < layerRows; i++){
                vector[layerCols - 1 + i] = matrix[i + layer][layerCols-1 + layer];
            }
            
            //copy bottom row
            for(int i = 1; i < layerCols; i++){
                vector[layerCols + layerRows - 2 + i] = matrix[layerRows - 1 + layer][layerCols - 1 - i + layer];
            }
            
            //copy left side
            for(int i = 1; i < layerRows - 1; i++){
                vector[2 * layerCols + layerRows - 3 + i] = matrix[layerRows - 1 - i + layer][layer];
            }
            
            vectors.put(layer, vector);
        }
            
        return vectors;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int rotations = in.nextInt();
        int[][] matrix = new int[rows][cols];
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                matrix[row][col] = in.nextInt();
            }
        }
        
        
        Map<Integer, int[]> vectors = vectorize(matrix);
        
        for(int[] vector : vectors.values()){
            rotateLeft(vector, rotations);
        }
        
        int[][] reconstructed = matrixize(vectors, rows, cols);
        for(int[] row : reconstructed){
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]",""));
        }
        
        
        in.close();
    }
}
