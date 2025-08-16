// Ameer Hassan
// CS 114 Section 021
// Proffesor Johnatahn Kapleau 
// 07-17-24 

import java.io.File;
import java.util.Scanner;


public class Main {
   private static char[][] maze;
   private static int rows;
   private static int cols;
   
   public static void main(String[] args) {
    try {
        Scanner scan = new Scanner(new File("maze.dat"));
        rows = scan.nextInt();
        cols = scan.nextInt();
        scan.nextLine();

        maze = new char[rows][cols];
        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < rows; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < cols; j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == '+') {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        scan.close();

        if (solve(startRow, startCol)) {
            System.out.println("Maze solved!");
        } else {
            System.out.println("No solution found.");
        }

        printMaze();

    } catch (Exception e) {
        e.printStackTrace();
    }   
}


   private static boolean solve(int r, int c) {
    
    if (r < 0 || r >= rows || c < 0 || c >= cols) {
        return false;
    }

   
    if (maze[r][c] == '-') {
        return true;
    }

   
    if (maze[r][c] != ' ' && maze[r][c] != '+') {
        return false;
    }


    if (maze[r][c] != '+') {
        maze[r][c] = '.';
    }

    if (solve(r - 1, c))
         return true; 
    if (solve(r, c + 1)) 
        return true; 
    if (solve(r + 1, c)) 
        return true; 
    if (solve(r, c - 1)) 
        return true; 


    if(maze[r][c] != '+'){
        maze[r][c] = ' ';
    }

    return false;
   
}

private static void printMaze(){
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            System.out.print(maze[i][j]);
        }
        System.out.println();
    }
}

}


