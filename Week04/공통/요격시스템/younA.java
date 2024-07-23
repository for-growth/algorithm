package 요격시스템;

import java.util.*;

class Missile{
    int start;
    int end;
    boolean checked;
    public Missile(int start, int end){
        this.start=start;
        this.end=end;
        checked = false;
    }
    public void print(){
        System.out.println(start+" "+end);
    }
}
public class younA {
    private static Missile[] missiles;

    public static void init(int[][] targets){
        missiles = new Missile[targets.length];
        int idx =0;
        for(int[] tmp : targets){
            missiles[idx++] = new Missile(tmp[0],tmp[1]);
        }
        Arrays.sort(missiles, new Comparator<Missile>() {
            @Override
            public int compare(Missile o1, Missile o2) {
                return o1.end-o2.end;
            }
        });
    }
    public static int solution(int[][] targets) {
        init(targets);
        int count=0;
        for(int i=0;i<missiles.length;){
            Missile current= missiles[i];
            count++;
            int next = i+1;
            for(;next<missiles.length;next++){
                if(missiles[next].start<current.end){
                    missiles[next].checked=true;
                }
                else break;
            }
            i=next;
        }
        return count;
    }

    public static void main(String[] args) {
        int [][]targets = new int[][]{
                {4,5},
                {4,8},
                {10,14},
                {11,13},
                {5,12},
                {3,7},
                {1,4}
                };
        solution(targets);
    }
}
