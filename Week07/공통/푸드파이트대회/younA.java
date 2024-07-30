package 푸드파이트대회;

public class younA {
    public static String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<food.length;i++){
                int count = food[i]/2;
                sb.append(String.valueOf(i).repeat(count));
        }
        answer = sb+"0";
        return answer+sb.reverse();
    }
    public static void main(String[] args) {
            solution(new int[]{1,3,4,6});
    }

}
