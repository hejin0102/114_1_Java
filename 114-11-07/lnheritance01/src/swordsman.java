java
// src/swordsman.java
public class swordsman extends Role {

    // 建構子
    public swordsman(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
//取得治癒力
    public int getHealPower() {
        return 0; // 劍客沒有治癒力，回傳 0
    }

    // 角色攻擊方法（使用父類 getter 存取攻擊力）
    public void attack(swordsman target) {
        System.out.println(this.getName() + " attacks " + target.getName() + " for " + this.getAttackPower() + " damage!");
        target.takeDamage(this.getAttackPower());
    }

    // 角色受傷方法（扣血、界限處理、印出狀態，死亡時顯示訊息）
    public void takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
        if (this.getHealth() < 0) {
            this.setHealth(0);
        }
        System.out.println(this.getName() + " 受傷，剩餘生命: " + this.getHealth() + ".");

        if (!isAlive()) {
            System.out.println(this.getName() + " 已經死亡!");
        }
    }

    // 是否存活：直接由 health 判斷（移除冗餘的 alive 欄位）
    public boolean isAlive() {
        return this.getHealth() > 0;
    }
}