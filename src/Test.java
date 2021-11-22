import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "None";
        int maxDur = -1;

        for( int i = 0 ; i < musicinfos.length; i++ ){
            String[] temp = musicinfos[i].split(",");
            String[] time = temp[0].split(":");
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            time = temp[1].split(":");
            int end = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int dur = end - start;
            String title = temp[2];
            String code = change(temp[3]);

            if( dur > code.length() ) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < dur / code.length(); j++) {
                    builder.append(code);
                }
                builder.append(code.substring(0, dur % code.length()));
                code = builder.toString();
            }else{
                code = code.substring(0,dur);
            }
            if(code.contains(m) && dur > maxDur){
                answer = title;
                maxDur = dur;
            }
        }
        return answer;
    }
    public String change(String s){
        s.replaceAll("C#","H");
        s.replaceAll("D#","I");
        s.replaceAll("F#","J");
        s.replaceAll("G#","K");
        String str = s.replaceAll("A#","L");

        return str;
    }
}