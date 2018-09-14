/**
 * Player
 */
public class Player {

    private static String[] arr = {"_", "_", "_", "_", "s", "_", "_", "#"};

    private static String player = "P"; 
    
    private static int currentPosition = 1;
    
    private static int health = 100;

    public static boolean isFinish = false;

    public static void update() {
        int length = arr.length;
        String[] arrTemp = new String[length];
        System.arraycopy(arr, 0, arrTemp, 0, length);
        arrTemp[currentPosition] = player;
        String str = String.join("", arrTemp);
        System.out.println(str);
        action();
    }

    private static void action() {
        // if (detect()) {

        // }
        walk();
    }

    private static void walk() {
        if (detect()) {
            System.out.println("前方有敌人，而你在发呆，不好意思你又送了");
            isFinish = true;
        }
        if (currentPosition < arr.length - 1 && arr[currentPosition + 1].equals("#")) {
            System.out.println("恭喜过关!");
            isFinish = true;
        } else {
            currentPosition ++;
        }
    }

    /* 
     * 检测前方有无敌人
     */
    private static boolean detect() {
        return arr[currentPosition + 1].equals("s");
    }

    /* 
     * 攻击
     */
    private static void attack() {

    }

    /* 
     * 治疗
     */
    private static void heal() {
        
    }
}