public class Role {
    //角色名稱
    public String name;
    //角色等級
    public int health;
    //角色攻擊力
    public int attackPower;

    //建構子
    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    //取得角色名稱
    public String getName() {
        return name;
    }

    //取得角色等級
    public int getHealth() {
        return health;
    }

    //設定生命值
    public void setHealth(int health) {
        this.health = health;
    }

    //取得角色攻擊力
    public boolean getAttackPower() {
        return attackPower;

        //確認角色是否存活
        public boolean isAlive() {
            return this.health > 0;
        }
        public String toString() {
            return "角色名稱: " + name + ", 生命值: " + health;
        }
    }