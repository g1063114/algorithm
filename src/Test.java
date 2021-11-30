import java.util.*;

class Solution {
    class Pair{
        public int idx;
        public int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public int solution(int[] properties, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();

        for( int i = 0 ; i < properties.length; i++ ){
            queue.add(new Pair(i,properties[i]));
        }

        while(!queue.isEmpty()){
            int cur = queue.peek().val;
            boolean flag = false;
            for( Pair p : queue ){
                if(p.val > cur){
                    flag = true;
                    break;
                }
            }
            if( flag ){
                Pair temp = queue.poll();
                queue.add(temp);
            }else{
                answer++;
                Pair temp = queue.poll();
                if( temp.idx == location ){
                    return answer;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[] properties = {1,1,9,1,1,1,1};
        int location = 0;

        System.out.print(S.solution(properties,location));
    }

}