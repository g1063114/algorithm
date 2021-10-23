import java.util.*;

class Edge implements Comparable<Edge>{

    public int vertex;
    public int cost;

    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Main{
    static int n,m;
    static List<List<Edge>> graph;
    static int[] dis;

    public void solution(int n){
        PriorityQueue<Edge> temp = new PriorityQueue<>();
        temp.offer(new Edge(n,0));
        dis[n] = 0;

        while(!temp.isEmpty()){
            Edge tmp = temp.poll();
            int nV = tmp.vertex;
            int nC = tmp.cost;
            if(nC > dis[nV]) continue;
            for( Edge e : graph.get(nV) ){
                if( dis[e.vertex] > nC + e.cost ){
                    dis[e.vertex] = nC + e.cost;
                    temp.offer(new Edge(e.vertex, nC + e.cost));
                }
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<List<Edge>>();
        for(int i = 0 ; i < n; i++ ){
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for( int i = 0 ; i < m; i++ ){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        T.solution(1);
        for( int i = 2; i <= n; i++ ){
            if(dis[i] != Integer.MAX_VALUE){
                System.out.println(i + " : " + dis[i]);
            }else{
                System.out.println(i + " : impossible");
            }
        }
    }
}
