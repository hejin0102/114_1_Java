// 檔案路徑: Account.java
import java.time.LocalDateTime;

public class Account {
    private static int accountCount = 0; // 帳戶數量統計

    // 帳戶號碼，唯一識別每個帳戶
    private String accountNumber;
    // 帳戶擁有者名稱（在主建構子中初始化）
    private final String ownerName;
    // 帳戶餘額
    private double balance;

    // 帳戶開立日期與時間（在建構子中初始化）
    private final Date openingDate;
    private final Time2 openingTime;

    /**
     * 主建構子：初始化帳戶號碼、持有人與初始餘額，並記錄開立時間
     */
    public Account(String accountNumber, String ownerName, double initialBalance) {
        LocalDateTime now = LocalDateTime.now(); // 取得目前日期與時間

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage() + "，將餘額設為0");
            this.balance = 0;
        }

        accountCount++; // 帳戶數量加1

        // 記錄帳戶開立的日期與時間
        this.openingDate = new Date(now.getMonthValue(), now.getDayOfMonth(), now.getYear());
        this.openingTime = new Time2(now.getHour(), now.getMinute(), now.getSecond());
    }

    // 其他便利建構子都委派給主建構子
    public Account(String accountNumber, double initialBalance) {
        this(accountNumber, "未知", initialBalance);
    }

    public Account() {
        this("未知", "未知", 0);
    }

    public Account(String accountNumber) {
        this(accountNumber, "未知", 0);
    }

    // 取得帳戶號碼
    public String getAccountNumber() {
        return accountNumber;
    }

    // 取得帳戶餘額
    public double getBalance() {
        return balance;
    }

    // 取得帳戶持有人
    public String getOwnerName() {
        return ownerName;
    }

    // 設定帳戶餘額（必須為正數）
    public void setBalance(double balance) {
        if (balance >= 0) { // 允許 0
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("帳戶餘額必須為非負數");
        }
    }

    // 設定帳戶號碼
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // 存款
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("存款金額必須為正數");
        }
    }

    // 提款
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("提款金額不合法");
        }
    }

    @Override
    public String toString() {
        return String.format("帳戶號碼: %s, 持有人: %s, 餘額: %.2f, 開立日期: %s, 開立時間: %s, 總帳戶數: %d",
                accountNumber, ownerName, balance, openingDate.toString(), openingTime.toString(), accountCount);
    }
}
