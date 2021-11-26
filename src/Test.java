import java.util.*;

class Solution {
    static int answer=0;
    public int solution(int k, int[][] dungeons) {
        DFS(k,0,new boolean[dungeons.length],dungeons);
        return answer;
    }

    public void DFS(int k, int count, boolean[] visit, int[][] dungeons){
        if( count >= visit.length ){
            answer = count;
            return;
        }

        for( int i = 0 ; i < dungeons.length; i++ ){
            if( visit[i] ){
                continue;
            }
            if( k < dungeons[i][0]) {
                answer = Math.max(count,answer);
                continue;
            }
            visit[i] = true;
            DFS(k-dungeons[i][1],count+1,visit,dungeons);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution S = new Solution();

        int[][] temp = new int[3][2];
        temp[0][0] = 80;
        temp[0][1] = 20;
        temp[1][0] = 50;
        temp[1][1] = 40;
        temp[2][0] = 30;
        temp[2][1] = 10;
        System.out.print(S.solution(80,temp));
    }

}