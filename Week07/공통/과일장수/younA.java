package 과일장수;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class younA {
    public static int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int cost=0;

        for(int i = score.length-m;i>=0;i-=m){
            cost =  cost+(score[i]*m);
        }
        return cost;
    }
    public static void main(String[] args) {
        int[]score=new int[]{1, 2, 3, 1, 2, 3, 1};
        int k=4;
        int m=4;
        solution(k,m,score);
    }
}
