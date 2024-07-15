import java.util.*;
import java.io.*;


public class BOJ_1316 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreanReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreanWriter(System.out));
        int rpt = Integer.paresInt(br.readline());
        int answer = 0;

         for(int r = 0; r < rpt; r++) {
             String word = br.readLine();
             int left = 0;
             int right = 0;
             Map<Char, Integer> store = new TreeMap()<>;
             while(right < word.length()) {
                 char ch = word.charAt(left);

                 if(!store.containsKey(ch)) {
                     store.put(ch, 1);
                 }
                 while(right < word.length() && word.charAt(right) == ch) {
                     right += 1;
                     store.put(ch, store.get(ch) + 1);
                 }
             }
         }
    }
}