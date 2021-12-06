import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] prime = new boolean[10001];

        int n = sc.nextInt();

        checkPrime(prime);
        for( int i = 0 ; i < n; i++ ){
            int t = sc.nextInt();
            int left = t / 2;
            int right = t / 2;

            while(true){
                if(!prime[left] && !prime[right]){
                    System.out.println(left + " " + right);
                    break;
                }
                left--;
                right++;
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