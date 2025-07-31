import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy ={-1,-1,0,1,1,1,0,-1};
    static int[] dx ={0,1,1,1,0,-1,-1,-1};
    static int w,h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            int[] size = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if(size[0]==0 && size[1]==0){
                break;
            }

            w = size[0];
            h = size[1];
            int count =0;

            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                String line = br.readLine();
                String[] parts = line.split(" ");
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(parts[j]);
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        visited[i][j] = true;
                        count++;
                        bfs(i,j);
                    }
                }
            }
        System.out.println(count);
        }
    }
    public static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y,x});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for(int i=0; i<8; i++){
                int ny = curY+dy[i];
                int nx = curX+dx[i];

                if(ny<0 || ny>=h || nx<0 || nx>=w) continue;

                if(map[ny][nx]==1 && !visited[ny][nx]){
                    queue.offer(new int[] {ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
