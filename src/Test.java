import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] prime = new boolean[246913];

        while(true){
            int n = sc.nextInt();
            if( n == 0 ) break;
            int cnt = 0;
            checkPrime(prime);

            for( int i = n ; i <= 2*n; i++ ){
                if( !prime[i] ){
                    cnt++;
                }
            }
            System.out.println("cnt = " + cnt);
        }
    }

    public static void checkPrime(boolean[] prime){
        prime[0] = true;
        prime[1] = true;

        for( int i = 2; i < Math.sqrt(prime.length); i++ ){
            if( prime[i] ) continue;
            for( int j = i*i; j < prime.length; j+=i ){
                prime[j] = true;
            }
        }
    }
}