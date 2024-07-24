package 기사단원의무기;

public class younA {
    private static int [] dp;
    public static int findDivisor(int num, int limit){
        int sqrt = (int)Math.sqrt(num);
        int count=1;
        for(int i=1;i<=sqrt;i++){
            if(num%i==0){
                count++;
                if(num/i!=i){
                    count++;
                }
            }
            if(limit<count){return -1;}
        }
        return count;
    }
    public static int solution(int number, int limit, int power) {
        dp = new int[number+1];
        int total =0;
        for(int i=1;i<=number;i++){
            int divisor = findDivisor(i,limit);
            dp[i] = divisor>0?divisor:power;

            total+=dp[i];
        }
        System.out.println(total);
        int answer = 0;
        return answer;
    }
    public static void main(String[] args) {
        int number = 100000;
        int limit =100;
        int power =50;
        solution(number,limit,power);
    }
}
