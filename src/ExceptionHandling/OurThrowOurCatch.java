package ExceptionHandling;

class AccountException{
    int amount = 2000;

    public void withdraw(int amt){
        try{
            if(amt>=amount){
                throw new ArithmeticException("Insufficient Balance");
            }
            else{
                amount = amount - amt;
                System.out.println("Balance after withdrawal is " + amount);
            }

        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}


public class OurThrowOurCatch {
    public static void main(String []args){
        AccountException accountException = new AccountException();
        accountException.withdraw(5000);
    }
}
