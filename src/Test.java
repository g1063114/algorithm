import java.util.*;

class Solution {
    boolean[] prime;
    public int solution(int n, int m) {
        int answer = 0;

        makePrime(m);
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for( int i = n; i <= m; i++){
            if(!prime[i]){
                sum+=i;
                if( min == Integer.MAX_VALUE ){
                    min = i;
                }
            }
        }
        if( sum == 0 ){
            return -1;
        }else{
            return sum;
        }
    }
    public void makePrime(int m){
        prime = new boolean[m+1];
        prime[0] = true;
        prime[1] = true;

        for( int i = 2; i <= Math.sqrt(m); i++){
            for( int j = i*i; j <m; j+=i ){
                prime[j] = true;
            }
        }
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int n = 60;
        int n2 = 100;
        System.out.print(S.solution(n,n2));
    }

}