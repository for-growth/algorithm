import java.util.*;
import java.io.*;

public class PRG_모음사전 {
    static StringBuilder sb = new StringBuilder();
    static List<String> words = new ArrayList<>();
    static String[] vowels = {"A", "I", "E", "O", "U"};
    //static boolean isDone = false;

    public static void bt(String target){
        //if(isDone) return;
        if(sb.length() > 5){
            return;
        }
        //else if (sb.toString().equals(target)) {
            words.add(sb.toString());
      //      isDone = true;
        //    return;
        //}
        if(!sb.isEmpty()) {
            words.add(sb.toString());
        }


        for(int i = 0; i < 5; i++){
            sb.append(vowels[i]);
            bt(target);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static int solution(String word){
        bt(word);

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.compareTo(o2) == 0) {
                    return o1.length() - o2.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        System.out.println(words);
        System.out.println(words.size());
        int answer = 1;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("AAAE"));
    }
}
