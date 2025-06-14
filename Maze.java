import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
//        mazeSol("", 3, 3);

        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] path = new int[maze.length][maze[0].length];

        backtrackingWithPath("", maze, 0, 0, path, 1);

    }

    private static void mazeSol(String p ,int r, int c) {

        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            mazeSol(p + "V", r - 1, c);
        }

        if (c > 1) {
            mazeSol(p + "H", r, c - 1);
        }

        if (c > 1 && r > 1) {
            mazeSol(p + "D", r - 1, c - 1);
        }

    }

    private static void mazeSol(String p, boolean[][] maze, int r, int c) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r < maze.length - 1) {
            mazeSol("R" + p, maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            mazeSol("D" + p, maze, r, c + 1);
        }

    }

    private static void backtracking(String p, boolean[][] maze, int r, int c) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        if (r < maze.length - 1) {
            backtracking(p + "D", maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            backtracking(p + "R", maze, r, c + 1);
        }

        if (c > 0) {
            backtracking(p + "L", maze, r, c - 1);
        }

        if (r > 0) {
            backtracking(p + "U", maze, r - 1, c);
        }

        maze[r][c] = true;
    }


    private static void backtrackingWithPath(String p, boolean[][] maze, int r, int c, int[][] path, int step) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length - 1) {
            backtrackingWithPath(p + "D", maze, r + 1, c, path, step + 1);
        }

        if (c < maze[0].length - 1) {
            backtrackingWithPath(p + "R", maze, r, c + 1, path, step + 1);
        }

        if (c > 0) {
            backtrackingWithPath(p + "L", maze, r, c - 1, path, step + 1);
        }

        if (r > 0) {
            backtrackingWithPath(p + "U", maze, r - 1, c, path, step + 1);
        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}
