import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename) throws FileNotFoundException {
    File file = new File(filename);
    Scanner scanner = new Scanner(file);
    String line = scanner.nextLine();
    String[] variables = line.split(" ", -2);
    int depth = 0;
    int r = Integer.parseInt(variables[0]);
    int c = Integer.parseInt(variables[1]);
    int e = Integer.parseInt(variables[2]);
    int n = Integer.parseInt(variables[3]);
    int[][] pasture = new int[r][c];
    for (int i = 0; i < r; i++) {
      line = scanner.nextLine();
      String[] pastureNumbers = line.split(" ", -2);
      for (int j = 0; j < pastureNumbers.length; j++) {
        pasture[i][j] = Integer.parseInt(pastureNumbers[j]);
      }
    }
    int[][] stomps = new int[n][3];
    int temp = 0;
    while (scanner.hasNextLine()){
      line = scanner.nextLine();
      String[] stompInstructions = line.split(" ", -2);
      for (int j = 0; j < stompInstructions.length; j++) {
        stomps[temp][j] = Integer.parseInt(stompInstructions[j]);
      }
      temp++;
    }
    for (int i = 0; i < stomps.length; i++) {
      int startRow = stomps[i][0] - 1;
      int startCol = stomps[i][1] - 1;
      int maxHeight = 0;
      for (int row = startRow; row <= startRow+2; row++) {
        for (int col = startCol; col <= startCol+2; col++) {
          if (pasture[row][col] > maxHeight)
            maxHeight = pasture[row][col];
        }
      }
      maxHeight -= stomps[i][2];
      for (int row = startRow; row <= startRow+2; row++) {
        for (int col = startCol; col <= startCol+2; col++) {
          if (pasture[row][col] > maxHeight)
            pasture[row][col] = maxHeight;
        }
      }
    }
    //after the stomp is over
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (e - pasture[i][j] > 0)
          pasture[i][j] = e - pasture[i][j];
        else pasture[i][j] = 0;
      }
    }
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        depth += pasture[i][j];
      }
    }
    return depth * 72 * 72;
  }

  public static int silver(String filename) throws FileNotFoundException {
    File file = new File(filename);
    Scanner scanner = new Scanner(file);
    String line = scanner.nextLine();
    String[] variables = line.split(" ", -2);
    int n = Integer.parseInt(variables[0]);
    int m = Integer.parseInt(variables[1]);
    int t = Integer.parseInt(variables[2]);
    int[][] pasture = new int[n][m];
    String[][] board = new String[n][m];
    int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    String tempp = "";
    String temppp = "";
    while (scanner.hasNextLine()) {
      tempp = scanner.nextLine();
      temppp += tempp;
    }
    int counter = 0;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        board[i][j] = "" + temppp.charAt(counter); //copying over the values into the board
        counter++;
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j].equals("*")) {
          pasture[i][j] = -1;
        }
      }
    }
    String[] coordinates = tempp.split(" ", -2);
    int startRow = Integer.parseInt(coordinates[0]) - 1;
    int startCol = Integer.parseInt(coordinates[1]) - 1;
    int endRow = Integer.parseInt(coordinates[2]) - 1;
    int endCol = Integer.parseInt(coordinates[3]) - 1;
    int[][] temp = new int[n][m];
    pasture[startRow][startCol] = 1;
    while (t > 0) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          temp[i][j] = pasture[i][j];
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (board[i][j].equals(".")) {
            pasture[i][j] = 0;
            for (int k = 0; k < moves.length; k++) {
              if (i+moves[k][0] < n && j+moves[k][1] < m &&
                  i+moves[k][0] >= 0 && j+moves[k][1] >= 0 &&
                  temp[i+moves[k][0]][j+moves[k][1]] != -1)
                pasture[i][j] += temp[i+moves[k][0]][j+moves[k][1]];
            }
          }
        }
      }
      t--;
    }
    return pasture[endRow][endCol];
  }

  public static void main(String[] args) {
    try {
      System.out.println(bronze("testCases/makelake.1.in"));
      System.out.println(bronze("testCases/makelake.2.in"));
      System.out.println(bronze("testCases/makelake.3.in"));
      System.out.println(bronze("testCases/makelake.4.in"));
      System.out.println(bronze("testCases/makelake.5.in"));
      System.out.println();
      System.out.println(silver("testCases/ctravel.1.in"));
      System.out.println(silver("testCases/ctravel.2.in"));
      System.out.println(silver("testCases/ctravel.3.in"));
      System.out.println(silver("testCases/ctravel.4.in"));
      System.out.println(silver("testCases/ctravel.5.in"));
    }
    catch(FileNotFoundException e) {
      System.out.println("file not found");
    }
  }

}
