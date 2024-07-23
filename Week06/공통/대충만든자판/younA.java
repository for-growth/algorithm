package 대충만든자판;
import java.util.*;

public class younA {
    public static int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        for(String s: keymap){
            char[] line = s.toCharArray();
            for(int i=0;i<line.length;i++){
                int cur = map.getOrDefault(line[i],-1);
                if(cur==-1 || i+1<cur){
                    map.put(line[i],i+1);
                }
            }
        }
        int[] answer = new int[targets.length];
        int idx = 0;
        for(String t: targets){
            char[] line = t.toCharArray();
            int total = 0;
            for(int i=0;i<line.length;i++){
                int num = map.getOrDefault(line[i],-1);
                if(num==-1){
                    answer[idx++] = -1;
                    total=-1;
                    break;
                }
                total+=num;
            }
            if(total!=-1)
                answer[idx++]= total;
        }
        return answer;
    }

    public static void main(String[] args) {
    }
}
