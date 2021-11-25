import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> temp = new ArrayList<>();
        int num = 0;
        int seq = 0;
        boolean flag = true;

        for( int i = 0; i < words.length; i++ ){
            if(temp.contains(words[i])){
                num = i % n + 1;
                seq = i / n + 1;
                flag = false;
                break;
            }
            temp.add(words[i]);

            if( words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) ){
                num = i % n + 1;
                seq = i / n + 1;
                flag = false;
                break;
            }
        }
        answer[0] = num;
        answer[1] = seq;
        if( flag ){
            return new int[]{0,0};
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution S = new Solution();

        String[] temp = new String[7];
        temp[0] = "hello";
        temp[1] = "one";
        temp[2] = "even";
        temp[3] = "never";
        temp[4] = "now";
        temp[5] = "world";
        temp[6] = "draw";
        System.out.print(S.solution(2,temp));
    }

}