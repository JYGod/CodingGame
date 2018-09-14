
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        while (!player.isFinish) {
            try {
                player.update();
                Thread.sleep(1 * 2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}