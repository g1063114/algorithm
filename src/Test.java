import java.util.*;

class Solution {
    static boolean[] chk = new boolean[7];
    static int answer;
    static List<Integer> list = new ArrayList<>();

    public int solution(String number) {
        String temp = "";

        for( int i = 0 ; i < number.length(); i++ ){
            rec(number,temp,i);
        }

        for( int x : list ){
            isPrime(x);
        }
        return answer;
    }

    public static void rec(String n, String temp, int len){
        if( temp.length() == len ){
            if(!list.contains(Integer.parseInt(temp))){
                list.add(Integer.parseInt(temp));
                return;
            }
        }

        for( int i = 0; i < n.length(); i++ ){
            if(chk[i]) continue;
            temp += n.charAt(i);
            chk[i] = true;
            rec(n, temp, len);
            chk[i] = false;
            temp = temp.substring(0,temp.length()-1);
        }
    }

    public static void isPrime(int n){
        if( n == 0 ) return;
        if( n == 1 ) return;

        for( int i = 2; i < Math.sqrt(n); i++ ){
            if( n % i == 0) return;
        }
        answer++;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        String number = "011";
        System.out.print(S.solution(number));
    }

}