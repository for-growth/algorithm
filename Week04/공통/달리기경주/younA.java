package 달리기경주;

import java.util.*;

public class younA {
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        answer= new String[players.length];

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int i =0;
        for(String p: players){
            list.add(p);
            map.put(p, i++);
        }
        for(String call: callings){
            int cur = map.get(call);
            String back = list.get(cur-1);
            map.put(call, cur-1);
            map.put(back,cur);

            list.set(cur-1, call);
            list.set(cur, back);
        }


        int idx =0;
        for(String name : list){
            answer[idx++] = name;
        }
        return answer;
    }
    public static void main(String[] args) {
        String [] players = {"mumu", "soe", "poe", "kai", "mine"};
        String [] callings = {"kai", "kai", "mine", "mine"};
        solution(players, callings);

    }
}
