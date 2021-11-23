import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n!=0){
            if( n % 2 == 0 ){
                n /= 2;
            }else{
                n--;
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution S = new Solution();

        System.out.print(S.solution(5000));
    }

}