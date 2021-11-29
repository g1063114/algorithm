import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for( int i = 0; i < clothes.length; i++ ){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }

        if( map.size() > 1 ){
            for( String key : map.keySet() ){
                answer *= map.get(key)+1;
            }
        }else{
            answer = clothes.length;
        }
        return answer-1;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        String[][] temp = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.print(S.solution(temp));
    }

}