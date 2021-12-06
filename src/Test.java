import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int minX = Math.min(x-0, w-x);
        int minY = Math.min(y-0, h-y);

        System.out.println(Math.min(minX,minY));
    }
}