import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer>[] people;
    static boolean[] visited;
    static int answer = -1;
    static int targetA,targetB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] targetLine = br.readLine().split(" ");
        targetA = Integer.parseInt(targetLine[0]);
        targetB = Integer.parseInt(targetLine[1]);
        int m = Integer.parseInt(br.readLine());

        // n 크기의 배열
         people = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            people[i] = new ArrayList<>();
        }


        for(int i=0; i<m; i++){
            String[] relationship = br.readLine().split(" ");
            int x = Integer.parseInt(relationship[0]);
            int y = Integer.parseInt(relationship[1]);

            people[x].add(y);
            people[y].add(x);
        }
        dfs(targetA , 0);

        System.out.println(answer);
    }
    public static void dfs(int node, int depth){
        visited[node] = true;

        if(node == targetB){
            answer = depth;
            return;
        }

        for(int next: people[node]){
            if(!visited[next]){
                dfs(next,depth+1);
            }
        }

    }
}
