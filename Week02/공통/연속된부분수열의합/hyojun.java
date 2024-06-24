package programmers;

/**
 * 앞선 배열이 존재하는지 확인하고 누적합 해주는 형식으로 풀어보자.
 */
public class lv2_연속된부분수열의합 {

    class Solution {
        public int[] solution(int[] sequence, int k) {
            int start = 0;
            int end = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int[] ans = new int[2];

            while(end<sequence.length && start<=end){
                if(start==end){
                    sum = sequence[start];
                }

                if(sum==k){
                    if(min>end-start){
                        min = end-start;
                        ans[0] = start;
                        ans[1] = end;
                    }

                    if(end+1<sequence.length){
                        sum += sequence[end+1];
                    }
                    end++;
                    if(start==end)break;
                }else if (sum >k){
                    sum -= sequence[start];
                    start++;
                }else if(sum <k){
                    if(end+1 < sequence.length){
                        sum += sequence[end+1];
                    }
                    end++;
                }
            }
            return ans;
        }
    }
}
