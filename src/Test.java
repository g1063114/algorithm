import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[prices.length];
        int time = 0;
        int idx = 0;
        for( int i = 0 ; i < prices.length; i++ ){
            queue.add(prices[i]);
        }

        while(!queue.isEmpty()){
            time = 0;
            for( int i = idx+1 ; i < prices.length; i++ ){
                if( queue.peek() <= prices[i] ){
                    time++;
                }else{
                    time++;
                    break;
                }
            }
            queue.poll();
            answer[idx] = time;
            idx++;
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution S = new Solution();

        int[] temp = new int[5];
        temp[0] = 1;
        temp[1] = 2;
        temp[2] = 3;
        temp[3] = 2;
        temp[4] = 3;
        System.out.print(S.solution(temp));
    }

}