package algorithms.graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DijkstraShortestReach2 {
	   
    public static void log(Object message){
       // System.out.println(message);
    }
    
    
    public static class Edge{
        
        public Edge(Integer endpoint, Integer distance){
            this.endpoint = endpoint;
            this.distance = distance;
        }
        
        Integer endpoint;
        Integer distance;
    }
    
    public static void Dijkstra(HashMap<Integer, ArrayList<Edge>> Graph, 
                                Integer source, Integer[] dist, Integer[] prev){
        dist[source] = 0;
        
        FibonacciHeap<Integer> Q = new FibonacciHeap<Integer>();
        HashMap<Integer, FibonacciHeap.Entry<Integer>> Nodes = new HashMap<Integer, FibonacciHeap.Entry<Integer>>();
        
        for(Integer v : Graph.keySet()){
            
            if(!v.equals(source)){
                dist[v] = Integer.MAX_VALUE;
                prev[v] = null;
            }
            
            Nodes.put(v, Q.enqueue(v, dist[v]));
        }
        
        while(!Q.isEmpty()){
            FibonacciHeap.Entry<Integer> node = Q.dequeueMin();
            Integer u = node.mElem;
            log("Node: " + u + " : " + node.mPriority);
            for(Edge v : Graph.get(u)){
                int alt = dist[u] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dist[u] + v.distance;
                if(alt < dist[v.endpoint]){
                    dist[v.endpoint] = alt;
                    prev[v.endpoint] = u;
                    Q.decreaseKey(Nodes.get(v.endpoint), alt);
                }
            }
        }            
    }
    
/*
1  function Dijkstra(Graph, source):
2      dist[source] ← 0                                    // Initialization
3
4      create vertex set Q
5
6      for each vertex v in Graph:           
7          if v ≠ source
8              dist[v] ← INFINITY                          // Unknown distance from source to v
9              prev[v] ← UNDEFINED                         // Predecessor of v
10
11         Q.add_with_priority(v, dist[v])
12
13
14      while Q is not empty:                              // The main loop
15         u ← Q.extract_min()                            // Remove and return best vertex
16         for each neighbor v of u:                       // only v that is still in Q
17             alt = dist[u] + length(u, v) 
18             if alt < dist[v]
19                 dist[v] ← alt
20                 prev[v] ← u
21                 Q.decrease_priority(v, alt)
22
23     return dist[], prev[]
*/
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(; T > 0; T--){
            int N =  in.nextInt();
            int M =  in.nextInt();
            Integer[] dist = new Integer[N + 1];
            Integer[] prev = new Integer[N + 1];
            
            HashMap<Integer, ArrayList<Edge>> Graph = new HashMap<Integer, ArrayList<Edge>>();
            
            for(int i = 0; i < M; i++){
                int x =  in.nextInt();
                int y =  in.nextInt();
                int r =  in.nextInt();
                
                ArrayList<Edge> xN = Graph.get(x);
                ArrayList<Edge> yN = Graph.get(y);
                
                if(xN == null){
                    xN = new ArrayList<Edge>();                   
                }
                
                if(yN == null){
                    yN = new ArrayList<Edge>();                  
                }
                
                xN.add(new Edge(y, r));
                yN.add(new Edge(x, r));
                
                Graph.put(x, xN);
                Graph.put(y, yN);
            }
            
            int source = in.nextInt();
            
           /*
            
            for(int i = 1; i < N; i++){
                ArrayList<Edge> node = Graph.get(i);
                for(Edge v : node){
                    log(i + " -> " + v.endpoint + ": " + v.distance);
                }
            }
            
            //*/
            Dijkstra(Graph, source, dist, prev);
            
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= N; i++){
                if(i != source){
                    if(dist[i] < Integer.MAX_VALUE)
                        sb.append(dist[i] + " ");
                    else
                        sb.append("-1 ");
                }
                    
            }
            
            System.out.println(sb.toString().trim());
            
        }
    }
    

/**
 * A class representing a Fibonacci heap.
 *
 * @param T The type of elements to store in the heap.
 * @author Keith Schwarz (htiek@cs.stanford.edu)
 *
 *  http://keithschwarz.com/interesting/code/?dir=fibonacci-heap
 */
public final static class FibonacciHeap<T> {

    public static final class Entry<T> {
        private int     mDegree = 0;       // Number of children
        private boolean mIsMarked = false; // Whether this node is marked

        private Entry<T> mNext;   // Next and previous elements in the list
        private Entry<T> mPrev;

        private Entry<T> mParent; // Parent in the tree, if any.

        private Entry<T> mChild;  // Child node, if any.

        private T      mElem;     // Element being stored here
        private double mPriority; // Its priority

        public T getValue() {
            return mElem;
        }

        public void setValue(T value) {
            mElem = value;
        }


        public double getPriority() {
            return mPriority;
        }

        private Entry(T elem, double priority) {
            mNext = mPrev = this;
            mElem = elem;
            mPriority = priority;
        }
    }

    private Entry<T> mMin = null;

    private int mSize = 0;

