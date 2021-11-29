import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        int sum_weight = 0;

        for( int i = 0 ; i < truck_weights.length; i++ ){
            int truck = truck_weights[i];

            while(true){
                if(queue.isEmpty()){
                    queue.add(truck);
                    sum_weight += truck;
                    answer++;
                    break;
                }else if( queue.size() == bridge_length ){
                    sum_weight -= queue.poll();
                }else{
                    if( sum_weight + truck <= weight ){
                        queue.add(truck);
                        sum_weight += truck;
                        answer++;
                         break;
                    }else{
                        queue.add(0);
                        answer++;
                    }
                }
            }
        }
        return answer + bridge_length;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[] temp = new int[4];
        temp[0] = 7;
        temp[1] = 4;
        temp[2] = 5;
        temp[3] = 6;
        System.out.print(S.solution(2,10, temp));
    }

}