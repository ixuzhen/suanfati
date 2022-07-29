import java.lang.reflect.AnnotatedArrayType;
import java.util.*;

public class Leetcode1094 {


    public boolean carPooling(int[][] trips, int capacity) {
        int[] sites = new int[1001];
        for (int[] trip: trips){
            sites[trip[1]] += trip[0];
            sites[trip[2]] -= trip[0];
        }
        int total = 0;
        for(int site : sites){
            total += site;
            if(total>capacity)
                return false;
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1] - t1[1];
            }
        });
        System.out.println(Arrays.deepToString(trips));
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[2]-t1[2];
            }
        });
        for (int[] trip : trips){
            pq.offer(trip);
            while(pq.peek()[2]<=trip[1]){
                capacity += pq.peek()[0];
                pq.poll();
            }
            if(trip[0]<=capacity){
                capacity -= trip[0];
            }else
                return false;

        }
        return true;
    }


    public boolean carPooling1(int[][] trips, int capacity) {
        int[][] sort_start = Arrays.copyOf(trips, trips.length);
        int[][] sort_end = trips;
        Leetcode1094.sort_arrays(sort_start, sort_end);
        int start = 0;
        int end = 0;
        while(start<trips.length){
            if(sort_start[start][1]<sort_end[end][2]){
                if(capacity>=sort_start[start][0]){
                    capacity -= sort_start[start][0];
                    start ++;
                }else
                    return false;
            }else if(sort_start[start][1]>sort_end[end][2]){
                capacity += sort_end[end][0];
                end++;
            }else{
                capacity = capacity - sort_start[start][0] + sort_end[end][0];
                start++;
                end++;
            }
        }
        return true;


    }

    public static void sort_arrays(int[][] sort_start, int[][] sort_end){
        Comparator<int[]> comparator_start = new Comparator<int[]>() {

            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1]-t2[1];
            }
        };
        Arrays.sort(sort_start, comparator_start);
        Arrays.sort(sort_end, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[2]-t2[2];
            }
        });
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {2,1,5},
                {3,5,7},

        };
        Leetcode1094 leetcode1094 = new Leetcode1094();
        boolean b = leetcode1094.carPooling(ints, 3);
        System.out.println(b);
    }

}
