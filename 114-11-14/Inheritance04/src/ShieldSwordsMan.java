public class ShieldSwordsMan extends SwordsMan{
    private int defenseCapacity;
    // 建構子：初始化持盾劍士的名稱、生命值和攻擊力
    public ShieldSwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // 重寫攻擊方法，持盾劍士攻擊時有機會反彈傷害
    @Override
    public void attack(Role opponent) {
        int reducedDamage = this.getAttackPower() - 5; // 減少5點傷害
        opponent.setHealth(opponent.getHealth() - reducedDamage);
        System.out.println(this.getName() + " 攻擊 " + opponent.getName() + " 造成 " +
                reducedDamage + " 點傷害（持盾減少5點傷害）。" + opponent);
    }

    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    public void defence() {
        this.setHealth(this.getHealth()+defenseCapacity);
        System.out.println(this.getName() + " 使用防禦，恢復 " + defenseCapacity + " 點生命值。" + this);
    }
}
