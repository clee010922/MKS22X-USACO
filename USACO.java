import java.util.*;
import java.io.*;
public class USACO {

  public static int bronze(String filename) throws FileNotFoundException {
    File file = new File(filename);
    Scanner scanner = new Scanner(file);
    int r = scanner.nextInt();
    int c = scanner.nextInt();
    int e = scanner.nextInt();
    int n = scanner.nextInt();
    int r_c = 0;
    int c_s = 0;
    int d_s = 0;
    int depth = 0;
    int[][] pasture = new int[r][c];
    while (scanner.hasNextLine()) {
    String line = scanner.nextLine();

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

  public static int silver(String filename) {

  }

}
