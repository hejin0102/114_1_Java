import java.util.Scanner;
public class Account {
    private static int accountcount= 0;
    private String accountNumber;
    private String ownerName;
    private double balance;


    public Account(String accountNumber, String ownerName,double initialBalance) {
        this.setAccountNumber(accountNumber);
        this.ownerName = ownerName;
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage() + ",餘額設為0");
        }
    }

    public Account(String accountNumber,double initialBalance) {
        this(accountNumber,"未知",initialBalance);
    }
    public Account(){
        this("0000","未知",0);
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getOwnerName() {
        return ownerName;
    }

    public void setBalance(double balance) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            if (balance > 0) {
                this.balance = balance;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("帳戶餘額必須為正數，請重新輸入：");
                    balance = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("帳戶餘額必須為正數");
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            if (amount > 0) {
                balance += amount;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("存款金額必須為正數，請重新輸入：");
                    amount = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("存款餘額必須為正數");
    }

    public void withdraw(double amount) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("提款金額不合法，請重新輸入：");
                    amount = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("提取金額不合法");
    }
}