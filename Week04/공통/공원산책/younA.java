package 공원산책;

import java.util.StringTokenizer;

public class younA {

    //private static char[][] parkArr;
    /** solve 1
    public static boolean checkOutOfBound(String dir, int step, int[] current){
        switch (dir) {
            case "E":
                if (current[1] + step >= parkArr[0].length) {
                    return false;
                }
                break;
            case "W":
                if (current[1] - step < 0) {
                    return false;
                }
                break;
            case "S":
                if (current[0] + step >= parkArr.length) {
                    return false;
                }
                break;
            case "N":
                if (current[0] - step < 0) {
                    return false;
                }
                break;
        }
        return true;
    }
    public static int[] move(String dir, int step, int[] current){
        int c_row = current[0];
        int c_col = current[1];

        if(dir.equals("E")){
            for(;c_col<current[1]+step;c_col++){
                if(parkArr[c_row][c_col]=='X'){ return new int[]{-1,-1};}
            }
        }
        else if(dir.equals("W")){
            for(;c_col>current[1]-step;c_col--){
                if(parkArr[c_row][c_col]=='X'){return new int[]{-1,-1};};
            }
        }
        else if(dir.equals("S")){
            for(;c_row<current[0]+step;c_row++){
                if(parkArr[c_row][c_col]=='X'){ return new int[]{-1,-1};}
            }
        }
        else{
            for(;c_row>current[0]-step;c_row--){
                if(parkArr[c_row][c_col]=='X'){return new int[]{-1,-1};};
            }
        }

        return new int[]{c_row, c_col};

    }
    public static int[] checkDirValid(String route, int[] current){
        StringTokenizer st = new StringTokenizer(route);

        String dir = st.nextToken();
        int step = Integer.parseInt(st.nextToken());
        if(checkOutOfBound(dir, step, current)){
           return move(dir, step, current);
        }

        return new int[]{-1,-1};

    }
    public static int[] findStart(String[] park){
        int row =0;

        for(String str: park) {
            char[] arr = str.toCharArray();
            for(int col=0;col<arr.length;col++){
                if(arr[col]=='S'){
                    return new int[]{row,col};
                }
            }
            row++;
        }
        return new int[]{};
    }
    public static void strTochar(String[] park){

        parkArr = new char[park.length][];
        int  row=0, col=0;

        for(String strPark: park){
            for(char charPark : strPark.toCharArray()){
                parkArr[row][col]= charPark;
                col++;
            }
            row++;
        }
    }
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int [2];
        int[] start = findStart(park);
        strTochar(park);

        for(String route: routes){
            if(checkDirValid(route, start)[0]!=-1){

            }
            else continue;
        }

        return answer;
    }
     */

    private static char[][] matrix;
    public static int[] parkTomatrix(String[] park){
        int row=0, col;
        matrix = new char[park.length][park[0].length()];

        int [] start = new int[2];
        for(String n: park){
            col=0;
            for(char tmp : n.toCharArray()){
                matrix[row][col] = tmp;
                if(tmp  == 'S'){
                    start[0] = row;
                    start[1] = col;
                }
                col++;
            }
            row++;
        }

        return start;
    }

    public static int[] move(String route, int[] current){
        StringTokenizer st = new StringTokenizer(route);

        String dir = st.nextToken();
        int step = Integer.parseInt(st.nextToken());

        int c_row = current[0];
        int c_col= current[1];
        int [] res = new int[]{-1,-1};
        if(dir.equals("E")){
            if(c_col+step >= matrix[0].length){ return res;}
            for(;c_col<=current[1]+step;c_col++){
                if(matrix[c_row][c_col]=='X'){return res;}
            }
            c_col-=1;
        }
        else if(dir.equals("W")){
            if(c_col-step < 0){ return res;}
            for(;c_col>=current[1]-step;c_col--){
                if(matrix[c_row][c_col]=='X'){return res;}
            }
            c_col+=1;
        }
        else if(dir.equals("S")){
            if(c_row+step >= matrix.length){ return res;}
            for(;c_row<=current[0]+step;c_row++){
                if(matrix[c_row][c_col]=='X'){return res;}
            }
            c_row-=1;
        }
        else {
            if(c_row-step < 0){ return res;}
            for(;c_row>=current[0]-step;c_row--){
                if(matrix[c_row][c_col]=='X'){return res;}
            }
            c_row+=1;
        }

        res[0]=c_row;
        res[1]=c_col;

        return res;
    }

    public static int[] solution(String[] park, String[] routes) {
       int [] current =  parkTomatrix(park);
        for(String route: routes){
           int[] res =  move(route,current);
           if(res[0] != -1){
               current=res;
           }
        }
        return current;
    }

    public static void main(String[] args) {
        String [] park = {"SOO","OXX","OOO"};
        String [] routes = {"E 2","S 2","W 1"};



        solution(park, routes);


    }
}
