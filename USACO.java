import java.util.*;
import java.io.*;
public class USACO {

  public static int bronze(String filename) throws FileNotFoundException {
    File file = new File(filename);
    Scanner scanner = new Scanner(file);
    String line = scanner.nextLine();
    String[] variables = line.split(" ", -1);
    int r = Integer.parseInt(variables[0]);
    int c = Integer.parseInt(variables[1]);
    int e = Integer.parseInt(variables[2]);
    int n = Integer.parseInt(variables[3]);
    int[][] stomps = new int[n][3];
    int[][] pasture = new int[r][c];
    for (int i = 0; i < r; i++) {
      line = scanner.nextLine();
      String[] pastureNumbers = line.split(" ", -1);
      for (int j = 0; j < pastureNumbers.length; j++) {
        pasture[i][j] = Integer.parseInt(pastureNumbers[j]);
      }
    }
    for (int i = 0; i < n; i++) {
      line = scanner.nextLine();
      String[] stompInstructions = line.split(" ", -1);
      for (int j = 0; i < stompInstructions.length; j++) {
        stomps[i][j] = Integer.parseInt(stompInstructions[j]);
      }
    }
    for (int i = 0; i < stomps.length; i++) {
      int startRow = stomps[i][0];
      int startCol = stomps[i][1];
      int maxHeight = 0;
      for (int r = startRow-1; r <= startRow+1; r++) {
        for (int c = startCol-1; c <= startCol+1; c++) {
          if (pasture[r][c] > maxHeight)
            maxHeight = pasture[r][c];
        }
      }
      maxHeight -= stomps[i][2];
      for (int r = startRow-1; r <= startRow+1; r++) {
        for (int c = startCol-1; c <= startCol+1; c++) {
          if (pasture[r][c] > maxHeight)
            pasture[r][c] = maxHeight;
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

  //public static int silver(String filename) {

  //}

}
