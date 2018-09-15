/**
 * Enemy
 */
public class Enemy {

    private int health;
    private int damage;

    public Enemy() {
        this.health = 20;
        this.damage = 15;
    }

    // 造成攻击
    public int attack() {
        String msg = "敌人发出了攻击,你受到 " + String.valueOf(this.damage) + " 点伤害!";
        PrintTool.printWithColor(msg, PrintTool.YELLOW);
        return this.damage;
    }

    // 遭到伤害
    // return isDead
    public boolean hurt(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        String msg = "你对敌人造成了 " + String.valueOf(damage) + " 点伤害, 敌人血量还剩: " + String.valueOf(this.health);
        PrintTool.printWithColor(msg, PrintTool.YELLOW);
        return this.health < 0;
    }
}