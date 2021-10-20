import java.util.*;

class Edge implements Comparable<Edge>{
    public int v1;
    public int v2;
    public int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Main {
    static int[] arr;
    static int answer = 0;

    public static int Find(int v){
        if( v == arr[v] ) return v;
        else return arr[v] = Find(arr[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if( fa != fb ) arr[fa] = fb;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        arr = new int[n+1];
        List<Edge> temp = new ArrayList<>();

        for( int i = 1; i <= n; i++ ){
            arr[i] = i;
        }
        for( int i = 1 ; i <= m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            temp.add(new Edge(a,b,c));
        }
        Collections.sort(temp);
        for(Edge e : temp){
            int fv1 = Find(e.v1);
            int fv2 = Find(e.v2);
            if( fv1 != fv2 ){
                answer+= e.cost;
                Union(e.v1, e.v2);
            }
        }
        System.out.println(answer);
    }
}
