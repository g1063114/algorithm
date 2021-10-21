import java.util.*;

class Main{
    public List<String> solution(int n, String[] s){
        List<String> answer = new ArrayList<>();

        for( int i = 0 ; i < n; i++ ){
            String temp = new StringBuilder(s[i]).reverse().toString();
            answer.add(temp);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] arr = new String[n];
        for( int i = 0 ; i < n; i++ ){
            arr[i] = kb.next();
        }
        for( String x : T.solution(n,arr)){
            System.out.println(x);
        }
    }
}
