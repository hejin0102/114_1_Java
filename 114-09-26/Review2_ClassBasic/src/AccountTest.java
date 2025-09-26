public class AccountTest {
    public static void main(String[] args) {
        // 建立一個帳戶，初始餘額為1000
public class AccountTest {
    public static void main(String[] args) {
        // 建立一個帳戶，初始餘額為1000
        Account account1 = new Account("A123", 1000.0);
        Account account2 = new Account("B456", 2000.0);

        System.out.printf("帳戶號碼: %s%n初始餘額: %.2f%n", account1.getAccountNumber(), account1.getBalance());
        System.out.printf("帳戶號碼: %s%n初始餘額: %.2f%n", account2.getAccountNumber(), account2.getBalance());

        account1.deposit(500.0);
        System.out.printf("帳戶號碼: %s%n目前餘額: %.2f%n", account1.getAccountNumber(), account1.getBalance());

        account1.withdraw(1000.0);
        System.out.printf("帳戶號碼: %s%n目前餘額: %.2f%n", account1.getAccountNumber(), account1.getBalance());

        // 測試存款
        try {
            account1.deposit(-100.0);
            System.out.printf("帳戶號碼: %s%n目前餘額: %.2f%n", account1.getAccountNumber(), account1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("存款失敗: " + e.getMessage());
        }

        //非法提款
        try {
            account1.withdraw(2000.0);
            System.out.printf("帳戶號碼: %s%n目前餘額: %.2f%n", account1.getAccountNumber(), account1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("提款失敗: " + e.getMessage());
        }
    }
}
