package 두원사이의정수쌍;

public class younA {
    public static long solution(int r1, int r2) {
        long answer = 0;
        for(int y=1; y<=r2;y++){
            int x2 = (int)Math.sqrt(Math.pow(r2,2) - Math.pow(y,2));
            int x1 = (int)Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(y,2)));
            answer +=x2-x1+1;
        }
        return answer*4;
    }

    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;
        System.out.println(solution(r1,r2));
    }
}
