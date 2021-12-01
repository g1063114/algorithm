import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        String answer = "";
        String[] temp = new String[numbers.length];

        for( int i = 0 ; i < numbers.length; i++ ){
            temp[i] = numbers[i]+"";
        }

        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if(temp[0].equals("0")) return "0";

        for( String s : temp ){
            answer+=s;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[] numbers = {6,10,2};

        System.out.print(S.solution(numbers));
    }

}