package hellojava;
import java.util.Scanner;
public class BankAccount {

    private long accountNumber;
    private double balance;

    public void BankAccount(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("amount " + amount + " has been credited to your account");
        } else {
            System.out.println("deposit amount cant be zero or negative");
        }
    }

    public void withdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("amount " + amount + "has been debited from your account");
        } else {
            System.out.println("you cant withdraw more than your balance or in negative");
        }
    }

    public static void main(String[] args) {

        BankAccount pawan = new BankAccount();
        Scanner keypad = new Scanner(System.in);
        System.out.println("""
                           HI A/C no- xxxxxxxxxxxxxxx 
                           Press O for Main Menu
                           press X to exit
                           """);

        {
            while (true) {

                char s = keypad.next().toLowerCase().charAt(0);

                if (s == 'x') {
                    System.out.println("GOODBYE");
                    break;
                }
                if (s != 'o' && s != 'x') {
                    System.out.println("please give valid input");
                }
                if (s == 'o') {
                    while (true) {
                        System.out.println("press 1 to Deposit");
                        System.out.println("press 2 to withdraw");
                        System.out.println("press 3 to check Balance");
                        System.out.println("press 0 to exit");

                        int choice;
                        choice = keypad.nextInt();

                        if (choice == 1) {
                            System.out.println("Enter amount to deposit = ");
                            double depositMoney = keypad.nextDouble();
                            pawan.deposit(depositMoney);
                        }
                        if (choice == 2) {
                            System.out.println("Enter amount to withdraw");
                            double withdrawMoney = keypad.nextDouble();
                            pawan.withdrawal(withdrawMoney);
                        }
                        if (choice == 3) {
                            System.out.println("Balance in your account = " + pawan.getBalance());
                        }
                        if (choice > 4 || choice < 0) {

                            System.out.println("please choose valid option");
                        }
                        if (choice == 0) {
                            System.out.println("Goodbye");
                        }
                        break;
                    }
                }
            }
            keypad.close();
        }
    }
}
