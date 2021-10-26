import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] chk = {0,0,0};
        int max = 0;
        int[][] temp = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        List<Integer> list = new ArrayList<>();

        for( int i = 0 ; i < answers.length; i++ ){
            if( temp[0][i%5] == answers[i] ){
                chk[0]++;
            }
            if( temp[1][i%8] == answers[i] ){
                chk[1]++;
            }
            if( temp[2][i%10] == answers[i] ){
                chk[2]++;
            }
        }
        Arrays.sort(chk);
        max = chk[2];

        for( int i = 0 ; i < chk.length; i++ ){
            if( max == chk[i] ){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];

        for( int i = 0 ; i < answer.length; i++ ){
            answer[i] = list.get(i);
        }

        return answer;
    }
}