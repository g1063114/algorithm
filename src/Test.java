import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for( int x : scoville ){
            pq.add(x);
        }

        while(pq.peek() < k){
            if(pq.size() < 2){
                return -1;
            }
            int temp1 = pq.poll();
            int temp2 = pq.poll();

            int newScoville = temp1 + temp2 * 2;
            pq.add(newScoville);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[] scoville = {1,2,3,9,10,12};
        int k = 7;
        System.out.print(S.solution(scoville,k));
    }

}