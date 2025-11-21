package java;
    public class ShieldSwordsMan extends Swordsman {
        private int defenseCapacity;

        // 建構子：初始化持盾劍士的名稱、生命值和攻擊力
        public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
            super(name, health, attackPower);
            this.defenseCapacity = Math.max(0, defenseCapacity);
        }

        // 攻擊對手，持盾劍士攻擊力略為降低
        @Override
        public void attack(Role opponent) {
            int reducedDamage = Math.max(0, this.getAttackPower() - 5); // 攻擊力減少5點，至少為0
            opponent.setHealth(Math.max(0, opponent.getHealth() - reducedDamage));
            System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + " 造成 " +
                    reducedDamage + " 點傷害。 " + opponent);
        }

        public int getDefenseCapacity() {
            return defenseCapacity;
        }

        public void defence() {
            this.setHealth(this.getHealth() + defenseCapacity);
            System.out.println(this.getName() + " 使用盾牌防禦，恢復 " + defenseCapacity + " 點生命值。 " + this);
        }

        public void showSpecialSkill() {
            System.out.println("===========================================");
            System.out.println("============ " + this.getName() + " 的特殊技能 ============");
            System.out.println("技能名稱：連續斬擊");
            System.out.println("技能描述：快速揮劍三次");
            System.out.println("技能效果：造成 150% 傷害");
            System.out.println("===========================================");
        }
    }
    }
}
