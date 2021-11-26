import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder temp = new StringBuilder();
        int index = 0;
        int max = Integer.MIN_VALUE;
        for( int i = 0 ; i < number.length() - k; i++ ){
            max = 0;
            for(int j = index; j < k+i; j++ ){
                if(max < number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            temp.append(max);
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        Solution S = new Solution();

        String number = "4177252841";
        System.out.print(S.solution(number,4));
    }

}