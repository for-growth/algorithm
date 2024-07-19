package 덧칠하기;

public class younA {
    public static void findIdx(int n, int start, int end){

    }
    public static int solution(int n, int m, int[] section) {
        int count =0, i=0;
        for(;i<section.length;){
            int cur = section[i];
            int range= cur+m-1;
            count++;
            while(range>=section[i]){
                if(i>=section.length-1){
                    i++;
                    break;
                }
                i++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        solution(5,4,new int[]{1,3});
    }
}
