import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if( Math.pow(c,2) == Math.pow(a,2) + Math.pow(b,2) ){
            System.out.println("right");
        }else{
            System.out.println("wrong");
        }
    }
}