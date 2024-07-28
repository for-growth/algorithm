import java.util.HashMap;

public class PGR_131127 {
    static class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;

            HashMap<String, Integer> target = new HashMap<>();
            HashMap<String, Integer> current = new HashMap<>();

            int numberSum = 0;
            for(int num: number){
                numberSum += num;
            }

            int left = 0;
            boolean found = true;
            int right = numberSum-1;

            for (int i = 0; i < want.length; i++) {
                target.put(want[i], number[i]);
            }

            for (int i = 0; i < numberSum; i++) {
                if(!current.containsKey(discount[i])){
                    current.put(discount[i], 1);
                } else{
                    current.put(discount[i], current.get(discount[i]) + 1);
                }
            }



            while(right < discount.length) {
                for(String key:target.keySet()){
                    if(!current.containsKey(key)){
                        found = false;
                        break;
                    } else if (current.get(key) < target.get(key)) {
                        found = false;
                        break;
                    }
                }
                if(found){
                    answer += 1;
                }


                current.put(discount[left], current.get(discount[left]) - 1);
                left++;
                right++;
                if(right == discount.length){ break; }
                if(!current.containsKey(discount[right])){
                    current.put(discount[right], 1);
                } else {
                    current.put(discount[right], current.get(discount[right]) + 1);
                }
                found = true;
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] nubmer1 = {3, 2, 2, 2, 1};
        String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        Solution solution = new Solution();
        System.out.println(solution.solution(want1, nubmer1, discount1));

        String[] want2 = {"apple"};
        int[] nubmer2 = {10};
        String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        System.out.println(solution.solution(want2, nubmer2, discount2));
    }
}
