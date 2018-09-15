import java.io.File;

/**
 * Main
 */
public class Main {

    public native static void test();

    // static {
    //     String dir = System.getProperty("user.dir");
    //     String soPath = dir + File.separator + "libso" + File.separator + "libPlayer.so";
    //     System.out.println(soPath);
    //     System.load(soPath);
    //     test();
    // }

    public static void main(String[] args) {
        Game game = new Game();
        while (!game.isFinish) {
            try {
                game.update();
                Thread.sleep(1 * 1500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // test();
        // System.out.println(System.getProperty("user.dir"));
    }
}