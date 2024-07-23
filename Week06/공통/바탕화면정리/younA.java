package 바탕화면정리;

public class younA {
    public static int[] solution(String[] wallpaper) {
        int srow = Integer.MAX_VALUE;
        int scol = Integer.MAX_VALUE;
        int erow = Integer.MIN_VALUE;
        int ecol = Integer.MIN_VALUE;
        int row =0;
        for(String str: wallpaper){
            char[]  line= str.toCharArray();
            for(int col=0;col<line.length;col++){
                if(line[col]=='#'){
                  if(row<srow){
                      srow = row;
                  }
                  if(col<scol){
                      scol = col;
                  }
                  if(col>ecol){
                      ecol=col;
                  }
                  if(row>erow){
                      erow=row;
                  }
                }
            }
            row++;
        }
        int[] answer = {srow,scol,erow+1,ecol+1};
        return answer;
    }
    public static void main(String[] args) {
        solution(new String[]{
                "..........", ".....#....", "......##..", "...##.....", "....#....."
        });


    }
}
