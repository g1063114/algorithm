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
    static int answer = 0;
    Queue<Pos> queue = new LinkedList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int n,m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        queue.add((new Pos(0,0,1)));
        maps[0][0] = 0;
        answer = BFS(0,0,maps);
        return answer;
    }

    public int BFS(int x, int y, int[][] map){
        while(!queue.isEmpty()){
            Pos temp = queue.poll();
            if( temp.x == m-1 && temp.y == n-1 ){
                return temp.cost;
            }
            for( int i = 0 ; i < 4; i++ ){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if( nx >= 0 && nx <m && ny >=0 && ny <n && map[ny][nx] != 0 ){
                    map[ny][nx] = 0;
                    queue.add(new Pos(nx,ny, temp.cost+1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[][] temp = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.print(S.solution(temp));
    }

}