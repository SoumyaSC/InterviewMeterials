package ExceptionHandling;

class AccountDemo{
    int amount = 500;

    public void withdraw(int amt){
       if(amt>=amount){
           throw new ArithmeticException("Insufficient Balance");
       }
    }
}

public class OurThrowDefaultCatch {
    public static void main(String []args){
        AccountDemo accountDemo = new AccountDemo();
        accountDemo.withdraw(1000);
    }

}
