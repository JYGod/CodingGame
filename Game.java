/**
 * Game
 */
public class Game {

    private static String[] arr = {" ", " ", " ", " ", " ", " ", "s", " ", " ", "#"};

    private static String player = "@"; 
    
    private static int currentPosition = 0; // Player当前位置

    private static int turn = 0; // 记录当前游戏的轮次

    private static int health = 100;

    private static int damage = 5;

    public static boolean isFinish = false;

    private static Enemy enemy = null;

    public static void update() {
        showPlayerInfo();
        generateMap();
        action();
        endTurn();  
    }

    private static void action() {
        if (feel()) {
            attack();
        } else {
            walk();
        }
    }

    /* 
     * 结算当前轮次
     */ 
    private static void endTurn() {
        turn++;
        System.out.println("------------------ turn " + turn + " ------------------");
        if (health <= 0) {
            System.out.println("你GG了");
            isFinish = true;
        }
        System.out.print("\n");
    }

    /* 
     * 显示玩家信息
     */ 
    private static void showPlayerInfo() {
        String healthMsg = "♥ " + String.valueOf(health);
        PrintTool.printWithColor(healthMsg, PrintTool.RED);
    }

    /* 
     * 生成最终的结果
     */    
    private static void generateMap() {
        int totalLength = arr.length + 2;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < totalLength; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print("╔");
                    } else if (j == totalLength - 1) {
                        System.out.print("╗");
                    } else {
                        System.out.print("═");
                    }
                    continue;
                }
                if (i == 2) {
                    if (j == 0) {
                        System.out.print("╚");
                    } else if (j == totalLength - 1) {
                        System.out.print("╝");
                    } else {
                        System.out.print("═");
                    }
                    continue;
                }
                if (j == 0 || j == totalLength - 1) {
                    System.out.print("‖");
                    continue;
                }
                if (currentPosition == (j - 1)) {
                    System.out.print(player);
                    continue;
                }
                System.out.print(arr[j - 1]);
            }
            System.out.print("\n");
        }
    }

    private static void walk() {
        if (feel()) {
            if (enemy == null) {
                enemy = new Enemy();
            }
            health -= enemy.attack();
            return;
        }
        if (currentPosition < arr.length - 1 && arr[currentPosition + 1].equals("#")) {
            System.out.println("恭喜过关!");
            isFinish = true;
        } else {
            currentPosition++;
        }
    }

    /* 
     * 检测前方有无敌人
     */
    private static boolean feel() {
        return arr[currentPosition + 1].equals("s");
    }

    /* 
     * 攻击
     */
    private static void attack() {
        if (enemy == null) {
            enemy = new Enemy();
        }
        health -= enemy.attack();
        boolean isDeath = enemy.hurt(damage);
        if (isDeath) {
            PrintTool.printWithColor("敌人阵亡 ~",  PrintTool.YELLOW);
            arr[currentPosition + 1] = " ";
        }
    }

    /* 
     * 治疗
     */
    private static void heal() {
        
    }
}