public class RPG {
    public static void main(String[] args) {
        // 建立劍客和魔法師角色
        SwordsMan swordsman = new SwordsMan("勇者", 100, 30);
        Magician magician = new Magician("黑暗劍士", 80, 20);

        Magician magician1_ = new Magician("黑法師", 70, 15);
        Magician magician2_ = new Magician("光療師", 60, 10);

        // 戰鬥模擬：雙方輪流攻擊，直到其中一方死亡
        while (swordsman.isAlive() && magician.isAlive()) {
            swordsman.attack(magician);
            if (!magician.isAlive()) {
                System.out.println(magician.getName() + " 已經死亡! " + swordsman.getName() + " 獲勝!");
                break;
            }

            magician.attack(swordsman);
            if (!swordsman.isAlive()) {
                System.out.println(swordsman.getName() + " 已經死亡! " + magician.getName() + " 獲勝!");
                break;
            }
        }
    }
}