import java.util.*;

class Solution {
    class Pos{
        public int x;
        public int y;
        public int cost;

        public Pos(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][][] chk;
    static int answer;
    static Queue<Pos> queue = new LinkedList<>();

    public int solution(int[][] board, int c) {
        chk = new boolean[board.length][board[0].length][2];
        for( int i = 0 ; i < board.length; i++ ){
            for( int j = 0 ; j < board[i].length; j++ ){
                if( board[i][j] == 2 ){
                    chk[i][j][0] = true;
                    queue.add(new Pos(j,i,0));
                }
            }
        }
        BFS(board,c,0,chk);
        return answer;
    }

    public void BFS(int[][] board, int c, int sum, boolean[][][] chk){
        int desX = 0, desY = 0;
        for( int i = 0 ; i < board.length; i++ ){
            for( int j = 0 ; j < board[0].length; j++ ){
                if( board[i][j] == 3 ){
                    desX = j;
                    desY = i;
                }
            }
        }

        while(!queue.isEmpty()){
            Pos temp = queue.poll();
            int cost = temp.cost;
            int min = Integer.MAX_VALUE;

            if( temp.x == desX && temp.y == desY ) {
                if( min > cost ){
                    min = cost;
                    answer = min;
                }
            }
            for( int i = 0 ; i < 4; i++ ){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if( nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length && chk[ny][nx][0] != true ){
                        if(board[ny][nx] == 0 || chk[ny][nx][1] == true){
                            queue.add(new Pos(nx,ny, cost+1));
                            chk[ny][nx][0] = true;
                            temp.cost -= 1;
                        }else if(board[ny][nx] == 1){
                            temp.cost = cost + 1 + c;
                            queue.add(new Pos(nx,ny, temp.cost));
                            chk[ny][nx][1] = true;
                            temp.cost -= c;
                        }else{
                            queue.add(new Pos(nx,ny, cost+1));
                        }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[][] board = {{0,0,0,0,2,0,0,0,0,0},{0,0,1,1,1,1,1,0,0,0},{0,0,1,1,1,1,1,1,0,0},{0,0,1,1,1,1,1,0,1,0},{0,0,1,1,1,1,1,0,0,0},{0,0,0,0,3,0,0,0,1,0}};
        int c = 2;
        System.out.print(S.solution(board, c));
    }

}