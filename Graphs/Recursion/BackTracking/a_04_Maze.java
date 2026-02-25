
// all the ways from (0,0) -----> respective path. only left and right such that there is a obstacle in the path (2,2)
public class a_04_Maze {
    public static void main(String[] args) {
        boolean[][] board = { { true, true, true, },
                { true, false, true },
                { true, true, true } };
        obstaclePath("", board, 0, 0);
    }

    public static void obstaclePath(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r < maze.length - 1) {
            obstaclePath(p + "D", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            obstaclePath(p + "R", maze, r, c + 1);
        }
    }
}
