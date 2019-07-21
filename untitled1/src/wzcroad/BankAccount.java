package wzcroad;

public class BankAccount {
    public int balance = 100;
    public int getBalance() {
        return balance;
    }
    public void withdraw(int amount) {
        balance -= amount;
    }
}
