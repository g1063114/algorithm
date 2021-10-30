import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        HashMap<Integer, Integer> temp = new HashMap<>();

        for( int i = 0 ; i < 10; i++ ){
            temp.put(i,1);
        }

        for( int i = 0 ; i < numbers.length; i++ ){
            temp.put(numbers[i], temp.getOrDefault(numbers[i],0)-1);
        }

        for( int key : temp.keySet() ){
            if( temp.get(key) == 1){
                answer+=key;
            }
        }
        return answer;
    }
}