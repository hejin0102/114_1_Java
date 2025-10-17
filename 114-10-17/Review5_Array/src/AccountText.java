public class AccountText {
    private static int customerCount;

    public static void main(String[] args) {
        Account[] customers = new Account[10];
        Account acc1 = new Account("A001", "Alice", 5000);
        addCustomer(customers, acc1);
        Account acc2  = new Account("A002", "Bob", 3000);
        addCustomer(customers, acc2);
        Account acc3  = new Account("A003", "Charlie", -100);
        addCustomer(customers, acc3);
    }

    public static void addCustomer(Account[] customers, Account newAccount) {
        if(customerCount<customers.length){
            customers[customerCount] = newAccount;
            customerCount++;
            System.out.println("成功新增客戶: " + newAccount.getAccountNumber());
            return;
        }
        System.out.println("無法新增客戶，客戶數已達上限");
    }
    public static void printCustomers(Account[] customers) {
        for (int i = 0; i < customerCount; i++) {
            printCustomersInfo(customers[i]);
        }
    }
    public static void printCustomersInfo(Account account) {
        System.out.println("帳號: " + account.getAccountNumber() +
                ", 持有人: " + account.getOwnerName() +
                ", 餘額: " + account.getBalance());
    }
}




