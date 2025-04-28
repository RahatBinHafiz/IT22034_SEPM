class Account {
    private double amount;

    public void addFunds(double funds) {
        if(funds > 0) amount += funds;
    }

    public double checkBalance() {
        return amount;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Account myAccount = new Account();
        myAccount.addFunds(500);
        System.out.println(myAccount.checkBalance());
    }
}
