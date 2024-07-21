package 크기가작은부분문자열;

public class younA {
    public static int solution(String t, String p) {
        int range = p.length();
        char [] pp = p.toCharArray();
        int count =0;

        for(int i=0;i<t.length()-range+1;i++){
            if(t.substring(i,i+range).equals(p)){
                count++;
                continue;
            }

            char[] current= t.substring(i,i+range)
                                .toCharArray();

            int idx =0;
            for(;idx<range;idx++){
              if(current[idx]<pp[idx]){
                  count++;
                  break;
              }
              else if(current[idx]>pp[idx]){
                  idx = range+1;
              }
            }
        }

        System.out.println(count);
            return count;
    }
    public static void main(String[] args) {
        String t = "10203";
        String p = "15";
        solution(t,p);
    }
}
