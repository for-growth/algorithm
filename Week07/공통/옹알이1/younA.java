package 옹알이1;

public class younA {
    public static int solution(String[] babbling) {
        String [] words = new String[]{"aya", "ye","woo","ma"};
        int count=0;
        for(String babble: babbling){
            for(int i=0;i<words.length;i++){
               babble= babble.replaceAll(words[i]," ");
            }
            if(babble.replaceAll(" ","").equals("")){
                count++;
            }
        }
        System.out.print(count);

        return count;
    }
    public static void main(String[] args) {
        solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"});
    }
}
