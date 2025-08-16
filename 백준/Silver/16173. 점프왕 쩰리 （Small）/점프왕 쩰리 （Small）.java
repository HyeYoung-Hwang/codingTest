import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        String answer = bfs();
        System.out.println(answer);
    }

    public static String bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            int moves = map[curY][curX];

            if(moves ==-1)
                return "HaruHaru";
            
            if(moves == 0)break;

            if(curY + moves < N){
                queue.offer(new int[] {curY+moves, curX});
            }
            if(curX + moves < N){
                queue.offer(new int[] {curY, curX + moves});
            }
        }
        return "Hing";
    }
}
