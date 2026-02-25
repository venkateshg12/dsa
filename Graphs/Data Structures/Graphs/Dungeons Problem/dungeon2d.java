import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class dungeon2d {
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] parts = read.readLine().trim().split(" ");
        int R = Integer.parseInt(parts[0]);
        int C = Integer.parseInt(parts[1]);

        if (R == 0 && C == 0) {
            System.out.println("-1");
        } else {
            char[][] map = new char[R][C];
            boolean[][] visited = new boolean[R][C];
            int startR = 0, startC = 0;

            for (int r = 0; r < R; r++) {
                String line = read.readLine();
                for (int c = 0; c < C; c++) {
                    map[r][c] = line.charAt(c);
                    if (map[r][c] == 'S') {
                        startR = r;
                        startC = c;
                    }
                }
            }

            int result = solve(map, visited, R, C, startR, startC);
            if (result == -1) {
                out.println("Trapped!");
            } else {
                out.println("Escaped in " + result + " minute(s).");
            }
        }

        out.flush();
        out.close();
        read.close();

    }

    public static int solve(char[][] map, boolean[][] visited, int R, int C, int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc, 0 });
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0], c = node[1], d = node[2];

            if (map[r][c] == 'E') {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
                        !visited[nr][nc] && map[nr][nc] != '#') {
                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc, d + 1 });
                }
            }
        }
        return -1;
    }
}