public class Magician extends Role {
    private int healPower = 20;

    public Magician(String name, int health, int attackPower) {
           super(name, health, attackPower);
           this.healPower = healPower;
    }

    //取得治療力
    public int getHealPower() {
        return healPower;
    }

    //治療劍客
    public int heal(swordsman ally) {
        ally.health += this.healPower;
        System.out.println(this.name+" 治療 "+ally.name+" 回復 "+this.healPower+" 點生命!");
        return ally.health;

    //檢查角色是否存活
    }
    public boolean isAlive() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }
}