import java.util.Arrays;

public class a_05_BackTrack_02 {
    public static void main(String[] args) {
        boolean[][] board = {{true, true, true},
                            {true, true, true},
                            {true ,true, true}};
        
        int[][] path = new int[board.length][board[0].length]; 
        
        allPathPrint(board, path, 0, 0, 1, " ");
    }

    public static void allPathPrint(boolean[][] maze, int[][] path, int r, int c,int step , String p) {
        if(r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]){
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length - 1) {
            allPathPrint(maze, path, r + 1 , c , step + 1, p +'D');
        }

        if(c < maze[0].length - 1) {
            allPathPrint(maze, path, r, c + 1, step + 1, p + 'R');
        }

        if (r > 0) {
            allPathPrint(maze, path, r - 1, c, step + 1, p + 'U');
        }

        if(c > 0) {
            allPathPrint(maze, path, r, c - 1, step + 1, p + 'L');
        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}