package 둘만의암호;

public class younA {
    public static String solution(String s, String skip, int index) {
        String al = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<skip.length();i++){
          al=  al.replace(skip.charAt(i), ' ');
        }
        al = al.replaceAll(" ","");

        char [] res = s.toCharArray();
        for(int i=0;i<res.length;i++){
            int cidx =  (al.indexOf(res[i])+index)%al.length();
            res[i] = al.charAt(cidx);
        }

        return String.copyValueOf(res);
    }
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index =5;
        solution(s,skip,index);
    }
}
