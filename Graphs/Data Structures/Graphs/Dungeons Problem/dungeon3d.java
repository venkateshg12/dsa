import java.io.*;
import java.util.*;

public class dungeon3d {
    static int[] dl = { 1, -1, 0, 0, 0, 0 };
    static int[] dr = { 0, 0, -1, 1, 0, 0 };
    static int[] dc = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        // int t = Integer.parseInt(read.readLine().trim());
        while (true) {
            String[] parts = read.readLine().trim().split(" ");
            int L = Integer.parseInt(parts[0]);
            int R = Integer.parseInt(parts[1]);
            int C = Integer.parseInt(parts[2]);

            if (L == 0 && R == 0 && C == 0)
                break;
            char[][][] map = new char[L][R][C];
            boolean[][][] visit = new boolean[L][R][C];

            int startL = 0, startR = 0, startC = 0;
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String line = read.readLine();
                    for (int c = 0; c < C; c++) {
                        map[l][r][c] = line.charAt(c);
                        if (map[l][r][c] == 'S') {
                            startL = l;
                            startR = r;
                            startC = c;
                        }
                    }
                }
                read.readLine();
            }
            int result = solve(map, visit, L, R, C, startL, startR, startC);
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

    public static int solve(char[][][] map, boolean[][][] visited, int L, int R, int C, int sl, int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sl, sr, sc, 0 });
        visited[sl][sr][sc] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int l = node[0], r = node[1], c = node[2], d = node[3];

            if (map[l][r][c] == 'E') {
                return d;
            }

            for (int i = 0; i < 6; i++) {
                int nl = l + dl[i];
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C &&
                        !visited[nl][nr][nc] && map[nl][nr][nc] != '#') {
                    visited[nl][nr][nc] = true;
                    q.add(new int[] { nl, nr, nc, d + 1 });
                }
            }
        }
        return -1;
    }
}