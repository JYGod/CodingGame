/**
 * PrintTool
 */
public class PrintTool {

    public static int BLACK = 30;
    public static int RED = 31;
    public static int GREEN = 32;
    public static int YELLOW = 33;
    public static int BLUE = 34;
    public static int PURPLE = 35;

    public static void printWithColor(String msg, int code) {
        System.out.println("\033["+ code + "m" + msg + "\033[0m");
    }
    
}