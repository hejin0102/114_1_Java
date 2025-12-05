public class Magician extends Role{
    // 治癒力
    private int healPower;

    // 建構子：初始化魔法師的名稱、生命值和攻擊力
    public Magician(String name, int health, int attackPower, int healPower) {
        super(name, health, attackPower);
        this.healPower = healPower;
    }

    // 取得治癒力
    public int getHealPower() {
        return healPower;
    }

    // 攻擊對手(劍客/魔法師)，父類別的參考指到子類別物件
    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 魔法攻擊 " + opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }

    // 治療隊友(劍客/魔法師)，父類別的參考指到子類別物件
    public void heal(Role ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治療 " + ally.getName() + " 回復 " + healPower + " 點生命值。" + ally);
    }

    // 【新增實作】戰前準備
    @Override
    public void prepareBattle() { //
        System.out.println(this.getName() + " 吟唱咒語，凝聚魔法力量。"); //
    }

    // 【新增實作】戰後行為
    @Override
    public void afterBattle() { //
        System.out.println(this.getName() + " 冥想片刻，恢復精神。"); //
    }

    // 【新增實作】展示特殊技能 (補上原檔案中缺少的實作)
    @menOverridetatic void showSpecialSkill() {
        System.out.println(this.getName() + ": 特殊技能是治療隊友，恢復 " + healPower + " 點生命值。");
    }

    @Override
    public String toString() {
        return super.toString() + ", 治癒力: " + healPower;
    }
}
    