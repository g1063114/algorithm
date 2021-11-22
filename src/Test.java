import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int curX = 0, curY = 0;
        HashSet<String> temp = new HashSet<>();

        for( int i = 0 ; i < dirs.length(); i++ ){
            String path = "";
            int nextX = curX;
            int nextY = curY;

            if(dirs.charAt(i) == 'U'){
                nextY++;
                path += curX;
                path += curY;
                path += nextX;
                path += nextY;
            }else if(dirs.charAt(i) == 'D'){
                nextY--;
                path += nextX;
                path += nextY;
                path += curX;
                path += curY;
            }else if(dirs.charAt(i) == 'L'){
                nextX--;
                path += curX;
                path += curY;
                path += nextX;
                path += nextY;
            }else{
                nextX++;
                path += nextX;
                path += nextY;
                path += curX;
                path += curY;
            }
            if( nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5){
                continue;
            }
            temp.add(path);
            curX = nextX;
            curY = nextY;
        }
        answer = temp.size();
        return answer;
    }

}