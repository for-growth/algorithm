package 카드뭉치;

public class younA {
    public static String remain(String[] remain, String[] goal, int rIdx, int gIdx){
        String answer ="Yes";
        while(rIdx<remain.length){
            if(!remain[rIdx++].equals(goal[gIdx++])){
                    answer="No";
                    return answer;
                }
            }
        return answer;
    }
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int i=0,j=0,g=0;
        String answer = "Yes";
        while(g<goal.length && i<cards1.length && j<cards2.length){
            if(cards1[i].equals(goal[g])){
                i++;
            }
           else if(cards2[j].equals(goal[g])){
                j++;
            }
           else{
               answer="No";
               return answer;
            }
            g++;
        }
        if(g>=goal.length){
            return answer;
        }
        if(i<cards1.length){
            answer = remain(cards1, goal, i,g);
        }
        if(j<cards2.length){
            answer = remain(cards2, goal, j,g);
        }
        return answer;
    }
    public static void main(String[] args) {
        String [] cards1 = new String[]{"show", "lot", "please", "the", "me"};
        String [] cards2 = new String[]{"money"};
       String ans= solution(cards1, cards2, new String[]{"show", "me", "the", "money"});
        System.out.println(ans);
    }
}
