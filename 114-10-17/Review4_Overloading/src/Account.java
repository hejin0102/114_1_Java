import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Account {
    private String accountNumber;
    private double balance;



    public Account(String accountNumber,double initialBalance){
        this.setAccountNumber(accountNumber);
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage()+",餘額設為0");
            this.balance = 0.0;
        }

    }
    public Account(){
        this("000000",0.0);
    }

    public Account(String accountNumber){
        this(accountNumber,0.0);
    }

    public String getAccountNumber () {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
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
    public void deposit(double amount,String currency) {
        double exchangeRate = 1.0; // 假設匯率為1美元兌30台幣
        switch(currency.toUpperCase()) {
            case "USD":
                exchangeRate = 30.0;
                break;
            case "EUR":
                exchangeRate = 33.0;
                break;
            case "JPY":
                exchangeRate = 0.25;
                break;
            default:
                throw new IllegalArgumentException("不支援的貨幣類型");
        }
        double amountInTWD = amount * exchangeRate;
        deposit(amountInTWD);
    }
    public void deposit(double ... amounts) {
        double total=0.;
        for (double amount : amounts) {
            if(amount >=0){
                total+=amount;
            }
            else{
                throw new IllegalArgumentException("存款金額必須為正數");
            }
        }
        this.deposit(total);
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