    public Entry<T> enqueue(T value, double priority) {
        checkPriority(priority);

        Entry<T> result = new Entry<T>(value, priority);

        mMin = mergeLists(mMin, result);

        ++mSize;

        return result;
    }

    public Entry<T> min() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return mMin;
    }

    public boolean isEmpty() {
        return mMin == null;
    }

    public int size() {
        return mSize;
    }

    public static <T> FibonacciHeap<T> merge(FibonacciHeap<T> one, FibonacciHeap<T> two) {
        FibonacciHeap<T> result = new FibonacciHeap<T>();

        result.mMin = mergeLists(one.mMin, two.mMin);

        result.mSize = one.mSize + two.mSize;

        one.mSize = two.mSize = 0;
        one.mMin  = null;
        two.mMin  = null;

        return result;
    }

    public Entry<T> dequeueMin() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");

        --mSize;

        Entry<T> minElem = mMin;

        if (mMin.mNext == mMin) { // Case one
            mMin = null;
        }
        else { // Case two
            mMin.mPrev.mNext = mMin.mNext;
            mMin.mNext.mPrev = mMin.mPrev;
            mMin = mMin.mNext; // Arbitrary element of the root list.
        }

        if (minElem.mChild != null) {
            /* Keep track of the first visited node. */
            Entry<?> curr = minElem.mChild;
            do {
                curr.mParent = null;
                curr = curr.mNext;
            } while (curr != minElem.mChild);
        }

        mMin = mergeLists(mMin, minElem.mChild);

        if (mMin == null) return minElem;

        List<Entry<T>> treeTable = new ArrayList<Entry<T>>();

        List<Entry<T>> toVisit = new ArrayList<Entry<T>>();

        for (Entry<T> curr = mMin; toVisit.isEmpty() || toVisit.get(0) != curr; curr = curr.mNext)
            toVisit.add(curr);

        for (Entry<T> curr: toVisit) {
            while (true) {
                while (curr.mDegree >= treeTable.size())
                    treeTable.add(null);

                if (treeTable.get(curr.mDegree) == null) {
                    treeTable.set(curr.mDegree, curr);
                    break;
                }

                Entry<T> other = treeTable.get(curr.mDegree);
                treeTable.set(curr.mDegree, null); // Clear the slot

                Entry<T> min = (other.mPriority < curr.mPriority)? other : curr;
                Entry<T> max = (other.mPriority < curr.mPriority)? curr  : other;

                max.mNext.mPrev = max.mPrev;
                max.mPrev.mNext = max.mNext;

                max.mNext = max.mPrev = max;
                min.mChild = mergeLists(min.mChild, max);
                
                max.mParent = min;

                max.mIsMarked = false;

                ++min.mDegree;

                curr = min;
            }

            if (curr.mPriority <= mMin.mPriority) mMin = curr;
        }
        return minElem;
    }

    public void decreaseKey(Entry<T> entry, double newPriority) {
        checkPriority(newPriority);
        if (newPriority > entry.mPriority)
            throw new IllegalArgumentException("New priority exceeds old.");

        decreaseKeyUnchecked(entry, newPriority);
    }

    public void delete(Entry<T> entry) {
        decreaseKeyUnchecked(entry, Double.NEGATIVE_INFINITY);
        dequeueMin();
    }

    private void checkPriority(double priority) {
        if (Double.isNaN(priority))
            throw new IllegalArgumentException(priority + " is invalid.");
    }

    private static <T> Entry<T> mergeLists(Entry<T> one, Entry<T> two) {

        if (one == null && two == null) { // Both null, resulting list is null.
            return null;
        }
        else if (one != null && two == null) { // Two is null, result is one.
            return one;
        }
        else if (one == null && two != null) { // One is null, result is two.
            return two;
        }
        else { // Both non-null; actually do the splice.
            Entry<T> oneNext = one.mNext; // Cache this since we're about to overwrite it.
            one.mNext = two.mNext;
            one.mNext.mPrev = one;
            two.mNext = oneNext;
            two.mNext.mPrev = two;

            return one.mPriority < two.mPriority? one : two;
        }
    }

    private void decreaseKeyUnchecked(Entry<T> entry, double priority) {
        entry.mPriority = priority;

        if (entry.mParent != null && entry.mPriority <= entry.mParent.mPriority)
            cutNode(entry);

        if (entry.mPriority <= mMin.mPriority)
            mMin = entry;
    }

    private void cutNode(Entry<T> entry) {
        entry.mIsMarked = false;

        if (entry.mParent == null) return;

        if (entry.mNext != entry) { // Has siblings
            entry.mNext.mPrev = entry.mPrev;
            entry.mPrev.mNext = entry.mNext;
        }

        if (entry.mParent.mChild == entry) {
            if (entry.mNext != entry) {
                entry.mParent.mChild = entry.mNext;
            }
            else {
                entry.mParent.mChild = null;
            }
        }
        --entry.mParent.mDegree;

        entry.mPrev = entry.mNext = entry;
        mMin = mergeLists(mMin, entry);

        if (entry.mParent.mIsMarked)
            cutNode(entry.mParent);
        else
            entry.mParent.mIsMarked = true;

        entry.mParent = null;
    }
}

}
