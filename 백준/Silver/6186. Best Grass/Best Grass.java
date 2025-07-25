import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    static char[][] map;
    static boolean[][] visited;
    static int R,C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        int count = 0;
        map = new char[R][C];
        visited = new boolean[R][C];

        // 입력값을 char로 바꾸기
        for(int i=0; i<R; i++){
            String line = sc.nextLine();
            for(int j=0; j<C; j++){
                map[i][j]=line.charAt(j);
            }
        }

        // # 찾기
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]=='#' && !visited[i][j]){
                    bfs(i,j);
                    count++;
                    visited[i][j]=true;
                }
            }
        }
        System.out.print(count);
    }
    public static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int curY = now[0];
            int curX = now[1];

            for(int i=0; i<4; i++){
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if(ny<0 || ny>=R || nx<0 || nx>=C)
                    continue;

                if(map[ny][nx]=='#' && !visited[ny][nx]){
                    visited[ny][nx]=true;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
    }

}