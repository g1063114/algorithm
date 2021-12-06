import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] prime = new boolean[m+1];

        checkPrime(prime);

        for( int i = n; i <= m; i++ ){
            if( !prime[i] ){
                System.out.println(i);
            }
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