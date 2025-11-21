public abstract class ShieldSwordsMan extends Role {

    public ShieldSwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack(Role opponent) {
        System.out.println(getName() + " 用盾牌衝撞 " + opponent.getName());
        opponent.setHealth(opponent.getHealth() - getAttackPower());
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("========== " + getName() + " 的特殊技能 ==========");
        System.out.println("技能名稱：鐵壁防禦");
        System.out.println("技能描述：提高自身防禦力");
        System.out.println("技能效果：本回合減少50%傷害");
        System.out.println("===================================");
    }
}
