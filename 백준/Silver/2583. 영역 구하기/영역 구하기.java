import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int h,w;

    static List<Integer> areaSizes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        h = Integer.parseInt(line[0]);
        w = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        map = new int[h][w];
        visited = new boolean[h][w];
        int count = 0;

        // 사각형 영역 표시
        for(int i=0; i<K; i++){
            String[] section = br.readLine().split(" ");
            int x1 = Integer.parseInt(section[0]);
            int y1 = Integer.parseInt(section[1]);
            int x2 = Integer.parseInt(section[2]);
            int y2 = Integer.parseInt(section[3]);

            for(int y = y1; y < y2; y++){
                for(int x = x1; x < x2; x++){
                    map[y][x] = 1;
                }
            }
        }

        for(int y=0; y<h; y++){
            for(int x=0; x<w; x++){
                if(!visited[y][x] && map[y][x] == 0){
                    visited[y][x] = true;
                    areaSizes.add(bfs(y,x));
                    count++;
                }
            }
        }
        Collections.sort(areaSizes);
        StringBuilder sb = new StringBuilder();
        for(int size : areaSizes){
            sb.append(size).append(" ");
        }

        System.out.println(count);
        System.out.println(sb.toString().trim());
    }

    public static int bfs(int y, int x){
        // 큐에 좌표 넣고 상하좌우 검증
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y,x});
        int size = 1;

        while (!queue.isEmpty()){
            // 해당 좌표의 상하좌우 검증
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for(int i=0; i<4; i++){
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if(ny<0 || ny>=h || nx<0 || nx>=w) continue;

                if(!visited[ny][nx] && map[ny][nx]==0){
                    visited[ny][nx] = true;
                    size++;
                    queue.offer(new int[] {ny,nx});
                }
            }
        }
        return size;

    }
}
