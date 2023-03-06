import java.util.Objects;
import java.util.Scanner;

public class Account {
    private String id;
    private String name;
    private int balance;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void credit(int amount) {
        if (amount <= 0) {
            System.out.println("Charge not successfully");
        } else {
            balance = balance + amount;
            System.out.println("Charge successfully, your balance is:" + balance);
        }
    }

    public void debit(int amount) {
        if (amount <= 0) {
            System.out.println("Data invalid");
        } else {
            if (balance >= amount) {
                balance = balance - amount;
                System.out.println("Debit successfully, your balance is:" + balance);
            } else {
                System.out.println("Your balance is not enough" + balance);
            }
        }
    }

    public void transferTo(int amount, Account accountTo, Account accountFrom) {
        if (amount <= 0) {
            System.out.println("Data invalid");
        } else {
            if (accountFrom.balance >= amount) {
                accountFrom.balance = accountFrom.balance - amount;
                accountTo.balance = accountTo.balance + amount;
                System.out.println("Balance of account from is:" + accountFrom.balance);
                System.out.println("Balance of account to is:" + accountTo.balance);
            } else {
                System.out.println("Your balance is not enough" + accountFrom.balance);
            }

        }


    }

    public void transferTo(int amount, Account accountTo) {
        if (amount <= 0) {
            System.out.println("Data invalid");
        } else {
            if (this.balance >= amount) {
                this.balance = this.balance - amount;
                accountTo.balance = accountTo.balance + amount;
                System.out.println("Balance of account from is:" + balance);
                System.out.println("Balance of account to is:" + accountTo.balance);
            } else {
                System.out.println("Your balance is not enough" + amount);
            }

        }


    }

    public static void main(String[] args) {
        Account accountTrang = new Account("123abc", "Trang", 10000);
        Account accountCong = new Account("456abc", "Cong", 5000);
        Scanner scMethod = new Scanner(System.in);
        int methodSelect;
        System.out.println("Please select method:");
        methodSelect = scMethod.nextInt();
            switch (methodSelect) {
                case 1:
                    Scanner scCredit = new Scanner(System.in);
                    int amount;
                    System.out.println("Please input amount you want to charge:");
                    amount = scCredit.nextInt();
                    accountTrang.credit(amount);
                    break;
                case 2:
                    Scanner scDebit = new Scanner(System.in);
                    int amount1;
                    System.out.println("Please input amount you want to paid:");
                    amount1 = scDebit.nextInt();
                    accountTrang.debit(amount1);
                    break;
                case 3:
                    Scanner scId = new Scanner(System.in);
                    String idAccount;
                    System.out.println("Please input Account ID:");
                    idAccount = scId.nextLine();
                    while (!Objects.equals(idAccount, "456abc")) {
                        System.out.println("Please input correct ID:");
                        idAccount = scId.nextLine();
                    }
                    Scanner scAmount = new Scanner(System.in);
                    int amountTransfer;
                    System.out.println("Please input your amount:");
                    amountTransfer = scAmount.nextInt();
                    accountTrang.transferTo(amountTransfer, accountCong);
                    break;

            }

    }

}
