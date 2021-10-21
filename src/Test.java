import java.util.*;

class Brick implements Comparable<Brick>{

    public int s;
    public int h;
    public int w;

    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}

class Main {
    static int[] dy;

    public static int solution(List<Brick> arr){
        int answer = 0 ;
        Collections.sort(arr);
        dy[0] = arr.get(0).h;
        answer = dy[0];

        for( int i = 1 ; i < arr.size(); i++ ){
            int max = 0;
            for( int j = i - 1; j >=0; j--){
                if(arr.get(j).w > arr.get(i).w && dy[j] > max){
                    max = dy[j];
                }
            }
            dy[i] = max + arr.get(i).h;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<Brick> arr = new ArrayList<>();
        dy = new int[n];

        for( int i = 0 ; i < n; i++ ){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Brick(a,b,c));
        }
        System.out.println(solution(arr));
    }
}
