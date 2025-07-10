/* write a problem to show all respective paths including up , down , right , left every direction as well */

public class a_05_BackTrack_01 {
    public static void main(String[] args) {
        boolean[][] board = { { true, true, true, },
                { true, true, true },
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
        maze[r][c] = false;

        if (r < maze.length - 1) {
            obstaclePath(p + "D", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            obstaclePath(p + "R", maze, r, c + 1);
        }

        if (r > 0) {
            obstaclePath(p + "U", maze, r - 1, c);
        }

        if (c > 0) {
            obstaclePath(p + "D", maze, r, c - 1);
        }
        // This line is where the function will be over.
        // so before the function gets removed , also remove the changes that were made
        // by that function.

        maze[r][c] = true;
    }
}
