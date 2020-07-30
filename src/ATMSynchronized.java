class Account{
    int balance;
    String name;

    public Account(int balance){
        this.balance = balance;
    }
}

class Customer implements Runnable{
    Account account;
    String name;
    int withdrawAmount;

    public Customer(Account account, String name, int withdrawAmount){
        this.account = account;
        this.name = name;
        this.withdrawAmount = withdrawAmount;

    }

    public void run(){
        synchronized (account) {
            if (account.balance >= withdrawAmount) {
                account.balance = account.balance - withdrawAmount;
                System.out.println("balance: " + account.balance);
            } else {
                System.out.println("Insufficient Balance");
            }
        }
    }
}


public class ATMSynchronized {
    public static void main(String []args){
        Account account = new Account(1000);

        Customer c1= new Customer(account, "Soumya", 600);
        Customer c2 = new Customer(account, "Sumegha", 700);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();
    }
}
