import java.util.*;

class Solution {
    static int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        boolean[] chk = new boolean[n];
        for( int i = 0 ; i < n; i++ ){
            if(!chk[i]){
                DFS(computers, i, chk);
                answer++;
            }
        }
        return answer;
    }

    public boolean[] DFS(int[][] computers, int idx, boolean[] chk){
        chk[idx] = true;

        for(int i = 0 ; i < computers.length; i++ ){
            if( idx != i && computers[idx][i] == 1 && chk[i] == false ){
                chk = DFS(computers, i, chk);
            }
        }
        return chk;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.print(S.solution(n,computers));
    }

}