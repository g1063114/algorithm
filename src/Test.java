import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> temp = new HashMap<>();

        for( int i = 0 ; i < participant.length; i++ ){
            temp.put(participant[i], temp.getOrDefault(participant[i],0)+1);
        }

        for( int i = 0 ; i < completion.length; i++ ){
            temp.put(completion[i], temp.getOrDefault(completion[i],0) -1);
        }

        for(String key : temp.keySet()){
            if(temp.get(key) == 1){
                return key;
            }
        }
        return "";
    }
}