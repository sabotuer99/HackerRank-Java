import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);        
        char[][] board = new char[10][10];
        
        //build board
        for(int i = 0; i < 10; i++){
            board[i] = in.next().toCharArray();
        }
        List<String> words = Arrays.asList(in.next().split(";"));       
        List<Slot> slots = getSlots(board);
        
        /*
        for(Slot slot : slots){
            System.out.println(slot);
        }
        System.out.println(Arrays.toString(words));
        */
        
        solve(board, words, slots);
        
        printBoard(board);
    }
    
    private static void printBoard(char[][] board){
        for(int i = 0; i < 10; i++){
            System.out.println(Arrays.toString(board[i]).replaceAll("[, \\[\\]]",""));
        }
    }
    
    private static boolean solve(char[][] board, List<String> words, List<Slot> slots){
        
        if(words.size() != slots.size()){
            return false;
        }
        
        if(words.size() == 0 && slots.size() == 0){
            return true;
        }
        
        
        for(int i = 0; i < slots.size(); i++){           
            Slot slot = slots.get(i);
            for(String word : words){
                if(isMatch(board, word, slot)){
                    char[][] newBoard = writeToSlot(board, slot, word);
                    List<String> newWords = new ArrayList<>(words);
                    List<Slot> newSlots = new ArrayList<>(slots);
                    newWords.remove(word);
                    newSlots.remove(slot);
                    
                    if(solve(newBoard, newWords, newSlots)){
                        copyBoard(newBoard, board);
                        return true;
                    }
                }
            }          
        }
               
        return false;
    }
    
    private static boolean isMatch(char[][] board, String word, Slot slot){
        if(slot.length() != word.length()){
            return false;
        }
        
        for(int row = slot.beginRow, i = 0; row <= slot.endRow; row++){
            for(int col = slot.beginCol; col <= slot.endCol; col++, i++){
                boolean match = board[row][col] == '-' || board[row][col] == word.toCharArray()[i];
                if(!match){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static List<Slot> getSlots(char[][] board){
        List<Slot> slots = new ArrayList<>();
        
        //get horizontal slots
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '-' && board[row][col+1] == '-'){
                    int start = col;
                    int end = start;
                    for(;end < 9 && board[row][end+1] == '-';end++);
                    slots.add(new Slot(row,row,start,end));
                    col = end + 1;
                }
            }
        }
        
        //get vertical slots
        for(int col = 0; col < 10; col++){
            for(int row = 0; row < 9; row++){          
                if(board[row][col] == '-' && board[row+1][col] == '-'){
                    int start = row;
                    int end = start;
                    for(;end < 9 && board[end+1][col] == '-';end++);
                    slots.add(new Slot(start,end,col,col));
                    row = end + 1;
                }
            }
        }
        
        return slots;
    }
    
    private static void copyBoard(char[][] existingBoard, char[][] newBoard){
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 10; col++){
                newBoard[row][col] = existingBoard[row][col];
            }
        }
    }      
    
    private static char[][] writeToSlot(char[][] existingBoard, Slot slot, String word){
        //if word doesn't fit, return existing board
        if(slot.length() != word.length()){
            return existingBoard;
        }
        
        //get a fresh copy of board
        char[][] newBoard = new char[10][10];
        copyBoard(existingBoard, newBoard);
        
        //write the word into the slot
        for(int row = slot.beginRow, i = 0; row <= slot.endRow; row++){
            for(int col = slot.beginCol; col <= slot.endCol; col++, i++){
                newBoard[row][col] = word.toCharArray()[i];
                
                //printBoard(newBoard);
                //System.out.println();
            }
        }
        
        return newBoard;
    }
    
    private static class Slot{
        public int beginRow;
        public int endRow;
        public int beginCol;
        public int endCol;
        
        public Slot(int beginRow, int endRow, int beginCol, int endCol){
            this.beginRow = beginRow;
            this.endRow = endRow;
            this.beginCol = beginCol;
            this.endCol = endCol;
        }
        
        public String toString(){
            return "(" + beginCol + ","+ beginRow + ")"+
                   "(" + endCol + ","+ endRow + ")";
        }
        
        public int length(){
            return endRow - beginRow + endCol - beginCol + 1;
        }
        
        @Override
        public int hashCode(){
            return beginRow ^ (endRow << 8) ^ (beginCol << 16) ^ (endCol << 24);
        }
        
        @Override
        public boolean equals(Object o){
            if(!(o instanceof Slot)){
                return false;
            }
            
            Slot other = (Slot)o;
            return this.beginRow == other.beginRow &&
                   this.endRow == other.endRow &&
                   this.beginCol == other.beginCol &&
                   this.endCol == other.endCol;
        }
    }
}
