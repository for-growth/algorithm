package 추억점수;

import java.util.HashMap;
import java.util.Map;

public class younA {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        int idx =0;
        for(int n: yearning){
            map.put(name[idx++], n);
        }

        idx =0;
        for(String[] part: photo){
            int total = 0;
            for(String p: part){
                total+=map.getOrDefault(p, 0);
            }
            answer[idx++] =  total;
        }

        return answer;
    }
    public static void main(String[] args) {
        String [] name ={"kali", "mari", "don"};
        int [] yearning ={11, 1, 55};

        String[][]photo = {
                {"kali", "mari", "don"},
                {"pony", "tom", "teddy"},
                {"con", "mona", "don"}
        };

        solution(name, yearning, photo);



    }
}
