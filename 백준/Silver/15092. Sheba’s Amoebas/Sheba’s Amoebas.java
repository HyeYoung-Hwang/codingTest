import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int R,C;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        map = new char[R][C];
        visited = new boolean[R][C];
        int count = 0;

        for(int i=0; i<R; i++){
            String line = sc.nextLine();
            for(int j=0; j<C; j++){
                map[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]=='#' && !visited[i][j]){
                    count++;
                    bfs(i,j);
                    visited[i][j]=true;
                }
            }
        }
        System.out.print(count);
    }
    public static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y,x});

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int curY = now[0];
            int curX = now[1];

            for(int i=0; i<8; i++){
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if(ny<0 || ny>=R || nx<0 || nx>=C)continue;

                if(map[ny][nx] == '#' && !visited[ny][nx]){
                    visited[ny][nx]=true;
                    queue.offer(new int[]{ny,nx});
                }
            }
        }
    }
}
