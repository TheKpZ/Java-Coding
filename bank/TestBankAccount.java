package bank;
import javax.swing.JOptionPane;
public class TestBankAccount {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the Bank Account Program");

        String openAccount = JOptionPane.showInputDialog(null, "Would you like to open a new account? (yes/no)");
        if ("yes".equals(openAccount)) {
            double startBalance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the starting balance:"));
            BankAccount account = new BankAccount(startBalance);
            JOptionPane.showMessageDialog(null, "Thank you for creating an account with a starting balance of " + startBalance);
            performOperations(account);
        } else {
            JOptionPane.showMessageDialog(null, "Goodbye");
        }
    }

    public static void performOperations(BankAccount account) {
        while (true) {
            String choice = JOptionPane.showInputDialog(null,"What would you like to do? (d: deposit, w: withdraw, g: get balance, or x: quit)");
            if ("d".equals(choice)) {
                String depositAmount = JOptionPane.showInputDialog(null, "Enter the amount to deposit:");
                account.deposit(depositAmount);
            }else if ("w".equals(choice)) {
                String withdrawAmount = JOptionPane.showInputDialog(null, "Enter the amount to withdraw:");
                if (withdrawAmount != null) {
                    double amount = Double.parseDouble(withdrawAmount);
                    if (amount <= account.getBalance()) { 
                        account.withdraw(amount);
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient funds");
                    }
                }
            } else if ("g".equals(choice)) {
                double currentBalance = account.getBalance();
                JOptionPane.showMessageDialog(null, "Your current balance is: " + currentBalance);
            } else if ("x".equals(choice)){
                JOptionPane.showMessageDialog(null, "Thank you for using the Bank Account Program. Goodbye!");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please enter d, w, g, or x.");
            }
        }
    }
}
