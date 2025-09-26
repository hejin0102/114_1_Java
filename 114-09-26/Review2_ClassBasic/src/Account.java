public class Account {
    // 帳戶號碼，唯一識別每個帳戶
    private String accountNumber;
    private double balance;

    /**
     * 建構子，初始化帳戶號碼和初始餘額
     * @param accountNumber 帳戶號碼
     * @param initialBalance 初始餘額
     */
            public Account(String accountNumber, double initialBalance) {
                this.setAccountNumber(accountNumber);
                try {
                    this.setBalance(initialBalance);
                } catch (IllegalArgumentException e) {
                    System.out.println("初始餘額錯誤: " + e.getMessage());
                    this.setBalance(0); // 若初始餘額錯誤，設為0
                }
            }

    }

    /**
     * 取得帳戶餘額
     * @return 帳戶餘額
     */
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("餘額不能為負數");
        }
        this.balance = balance;
    }

    /**
     * 存款方法，將指定金額存入帳戶
     * @param amount 存款金額，必為正數
     * @throws IllegalArgumentException 當存款金額為負數時拋出例外
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("存款金額必須為正數");
        }
        balance += amount;
    }

    /**
     * 提款方法，將指定金額從帳戶中扣除指定金額
     * @param amount 提款金額，必為正數且不得超過帳戶餘額
     * @throws IllegalArgumentException 當提款金額為負數或超過帳戶餘額時拋出例外
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("提款金額必須為正數");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("提款金額超過帳戶餘額");
        }
        balance -= amount;
    }
}
