import java.util.*;

class Main{
    public char solution(int n, String s){
        char answer = ' ';
        HashMap<Character, Integer> temp = new HashMap<>();

        for( char x : s.toCharArray() ){
            temp.put(x, temp.getOrDefault(x,0) + 1);
        }
        int max = 0;
        for( char key : temp.keySet() ){
            if(temp.get(key) > max ){
                max = temp.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String s = kb.next();
        System.out.print(T.solution(n,s));
    }
}
