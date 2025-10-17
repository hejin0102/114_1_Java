public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account("A123", 1000.0);
        Account account2 = new Account("B456", 2000.0);
        Account account3 = new Account();
        //system.out.println("帳戶號碼: " + account1.getAccountNumber());
        //System.out.println("初始餘額: " + account1.getBalance());
        System.out.printf("帳戶號碼: %s, 初始餘額: %.2f%n", account1.getAccountNumber(), account1.getBalance());
        System.out.printf("帳戶號碼: %s, 初始餘額: %.2f%n", account2.getAccountNumber(), account2.getBalance());
        account1.deposit(500.0);
        System.out.printf("帳戶號碼:%s%n,存款後餘額: %.2f%n", account1.getBalance(), account1.getBalance());

        account1.withdraw(1000.0);
        System.out.printf("帳戶號碼:%s%n,提款後餘額: %.2f%n", account1.getBalance(), account1.getBalance());

        //try {
        //  account1.deposit(-1000.0);

        //   System.out.printf("帳戶號碼:%s%n,存款後餘額: %.2f%n", account1.getBalance(), account1.getBalance());
        // } catch (IllegalArgumentException e) {
        //     System.out.println("存款錯誤: " + e.getMessage());
        //}

        //try {
        //   account1.withdraw(2000.0);
        //  System.out.printf("帳戶號碼:%s%n,提款後餘額: %.2f%n", account1.getBalance(), account1.getBalance());
        //} catch (IllegalArgumentException e) {
        //   System.out.println("提款錯誤: " + e.getMessage());
        //}

        try {
            account1.deposit( -100,"USD");
            System.out.printf("帳戶號碼:%s%n,提款後餘額: %.2f%n", account1.getBalance(), account1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("提款錯誤: " + e.getMessage());
        }
        try{
            account2.deposit(1000,2000,5000);
            System.out.printf("帳戶號碼:%s%n,提款後餘額: %.2f%n", account2.getBalance(), account2.getBalance());
        }catch(IllegalArgumentException e){
            System.out.println("存款錯誤: " + e.getMessage());
        }
    }
}

