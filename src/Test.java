import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int idx = 1;
        for( int i = 32; i <=57; i++ ){
            map.put((char)i+"",idx);
            idx++;
        }

        boolean flag = false;
        for( int i = 0 ; i < msg.length(); i++ ){
            String temp = msg.charAt(i)+"";

            while(map.containsKey(temp)){
                i++;
                if( i == msg.length()){
                    flag = true;
                    break;
                }
                temp += msg.charAt(i);
            }
            if(flag){
                list.add(map.get(temp));
                break;
            }
            list.add(map.get(temp.substring(0,temp.length()-1)));
            map.put(temp,idx++);
            i--;
        }
        answer = new int[list.size()];
        for( int i = 0 ; i < list.size(); i++ ){
            answer[i] = list.get(i);
        }
        return answer;
    }
}