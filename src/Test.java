import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4","1","2"};

        while(n > 0){
            int rem = n % 3;
            n /= 3;

            if( rem == 0 ){
                n--;
            }

            answer = numbers[rem] + answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int n = 4;
        System.out.print(S.solution(n));
    }

}