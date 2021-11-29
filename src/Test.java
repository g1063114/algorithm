import java.util.*;

class Solution {
    public int[] solution(String[] genre, int[] plays) {
        List<Integer> temp = new ArrayList<>();
        int[] answer = {};
        HashMap<String,Integer> map = new HashMap<>();

        for( int i = 0; i < genre.length; i++ ){
            map.put(genre[i],map.getOrDefault(genre[i],0)+plays[i]);
        }
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, ((o1, o2) -> map.get(o2).compareTo(map.get(o1))));

        for( String key : map.keySet() ){
            HashMap<Integer,Integer> intMap = new HashMap<>();
            for( int i = 0 ; i < genre.length; i++ ){
                if(key.equals(genre[i])){
                    intMap.put(i,plays[i]);
                }
            }
            List<Integer> intKeyList = new ArrayList<>(intMap.keySet());
            Collections.sort(intKeyList, (o1, o2) -> intMap.get(o2).compareTo(intMap.get(o1)));
            for( int x : intKeyList ){
                temp.add(x);
            }
        }

        answer = new int[temp.size()];

        for(int i = 0 ; i < temp.size(); i++ ){
            answer[i] = temp.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        String[] genre = {"classic","pop","classic","classic","pop"};
        int[] plays = {500,600,150,800,2500};

        System.out.print(S.solution(genre,plays));
    }

}