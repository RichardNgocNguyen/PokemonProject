import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Point;

public class Map{

  private char [][] map;
  private boolean [][] revealed;

   /** Default Constructor
  **/
  public Map(){
    final int row = 5;
    final int column = 5;
    this.map = new char[row][column];
    this.revealed = new boolean[row][column];
    for (int k = 0;k < row; k++){
      for (int l = 0; l < column; l++){
        this.revealed[k][l] = false;
      }
    }
  }


  public void loadMap(int mapNum) {
    String mapSelection = "";
    if (mapNum == 0) {
        mapSelection = "G:\\My Drive\\Program\\Java\\Java 8-17\\3_PokemonProject\\src\\Areas\\Area1.txt";
    }
    else if (mapNum == 1) {
        mapSelection = "G:\\My Drive\\Program\\Java\\Java 8-17\\3_PokemonProject\\src\\Areas\\Area2.txt";
    }
    else if (mapNum == 2) {
        mapSelection = "G:\\My Drive\\Program\\Java\\Java 8-17\\3_PokemonProject\\src\\Areas\\Area3.txt";
    }

    try {
      int i = 0;
      Scanner read = new Scanner(new File(mapSelection));
      while ( read.hasNextLine() ) {
        String reading = read.nextLine(); 
        String nospaces = reading.replaceAll(" ", "");
        char[] letter = nospaces.toCharArray();
        for (int j = 0; j < letter.length; j++) {
          char characters = letter[j];
          this.map[i][j] = characters;
        }
      i++;
      }
    }
    catch (FileNotFoundException fnf) {
      System.out.println("File Not Found");
    }
  }

  /**
  * Using Point from Trainer return '*' for Character at location 
  * @returns char
  **/
  public char getCharAtLoc(Point p) {
    int x = p.x;
    int y = p.y;
    return this.map[x][y];
  }


  /**
  * @param Takes in point
  * Maps the letters if it is revealed, but maps 'x' when not revealed
  * @returns map as string
  **/
  public String mapToString(Point p) {
    String map = "";
    for (int i=0;i<5;i++){
      for (int j=0; j<5;j++){
        if (i == p.x && j == p.y) {
          map += "*" + " ";
        }
        else if (revealed[i][j]) {
          map += this.map[i][j] + " ";
        }
        else {
          map += 'x' + " ";
        }
      }
    map += "\n";
    }
    return map;
  }

  /**
  * Finds the coordinates for starting Point
  * @returns point 
  **/
  public Point findStart() {
    for (int i=0;i<5;i++){
      for (int j=0; j<5;j++){
        if (this.map[i][j] == 's') {
          return new Point(i, j);
        }
      }
    }
    return new Point(0,0);
  }
  
  /**
  * @param takes in point 
  * Reveals point in map by setting revealed to true at x,y 
  **/
  public void reveal(Point p) {
    int x = p.x;
    int y = p.y;
    this.revealed[x][y] = true;
  }

  /**
  * @param takes in point 
  * Replaces char to 'n' if it is a one time encounter
  **/
  public void removeCharAtLoc(Point p) {
    int x = p.x;
    int y = p.y;
    this.map[x][y] = 'n';
  }
}
