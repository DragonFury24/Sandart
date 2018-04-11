import java.awt.Color;
import java.util.stream.IntStream;

public class SandUtilities {
    //pre : c!= null
    //post: returns the inverted color from the one sent as c
    public static Color invert(Color c) {
        return new Color(~c.getRGB());      //temporary return statement to keep things compiling
    }

    //pre:   m!= null
    //post:  for each non-null element of m, changes it to its inverted color
    //       skips any color with the value skip1 and skip2, leaving them unchanged
    public static void invertColors(Color[][] m, Color skip1, Color skip2) {
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[row].length; col++) {
                if (m[row][col] == null)
                    continue;

                if (m[row][col].equals(skip1) || m[row][col].equals(skip2))
                    continue;

                m[row][col] = new Color(~m[row][col].getRGB());
            }
        }
    }

    //pre:   m is a square 2-D array (m.length==m[0].length)
    //post:  flips the array upside down
    public static void flipUpsideDown(Object[][] m) {
        reverseRows(m);
    }

    //pre:   m is a square 2-D array (m.length==m[0].length)
    //post:  rotates the array 90 degrees to the left
    public static void rotateLeft(Object[][] m) {
        transpose(m);
        reverseRows(m);
    }

    //pre:   m is a square 2-D array (m.length==m[0].length)
    //post:  rotates the array 90 degrees to the right
    public static void rotateRight(Object[][] m) {
        reverseRows(m);
        transpose(m);
    }

    private static void reverseRows(Object[][] m) {
        IntStream.range(0, m.length / 2)
                 .forEach(i -> swapRows(m, i, m.length - i - 1));
    }

    private static void swapRows(Object[][] m, int row1, int row2) {
        Object[] temp = m[row1];
        m[row1] = m[row2];
        m[row2] = temp;
    }

    private static void transpose(Object[][] m) {
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[row].length; col++) {
                Object temp = m[row][col];
                m[row][col] = m[col][row];
                m[col][row] = temp;
            }
        }
    }
}