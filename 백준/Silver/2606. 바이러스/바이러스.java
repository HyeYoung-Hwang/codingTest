import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalComputer = Integer.parseInt(br.readLine());
        int connectionNum = Integer.parseInt(br.readLine());

        graph = new ArrayList[totalComputer + 1];
        visited = new boolean[totalComputer + 1];

        for(int i=1; i<=totalComputer; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<connectionNum; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        System.out.print(count-1);
    }

    public static void dfs(int node){
        visited[node]=true;
        count++;

        for(int next : graph[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
