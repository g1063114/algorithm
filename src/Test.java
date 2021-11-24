import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int min = 0;
        Arrays.sort(people);

        for( int max = people.length-1; min <= max; max--){
            if( people[min] + people[max] <= limit ){
                min++;
            }
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution S = new Solution();

        int[] temp = new int[4];
        temp[0] = 70;
        temp[1] = 50;
        temp[2] = 80;
        temp[3] = 50;
        System.out.print(S.solution(temp,100));
    }

}